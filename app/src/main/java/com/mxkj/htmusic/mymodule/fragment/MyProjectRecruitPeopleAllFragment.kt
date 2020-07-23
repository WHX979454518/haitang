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
import com.mxkj.htmusic.mymodule.adapter.MyProjectRecruitPeopleAllFragmentAdapter
import com.mxkj.htmusic.mymodule.bean.MyProjectRecruitBean
import com.mxkj.yuanyintang.net.NetWork
import com.trello.rxlifecycle2.components.support.RxFragment
import okhttp3.Headers
import java.util.ArrayList

class MyProjectRecruitPeopleAllFragment : RxFragment() {
    private var rootView: View? = null
    private var recyclerview: RecyclerView? = null
    private var musicListMusicIanAdapter: MyProjectRecruitPeopleAllFragmentAdapter? = null
    private val musicListMusicIanBeanList = ArrayList<MyProjectRecruitBean.DataBean>()
    private var tv_no_data: TextView? = null



//    internal var work_type_id: String? = ""
//    internal var require_id: String? = ""


    private var page: Int = 1

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

            if (musicListMusicIanBeanList.size < 0) {
                tv_no_data!!.setVisibility(View.VISIBLE)
                tv_no_data!!.setText("你还没有选定该工种的音乐人呢")
            } else {
                tv_no_data!!.setVisibility(View.GONE)
            }

            musicListMusicIanAdapter = MyProjectRecruitPeopleAllFragmentAdapter(musicListMusicIanBeanList, fragmentManager)
            recyclerview!!.setAdapter(musicListMusicIanAdapter)
        } else {
            musicListMusicIanAdapter!!.setNewData(musicListMusicIanBeanList)
        }
    }

    private fun ParticipateDate() {

        NetWork.getproject(activity!!, "", "", object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                jsonPondData(resultData)
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {}
        })



//        val dataBean1 = ProjectListBean.DataBean()
//        dataBean1.project_title = "一白二穷工作室"
//        //        dataBean1.setHead("0");
//        val dataBean2 = ProjectListBean.DataBean()
//        dataBean2.project_title = "MortonWill莫顿"
//        //        dataBean2.setHead("1");
//        val dataBean3 = ProjectListBean.DataBean()
//        dataBean3.project_title = "机智过人的阿怜酱"
//        //        dataBean3.setHead("4");
//        val dataBean4 = ProjectListBean.DataBean()
//        dataBean4.project_title = "叶爱ryeowook"
//        //        dataBean4.setHead("2");
//        val dataBean5 = ProjectListBean.DataBean()
//        dataBean5.project_title = "夜雨寄北古风团队夜雨寄..."
//        //        dataBean5.setHead("3");
//        musicListMusicIanBeanList.add(dataBean1)
//        musicListMusicIanBeanList.add(dataBean2)
//        musicListMusicIanBeanList.add(dataBean3)
//        musicListMusicIanBeanList.add(dataBean4)
//        musicListMusicIanBeanList.add(dataBean5)
    }

    private fun jsonPondData(resultData: String) {
//        interRefresh?.setStopRefreshing()
        val signUpMusicansBean = JSON.parseObject(resultData, MyProjectRecruitBean::class.java)
        val jsonArray = signUpMusicansBean?.data
        if (jsonArray!!.size > 0) {
//            rootView?.view_nodata?.visibility = View.GONE
            val toJSONString = JSON.toJSONString(jsonArray)
            val parse = JSON.parseArray(toJSONString, MyProjectRecruitBean.DataBean::class.java)
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