package com.mxkj.htmusic.projectmodule.activity

import android.content.Intent
import android.support.design.widget.AppBarLayout
import android.util.Log
import android.view.View
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.projectmodule.bean.NodeBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import kotlinx.android.synthetic.main.activity_addnode.*
import java.util.ArrayList
import java.util.concurrent.TimeUnit

/*
增加节点
 */
class AddNodeActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {


    private var nodeBeanList = ArrayList<NodeBean>()
    private val CHOOSE_CARD_REQUEST_CODE = 0x0003
    val CARD_BEAN = "CARD_BEAN"
    //节点集合
    private var nodeListone = ArrayList<NodeBean>()
    var nodeBeanone = NodeBean()
    private var nodeListtwo = ArrayList<NodeBean>()
    var nodeBeantwo = NodeBean()
    private var nodeListthree = ArrayList<NodeBean>()
    var nodeBeanthree = NodeBean()
    var getMusicTagTagone:String = ""


    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    override fun setLayoutId(): Int {
        return R.layout.activity_addnode
    }

    override fun initView() {
        hideTitle(true)


        if(null!=intent.getStringExtra("biaoshi")){
            if(intent.getStringExtra("biaoshi").equals("1")){
                getMusicTagTagone = CacheUtils.getString(this@AddNodeActivity, "percentageone", "")!!
            }else if(intent.getStringExtra("biaoshi").equals("2")){
                getMusicTagTagone = CacheUtils.getString(this@AddNodeActivity, "percentagetwo", "")!!
            }else if(intent.getStringExtra("biaoshi").equals("3")){
                getMusicTagTagone = CacheUtils.getString(this@AddNodeActivity, "percentagethree", "")!!
            }
        }

//        val getMusicTagTagtwo = CacheUtils.getString(this@AddNodeActivity, "percentagetwo", "")
//        val getMusicTagTagthree = CacheUtils.getString(this@AddNodeActivity, "percentagethree", "")
        if ((JSON.parseArray(getMusicTagTagone, NodeBean::class.java) as ArrayList<NodeBean>).size>0) {
            val list = JSON.parseArray(getMusicTagTagone, NodeBean::class.java)
            nodeBeanList.addAll(list)
            if(nodeBeanList.get(nodeBeanList.size-1).name == ""){

            }else{
                delect_node.visibility = View.VISIBLE
            }
            node_ed.setText(nodeBeanList.get(nodeBeanList.size-1).name)
            node_margin_ed.setText(nodeBeanList.get(nodeBeanList.size-1).percentage)
        }

//


        onViewClick()
    }

    private fun onViewClick() {
        //保存节点
        RxView.clicks(node_save)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    nodeBeanone.name = node_ed.text.toString()
                    nodeBeanone.percentage = node_margin_ed.text.toString()
                    nodeListone.add(nodeBeanone)

                    CacheUtils.setString(this@AddNodeActivity, "percentageone", JSON.toJSONString(nodeListone))
                    CacheUtils.setString(this@AddNodeActivity, "percentagetwo", JSON.toJSONString(nodeListone))
                    CacheUtils.setString(this@AddNodeActivity, "percentagethree", JSON.toJSONString(nodeListone))
                    val intentintent = Intent()
                    intentintent.putExtra(CARD_BEAN, nodeBeanone)
                    intentintent.putExtra("biaoshi",intent.getStringExtra("biaoshi"))
                    Log.e("hhhhhhhh",""+intent.getStringExtra("biaoshi"))
                    setResult(RESULT_OK, intentintent)
                    finish();
                }
        //刪除节点
        RxView.clicks(delect_node)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    node_ed.setText("")
                    node_margin_ed.setText("")
                    nodeBeanone.name = node_ed.text.toString()
                    nodeBeanone.percentage = node_margin_ed.text.toString()
                    nodeListone.add(nodeBeanone)
                    CacheUtils.setString(this@AddNodeActivity, "percentageone", JSON.toJSONString(nodeListone))
                    CacheUtils.setString(this@AddNodeActivity, "percentagetwo", JSON.toJSONString(nodeListone))
                    CacheUtils.setString(this@AddNodeActivity, "percentagethree", JSON.toJSONString(nodeListone))
                    val intentintent = Intent()
                    intentintent.putExtra(CARD_BEAN, nodeBeanone)
                    intentintent.putExtra("biaoshi",intent.getStringExtra("biaoshi"))
                    Log.e("hhhhhhhh",""+intent.getStringExtra("biaoshi"))
                    setResult(RESULT_OK, intentintent)
                    finish();
                }

    }

    override fun initEvent() {

    }

    override fun initData() {

    }
}