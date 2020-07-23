package com.mxkj.htmusic.mymodule.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import com.flyco.tablayout.SousuoSlidingTabLayout
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.fragment.ParticipateFragment
import com.mxkj.htmusic.mymodule.adapter.SlidingFragmentViewPager
import com.mxkj.htmusic.mymodule.fragment.AllFragment
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_participate.*


class ParticipateActivity : StandardUiActivity() {

    internal var tabs: SousuoSlidingTabLayout? = null
    private var slidingFragmentViewPager: SlidingFragmentViewPager? = null
    internal var viewpager: ViewPager? = null
    internal var strings: ArrayList<String> = ArrayList()
    private val fragments = ArrayList<Fragment>()

    var count:Int = 0

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_participate
    }

    override fun initView() {
        setTitleText("我参与的")
        tabs = findViewById(R.id.partivipate_tabs)
        viewpager = findViewById(R.id.partivipate_viewpager)
        showRightButton()
        onViewClick()
    }

    override fun initData() {
        //数据是要通过接口请求来的。这里写了案例
        getheadpagerdata()

        slidingFragmentViewPager = SlidingFragmentViewPager(supportFragmentManager, strings, fragments, this@ParticipateActivity)
        viewpager!!.adapter = slidingFragmentViewPager
        tabs!!.setViewPager(viewpager)
        tabs!!.updateTabSelection(0)
        viewpager!!.offscreenPageLimit = strings.size
    }

    private fun onViewClick() {

        RxView.clicks(participate_time_sorting).subscribe {
            count++
            if(count%2==0){
                participate_time_sorting.setTextColor(Color.parseColor("#616366"))
                participate_time_sorting.setBackgroundColor(Color.parseColor("#f7f7fa"))
            }else{
                participate_time_sorting.setTextColor(Color.parseColor("#14b4aa"))
                participate_time_sorting.setBackgroundColor(Color.parseColor("#32d6c8"))
            }

        }
        RxView.clicks(participate_timeend_sorting).subscribe {
            count++
            if(count%2==0){
                participate_timeend_sorting.setTextColor(Color.parseColor("#616366"))
                participate_timeend_sorting.setBackgroundColor(Color.parseColor("#f7f7fa"))
            }else{
                participate_timeend_sorting.setTextColor(Color.parseColor("#14b4aa"))
                participate_timeend_sorting.setBackgroundColor(Color.parseColor("#32d6c8"))
            }
        }
    }

    companion object {

    }

    override fun initEvent() {

    }

    private fun getheadpagerdata() {
        strings.clear()
        strings.add("全部")
        strings.add("报名中")
        strings.add("待签约")
        strings.add("待支付")
        strings.add("进行中")
        strings.add("已完成")
        strings.add("已终止")
        Log.e("",""+strings)
        val bundle = Bundle()
        bundle.putString("biaoshi", "全部")
        val fragment = AllFragment()
        fragment.arguments = bundle
        fragments.add(fragment)

        val bundle2 = Bundle()
        bundle2.putString("biaoshi", "报名中")
        val fragment2 = ParticipateFragment()
        fragment2.arguments = bundle2
        fragments.add(fragment2)

        val bundle3 = Bundle()
        bundle3.putString("biaoshi", "待签约")
        val fragment3 = ParticipateFragment()
        fragment3.arguments = bundle3
        fragments.add(fragment3)

        val bundle4 = Bundle()
        bundle4.putString("biaoshi", "待支付")
        val fragment4 = ParticipateFragment()
        fragment4.arguments = bundle4
        fragments.add(fragment4)

        val bundle5 = Bundle()
        bundle5.putString("biaoshi", "进行中")
        val fragment5 = ParticipateFragment()
        fragment5.arguments = bundle5
        fragments.add(fragment5)

        val bundle6 = Bundle()
        bundle6.putString("biaoshi", "已完成")
        val fragment6 = ParticipateFragment()
        fragment6.arguments = bundle6
        fragments.add(fragment6)

        val bundle7 = Bundle()
        bundle7.putString("biaoshi", "已终止")
        val fragment7 = ParticipateFragment()
        fragment7.arguments = bundle7
        fragments.add(fragment7)
    }
}
