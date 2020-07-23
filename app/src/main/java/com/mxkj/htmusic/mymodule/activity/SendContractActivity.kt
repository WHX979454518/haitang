package com.mxkj.htmusic.mymodule.activity

import android.view.View
import android.widget.Toast
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil
import com.mxkj.htmusic.projectmodule.bean.ContractBean
import com.mxkj.htmusic.projectmodule.bean.SignUpMusicansBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo
import com.mxkj.htmusic.toolmodule.utils.customkeyboard.KeyboardUtil
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_sendcontract.*
import okhttp3.Headers
import java.util.regex.Pattern


class SendContractActivity : StandardUiActivity() {

    internal var contractcontent: String? = ""


    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_sendcontract
    }

    override fun initView() {
        setTitleText("发送合同")
        showRightButton()
        onViewClick()
    }

    var signUpMusicansBean=  SignUpMusicansBean.DataBean()
    override fun initData() {

        if(null!=intent.getSerializableExtra("item")){
            signUpMusicansBean = intent.getSerializableExtra("item") as SignUpMusicansBean.DataBean
            project_name_tv_describe.setText(signUpMusicansBean.project.project_title)
            project_type.setText(signUpMusicansBean.work_type.title)
            cycle.setText(signUpMusicansBean.creation_days.toString()+"天")
            price.setText(signUpMusicansBean.money)
            music_name.setText(signUpMusicansBean.sea_member.nickname)
        }
    }

    private fun onViewClick() {
        //自定义键盘
        var keyboardUtil = KeyboardUtil(this@SendContractActivity)
        keyboardUtil.setOnOkClick {
            if (validate()) {
                ll_price_select.visibility = View.GONE
                cycle.setText(et_price.text.toString()+"天")
            }
        }
        keyboardUtil.setOnCancelClick {
            ll_price_select.visibility = View.GONE
            cycle.setText(et_price.text.toString()+"天")
        }
        //这里是预计用时的自定义键盘
        var whenkeyboardUtil = KeyboardUtil(this@SendContractActivity)
        whenkeyboardUtil.setOnOkClick {
            if (validate()) {
                ll_price_select.visibility = View.GONE
                price.setText("￥"+et_price.text.toString())
            }
        }
        whenkeyboardUtil.setOnCancelClick {
            ll_price_select.visibility = View.GONE
            price.setText("￥"+et_price.text.toString())
        }
        //修改周期
        RxView.clicks(modify_cycle).subscribe {
            ll_price_select.visibility = View.VISIBLE
            et_price.setText("")
            keyboardUtil.attachTo(et_price)
            et_price.isFocusable = true
            et_price.isFocusableInTouchMode = true
            et_price.requestFocus()
        }
        //修改稿酬
        RxView.clicks(modify_price).subscribe {
            ll_price_select.visibility = View.VISIBLE
            et_price.setText("")
            baomi.setText("稿酬")
            day.setText("元")
            whenkeyboardUtil.attachTo(et_price)
            et_price.isFocusable = true
            et_price.isFocusableInTouchMode = true
            et_price.requestFocus()
        }



        var checkcount = 0
        //合同单选
        RxView.clicks(cb_composition).subscribe {
            checkcount++
            if(checkcount%2==0){
                cb_composition.setChecked(false)
                send_contract_btn.alpha = 0.5f
            }else{
                cb_composition.setChecked(true)
                send_contract_btn.alpha = 1f
                NetWork.getcontract(this@SendContractActivity, signUpMusicansBean.project_id, object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
                        contractcontent = ""
                    }
                    override fun doError(msg: String) {
                    }
                    override fun doResult() {}
                })
                var userBean = UserInfo()
                val REGEX_CHINESE = "[\u4e00-\u9fa5]"// 中文正则

                val regEx = "[^0-9]"
                val p = Pattern.compile(regEx)
                val m = p.matcher(price.text.toString())


                UserInfoUtil.getUserInfoById(0, this@SendContractActivity) { infoBean ->
                    if (infoBean?.data != null) {
                        RxBus.getDefault().post("resetData")
                        userBean = infoBean
                        val pat = Pattern.compile(REGEX_CHINESE)
                        val mat = pat.matcher(cycle.text.toString())
                        //发送合同
                        RxView.clicks(send_contract_btn).subscribe {
                            NetWork.getconreact(this@SendContractActivity
                                    ,signUpMusicansBean.project_id,
                                    signUpMusicansBean.project_task_id,
                                    signUpMusicansBean.work_type_id,
                                    signUpMusicansBean.id,
                                    userBean.data.id,
                                    signUpMusicansBean.sea_member.uid,
                                    m.replaceAll("").trim(),
                                    Integer.parseInt(mat.replaceAll("")),
                                    contractcontent.toString(),
                                    object : NetWork.TokenCallBack {
                                        override fun doNext(resultData: String, headers: Headers?) {
                                            val jsonObject = JSON.parseObject(resultData)
                                            val msg = jsonObject.getString("msg")!!
                                            setSnackBar(msg, "", R.drawable.icon_fails)
                                            finish()
                                        }

                                        override fun doError(msg: String) {

                                        }

                                        override fun doResult() {}
                                    })
                        }
                    }
                }
            }
        }
        //合同
        RxView.clicks(contract).subscribe {
            goActivity(ContractActivity::class.java)
        }
    }

    companion object {

    }

    override fun initEvent() {


    }
    //自定義键盘
    fun validate(): Boolean {
        if (et_price.text.toString() == "") {
            Toast.makeText(application, "天数不能为空", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}
