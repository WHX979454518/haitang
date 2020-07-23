package com.mxkj.htmusic.mymodule.fragment

import android.support.design.widget.AppBarLayout
import com.mxkj.htmusic.R
import com.mxkj.yuanyintang.base.fragment.BaseLazyFragment

class IntroductionFragment : BaseLazyFragment(), AppBarLayout.OnOffsetChangedListener {
    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val contentViewLayoutID: Int
        get() = R.layout.activity_main

    override fun onFirstVisibleToUser() {


    }


    override fun onVisibleToUser() {

    }

    override fun onInvisibleToUser() {

    }
}