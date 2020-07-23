package com.mxkj.htmusic.mymodule.activity

import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_contract.*


class ContractActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_contract
    }

    override fun initView() {
        hideTitle(true)
//        setTitleText("合同")
//        showRightButton()
        onViewClick()
    }

    override fun initData() {

    }

    private fun onViewClick() {

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
            }
        }

    }

    companion object {

    }

    override fun initEvent() {

    }

}
