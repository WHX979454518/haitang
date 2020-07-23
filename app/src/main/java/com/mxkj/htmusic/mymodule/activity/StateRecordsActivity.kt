package com.mxkj.htmusic.mymodule.activity

import android.util.Log
import android.view.View
import com.alibaba.fastjson.JSON
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil
import com.mxkj.htmusic.projectmodule.bean.SelectedMusicansBean
import com.mxkj.htmusic.projectmodule.bean.StateRecordsBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_staterecords.*
import okhttp3.Headers


class StateRecordsActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_staterecords
    }

    override fun initView() {
        hideTitle(true)
        onViewClick()
    }

    var state=  SelectedMusicansBean.DataBean()
    internal var contractcontent: String? = ""
    override fun initData() {
        if(null!=intent.getSerializableExtra("state")) {
            state = intent.getSerializableExtra("state") as SelectedMusicansBean.DataBean
            state = intent.getSerializableExtra("state") as SelectedMusicansBean.DataBean
            if(state.require_status.equals(0)){
                pay_ll.visibility = View.GONE
                qianyue_ll.visibility = View.GONE
                sign_up_ll.visibility = View.VISIBLE
                daiqianyue_ll.visibility = View.GONE
                acceptance_ll.visibility = View.GONE
            }else if(state.require_status.equals(1)){
                acceptance_ll.visibility = View.GONE
                pay_ll.visibility = View.GONE
                qianyue_ll.visibility = View.GONE
                sign_up_ll.visibility = View.VISIBLE
                daiqianyue_ll.visibility = View.VISIBLE
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)
            }else if(state.require_status.equals(2)){
                acceptance_ll.visibility = View.GONE
                pay_ll.visibility = View.VISIBLE
                qianyue_ll.visibility = View.VISIBLE
                sign_up_ll.visibility = View.VISIBLE
                daiqianyue_ll.visibility = View.VISIBLE
                progress_l2.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)
            }else if(state.require_status.equals(3)){
                acceptance_ll.visibility = View.VISIBLE
                pay_ll.visibility = View.VISIBLE
                qianyue_ll.visibility = View.VISIBLE
                sign_up_ll.visibility = View.VISIBLE
                daiqianyue_ll.visibility = View.VISIBLE
                progress_l1.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l2.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)
            }else if(state.require_status.equals(4)){
                acceptance_ll.visibility = View.GONE
                pay_ll.visibility = View.GONE
                qianyue_ll.visibility = View.GONE
                refusedqianyue_ll.visibility = View.VISIBLE
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)

            }else if(state.require_status.equals(5)){
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)





            }else if(state.require_status.equals(6)){
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)





            }else if(state.require_status.equals(7)){
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)





            }else if(state.require_status.equals(8)){
                progress_l3.setBackgroundResource(R.drawable.bg_notselected_progress)
                progress_l4.setBackgroundResource(R.drawable.bg_notselected_progress)





            }


            var userBean = UserInfo()
            UserInfoUtil.getUserInfoById(0, this@StateRecordsActivity) { infoBean ->
                if (infoBean?.data != null) {
                    RxBus.getDefault().post("resetData")
                    userBean = infoBean
                    NetWork.getcontractlog(this@StateRecordsActivity, state.project_id,state.project_task_id,
                            userBean.data.id,state.sea_member.uid, object : NetWork.TokenCallBack {
                        override fun doNext(resultData: String, headers: Headers?) {
                            Log.e("yyyyyyy",""+resultData)
                            val stateRecordsBean = JSON.parseObject(resultData, StateRecordsBean::class.java)


//                            money.setText("￥"+stateRecordsBean.data.)




                        }
                        override fun doError(msg: String) {
                        }
                        override fun doResult() {}
                    })
                }
            }




        }

    }

    private fun onViewClick() {

    }

    companion object {

    }

    override fun initEvent() {

    }
}
