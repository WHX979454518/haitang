package com.mxkj.htmusic.projectmodule.activity

import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import android.widget.Toast
import com.alibaba.fastjson.JSON
import com.google.gson.Gson
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil
import com.mxkj.htmusic.projectmodule.adapter.Enroll
import com.mxkj.htmusic.projectmodule.adapter.SignUpTypeWorkAdapter
import com.mxkj.htmusic.projectmodule.bean.*
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import com.mxkj.htmusic.toolmodule.utils.Constants
import com.mxkj.htmusic.toolmodule.utils.MyListView
import com.mxkj.htmusic.toolmodule.utils.customkeyboard.KeyboardUtil
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_sign_up.*
import okhttp3.Headers
import java.util.ArrayList


class SignUpActivity : StandardUiActivity() {

    var checkcount = 0
    var count = 0

    lateinit var uid: String
    lateinit var require_id: String
    lateinit var project_id: String
    lateinit var project_task_id: String
    lateinit var work_type_id: String
    lateinit var money: String
    lateinit var creation_days: String
    lateinit var remark: String
    lateinit var taskids: String




    internal lateinit var sign_up_lv: MyListView

    var allTaskBean = AllTaskBean.DataBean()
    var ids :String= ""
    var offer :String= ""//我的报价
    var time :String= ""//预计总用时
    var message :String= ""//留言

    var result :String =  ""
    var enroolList = ArrayList<Enroll.EnrollBean>()

    val alltasklist = ArrayList<AllTaskBean.DataBean>()
    internal val myhandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {//接收到完整的包裹
            super.handleMessage(msg)
            when (msg.what) {
                1 -> {
                    val bundle = msg.data
                    offer = bundle.getString("project_offer")
                    time = bundle.getString("project_when")
                    message = bundle.getString("project_leave_message")
                    allTaskBean = bundle.getSerializable("item") as AllTaskBean.DataBean
                    alltasklist.add(allTaskBean)
                    for (i in alltasklist.indices) {
                        val id = alltasklist[i].id.toString()
                        ids = "$id"
                    }
                    Log.e("fffff",""+ids);
//                    for (i in worktypeidlist.indices) {
//                        ids += worktypeidlist.get(i).id.toString() + ","
//                    }
//                    ids = ids.substring(0, ids.length-1)
//                    Log.e("fffff",""+ids)


                    var userBean = UserInfo()
                    val uJson = CacheUtils.getString(this@SignUpActivity, Constants.User.USER_JSON)

                    UserInfoUtil.getUserInfoById(0, this@SignUpActivity) { infoBean ->
                        if (infoBean?.data != null) {
                            RxBus.getDefault().post("resetData")
                            userBean = infoBean
                            val enroll = Enroll.EnrollBean()
                            enroll!!.uid = userBean.data.id
                            enroll!!.require_id = Integer.parseInt(uid)
                            enroll!!.project_id = require_id
                            enroll!!.project_task_id = allTaskBean.id.toString()
                            enroll!!.work_type_id = ids
                            enroll!!.money = offer
                            enroll!!.creation_days = time
                            enroll!!.remark = message
                            enroolList.add(enroll)
                            val gson = Gson()
                            result = gson.toJson(enroolList)
                            Log.e("iiiiiii",""+result.toString())
                        }
                    }



                }
            }


        }
    }


    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_sign_up
    }

    override fun initView() {
        hideTitle(true)

        if(null!=intent.getSerializableExtra("uid")){
            uid = intent.getStringExtra("uid")
            require_id = intent.getStringExtra("require_id")
            project_id = intent.getStringExtra("project_id")
            project_task_id = intent.getStringExtra("project_task_id")
            work_type_id = intent.getStringExtra("work_type_id")
            money = intent.getStringExtra("money")
            creation_days = intent.getStringExtra("creation_days")
            remark = intent.getStringExtra("remark")
            taskids = intent.getStringExtra("taskids")
        }


        onViewClick()
    }

    override fun initData() {
        sign_up_lv = findViewById<MyListView>(R.id.sign_up_lv)//获取工种类型
        NetWork.getalltask(this@SignUpActivity, project_id, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                //工种类型
                val allTaskBean = JSON.parseObject(resultData, AllTaskBean::class.java)
                val dataArray = allTaskBean?.data
                val toJSONString = JSON.toJSONString(dataArray)
                val parse = JSON.parseArray(toJSONString, AllTaskBean.DataBean::class.java)
                val parseArray = ArrayList<AllTaskBean.DataBean>()
                parseArray.addAll(parse)
                val signUpTypeWorkAdapter = SignUpTypeWorkAdapter(parseArray,this@SignUpActivity,myhandler)
                sign_up_lv.adapter = signUpTypeWorkAdapter
//                work_type_lv.setOnItemClickListener { parent, view, position, id ->
//                }
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }

    private fun onViewClick() {
        //自定义键盘
        var keyboardUtil = KeyboardUtil(this@SignUpActivity)
        keyboardUtil.setOnOkClick {
            if (validate()) {
                ll_price_select.visibility = View.GONE
                project_offer.setText(et_price.text)
            }
        }
        keyboardUtil.setOnCancelClick {
            ll_price_select.visibility = View.GONE
            project_offer.setText(et_price.text)
        }
        //这里是预计用时的自定义键盘
        var whenkeyboardUtil = KeyboardUtil(this@SignUpActivity)
        whenkeyboardUtil.setOnOkClick {
            if (validate()) {
                ll_price_select.visibility = View.GONE
                project_when.setText(et_price.text)
            }
        }
        whenkeyboardUtil.setOnCancelClick {
            ll_price_select.visibility = View.GONE
            project_when.setText(et_price.text)
        }




        //X号
        RxView.clicks(finish).subscribe {
            finish()
        }
        //作词单选
        RxView.clicks(cb_lyrics).subscribe {
            checkcount++
            if(checkcount%2==0){
                cb_lyrics.setChecked(false)
            }else{
                cb_lyrics.setChecked(true)
            }

        }
        //作曲单选
        RxView.clicks(cb_composition).subscribe {
            checkcount++
            if(checkcount%2==0){
                cb_composition.setChecked(false)
            }else{
                cb_composition.setChecked(true)
            }
        }
        //唱见单选
        RxView.clicks(cb_sing_see).subscribe {
            checkcount++
            if(checkcount%2==0){
                cb_sing_see.setChecked(false)
            }else{
                cb_sing_see.setChecked(true)
            }
        }
        //策划单选
        RxView.clicks(cb_planning).subscribe {
            checkcount++
            if(checkcount%2==0){
                cb_planning.setChecked(false)
            }else{
                cb_planning.setChecked(true)
            }
        }

        //作词
        RxView.clicks(project_open1).subscribe {
            count++
            if(count%2==0){
                project_open1.setImageResource(R.mipmap.icon_type_shouqi)
                project_lyrics_rl1.visibility = View.GONE
            }else{
                project_lyrics_rl1.visibility = View.VISIBLE
                project_open1.setImageResource(R.mipmap.icon_type_zhankai)
            }
        }
        //作曲
        RxView.clicks(project_open2).subscribe {
            count++
            if(count%2==0){
                project_open2.setImageResource(R.mipmap.icon_type_shouqi)
                project_composition_rl1.visibility = View.GONE
            }else{
                project_open2.setImageResource(R.mipmap.icon_type_zhankai)
                project_composition_rl1.visibility = View.VISIBLE
            }
        }
        //唱见
        RxView.clicks(project_open3).subscribe {
            count++
            if(count%2==0){
                project_open3.setImageResource(R.mipmap.icon_type_shouqi)
                project_sing_see_rl1.visibility = View.GONE
            }else{
                project_open3.setImageResource(R.mipmap.icon_type_zhankai)
                project_sing_see_rl1.visibility = View.VISIBLE
            }
        }
        //策划
        RxView.clicks(project_open4).subscribe {
            count++
            if(count%2==0){
                project_open4.setImageResource(R.mipmap.icon_type_shouqi)
                project_planning_rl1.visibility = View.GONE
            }else{
                project_open4.setImageResource(R.mipmap.icon_type_zhankai)
                project_planning_rl1.visibility = View.VISIBLE
            }
        }

        //报价自定义键盘弹框
        RxView.clicks(project_offer_image).subscribe {
            ll_price_select.visibility = View.VISIBLE
            et_price.setText("")
            keyboardUtil.attachTo(et_price)
            et_price.isFocusable = true
            et_price.isFocusableInTouchMode = true
            et_price.requestFocus()
        }
        //预计用时自定义键盘弹框
        RxView.clicks(project_when_image).subscribe {
            ll_price_select.visibility = View.VISIBLE
            et_price.setText("")
            baomi.setText("预计用时")
            day.setText("天")
            whenkeyboardUtil.attachTo(et_price)
            et_price.isFocusable = true
            et_price.isFocusableInTouchMode = true
            et_price.requestFocus()
        }

        //确定报名
        RxView.clicks(to_sign_up).subscribe {
            var userBean = UserInfo()
            val uJson = CacheUtils.getString(this@SignUpActivity, Constants.User.USER_JSON)

            UserInfoUtil.getUserInfoById(0, this@SignUpActivity) { infoBean ->
                if (infoBean?.data != null) {

                    RxBus.getDefault().post("resetData")
                    userBean = infoBean


                    NetWork.getprojectunenroll(this@SignUpActivity,
                            result,
                            object : NetWork.TokenCallBack {
                        override fun doNext(resultData: String, headers: Headers?) {
                            val jsonObject = JSON.parseObject(resultData)
                            val msg = jsonObject.getString("msg")!!
                            setSnackBar(msg, "", R.drawable.icon_fails)
                            finish()
                        }

                        override fun doError(msg: String) {

                        }

                        override fun doResult() {

                        }
                    })
                }
            }

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
