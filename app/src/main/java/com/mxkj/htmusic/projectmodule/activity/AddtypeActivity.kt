package com.mxkj.htmusic.projectmodule.activity

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.TextView
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.projectmodule.adapter.AddTypeWorkAdapter
import com.mxkj.htmusic.projectmodule.bean.NodeBean
import com.mxkj.htmusic.projectmodule.bean.TypeWorkBean
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import com.mxkj.yuanyintang.net.NetWork
import kotlinx.android.synthetic.main.activity_addtype.*
import kotlinx.android.synthetic.main.uc_navigationbar.*
import okhttp3.Headers
import java.util.*
import java.util.concurrent.TimeUnit

/*
添加工种
 */
class AddtypeActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {
    private val CHOOSE_CARD_REQUEST_CODE = 0x0003
    val CARD_BEAN = "CARD_BEAN"
    internal var resultIntent: Intent? = null
    internal var typekBean: TypeWorkBean.DataBean? =null
    private var typekBeanList = ArrayList<TypeWorkBean.DataBean>()

    internal lateinit var inflate: View
    internal lateinit var dialog: Dialog
    internal lateinit var wm: WindowManager
    internal lateinit var composition_rl:RelativeLayout
    internal lateinit var composition:TextView
    internal lateinit var lyrics_rl:RelativeLayout
    internal lateinit var lyrics:TextView
    internal lateinit var singer_rl:RelativeLayout
    internal lateinit var singer:TextView
    internal lateinit var arrangements_rl:RelativeLayout
    internal lateinit var arrangements:TextView
    internal lateinit var late_rl:RelativeLayout
    internal lateinit var late:TextView
    internal lateinit var cancel_rl:RelativeLayout
    internal lateinit var work_type_lv:ListView


    internal lateinit var ed_custom:EditText

    //节点集合
    private var nodeListone = ArrayList<NodeBean>()
    var nodeBeanone = NodeBean()
    private var nodeListtwo = ArrayList<NodeBean>()
    val nodeBeantwo = NodeBean()
    private var nodeListthree = ArrayList<NodeBean>()
    val nodeBeanthree = NodeBean()

    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    override fun setLayoutId(): Int {
        return R.layout.activity_addtype
    }

    override fun initView() {
        setTitleText("添加工种")
        rightButton.setText("保存")


        if(null!=intent.getSerializableExtra("typeBean")){
            var typeBean = TypeWorkBean.DataBean()
            typeBean = intent.getSerializableExtra("typeBean") as TypeWorkBean.DataBean
            add_type.setText(typeBean.title)
            add_budget.setText(typeBean.content)
            delect.visibility = View.VISIBLE
        }

        onViewClick()
    }

    private fun onViewClick() {
        RxView.clicks(rightButton)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
//                    val selectMusicTagTag = CacheUtils.getString(this@AddtypeActivity, "typekBeanList", "")
//                    if ((JSON.parseArray(selectMusicTagTag, TypeWorkBean.DataBean::class.java) as ArrayList<TypeWorkBean.DataBean>).size>0){
//                        val list = JSON.parseArray(selectMusicTagTag, TypeWorkBean.DataBean::class.java)
////                        typekBeanList.addAll(list)
//                    }
                    typekBean!!.title =add_type.text.toString()
                    typekBean!!.content =add_budget.text.toString()
//                    typekBean!!.content =add_cycle.text.toString()
//                    typekBean!!.content =add_time.text.toString()

                    val getMusicTagTag = CacheUtils.getString(this@AddtypeActivity, "typekBeanList", "")
                    if ((JSON.parseArray(getMusicTagTag, TypeWorkBean.DataBean::class.java) as ArrayList<TypeWorkBean.DataBean>).size>0) {
                        val list = JSON.parseArray(getMusicTagTag, TypeWorkBean.DataBean::class.java)
                        typekBeanList.addAll(list)
                        var newlist = ArrayList<TypeWorkBean.DataBean>()
                        newlist.addAll(list)
                        var title1=""
                        var title2=""
                        for (i in newlist.indices) {
                             title1 = newlist[i].title
                        }
                        for (i in typekBeanList.indices) {
                             title2 = typekBeanList[i].title
                        }
                        if(title1==typekBean!!.title){

                        }else{
                            typekBeanList.add(typekBean!!)
                        }
//                        if(title1==title2){
//
//                        }else{
//                            typekBeanList.add(typekBean!!)
//                        }
                    }else{
                        typekBeanList.add(typekBean!!)
                    }

                    CacheUtils.setString(this@AddtypeActivity, "typekBeanList", JSON.toJSONString(typekBeanList))
                    val intent = Intent()
                    intent.putExtra(CARD_BEAN, typekBean)
                    setResult(RESULT_OK, intent)
                    finish();

                }
        //删除公众
        RxView.clicks(delect)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    val getMusicTagTag = CacheUtils.getString(this@AddtypeActivity, "typekBeanList", "")
                    if ((JSON.parseArray(getMusicTagTag, TypeWorkBean.DataBean::class.java) as ArrayList<TypeWorkBean.DataBean>).size>0) {
                        val list = JSON.parseArray(getMusicTagTag, TypeWorkBean.DataBean::class.java)
                        typekBeanList.addAll(list)
                        for (i in typekBeanList.indices) {
                            var title2 = typekBeanList[i].title
                            val typeBean = typekBeanList[i]
                            if(add_type.text.toString() == title2){

                            }else{
                                typekBeanList = ArrayList<TypeWorkBean.DataBean>()
                                typekBeanList.add(typeBean!!)
                                CacheUtils.setString(this@AddtypeActivity, "typekBeanList", JSON.toJSONString(typekBeanList))
                                val intent = Intent()
                                intent.putExtra(CARD_BEAN, typeBean)
                                setResult(RESULT_OK, intent)
                                finish();
                            }
                        }



                    }else{

                    }
                }


        //增加20%节点
        RxView.clicks(node_ll20)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    if(margin20.text.toString().equals("")&&node_name1.text.toString().equals("")){

                    }else{
                        nodeBeanone.percentage = margin20.text.toString()
                        nodeBeanone.name = node_name1.text.toString()
                        nodeListone.add(nodeBeanone)
                    }
                    CacheUtils.setString(this@AddtypeActivity, "percentageone", JSON.toJSONString(nodeListone))
                    val intent = Intent(this@AddtypeActivity, AddNodeActivity::class.java)
                    intent.putExtra("biaoshi",1.toString())
                    startActivityForResult(intent, CHOOSE_CARD_REQUEST_CODE)
                }
        //增加50%节点
        RxView.clicks(node_ll50)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {

                    if(margin50.text.toString().equals("")&&node_name2.text.toString().equals("")){

                    }else{
                        nodeBeantwo.percentage = margin50.text.toString()
                        nodeBeantwo.name = node_name2.text.toString()
                        nodeListtwo.add(nodeBeantwo)
                    }
                    CacheUtils.setString(this@AddtypeActivity, "percentagetwo", JSON.toJSONString(nodeListtwo))
                    val intent = Intent(this@AddtypeActivity, AddNodeActivity::class.java)
                    intent.putExtra("biaoshi",2.toString())
                    startActivityForResult(intent, CHOOSE_CARD_REQUEST_CODE)
                }
        //增加80%节点
        RxView.clicks(node_ll80)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {
                    if(margin80.text.toString().equals("")&&node_name3.text.toString().equals("")){

                    }else{
                        nodeBeanthree.percentage = margin80.text.toString()
                        nodeBeanthree.name = node_name3.text.toString()
                        nodeListthree.add(nodeBeanthree)
                    }

                    CacheUtils.setString(this@AddtypeActivity, "percentagethree", JSON.toJSONString(nodeListthree))
                    val intent = Intent(this@AddtypeActivity, AddNodeActivity::class.java)
                    intent.putExtra("biaoshi",3.toString())
                    startActivityForResult(intent, CHOOSE_CARD_REQUEST_CODE)
                }

    }

    override fun initEvent() {
        /*
           选择工种的弹窗
         */
        dialog = Dialog(this@AddtypeActivity, R.style.ActionSheetDialogStyle)
        add_type_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@AddtypeActivity).inflate(R.layout.add_type__dialog, null)
            composition_rl = inflate.findViewById<RelativeLayout>(R.id.composition_rl)//作曲
            lyrics_rl = inflate.findViewById<RelativeLayout>(R.id.lyrics_rl)//作词
            singer_rl = inflate.findViewById<RelativeLayout>(R.id.singer_rl)//歌手
            arrangements_rl = inflate.findViewById<RelativeLayout>(R.id.arrangements_rl)//编曲
            late_rl = inflate.findViewById<RelativeLayout>(R.id.late_rl)//后期
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消

            composition = inflate.findViewById<TextView>(R.id.composition)//作曲
            lyrics = inflate.findViewById<TextView>(R.id.lyrics)//作词
            singer = inflate.findViewById<TextView>(R.id.singer)//歌手
            arrangements = inflate.findViewById<TextView>(R.id.arrangements)//编曲
            late = inflate.findViewById<TextView>(R.id.late)//后期

            work_type_lv = inflate.findViewById<ListView>(R.id.work_type_lv)//
            getDialog()

            getworktype(work_type_lv)

            composition_rl.setOnClickListener {
                add_type.setTextColor(Color.parseColor("#1a1a1a"))
                add_type.setText(composition.text.toString())
                dialog.cancel()
            }
            lyrics_rl.setOnClickListener {
                add_type.setTextColor(Color.parseColor("#1a1a1a"))
                add_type.setText(lyrics.text.toString())
                dialog.cancel()
            }
            singer_rl.setOnClickListener {
                add_type.setTextColor(Color.parseColor("#1a1a1a"))
                add_type.setText(singer.text.toString())
                dialog.cancel()
            }
            arrangements_rl.setOnClickListener {
                add_type.setTextColor(Color.parseColor("#1a1a1a"))
                add_type.setText(arrangements.text.toString())
                dialog.cancel()
            }
            late_rl.setOnClickListener {
                add_type.setText(late.text.toString())
                dialog.cancel()
            }
        }
        add_budget_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@AddtypeActivity).inflate(R.layout.add_budget__dialog, null)
            composition_rl = inflate.findViewById<RelativeLayout>(R.id.composition_rl)//作曲
            lyrics_rl = inflate.findViewById<RelativeLayout>(R.id.lyrics_rl)//作词
            singer_rl = inflate.findViewById<RelativeLayout>(R.id.singer_rl)//歌手
            arrangements_rl = inflate.findViewById<RelativeLayout>(R.id.arrangements_rl)//编曲
            late_rl = inflate.findViewById<RelativeLayout>(R.id.late_rl)//后期
            ed_custom = inflate.findViewById<EditText>(R.id.ed_custom)//自定义
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消

            composition = inflate.findViewById<TextView>(R.id.composition)//作曲
            lyrics = inflate.findViewById<TextView>(R.id.lyrics)//作词
            singer = inflate.findViewById<TextView>(R.id.singer)//歌手
            arrangements = inflate.findViewById<TextView>(R.id.arrangements)//编曲

            getDialog()
            composition_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(composition.text.toString())
                dialog.cancel()
            }
            lyrics_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(lyrics.text.toString())
                dialog.cancel()
            }
            singer_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(singer.text.toString())
                dialog.cancel()
            }
            arrangements_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(arrangements.text.toString())
                dialog.cancel()
            }
            late_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(late.text.toString())
                dialog.cancel()
            }
            late_rl.setOnClickListener {
                add_budget.setTextColor(Color.parseColor("#1a1a1a"))
                add_budget.setText(ed_custom.text.toString())
                dialog.cancel()
            }
        }
        add_cycle_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@AddtypeActivity).inflate(R.layout.add_cycle__dialog, null)
            composition_rl = inflate.findViewById<RelativeLayout>(R.id.composition_rl)//作曲
            lyrics_rl = inflate.findViewById<RelativeLayout>(R.id.lyrics_rl)//作词
            singer_rl = inflate.findViewById<RelativeLayout>(R.id.singer_rl)//歌手
            arrangements_rl = inflate.findViewById<RelativeLayout>(R.id.arrangements_rl)//编曲
            late_rl = inflate.findViewById<RelativeLayout>(R.id.late_rl)//后期
            ed_custom = inflate.findViewById<EditText>(R.id.ed_custom)//自定义
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消

            composition = inflate.findViewById<TextView>(R.id.composition)//作曲
            lyrics = inflate.findViewById<TextView>(R.id.lyrics)//作词
            singer = inflate.findViewById<TextView>(R.id.singer)//歌手
            arrangements = inflate.findViewById<TextView>(R.id.arrangements)//编曲


            getDialog()


            composition_rl.setOnClickListener {
                add_cycle.setTextColor(Color.parseColor("#1a1a1a"))
                add_cycle.setText(composition.text.toString())
                dialog.cancel()
            }
            lyrics_rl.setOnClickListener {
                add_cycle.setTextColor(Color.parseColor("#1a1a1a"))
                add_cycle.setText(lyrics.text.toString())
                dialog.cancel()
            }
            singer_rl.setOnClickListener {
                add_cycle.setTextColor(Color.parseColor("#1a1a1a"))
                add_cycle.setText(singer.text.toString())
                dialog.cancel()
            }
            arrangements_rl.setOnClickListener {
                add_cycle.setTextColor(Color.parseColor("#1a1a1a"))
                add_cycle.setText(arrangements.text.toString())
                dialog.cancel()
            }
            late_rl.setOnClickListener {
                add_cycle.setTextColor(Color.parseColor("#1a1a1a"))
                add_cycle.setText(ed_custom.text.toString())
                dialog.cancel()
            }
        }
        add_time_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@AddtypeActivity).inflate(R.layout.add_creationtime__dialog, null)
            composition_rl = inflate.findViewById<RelativeLayout>(R.id.composition_rl)//作曲
            lyrics_rl = inflate.findViewById<RelativeLayout>(R.id.lyrics_rl)//作词
            singer_rl = inflate.findViewById<RelativeLayout>(R.id.singer_rl)//歌手
            arrangements_rl = inflate.findViewById<RelativeLayout>(R.id.arrangements_rl)//编曲
            late_rl = inflate.findViewById<RelativeLayout>(R.id.late_rl)//后期
            ed_custom = inflate.findViewById<EditText>(R.id.ed_custom)//自定义
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消

            composition = inflate.findViewById<TextView>(R.id.composition)//作曲
            lyrics = inflate.findViewById<TextView>(R.id.lyrics)//作词
            singer = inflate.findViewById<TextView>(R.id.singer)//歌手
            arrangements = inflate.findViewById<TextView>(R.id.arrangements)//编曲

            getDialog()
            composition_rl.setOnClickListener {
                add_time.setTextColor(Color.parseColor("#1a1a1a"))
                add_time.setText(composition.text.toString())
                dialog.cancel()
            }
            lyrics_rl.setOnClickListener {
                add_time.setTextColor(Color.parseColor("#1a1a1a"))
                add_time.setText(lyrics.text.toString())
                dialog.cancel()
            }
            singer_rl.setOnClickListener {
                add_time.setTextColor(Color.parseColor("#1a1a1a"))
                add_time.setText(singer.text.toString())
                dialog.cancel()
            }
            arrangements_rl.setOnClickListener {
                add_time.setTextColor(Color.parseColor("#1a1a1a"))
                add_time.setText(arrangements.text.toString())
                dialog.cancel()
            }
            late_rl.setOnClickListener {
                add_time.setTextColor(Color.parseColor("#1a1a1a"))
                add_time.setText(ed_custom.text.toString())
                dialog.cancel()
            }
        }
    }

    override fun initData() {

    }

    fun getDialog(){
        cancel_rl.setOnClickListener(View.OnClickListener { dialog.cancel() })
        //将布局设置给Dialog
        dialog.setContentView(inflate)
        //获取当前Activity所在的窗体
        val dialogWindow1 = dialog.window
        //设置Dialog从窗体底部弹出
        dialogWindow1!!.setGravity(Gravity.BOTTOM)
        //获得窗体的属性
        val lp1 = dialogWindow1.attributes
        lp1.y = 0//设置Dialog距离底部的距离
        wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val d1 = wm.getDefaultDisplay() // 获取屏幕宽、高度
//        val d1 = wm.getDefaultDisplay() // 获取屏幕宽、高度
        val p1 = dialogWindow1.attributes // 获取对话框当前的参数值
        p1.height = (748).toInt(); // 高度设置为屏幕的0.6，根据实际情况
        p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
        //    将属性设置给窗体
        dialogWindow1.attributes = lp1
        dialog.show()//显示对话框
    }

    //获取工种类型
    private fun getworktype(work_type_lv:ListView) {
        NetWork.getworktype(this@AddtypeActivity, 0, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                //工种类型
                val typeWorkBean = JSON.parseObject(resultData, TypeWorkBean::class.java)
                val dataArray = typeWorkBean?.data
                val toJSONString = JSON.toJSONString(dataArray)
                val parse = JSON.parseArray(toJSONString, TypeWorkBean.DataBean::class.java)
                val parseArray = ArrayList<TypeWorkBean.DataBean>()
                parseArray.addAll(parse)
                val addTypeWorkAdapter = AddTypeWorkAdapter(parseArray,this@AddtypeActivity)
                work_type_lv.adapter = addTypeWorkAdapter
                work_type_lv.setOnItemClickListener { parent, view, position, id ->
                    typekBean = parseArray[position]
                    add_type.setText("")
                    add_type.setText(typekBean!!.title)
                    dialog.cancel()


//                    val addWorkTypeHelper = AddWorkTypeHelper(this@AddtypeActivity)
//                    val addWorkTypeDb = AddWorkTypeDb(addWorkTypeHelper)
//                    addWorkTypeDb.add(typekBean)
                }

            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==CHOOSE_CARD_REQUEST_CODE){
            if(null!=data){
                if(null!=data!!.getSerializableExtra(CARD_BEAN)){
                    nodeBeanone = data!!.getSerializableExtra(CARD_BEAN) as NodeBean

                    Log.e("ttttttt",""+data.getStringExtra("biaoshi"))
                    if(data.getStringExtra("biaoshi").equals("1")){
                        margin20.setText(nodeBeanone.percentage)
                        node_name1.setText(nodeBeanone.name)
                    }else if(data.getStringExtra("biaoshi").equals("2")){
                        margin50.setText(nodeBeanone.percentage)
                        node_name2.setText(nodeBeanone.name)
                    }else if(data.getStringExtra("biaoshi").equals("3")){
                        margin80.setText(nodeBeanone.percentage)
                        node_name3.setText(nodeBeanone.name)
                    }
                }else{
                    return
                }
            }
        }
    }

}