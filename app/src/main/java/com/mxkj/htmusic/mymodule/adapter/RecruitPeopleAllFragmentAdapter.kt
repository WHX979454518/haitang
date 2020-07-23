package com.mxkj.htmusic.mymodule.adapter

import android.os.Bundle
import android.widget.TextView

import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.activity.RecruitPeopleRegistrationStatusActivity
import com.mxkj.htmusic.projectmodule.bean.SelectedMusicansBean
import com.mxkj.htmusic.toolmodule.base.BaseQuickAdapter
import com.mxkj.htmusic.toolmodule.base.BaseViewHolder
import com.mxkj.yuanyintang.upush.UpushService.Companion.goActivity

class RecruitPeopleAllFragmentAdapter(data: List<SelectedMusicansBean.DataBean>) : BaseQuickAdapter<SelectedMusicansBean.DataBean, BaseViewHolder>(R.layout.item_recruitpeopleall, data) {
    override fun convert(helper: BaseViewHolder, item: SelectedMusicansBean.DataBean, position: Int) {
        isPlayView(helper, item)

        RxView.clicks(helper.getView(R.id.participate_layout)).subscribe {
            val bundle = Bundle()
            bundle.putSerializable("state",item)
            goActivity(RecruitPeopleRegistrationStatusActivity::class.java,bundle,mContext)
        }


    }
    private fun isPlayView(helper: BaseViewHolder, item: SelectedMusicansBean.DataBean) {
        val registration_name = helper.getView<TextView>(R.id.registration_name)
        val registration_status = helper.getView<TextView>(R.id.registration_status)
        registration_name.setText(item.project.project_title)
        if (item.require_status.equals(3)) {
            registration_status.setText("待支付")
//            registration_status.setTextColor(Color.parseColor("#FF6699"))
        } else if(item.require_status.equals(1)){
            registration_status.setText("待签约")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }else if(item.require_status.equals(2)){
            registration_status.setText("签约失败")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }else if(item.require_status.equals(4)){
            registration_status.setText("进行中")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        } else if(item.require_status.equals(5)){
            registration_status.setText("已验收")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }else if(item.require_status.equals(6)){
            registration_status.setText("待评价")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }else if(item.require_status.equals(7)){
            registration_status.setText("已完成")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }else if(item.require_status.equals(8)){
            registration_status.setText("已终止")
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
        }
    }
}
