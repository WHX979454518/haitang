package com.mxkj.htmusic.mymodule.activity.settings

import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity


class SecuritySettingsActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_aecuritysettings
    }

    override fun initView() {
        setTitleText("安全设置")
        showRightButton()
        setRightButtonText("确认")
        onViewClick()
    }

    override fun initData() {

    }

    private fun onViewClick() {

    }

    companion object {

    }

    override fun initEvent() {

    }
}
