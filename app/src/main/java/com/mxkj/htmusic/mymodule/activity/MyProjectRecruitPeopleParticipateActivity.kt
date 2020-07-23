package com.mxkj.htmusic.mymodule.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.flyco.tablayout.SousuoSlidingTabLayout
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.SlidingFragmentViewPager
import com.mxkj.htmusic.mymodule.fragment.MyProjectRecruitPeopleAllFragment
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity


class MyProjectRecruitPeopleParticipateActivity : StandardUiActivity() {

    internal var tabs: SousuoSlidingTabLayout? = null
    private var slidingFragmentViewPager: SlidingFragmentViewPager? = null
    internal var viewpager: ViewPager? = null
    internal var strings: ArrayList<String> = ArrayList()
    private val fragments = ArrayList<Fragment>()

    var count:Int = 0

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_myprojectrecruitpeopleparticipate
    }

    override fun initView() {
        setTitleText("我的项目")
        tabs = findViewById(R.id.partivipate_tabs)
        viewpager = findViewById(R.id.partivipate_viewpager)
        showRightButton()
        onViewClick()
    }

    override fun initData() {
        //数据是要通过接口请求来的。这里写了案例
        getheadpagerdata()

        slidingFragmentViewPager = SlidingFragmentViewPager(supportFragmentManager, strings, fragments, this@MyProjectRecruitPeopleParticipateActivity)
        viewpager!!.adapter = slidingFragmentViewPager
        tabs!!.setViewPager(viewpager)
        tabs!!.updateTabSelection(0)
        viewpager!!.offscreenPageLimit = strings.size
    }

    private fun onViewClick() {

    }

    companion object {

    }

    override fun initEvent() {

    }

    private fun getheadpagerdata() {
        strings.clear()
        strings.add("全部")
        strings.add("审核中")
        strings.add("审核失败")
        strings.add("招募中")
        strings.add("招募结束")
        val bundle = Bundle()
        bundle.putString("biaoshi", "")
        val fragment1 = MyProjectRecruitPeopleAllFragment()
        fragment1.arguments = bundle
        fragments.add(fragment1)
        val fragment2 = MyProjectRecruitPeopleAllFragment()
        fragment2.arguments = bundle
        fragments.add(fragment2)
        val fragment3 = MyProjectRecruitPeopleAllFragment()
        fragment3.arguments = bundle
        fragments.add(fragment3)
        val fragment4 = MyProjectRecruitPeopleAllFragment()
        fragment4.arguments = bundle
        fragments.add(fragment4)
        val fragment5 = MyProjectRecruitPeopleAllFragment()
        fragment5.arguments = bundle
        fragments.add(fragment5)
    }
}
