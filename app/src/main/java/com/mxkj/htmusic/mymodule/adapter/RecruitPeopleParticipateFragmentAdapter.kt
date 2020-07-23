package com.mxkj.htmusic.mymodule.adapter

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView

import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.activity.SendContractActivity
import com.mxkj.htmusic.projectmodule.bean.SignUpMusicansBean
import com.mxkj.htmusic.toolmodule.base.BaseQuickAdapter
import com.mxkj.htmusic.toolmodule.base.BaseViewHolder
import com.mxkj.yuanyintang.base.dialog.BaseConfirmDialog
import com.mxkj.yuanyintang.upush.UpushService.Companion.goActivity

class RecruitPeopleParticipateFragmentAdapter(data: List<SignUpMusicansBean.DataBean>) : BaseQuickAdapter<SignUpMusicansBean.DataBean, BaseViewHolder>(R.layout.item_recruitpeopleparticipate, data) {
    override fun convert(helper: BaseViewHolder, item: SignUpMusicansBean.DataBean, position: Int) {
        isPlayView(helper, item)

//        RxView.clicks(helper.getView(R.id.participate_layout)).subscribe {
//            val bundle = Bundle()
//            bundle.putSerializable("state",item.head)
//            goActivity(RecruitPeopleRegistrationStatusActivity::class.java,bundle,mContext)
//        }

    }
    private fun isPlayView(helper: BaseViewHolder, item: SignUpMusicansBean.DataBean) {
        val registration_name = helper.getView<TextView>(R.id.registration_name)
        val registration_selected = helper.getView<TextView>(R.id.registration_selected)
        registration_name.setText(item.project.project_title)
        //这里判断是否已经发过合同来改变颜色和背景，如果发过合同则不做操作
        if (item.status.equals("0")) {
            registration_selected.setText("已选定")
            registration_selected.setTextColor(Color.parseColor("#c2c7cc"))
            registration_selected.setBackgroundResource(R.drawable.bg_grayregistrationstas_bg)
        }else{
            RxView.clicks(helper.getView(R.id.registration_selected)).subscribe {
                BaseConfirmDialog.newInstance().title("确定选定")
                        .content("是否选定音乐人【"+ item.sea_member.nickname+"】\n" + "\n选定后，你将会给他发送一份电子合同")
                        .confirmText("取消").cancleText("确定").showDialog(mContext, object : BaseConfirmDialog.onBtClick {
                            override fun onConfirm() {

                            }

                            override fun onCancle() {
                                val bundle = Bundle()
                                bundle.putSerializable("item",item)
                                goActivity(SendContractActivity::class.java,bundle,mContext)
                            }
                        })

            }
        }

    }
}
