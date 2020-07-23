package com.mxkj.htmusic.mymodule.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.bean.MyInvolvedmusicanBean
import com.mxkj.htmusic.projectmodule.bean.ContractBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_registrationstatus.*
import okhttp3.Headers


class RegistrationStatusActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_registrationstatus
    }

    override fun initView() {

        if(null!=intent.getSerializableExtra("mystate")){
            var mystate = intent.getSerializableExtra("mystate")as MyInvolvedmusicanBean.DataBean

            Log.e("iiiiii",""+mystate.status)
            if(mystate.status.equals(1)){
                setTitleText(mystate.status_text)
                registration_state.setText(mystate.status_text)
                registration_state_describe.setText("你已成功报名，请等待招募人选择")
            }else if(mystate.status.equals(2)){
                setTitleText(mystate.status_text)
                registration_state.setText(mystate.status_text)
                registration_state_describe.setText("你被招募人选定，请尽快签约")
                project_contract.visibility = View.VISIBLE
                biaozhu.visibility = View.VISIBLE
                refused_sign.visibility = View.VISIBLE
                sgree_sign.visibility = View.VISIBLE

                if(mystate.contract.musician_status.equals(3)){
                    setTitleText(mystate.contract.musician_status_text)//待签约
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText("你被招募人选定，请尽快签约")
                }else if(mystate.contract.musician_status.equals(4)){
                    setTitleText(mystate.contract.musician_status_text)//待支付
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    project_contract.visibility = View.VISIBLE
                }else if(mystate.contract.musician_status.equals(5)){
                    setTitleText(mystate.contract.musician_status_text)//签约失败
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText("你已拒绝，签约失败")
                    project_contract.visibility = View.VISIBLE
                }else if(mystate.contract.musician_status.equals(6)){
                    setTitleText(mystate.contract.musician_status_text)//进行中
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText("项目已开始，请尽快提交作品")
                    biaozhu.visibility = View.GONE
                    project_contract.visibility = View.VISIBLE
                    termination.visibility = View.VISIBLE
                    delay.visibility = View.VISIBLE
                    status_progress.visibility = View.VISIBLE
                }else if(mystate.contract.musician_status.equals(7)){
                    setTitleText(mystate.contract.musician_status_text)//已验收
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    project_contract.visibility = View.VISIBLE
                }else if(mystate.contract.musician_status.equals(8)){
                    setTitleText(mystate.contract.musician_status_text)//待评价
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText("项目已完成，请尽快评价")
                    xuqiumiaoshu_rl.visibility = View.VISIBLE
                    xuqiumiaoshu_ll.visibility = View.VISIBLE
                    project_contract.visibility = View.VISIBLE
                    sgree_sign.visibility = View.GONE
                    refused_sign.visibility = View.GONE
                    status_progress.visibility = View.VISIBLE
                    signing_failed_ll.visibility = View.GONE
                }else if(mystate.contract.musician_status.equals(9)){
                    setTitleText(mystate.contract.musician_status_text)//已完成
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    project_contract.visibility = View.VISIBLE
                }else if(mystate.contract.musician_status.equals(10)){
                    setTitleText(mystate.contract.musician_status_text)//已终止
                    registration_state.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    registration_state_describe.setText(mystate.contract.musician_status_text)
                    project_contract.visibility = View.VISIBLE
                }


            }

        }
        onViewClick()
        //上传
        onupload()
    }

    override fun initData() {
        if(null!=intent.getSerializableExtra("mystate")) {
            val mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
            project_name_tv_describe.setText(mystate.project.project_title)
            cycle.setText(mystate.creation_days.toString())
            remuneration.setText(mystate.money)
            type.setText(mystate.work_type.title)

            music_name.setText(mystate.sea_require_member.nickname)
        }
    }

    private fun onViewClick() {

        //状态记录
        RxView.clicks(state_records).subscribe {
            val bundle = Bundle()
            if(null!=intent.getSerializableExtra("state")){
                val state = intent.getSerializableExtra("state")
                bundle.putSerializable("state", state)
            }else{
                bundle.putSerializable("state", "")
            }
            goActivity(StateRecordsActivity::class.java,null)
        }
        //拒绝签约
        RxView.clicks(refused_sign).subscribe {

            if(null!=intent.getSerializableExtra("mystate")) {
                val mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
                NetWork.getrejectsign(this@RegistrationStatusActivity, mystate.contract.id, "太垃圾了", object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        Log.e("uuuuuu",""+resultData)
                        NetWork.getcontract(this@RegistrationStatusActivity, mystate.contract.id, object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
                                val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
//                                contractcontent = contractBean.data.content
                                setTitleText("签约失败")//
                                registration_state.setText(mystate.status_text)
                                registration_state_describe.setText("签约失败")
                                registration_state_describe.setText("你已拒绝，签约失败")
                            }
                            override fun doError(msg: String) {
                            }
                            override fun doResult() {}
                        })
                    }

                    override fun doError(msg: String) {

                    }

                    override fun doResult() {}
                })
            }


        }


        //同意签约
        RxView.clicks(sgree_sign).subscribe {

            if(null!=intent.getSerializableExtra("mystate")) {
                val mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
                NetWork.getagreesign(this@RegistrationStatusActivity, mystate.contract.id, object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        Log.e("uuuuuu",""+resultData)
                        NetWork.getcontract(this@RegistrationStatusActivity, mystate.contract.id, object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
                                val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
//                                contractcontent = contractBean.data.content
                                setTitleText("请支付")//
                                registration_state.setText(mystate.status_text)
                                registration_state_describe.setText("请支付")
                                registration_state_describe.setText("请支付")
                            }
                            override fun doError(msg: String) {
                            }
                            override fun doResult() {}
                        })
                    }

                    override fun doError(msg: String) {

                    }

                    override fun doResult() {}
                })
            }
        }


        //音乐人申请终止项目合同
        RxView.clicks(termination).subscribe {

            if(null!=intent.getSerializableExtra("mystate")) {
                val mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
                NetWork.getapplestop(this@RegistrationStatusActivity,
                        mystate.contract.id, "太垃圾了",
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
                            }

                            override fun doError(msg: String) {

                            }

                            override fun doResult() {}
                        })
            }


        }


        //音乐人申请延长项目合同周期
        RxView.clicks(delay).subscribe {

            if(null!=intent.getSerializableExtra("mystate")) {
                val mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
                NetWork.getappledelay(this@RegistrationStatusActivity,
                        mystate.contract.id,
                        6,
                        "太垃圾了",
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
                            }

                            override fun doError(msg: String) {

                            }

                            override fun doResult() {}
                        })
            }


        }



        var checkcount1 = 0
        var checkcount2 = 0
        var checkcount3 = 0
        var checkcount4 = 0
        //需求描述星星评分
        RxView.clicks(xuqiu_onestars).subscribe {
            checkcount1++
            if(checkcount1%2==0){
                xuqiu_onestars.setBackgroundResource(R.mipmap.icon_start_yellow)
                quality_of_work.visibility  = View.VISIBLE
                quality_of_work.setText("差")
//                quality_of_work.setText("未达标")
//                quality_of_work.setText("一般")
//                quality_of_work.setText("优秀")
//                quality_of_work.setText("非常优秀")
            }else{
                xuqiu_onestars.setBackgroundResource(R.mipmap.icon_start_gray)
            }
        }
        //沟通态度星星评分
        RxView.clicks(goutong_onestars).subscribe {
            checkcount2++
            if(checkcount2%2==0){
                goutong_onestars.setBackgroundResource(R.mipmap.icon_start_yellow)
                communication_attitude.visibility  = View.VISIBLE
                communication_attitude.setText("差")
//                communication_attitude.setText("不太顺畅")
//                communication_attitude.setText("一般")
//                communication_attitude.setText("顺畅")
//                communication_attitude.setText("非常顺畅")
            }else{
                goutong_onestars.setBackgroundResource(R.mipmap.icon_start_gray)
            }
        }

        //反馈及时星星评分
        RxView.clicks(fankui_onestars).subscribe {
            checkcount3++
            if (checkcount3 % 2 == 0) {
                fankui_onestars.setBackgroundResource(R.mipmap.icon_start_yellow)
                feedback.visibility = View.VISIBLE
                feedback.setText("非常不及时")
//                feedback.setText("不及时")
//                feedback.setText("一般")
//                feedback.setText("及时")
//                feedback.setText("非常及时")
            } else {
                fankui_onestars.setBackgroundResource(R.mipmap.icon_start_gray)
            }
        }

        //验收准时星星评分
        RxView.clicks(yanshou_onestars).subscribe {
            checkcount4++
            if (checkcount4 % 2 == 0) {
                yanshou_onestars.setBackgroundResource(R.mipmap.icon_start_yellow)
                acceptance.visibility = View.VISIBLE
                acceptance.setText("非常不及时")
//                acceptance.setText("不及时")
//                acceptance.setText("一般")
//                acceptance.setText("及时")
//                acceptance.setText("非常及时")
            } else {
                fankui_onestars.setBackgroundResource(R.mipmap.icon_start_gray)
            }
        }

        //合作完成相互评价
        RxView.clicks(submit_evaluation).subscribe {
            if(null!=intent.getSerializableExtra("mystate")) {
                var zhiliangnumber = 0
                var goutongnumber = 0
                var fankuinumber = 0
                var jishinumber = 0
                if(quality_of_work.text.toString().equals("差")){
                    zhiliangnumber = 1
                }
                if(communication_attitude.text.toString().equals("差")){
                    goutongnumber = 1
                }
                if(feedback.text.toString().equals("非常不及时")){
                    fankuinumber = 1
                }
                if(acceptance.text.toString().equals("非常不及时")){
                    jishinumber = 1
                }


                var mystate = intent.getSerializableExtra("mystate") as MyInvolvedmusicanBean.DataBean
                NetWork.getevaluate(this@RegistrationStatusActivity,
                        mystate.uid,
                        mystate.sea_require_member.uid,
                        mystate.project_id,
                        mystate.project_task_id,
                        mystate.id,
                        2,//评价人身份1为招募人向音乐人评价 2为音乐人向招募人评价
                        0,//	作品质量 当招募人向音乐人评价时 必填
                        zhiliangnumber,//	需求描述准确 当音乐人向招募人评价时 必填
                        goutongnumber,//沟通态度（差）
                        fankuinumber,//反馈及时（一般）
                        0,//	交付准时 当招募人向音乐人评价时 必填
                        jishinumber,//验收准时 当音乐人向招募人评价时 必填
                        et_song_content.text.toString(),
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                val jsonObject = JSON.parseObject(resultData)
                                val msg = jsonObject.getString("msg")!!
                                setSnackBar(msg, "", R.drawable.icon_fails)
                                finish()
//                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
                            }
                            override fun doError(msg: String) {
                            }
                            override fun doResult() {}
                        })
            }
        }

    }

    companion object {

    }

    override fun initEvent() {

    }

    var delectcount = 1
    private fun onupload() {
        iv_canclevideo.setOnClickListener {
            beforeUploadvideo.visibility = View.VISIBLE
            llUploadingvideo.visibility = View.GONE
            delectcount = 2
        }
    }

}
