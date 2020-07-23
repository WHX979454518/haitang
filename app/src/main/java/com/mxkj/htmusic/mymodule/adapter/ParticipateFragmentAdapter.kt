package com.mxkj.htmusic.mymodule.adapter

import android.os.Bundle
import android.widget.TextView

import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.activity.RegistrationStatusActivity
import com.mxkj.htmusic.mymodule.bean.MyInvolvedmusicanBean
import com.mxkj.htmusic.toolmodule.base.BaseQuickAdapter
import com.mxkj.htmusic.toolmodule.base.BaseViewHolder
import com.mxkj.yuanyintang.upush.UpushService.Companion.goActivity

class ParticipateFragmentAdapter(data: List<MyInvolvedmusicanBean.DataBean>) : BaseQuickAdapter<MyInvolvedmusicanBean.DataBean, BaseViewHolder>(R.layout.item_participate, data) {
    override fun convert(helper: BaseViewHolder, item: MyInvolvedmusicanBean.DataBean, position: Int) {
        isPlayView(helper, item)

        RxView.clicks(helper.getView(R.id.participate_layout)).subscribe {
            val bundle = Bundle()
            bundle.putSerializable("mystate",item)
            goActivity(RegistrationStatusActivity::class.java,bundle,mContext)
        }


    }
    private fun isPlayView(helper: BaseViewHolder, item: MyInvolvedmusicanBean.DataBean) {
        val registration_name = helper.getView<TextView>(R.id.registration_name)
        val registration_status = helper.getView<TextView>(R.id.registration_status)
        val project_musicans_name = helper.getView<TextView>(R.id.project_musicans_name)
        val progect_time = helper.getView<TextView>(R.id.progect_time)

        registration_name.setText(item.project.project_title)
        project_musicans_name.setText(item.sea_require_member.nickname)
        if (item.status.equals(1)) {
            registration_status.setText(item.status_text)//报名中
//            registration_status.setTextColor(Color.parseColor("#FF6699"))
            progect_time.setText(item.money)
        } else if(item.status.equals(2)&& null!=item.contract){
            registration_status.setText(item.status_text)//待签约
//            registration_status.setTextColor(Color.parseColor("#4CBEFF"))
            progect_time.setText(item.contract.money)
            registration_status.setText(item.contract.musician_status_text)//待签约
        }
    }
}
