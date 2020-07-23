package com.mxkj.htmusic.mymodule.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.SlidingFragmentViewPager
import com.mxkj.htmusic.mymodule.fragment.IntroductionFragment
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_personalhomepage.*
import java.util.ArrayList

class MusiciansPersonalHomePageActivity : StandardUiActivity(), Panel.OnPanelListener {
    private var currentItem: Int = 0
    internal var strings: MutableList<String> = ArrayList()
    private var fragments: MutableList<Fragment> = ArrayList()
    private lateinit var homepageFragment: IntroductionFragment
    private lateinit var musicFragment: IntroductionFragment
    private lateinit var pondFragment: IntroductionFragment
    private var musicIanEvent: Disposable? = null
    private var playerMusicEvent: Disposable? = null
    private lateinit var slidingFragmentViewPager: SlidingFragmentViewPager


    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_personalhomepage
    }

    override fun initView() {
        hideTitle(true)
        initViewPager()
        initViewHeight()
    }

    override fun initData() {

    }

    override fun initEvent() {

    }

    private fun initViewPager() {
        strings.clear()
        strings.add("简介")
        strings.add("作品")
        strings.add("相册")

        val bundle = Bundle()
        bundle.putString("id", "")

        homepageFragment = IntroductionFragment()
        homepageFragment.arguments = bundle

        musicFragment = IntroductionFragment()
        musicFragment.arguments = bundle

        pondFragment = IntroductionFragment()
        pondFragment.arguments = bundle
        fragments.clear()
        fragments.add(homepageFragment)
        fragments.add(musicFragment)
        fragments.add(pondFragment)
        slidingFragmentViewPager = SlidingFragmentViewPager(supportFragmentManager, strings, fragments, this)
        viewpager.adapter = slidingFragmentViewPager
        tabs.setViewPager(viewpager)
        viewpager.currentItem = currentItem
        viewpager.offscreenPageLimit = 3
        viewpager.currentItem = currentItem
        tabs.updateTabSelection(currentItem)

    }

    private fun initViewHeight() {
        app_bar.addOnOffsetChangedListener({ appBarLayout, verticalOffset ->
            val scrollRangle = appBarLayout.totalScrollRange
            //初始verticalOffset为0，不能参与计算。
            if (verticalOffset == 0) {
                tv_title.alpha = 0.0f
                layout_head.alpha = 1.0f
            } else {
                //保留一位小数
                val alpha = (Math.abs(Math.round(1.0f * verticalOffset / scrollRangle) * 10) / 10).toFloat()
                tv_title.alpha = alpha
                layout_head.alpha = 1.0f - alpha
            }
        })
    }


    override fun onPanelClosed(panel: Panel) {

    }

    override fun onPanelOpened(panel: Panel) {

    }
}
