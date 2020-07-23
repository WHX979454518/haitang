package com.mxkj.htmusic.mymodule.activity.login_regist

import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.yuanyintang.utils.app.ActivityCollector
import com.umeng.analytics.MobclickAgent

class RegSuccessRecommend2 : StandardUiActivity() {
    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_profile
    }

    override fun initView() {
        hideTitle(true)
    }

    override fun initData() {

    }

    override fun initEvent() {
            MobclickAgent.onEvent(this,"intre_skip")
            finish()
    }

    override fun onResume() {
        super.onResume()
        ActivityCollector.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)

    }

}
