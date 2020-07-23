package com.mxkj.htmusic.mymodule.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alibaba.fastjson.JSON
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.adapter.RecruitPeopleParticipateFragmentAdapter
import com.mxkj.htmusic.projectmodule.bean.SignUpMusicansBean
import com.mxkj.htmusic.toolmodule.HomeActivity
import com.mxkj.yuanyintang.net.NetWork
import com.trello.rxlifecycle2.components.support.RxFragment
import okhttp3.Headers
import java.util.ArrayList

class RecruitPeopleParticipateFragment : RxFragment() {
    private lateinit var homeActivity: HomeActivity
    private var rootView: View? = null
    private var recyclerview: RecyclerView? = null
    private var musicListMusicIanAdapter: RecruitPeopleParticipateFragmentAdapter? = null
    private val musicListMusicIanBeanList = ArrayList<SignUpMusicansBean.DataBean>()

    internal var work_type_id: String? = ""
    internal var require_id: String? = ""


    private var page: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView != null) {
            val parent = rootView!!.parent as ViewGroup
            parent?.removeView(rootView)
        } else {
            rootView = inflater.inflate(R.layout.recruitpeopleparticipatefragment, container, false)
        }
        initEvent()
        return rootView
    }

    private fun initEvent() {
        recyclerview = rootView!!.findViewById<RecyclerView>(R.id.recyclerview)

        val bundle = arguments
        if (null != bundle!!.getString("require_id")) {
            work_type_id = bundle.getString("work_type_id")
            require_id = bundle.getString("require_id")
        }

        initdata()
    }

    private fun initdata() {
        //需要请求来tinachognshuju
        ParticipateDate()

        recyclerview!!.setLayoutManager(LinearLayoutManager(activity))
        if (musicListMusicIanAdapter == null) {
            musicListMusicIanAdapter = RecruitPeopleParticipateFragmentAdapter(musicListMusicIanBeanList)
            recyclerview!!.setAdapter(musicListMusicIanAdapter)
        } else {
            musicListMusicIanAdapter!!.setNewData(musicListMusicIanBeanList)
        }
    }

    private fun ParticipateDate() {
        NetWork.getenroollist(activity!!, "", "", "", Integer.parseInt(require_id), object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                jsonPondData(resultData)
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {}
        })
    }

    private fun jsonPondData(resultData: String) {
//        interRefresh?.setStopRefreshing()
        val signUpMusicansBean = JSON.parseObject(resultData, SignUpMusicansBean::class.java)
        val jsonArray = signUpMusicansBean?.data
        if (jsonArray!!.size > 0) {
//            rootView?.view_nodata?.visibility = View.GONE
            val toJSONString = JSON.toJSONString(jsonArray)
            val parse = JSON.parseArray(toJSONString, SignUpMusicansBean.DataBean::class.java)
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