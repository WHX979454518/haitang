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

class ParticipateFragment : RxFragment() {
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

    internal var musician_status: String? = ""

    internal var biaoshi: String? = ""
    private fun initEvent() {
        //上层穿过来的标识，判断是报名中还是待签约还是什么状态
        val bundle = arguments
        if (null != bundle!!.getString("biaoshi")) {
            biaoshi = bundle.getString("biaoshi")

            if(biaoshi.equals("报名中")){
                musician_status = "98"
            }else if(biaoshi.equals("待签约")){
                musician_status = "3"
            }else if(biaoshi.equals("待支付")){
                musician_status = "4"
            }else if(biaoshi.equals("进行中")){
                musician_status = "6"
            }else if(biaoshi.equals("待评价")){
                musician_status = "8"
            } else if(biaoshi.equals("已完成")){
                musician_status = "9"
            }else if(biaoshi.equals("已终止")){
                musician_status = "10"
            }
        }


        recyclerview = rootView!!.findViewById(R.id.recyclerview)
        tv_no_data = rootView!!.findViewById(R.id.tv_no_data)
        initdata()

        initdata()
    }

    private fun initdata() {
        //需要请求来tinachognshuju
        ParticipateDate()

        recyclerview!!.setLayoutManager(LinearLayoutManager(activity))
        if (musicListMusicIanAdapter == null) {

            if (musicListMusicIanBeanList.size < 0) {
                  tv_no_data!!.setVisibility(View.VISIBLE)
                  tv_no_data!!.setText("你还没有项目在进行中")
                }else{
                 tv_no_data!!.setVisibility(View.GONE)
            }
            musicListMusicIanAdapter = ParticipateFragmentAdapter(musicListMusicIanBeanList)
            recyclerview!!.setAdapter(musicListMusicIanAdapter)
        } else {
            musicListMusicIanAdapter!!.setNewData(musicListMusicIanBeanList)
        }
    }

    private fun ParticipateDate() {

        NetWork.getmusicancontract(activity!!, this!!.musician_status!!, "", object : NetWork.TokenCallBack {
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
            tv_no_data!!.setVisibility(View.VISIBLE)
            tv_no_data!!.setText("你还没有项目在进行中")
        }
    }
}