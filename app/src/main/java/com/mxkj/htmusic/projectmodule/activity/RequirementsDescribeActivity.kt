package com.mxkj.htmusic.projectmodule.activity

import android.content.Intent
import android.support.design.widget.AppBarLayout
import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_requirementsdescribe.*


/*
需求描述
 */
class RequirementsDescribeActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    override fun setLayoutId(): Int {
        return R.layout.activity_requirementsdescribe
    }

    override fun initView() {
        hideLeftButton()
        hideRightButton()
        hideTitle(true)
    }

    override fun initEvent() {
        requirementsDescribe_finish.setOnClickListener {
            finish()
        }
        requirementsDescribe_save.setOnClickListener {
            val intent = Intent()
            intent.putExtra("date", ed_requirements_describe.text.toString())
            setResult(2, intent)
            finish();
        }

    }

    override fun initData() {

    }

}