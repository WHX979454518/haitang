package com.mxkj.htmusic.mymodule.activity.settings

import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity


class EditProfileActivity : StandardUiActivity() {

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_profile
    }

    override fun initView() {
        setTitleText("编辑简介")
        showRightButton()
        setRightButtonText("保存")
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
