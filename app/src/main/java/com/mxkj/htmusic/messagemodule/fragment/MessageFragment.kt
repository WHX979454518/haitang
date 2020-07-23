package com.mxkj.htmusic.messagemodule.fragment

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.SlidingFragmentViewPager
import com.mxkj.htmusic.mymodule.fragment.IntroductionFragment
import com.mxkj.htmusic.toolmodule.HomeActivity
import com.trello.rxlifecycle2.components.support.RxFragment
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_message.*
import java.util.ArrayList

class MessageFragment : RxFragment(){
    private lateinit var homeActivity: HomeActivity
    private var rootView: View? = null


    private var currentItem: Int = 0
    internal var strings: MutableList<String> = ArrayList()
    private var fragments: MutableList<Fragment> = ArrayList()
    private lateinit var homepageFragment: IntroductionFragment
    private lateinit var musicFragment: IntroductionFragment
    private lateinit var pondFragment: IntroductionFragment
    private var musicIanEvent: Disposable? = null
    private var playerMusicEvent: Disposable? = null
    private lateinit var slidingFragmentViewPager: SlidingFragmentViewPager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_message, container, false)
        return rootView
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (null == rootView) {
            return
        }
        homeActivity = activity as HomeActivity


        initViewPager()
    }

    private fun initViewPager() {
        strings.clear()
        strings.add("会话")
        strings.add("待办事项")
        strings.add("系统消息")

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
        slidingFragmentViewPager = SlidingFragmentViewPager(homeActivity.getSupportFragmentManager(), strings, fragments, homeActivity)
        message_viewpager.adapter = slidingFragmentViewPager
        message_tabs.setViewPager(message_viewpager)
        message_viewpager.currentItem = currentItem
//        message_viewpager.offscreenPageLimit = 3
        message_viewpager.currentItem = currentItem
        message_tabs.updateTabSelection(currentItem)

    }

}