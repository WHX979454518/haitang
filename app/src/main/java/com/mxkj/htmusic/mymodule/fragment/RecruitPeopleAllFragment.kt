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
import com.mxkj.htmusic.mymodule.adapter.RecruitPeopleAllFragmentAdapter
import com.mxkj.htmusic.projectmodule.bean.SelectedMusicansBean
import com.mxkj.yuanyintang.net.NetWork
import com.trello.rxlifecycle2.components.support.RxFragment
import okhttp3.Headers
import java.util.ArrayList

class RecruitPeopleAllFragment : RxFragment() {
    private var page: Int = 1
    private var rootView: View? = null
    private var recyclerview: RecyclerView? = null
    private var musicListMusicIanAdapter: RecruitPeopleAllFragmentAdapter? = null
    private val musicListMusicIanBeanList = ArrayList<SelectedMusicansBean.DataBean>()
    private var tv_no_data: TextView? = null


    internal var work_type_id: String? = ""
    internal var require_id: String? = ""
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
        recyclerview = rootView!!.findViewById<RecyclerView>(R.id.recyclerview)
        tv_no_data = rootView!!.findViewById<TextView>(R.id.tv_no_data)

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

            if (musicListMusicIanBeanList.size < 0) {
                tv_no_data!!.setVisibility(View.VISIBLE)
                tv_no_data!!.setText("你还没有选定该工种的音乐人呢")
            } else {
                tv_no_data!!.setVisibility(View.GONE)
            }

            musicListMusicIanAdapter = RecruitPeopleAllFragmentAdapter(musicListMusicIanBeanList)
            recyclerview!!.setAdapter(musicListMusicIanAdapter)
        } else {
            musicListMusicIanAdapter!!.setNewData(musicListMusicIanBeanList)
        }
    }

    private fun ParticipateDate() {

        NetWork.getcontractlist(activity!!, "", "","", Integer.parseInt(require_id), object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                jsonPondData(resultData)
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {}
        })

//        val dataBean1 = SelectedMusicansBean.DataBean()
//        val dataBean11 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean11.project_title = "一白二穷工作室"
//        dataBean1.require_status = 0
//        val dataBean2 = SelectedMusicansBean.DataBean()
//        val dataBean22 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean22.project_title = "MortonWill莫顿"
//        dataBean2.require_status = 1
//        val dataBean3 = SelectedMusicansBean.DataBean()
//        val dataBean33 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean33.project_title = "机智过人的阿怜酱"
//        dataBean3.require_status = 2
//        val dataBean4 = SelectedMusicansBean.DataBean()
//        val dataBean44 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean44.project_title = "叶爱ryeowook"
//        dataBean4.require_status = 3
//        val dataBean5 = SelectedMusicansBean.DataBean()
//        val dataBean55 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean55.project_title = "夜雨寄北古风团队夜雨寄..."
//        dataBean5.require_status = 4
//
//        val dataBean6 = SelectedMusicansBean.DataBean()
//        val dataBean66 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean66.project_title = "一白二穷工作室"
//        dataBean6.require_status = 5
//        val dataBean7 = SelectedMusicansBean.DataBean()
//        val dataBean77 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean77.project_title = "MortonWill莫顿"
//        dataBean7.require_status = 6
//        val dataBean8 = SelectedMusicansBean.DataBean()
//        val dataBean88 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean88.project_title = "机智过人的阿怜酱"
//        dataBean8.require_status = 7
//        val dataBean9 = SelectedMusicansBean.DataBean()
//        val dataBean99 = SelectedMusicansBean.DataBean.ProjectBean()
//        dataBean99.project_title = "叶爱ryeowook"
//        dataBean9.require_status = 8
//
//
//        dataBean1.project = dataBean11
//        dataBean2.project = dataBean22
//        dataBean3.project = dataBean33
//        dataBean4.project = dataBean44
//        dataBean5.project = dataBean55
//        dataBean6.project = dataBean66
//        dataBean7.project = dataBean77
//        dataBean8.project = dataBean88
//
//        musicListMusicIanBeanList.add(dataBean1)
//        musicListMusicIanBeanList.add(dataBean2)
//        musicListMusicIanBeanList.add(dataBean3)
//        musicListMusicIanBeanList.add(dataBean4)
//        musicListMusicIanBeanList.add(dataBean5)
//        musicListMusicIanBeanList.add(dataBean6)
//        musicListMusicIanBeanList.add(dataBean7)
//        musicListMusicIanBeanList.add(dataBean8)
//        musicListMusicIanAdapter = RecruitPeopleAllFragmentAdapter(musicListMusicIanBeanList)
//        recyclerview!!.setAdapter(musicListMusicIanAdapter)
    }

    private fun jsonPondData(resultData: String) {
//        interRefresh?.setStopRefreshing()
        val selectedMusicansBean = JSON.parseObject(resultData, SelectedMusicansBean::class.java)
        val jsonArray = selectedMusicansBean?.data
        if (jsonArray!!.size > 0) {
//            rootView?.view_nodata?.visibility = View.GONE
            val toJSONString = JSON.toJSONString(jsonArray)
            val parse = JSON.parseArray(toJSONString, SelectedMusicansBean.DataBean::class.java)
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