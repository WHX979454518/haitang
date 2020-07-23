package com.mxkj.htmusic.mymodule.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.View
import com.flyco.tablayout.SousuoSlidingTabLayout
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.SlidingFragmentViewPager
import com.mxkj.htmusic.mymodule.fragment.RecruitPeopleAllFragment
import com.mxkj.htmusic.mymodule.fragment.RecruitPeopleParticipateFragment
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_recruitpeopleparticipate.*


class RecruitPeopleParticipateActivity : StandardUiActivity() {

    internal var tabs: SousuoSlidingTabLayout? = null
    private var slidingFragmentViewPager: SlidingFragmentViewPager? = null
    internal var viewpager: ViewPager? = null
    internal var strings: ArrayList<String> = ArrayList()
    private val fragments = ArrayList<Fragment>()

    var count:Int = 0


    lateinit var work_type_id: String
    lateinit var require_id: String


    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_recruitpeopleparticipate
    }

    override fun initView() {
        setTitleText("应征列表")
        tabs = findViewById(R.id.partivipate_tabs)
        viewpager = findViewById(R.id.partivipate_viewpager)

        if(null!=intent.getSerializableExtra("require_id")) {
            work_type_id = intent.getStringExtra("work_type_id")
            require_id = intent.getStringExtra("require_id")
        }



        showRightButton()
        onViewClick()
    }

    override fun initData() {
        //数据是要通过接口请求来的。这里写了案例
        getheadpagerdata()

        slidingFragmentViewPager = SlidingFragmentViewPager(supportFragmentManager, strings, fragments, this@RecruitPeopleParticipateActivity)
        viewpager!!.adapter = slidingFragmentViewPager
        tabs!!.setViewPager(viewpager)
        tabs!!.updateTabSelection(0)
        viewpager!!.offscreenPageLimit = strings.size

        viewpager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
//                rootView?.bigTxtTab?.setCurrSelectItem(position)
                when (position) {
                    0 -> {
                        flag.visibility = View.VISIBLE
                    }
                    1 ->{
                        flag.visibility = View.GONE
                    }
                }
            }
        })


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
        strings.add("选定音乐人")
        strings.add("报名音乐人")

        val bundle = Bundle()

        if(null!=intent.getStringExtra("require_id")) {
            work_type_id = intent.getStringExtra("work_type_id")
            require_id = intent.getStringExtra("require_id")
            bundle.putString("work_type_id", intent.getStringExtra("work_type_id"))
            bundle.putString("require_id", intent.getStringExtra("require_id"))
        }else{
            bundle.putString("work_type_id", "0")
            bundle.putString("require_id", "0")
        }

        val fragment = RecruitPeopleAllFragment()
        fragment.arguments = bundle
        fragments.add(fragment)
        val fragment2 = RecruitPeopleParticipateFragment()
        fragment2.arguments = bundle
        fragments.add(fragment2)
    }
}
