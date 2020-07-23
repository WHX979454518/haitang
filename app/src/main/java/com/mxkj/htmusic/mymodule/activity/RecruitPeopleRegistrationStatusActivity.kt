package com.mxkj.htmusic.mymodule.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.projectmodule.activity.RecruitPeoplePayActivity
import com.mxkj.htmusic.projectmodule.bean.ContractBean
import com.mxkj.htmusic.projectmodule.bean.SelectedMusicansBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_recruitpeopleregistrationstatus.*
import okhttp3.Headers
import com.mxkj.yuanyintang.upush.UpushService.Companion.goActivity

class RecruitPeopleRegistrationStatusActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_recruitpeopleregistrationstatus
    }

    override fun initView() {

        if(null!=intent.getSerializableExtra("state")){
            val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
            if(state.require_status.equals(1)){
                setTitleText("待签约")
                registration_state.setText("待签约")
                registration_state_describe.setText("你的签约邀请已发送，请等待音乐人签约")
                project_contract.visibility = View.VISIBLE
                refused_sign.visibility = View.VISIBLE
            }else if(state.require_status.equals(2)){
                setTitleText("签约失败")
                registration_state.setText("签约失败")
                registration_state_describe.setText("音乐人已拒绝，签约失败")
                xuqiumiaoshu_rl.visibility = View.VISIBLE
                project_contract.visibility = View.VISIBLE
                score_ll1.visibility = View.GONE
                score_ll2.visibility = View.GONE
                score_ll3.visibility = View.GONE
                score_ll4.visibility = View.GONE
                et_song_content.visibility = View.GONE
                submit_evaluation.visibility = View.GONE
                signing_failed_ll.visibility = View.VISIBLE
            } else if(state.require_status.equals(3)){
                setTitleText("待支付")
                registration_state.setText("待支付")
                registration_state_describe.setText("音乐人已签约，请尽快支付保证金")
                pay.visibility = View.VISIBLE
                project_contract.visibility = View.VISIBLE

//                lianxiren.visibility = View.GONE
//                zhaomuren.visibility = View.GONE
//                pay_musicans.visibility = View.VISIBLE
//                zhaomuren2.visibility = View.VISIBLE
//                xiangmu_rl.visibility = View.GONE
//                xiangmu_rl1.visibility = View.VISIBLE
//                qianyue_rl.visibility = View.GONE
            }else if(state.require_status.equals(4)){
                setTitleText("进行中")
                registration_state.setText("进行中")
                registration_state_describe.setText("项目已开始，开始验收作品")
                project_contract.visibility = View.VISIBLE
                termination.visibility = View.VISIBLE
                delay.visibility = View.VISIBLE
                status_progress.visibility = View.VISIBLE
            }else if(state.require_status.equals(5)){
                setTitleText("已验收")
                registration_state.setText("已验收")
                registration_state_describe.setText("已验收")




            }else if(state.require_status.equals(6)){
                setTitleText("待评价")
                registration_state.setText("待评价")
                registration_state_describe.setText("项目已全部验收，请尽快评价")
                xuqiumiaoshu_rl.visibility = View.VISIBLE
                signing_failed_ll.visibility = View.GONE
                xuqiumiaoshu_ll.visibility = View.VISIBLE
                project_contract.visibility = View.VISIBLE
                lianxiren.visibility = View.VISIBLE
            } else if(state.require_status.equals(7)){
                setTitleText("已完成")
                registration_state.setText("已完成")
                registration_state_describe.setText("已完成")




            }else if(state.require_status.equals(8)){
                setTitleText("已终止")
                registration_state.setText("已终止")
                registration_state_describe.setText("已终止")




            }
        }
        onViewClick()
    }

    var selectedMusicansBean=  SelectedMusicansBean.DataBean()
    internal var contractcontent: String? = ""
    override fun initData() {
        if(null!=intent.getSerializableExtra("state")){
            selectedMusicansBean = intent.getSerializableExtra("state") as SelectedMusicansBean.DataBean
            project_name_tv_describe.setText(selectedMusicansBean.project.project_title)
            cycle.setText(selectedMusicansBean.delay_days)
            remuneration.setText(selectedMusicansBean.money)
            type.setText(selectedMusicansBean.work_type.title)

            music_name.setText(selectedMusicansBean.sea_member.nickname)
            music_name2.setText(selectedMusicansBean.sea_member.nickname)
            project_name_tv_describe1.setText(selectedMusicansBean.project.project_title)
            remuneration1.setText(selectedMusicansBean.money)
            allmoney.setText(selectedMusicansBean.money)
        }
        NetWork.getcontract(this@RecruitPeopleRegistrationStatusActivity, selectedMusicansBean.id, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
//                contractcontent = contractBean.data.content
            }
            override fun doError(msg: String) {
            }
            override fun doResult() {}
        })
    }

    private fun onViewClick() {
        //状态记录
        RxView.clicks(state_records).subscribe {
            val bundle = Bundle()
            if(null!=intent.getSerializableExtra("state")){
                val selectedMusicansBean = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                bundle.putSerializable("state", selectedMusicansBean)
            }else{
                bundle.putSerializable("state", "")
            }
            goActivity(StateRecordsActivity::class.java,bundle)
        }
        //查看合同
        RxView.clicks(project_contract).subscribe {
            goActivity(ContractActivity::class.java)
        }

        //取消签约
        RxView.clicks(refused_sign).subscribe {
            if(null!=intent.getSerializableExtra("state")){
                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                NetWork.getcancelsign(this@RecruitPeopleRegistrationStatusActivity, state.id,"太垃圾lalallalal", object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        Log.e("uuuuuu",""+resultData)
//                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
                    }
                    override fun doError(msg: String) {
                    }
                    override fun doResult() {}
                })
            }
        }




        //去支付
        RxView.clicks(pay).subscribe {
            if(null!=intent.getSerializableExtra("state")){
                val bundle = Bundle()
                bundle.putSerializable("state",intent.getSerializableExtra("state"))
                goActivity(RecruitPeoplePayActivity::class.java, bundle, this@RecruitPeopleRegistrationStatusActivity)
            }
        }


        //招募人快速验收
        RxView.clicks(rapid_acceptance).subscribe {
            if(null!=intent.getSerializableExtra("state")){
                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                NetWork.getfastcheck(this@RecruitPeopleRegistrationStatusActivity,
                        state.sea_member.uid,
                        state.project.id,
                        state.project_task_id,
                        state.id,
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
//                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
                            }
                            override fun doError(msg: String) {
                            }
                            override fun doResult() {}
                        })
            }
        }


        //招募人延长项目合同周期
        RxView.clicks(delay).subscribe {
            if(null!=intent.getSerializableExtra("state")){
                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                NetWork.getdelay(this@RecruitPeopleRegistrationStatusActivity,
                        state.id,
                        20,
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
//                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
                            }
                            override fun doError(msg: String) {
                            }
                            override fun doResult() {}
                        })
            }
        }


        //招募人终止合作
        RxView.clicks(termination).subscribe {
            if(null!=intent.getSerializableExtra("state")){
                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                NetWork.getcontract(this@RecruitPeopleRegistrationStatusActivity,
                        state.id,
                        "终止了合作",
                        object : NetWork.TokenCallBack {
                            override fun doNext(resultData: String, headers: Headers?) {
                                Log.e("uuuuuu",""+resultData)
//                        val contractBean = JSON.parseObject(resultData, ContractBean::class.java)
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
            if(null!=intent.getSerializableExtra("state")){
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


                val state = intent.getSerializableExtra("state")as SelectedMusicansBean.DataBean
                NetWork.getevaluate(this@RecruitPeopleRegistrationStatusActivity,
                        state.uid,
                        state.musician_id,
                        state.project_id,
                        state.project_task_id,
                        state.id,
                        1,//评价人身份1为招募人向音乐人评价 2为音乐人向招募人评价
                        zhiliangnumber,//	作品质量 当招募人向音乐人评价时 必填
                        0,//	需求描述准确 当音乐人向招募人评价时 必填
                        goutongnumber,//沟通态度（差）
                        fankuinumber,//反馈及时（一般）
                        jishinumber,//	交付准时 当招募人向音乐人评价时 必填
                        0,//验收准时 当音乐人向招募人评价时 必填
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
}
