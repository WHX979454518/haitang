//package com.mxkj.haitang.projectmodule.activity
//
//import android.os.Bundle
//import android.support.design.widget.AppBarLayout
//import android.util.Log
//import com.jakewharton.rxbinding2.view.RxView
//import com.mxkj.haitang.R
//import com.mxkj.haitang.projectmodule.bean.SelectedMusicansBean
//import com.mxkj.haitang.toolmodule.base.baseactivity.StandardUiActivity
//import com.mxkj.yuanyintang.net.NetWork
//import kotlinx.android.synthetic.main.activity_recruitpeople.*
//import okhttp3.Headers
//
///*
//招募人支付
// */
//class RecruitPeoplePayActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {
//
//
//    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override val isVisibilityBottomPlayer: Boolean
//        get() = false
//
//    override fun setLayoutId(): Int {
//        return R.layout.activity_recruitpeople
//    }
//
//    override fun initView() {
//        setTitleText("待支付")
//        onViewClick()
//    }
//
//    private fun onViewClick() {
//        //取消合作就是取消签约
//        RxView.clicks(cancel_cooperation).subscribe {
//            if(null!=intent.getSerializableExtra("state")){
//                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
//                NetWork.getcancelsign(this@RecruitPeoplePayActivity, state.id,"太垃圾lalallalal", object : NetWork.TokenCallBack {
//                    override fun doNext(resultData: String, headers: Headers?) {
//                        Log.e("uuuuuu",""+resultData)
////                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
//                    }
//                    override fun doError(msg: String) {
//                    }
//                    override fun doResult() {}
//                })
//            }
//        }
//
//        //去支付
//        RxView.clicks(paymoney).subscribe {
//            if(null!=intent.getSerializableExtra("state")){
//                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
//
//
//                NetWork.getcreateorder(this@RecruitPeoplePayActivity,
//                        state.project.id,
//                        state.project_task_id,
//                        state.id,
//                        state.uid,
//                        state.sea_member.uid,
//                        1,//支付类型1微信2支付宝3QQ4小鱼干
//                        state.money,
//                        object : NetWork.TokenCallBack {
//                            override fun doNext(resultData: String, headers: Headers?) {
//                                Log.e("uuuuuu",""+resultData)
////                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
//                            }
//                            override fun doError(msg: String) {
//                            }
//                            override fun doResult() {}
//                        })
//            }
//        }
//
//    }
//
//    override fun initEvent() {
//
//    }
//
//    override fun initData() {
//        if(null!=intent.getSerializableExtra("state")){
//            val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
//            music_name2.setText(state.sea_member.nickname)
//            project_name_tv_describe1.setText(state.project.project_title)
//            remuneration1.setText(state.money)
//            allmoney.setText(state.money)
//        }
//    }
//}