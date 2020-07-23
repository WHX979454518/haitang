package com.mxkj.htmusic.mymodule.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alibaba.fastjson.JSON
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.ParticipateFragmentAdapter
import com.mxkj.htmusic.mymodule.bean.MyInvolvedmusicanBean
import com.mxkj.yuanyintang.net.NetWork
import com.trello.rxlifecycle2.components.support.RxFragment
import okhttp3.Headers
import java.util.ArrayList

class AllFragment : RxFragment() {
    private var rootView: View? = null

    private var recyclerview: RecyclerView? = null
    private var musicListMusicIanAdapter: ParticipateFragmentAdapter? = null
    private val musicListMusicIanBeanList = ArrayList<MyInvolvedmusicanBean.DataBean>()
    private var page: Int = 1

    private var tv_no_data: TextView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView != null) {
            val parent = rootView!!.parent as ViewGroup
            parent?.removeView(rootView)
        } else {
            rootView = inflater.inflate(R.layout.participatefragment, container, false)
        }
        initEvent()
        return rootView
    }

    private fun initEvent() {
        recyclerview = rootView!!.findViewById(R.id.recyclerview)
        tv_no_data = rootView!!.findViewById(R.id.tv_no_data)
        initdata()
    }

    private fun initdata() {
        //需要请求来tinachognshuju
        ParticipateDate()

        recyclerview!!.setLayoutManager(LinearLayoutManager(activity))
        if (musicListMusicIanAdapter == null) {
            musicListMusicIanAdapter = ParticipateFragmentAdapter(musicListMusicIanBeanList)
            recyclerview!!.setAdapter(musicListMusicIanAdapter)
        } else {
            musicListMusicIanAdapter!!.setNewData(musicListMusicIanBeanList)
        }
    }

    private fun ParticipateDate() {

        NetWork.getmusicancontract(activity!!, "99", "", object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                jsonPondData(resultData)
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {}
        })


//        val dataBean1 = ParticipateFragmentBean.DataBean()
//        dataBean1.title = "儿童游戏背景音乐商业使用权购买..."
//        dataBean1.head = "0"
//        val dataBean2 = ParticipateFragmentBean.DataBean()
//        dataBean2.title = "刚好创建自己的社团，想要找一名..."
//        dataBean2.head = "1"
//        val dataBean3 = ParticipateFragmentBean.DataBean()
//        dataBean3.title = "儿童游戏背;;;;;;;;..."
//        dataBean3.head = "4"
//        val dataBean4 = ParticipateFragmentBean.DataBean()
//        dataBean4.title = "贴唱后期混音 200 一首"
//        dataBean4.head = "2"
//        val dataBean5 = ParticipateFragmentBean.DataBean()
//        dataBean5.title = "刚好创建自己的社团，想要找一名..."
//        dataBean5.head = "3"
//        musicListMusicIanBeanList.add(dataBean1)
//        musicListMusicIanBeanList.add(dataBean2)
//        musicListMusicIanBeanList.add(dataBean3)
//        musicListMusicIanBeanList.add(dataBean4)
//        musicListMusicIanBeanList.add(dataBean5)
    }
    private fun jsonPondData(resultData: String) {
//        interRefresh?.setStopRefreshing()
        val signUpMusicansBean = JSON.parseObject(resultData, MyInvolvedmusicanBean::class.java)
        val jsonArray = signUpMusicansBean?.data
        if (jsonArray!!.size > 0) {
//            rootView?.view_nodata?.visibility = View.GONE
            val toJSONString = JSON.toJSONString(jsonArray)
            val parse = JSON.parseArray(toJSONString, MyInvolvedmusicanBean.DataBean::class.java)
            if (page == 1) {
                musicListMusicIanBeanList.clear()
            }
            musicListMusicIanBeanList.addAll(parse)
            musicListMusicIanAdapter?.setNewData(musicListMusicIanBeanList)
        } else if (page == 1) {
//            rootView?.view_nodata?.visibility = View.VISIBLE
        }
    }
}