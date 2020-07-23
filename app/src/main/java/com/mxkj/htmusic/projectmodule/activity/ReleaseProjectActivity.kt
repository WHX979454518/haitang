package com.mxkj.htmusic.projectmodule.activity

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.support.design.widget.AppBarLayout
import android.text.InputType
import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_releasprogect.*
import kotlinx.android.synthetic.main.uc_navigationbar.*
import java.lang.reflect.Method
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import com.alibaba.fastjson.JSON
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import com.mxkj.htmusic.toolmodule.utils.MultiLineRadioGroup
import java.util.ArrayList
import android.view.WindowManager
import android.widget.*
import com.google.gson.Gson
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil
import com.mxkj.htmusic.projectmodule.adapter.TypeWorkAdapter
import com.mxkj.htmusic.projectmodule.adapter.WorkPurposesAdapter
import com.mxkj.htmusic.projectmodule.bean.*
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo
import com.mxkj.htmusic.toolmodule.utils.Constants
import com.mxkj.htmusic.toolmodule.utils.MyListView
import com.mxkj.htmusic.toolmodule.utils.customkeyboard.KeyboardUtil
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.yuanyintang.net.NetWork
import okhttp3.Headers
import java.util.concurrent.TimeUnit

/*
发布项目
 */
class ReleaseProjectActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {

    //用来接收公众页面返回的工种数据
    private val CHOOSE_CARD_REQUEST_CODE = 0x0003
    val CARD_BEAN = "CARD_BEAN"
    private var typeBean: TypeWorkBean.DataBean? = null

    internal lateinit var inflate: View
    internal lateinit var dialog: Dialog
    internal lateinit var wm: WindowManager
    internal lateinit var mulrg_tag:MultiLineRadioGroup
    internal lateinit var determine:TextView

    internal lateinit var composition_rl:RelativeLayout
    internal lateinit var composition:TextView
    internal lateinit var lyrics_rl:RelativeLayout
    internal lateinit var lyrics:TextView
    internal lateinit var singer_rl:RelativeLayout
    internal lateinit var singer:TextView
    internal lateinit var arrangements_rl:RelativeLayout
    internal lateinit var arrangements:TextView
    internal lateinit var late_rl:RelativeLayout
    internal lateinit var tv_rl:RelativeLayout
    internal lateinit var network_rl:RelativeLayout
    internal lateinit var all_channels_rl:RelativeLayout
    internal lateinit var late:TextView
    internal lateinit var tv:TextView
    internal lateinit var network:TextView
    internal lateinit var all_channels:TextView
    internal lateinit var projectdetails_lv: MyListView
    internal lateinit var projectdetails_list_lv: ListView

    internal lateinit var cancel_rl:RelativeLayout

    internal lateinit var ed_custom:EditText

    internal lateinit var releasproject_lv: MyListView


    internal lateinit var et_price:EditText
    internal lateinit var ll_price_select: LinearLayout



//    var taskprogress = ArrayList<Task.Progress>()

    var newlist = ArrayList<TypeWorkBean.DataBean>()



    internal var detialBean: WorkPurposesBean.DataBean? =null
    internal var itemdetialBean: WorkPurposesBean.DataBean? =null
    var ids :String= ""

    var str1:String = ""
    var str2:String = ""
    var str3 = 0
    var str4 = 0


    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    override fun setLayoutId(): Int {
        return R.layout.activity_releasprogect
    }

    override fun initView() {
        setTitleText("发布项目")
        rightButton.setText("保存")
        disableShowSoftInput()
        onViewClick()
    }

    override fun initEvent() {
        val keyboardUtil = KeyboardUtil(this@ReleaseProjectActivity)
        et_price = findViewById(R.id.et_price)
        ll_price_select = findViewById(R.id.ll_price_select)
        keyboardUtil.setOnOkClick {
            if (validate()) {
                ll_price_select.visibility = View.GONE
                tv_confidentiality_period.setText(et_price.text)
            }
        }
        keyboardUtil.setOnCancelClick {
            ll_price_select.visibility = View.GONE
            tv_confidentiality_period.setText(et_price.text)
        }

        et_price.setOnTouchListener { v, event ->
            keyboardUtil.attachTo(et_price)
            false
        }

        /*
          选择工种的弹窗
        */
        dialog = Dialog(this@ReleaseProjectActivity, R.style.ActionSheetDialogStyle)
        work_purposes_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@ReleaseProjectActivity).inflate(R.layout.release_project__work_purposes__dialog, null)
            composition_rl = inflate.findViewById<RelativeLayout>(R.id.composition_rl)//作曲
            lyrics_rl = inflate.findViewById<RelativeLayout>(R.id.lyrics_rl)//作词
            singer_rl = inflate.findViewById<RelativeLayout>(R.id.singer_rl)//歌手
            arrangements_rl = inflate.findViewById<RelativeLayout>(R.id.arrangements_rl)//编曲
            late_rl = inflate.findViewById<RelativeLayout>(R.id.late_rl)//后期
            tv_rl = inflate.findViewById<RelativeLayout>(R.id.tv_rl)//电视
            network_rl = inflate.findViewById<RelativeLayout>(R.id.network_rl)//网络
            all_channels_rl = inflate.findViewById<RelativeLayout>(R.id.all_channels_rl)//全渠道

            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消

            composition = inflate.findViewById<TextView>(R.id.composition)//作曲
            lyrics = inflate.findViewById<TextView>(R.id.lyrics)//作词
            singer = inflate.findViewById<TextView>(R.id.singer)//歌手
            arrangements = inflate.findViewById<TextView>(R.id.arrangements)//编曲
            late = inflate.findViewById<TextView>(R.id.late)//后期
            tv = inflate.findViewById<TextView>(R.id.tv)//电视
            network = inflate.findViewById<TextView>(R.id.network)//网络
            all_channels = inflate.findViewById<TextView>(R.id.all_channels)//全渠道

            projectdetails_lv = inflate.findViewById<MyListView>(R.id.projectdetails_lv)//获取作品用途(使用范围)
            projectdetails_list_lv= inflate.findViewById<ListView>(R.id.projectdetails_list_lv)//获取使用渠道
            getDialog()

            getUsescope()

            composition_rl.setOnClickListener {
                tv_work_purposes.setTextColor(Color.parseColor("#1a1a1a"))
                tv_work_purposes.setText(composition.text.toString())
                composition.setTextColor(Color.parseColor("#14b4aa"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
//                dialog.cancel()
            }
            lyrics_rl.setOnClickListener {
                tv_work_purposes.setTextColor(Color.parseColor("#1a1a1a"))
                tv_work_purposes.setText(lyrics.text.toString())
                lyrics.setTextColor(Color.parseColor("#14b4aa"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
//                dialog.cancel()
            }
            singer_rl.setOnClickListener {
                tv_work_purposes.setTextColor(Color.parseColor("#1a1a1a"))
                tv_work_purposes.setText(singer.text.toString())
                singer.setTextColor(Color.parseColor("#14b4aa"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))

//                dialog.cancel()
            }
            arrangements_rl.setOnClickListener {
                tv_work_purposes.setTextColor(Color.parseColor("#1a1a1a"))
                tv_work_purposes.setText(arrangements.text.toString())
                arrangements.setTextColor(Color.parseColor("#14b4aa"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
//                dialog.cancel()
            }
            late_rl.setOnClickListener {
                tv_work_purposes.setText(late.text.toString())
                late.setTextColor(Color.parseColor("#14b4aa"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
//                dialog.cancel()
            }
            tv_rl.setOnClickListener {
                if(!tv_work_purposes.text.toString().equals("")){
                    if(tv_work_purposes.text.toString().contains("-")){
                        val loc = tv_work_purposes.text.toString().indexOf("-")//首先获取字符的位置
                        val newStr = tv_work_purposes.text.toString().substring(0, loc)//再对字符串进行截取，获得想要得到的字符串
                        tv_work_purposes.setText(newStr+"-"+tv.text.toString())
                    }else{
                        tv_work_purposes.setText(tv_work_purposes.text.toString()+"-"+tv.text.toString())
                    }
                }else{
                    tv_work_purposes.setText(tv_work_purposes.text.toString()+tv.text.toString())
                }
                tv.setTextColor(Color.parseColor("#14b4aa"))
                delay(dialog)
//                dialog.cancel()
            }
            network_rl.setOnClickListener {
                if(!tv_work_purposes.text.toString().equals("")){
                    if(tv_work_purposes.text.toString().contains("-")){
                        val loc = tv_work_purposes.text.toString().indexOf("-")//首先获取字符的位置
                        val newStr = tv_work_purposes.text.toString().substring(0, loc)//再对字符串进行截取，获得想要得到的字符串
                        tv_work_purposes.setText(newStr+"-"+network.text.toString())
                    }else{
                        tv_work_purposes.setText(tv_work_purposes.text.toString()+"-"+network.text.toString())
                    }
                }else{
                    tv_work_purposes.setText(tv_work_purposes.text.toString()+network.text.toString())
                }
                network.setTextColor(Color.parseColor("#14b4aa"))
                delay(dialog)
//                dialog.cancel()
            }
            all_channels_rl.setOnClickListener {
                if(!tv_work_purposes.text.toString().equals("")){
                    if(tv_work_purposes.text.toString().contains("-")){
                        val loc = tv_work_purposes.text.toString().indexOf("-")//首先获取字符的位置
                        val newStr = tv_work_purposes.text.toString().substring(0, loc)//再对字符串进行截取，获得想要得到的字符串
                        tv_work_purposes.setText(newStr+"-"+all_channels.text.toString())
                    }else{
                        tv_work_purposes.setText(tv_work_purposes.text.toString()+"-"+all_channels.text.toString())
                    }
                }else{
                    tv_work_purposes.setText(tv_work_purposes.text.toString()+all_channels.text.toString())
                }
                all_channels.setTextColor(Color.parseColor("#14b4aa"))
                delay(dialog)
//                dialog.cancel()
            }

        }
        confidentiality_period_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@ReleaseProjectActivity).inflate(R.layout.release_project_confidentility_dialog, null)
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
            p1.height = (810).toInt(); // 高度设置为屏幕的0.6，根据实际情况
            p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
            //    将属性设置给窗体
            dialogWindow1.attributes = lp1
            dialog.show()//显示对话框
            composition_rl.setOnClickListener {
                tv_confidentiality_period.setTextColor(Color.parseColor("#1a1a1a"))
                tv_confidentiality_period.setText(composition.text.toString())
                composition.setTextColor(Color.parseColor("#14b4aa"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
                delay(dialog)
            }
            lyrics_rl.setOnClickListener {
                tv_confidentiality_period.setTextColor(Color.parseColor("#1a1a1a"))
                tv_confidentiality_period.setText(lyrics.text.toString())
                lyrics.setTextColor(Color.parseColor("#14b4aa"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
                delay(dialog)
            }
            singer_rl.setOnClickListener {
                tv_confidentiality_period.setTextColor(Color.parseColor("#1a1a1a"))
                tv_confidentiality_period.setText(singer.text.toString())
                singer.setTextColor(Color.parseColor("#14b4aa"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
                delay(dialog)
            }
            arrangements_rl.setOnClickListener {
                tv_confidentiality_period.setTextColor(Color.parseColor("#1a1a1a"))
                tv_confidentiality_period.setText(arrangements.text.toString())
                arrangements.setTextColor(Color.parseColor("#14b4aa"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                late.setTextColor(Color.parseColor("#1a1a1a"))
                delay(dialog)
            }
            late_rl.setOnClickListener {
                tv_confidentiality_period.setTextColor(Color.parseColor("#1a1a1a"))
                tv_confidentiality_period.setText(ed_custom.text.toString())
                late.setTextColor(Color.parseColor("#14b4aa"))
                arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                singer.setTextColor(Color.parseColor("#1a1a1a"))
                lyrics.setTextColor(Color.parseColor("#1a1a1a"))
                composition.setTextColor(Color.parseColor("#1a1a1a"))
                dialog.cancel()
                ll_price_select.visibility = View.VISIBLE
                keyboardUtil.attachTo(et_price)
                et_price.isFocusable = true
                et_price.isFocusableInTouchMode = true
                et_price.requestFocus()
            }

//            val keyboardUtil = KeyboardUtil(this@ReleaseProjectActivity)
//            ed_custom.setOnClickListener {
//                keyboardUtil.attachTo(ed_custom)
//                ed_custom.setFocusable(true)
//                ed_custom.setFocusableInTouchMode(true)
//                ed_custom.requestFocus()
//            }

        }
        work_style_rl.setOnClickListener {
            inflate = LayoutInflater.from(this@ReleaseProjectActivity).inflate(R.layout.release_project_work_style_dialog, null)
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消
            mulrg_tag = inflate.findViewById<MultiLineRadioGroup>(R.id.mulrg_tag)//风格标签
            determine = inflate.findViewById<TextView>(R.id.determine)//确定
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
            p1.height = (500).toInt(); // 高度设置为屏幕的0.6，根据实际情况
            p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
            //    将属性设置给窗体
            dialogWindow1.attributes = lp1
            dialog.show()//显示对话框
            cancel_rl.setOnClickListener(View.OnClickListener { dialog.cancel() })
            initHotTagData()
            determine.setOnClickListener(View.OnClickListener {
                var toastagList = ArrayList<String>()
                selectedTagList.indices.forEach {
                    toastagList.add(selectedTagList.get(it).title)
                }
                tv_work_style.setText(listToString(toastagList))
                dialog.cancel()
            })
        }
        release_project_add_type.setOnClickListener {
//            val intent = Intent(this@ReleaseProjectActivity, AddtypeActivity::class.java)
//            startActivity(intent)
            CacheUtils.setString(this@ReleaseProjectActivity, "typekBeanList", JSON.toJSONString(newlist))
            val intent = Intent(this@ReleaseProjectActivity, AddtypeActivity::class.java)
            startActivityForResult(intent, CHOOSE_CARD_REQUEST_CODE)
        }
        demand_describe_rl.setOnClickListener {
            val intent = Intent(this@ReleaseProjectActivity, RequirementsDescribeActivity::class.java)
            startActivityForResult(intent, 1)
        }
        demand_describe.setOnClickListener {
            val intent = Intent(this@ReleaseProjectActivity, RequirementsDescribeActivity::class.java)
//            startActivityForResult(intent, 1)
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

    //点击输入框不弹出软键盘
    fun disableShowSoftInput() {
        if (android.os.Build.VERSION.SDK_INT <= 10) {
            demand_describe.setInputType(InputType.TYPE_NULL)
        } else {
            val cls = EditText::class.java
            val method: Method
            try {
                method = cls.getMethod("setShowSoftInputOnFocus", Boolean::class.javaPrimitiveType!!)
                method.setAccessible(true)
                method.invoke(demand_describe, false)
            } catch (e: Exception) {
            }

        }
    }
    fun delay(dialog: Dialog){
        object : Thread() {
            override fun run() {
                super.run()
                try {
                    Thread.sleep(1000)//休眠3秒
                    /**
                     * 要执行的操作
                     */
                    dialog.cancel()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }

    private var selectedTagList = ArrayList<ProjectStyleTagListBean.DataBean>()
    private fun initHotTagData() {
        //                val pondHotTagBean = JSON.parseObject(resultData, ProjectStyleTagListBean::class.java)
//                val dataArray = pondHotTagBean?.data
//                val toJSONString = JSON.toJSONString(dataArray)
//                val parseArray = JSON.parseArray(toJSONString, ProjectStyleTagListBean.DataBean.TagBean::class.java)
        NetWork.getworkstyle(this@ReleaseProjectActivity, 0, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                val jsonObject = JSON.parseObject(resultData)
                val pondHotTagBean = JSON.parseObject(resultData, ProjectStyleTagListBean::class.java)
                val dataArray = pondHotTagBean?.data
                val toJSONString = JSON.toJSONString(dataArray)
                val parseArray = JSON.parseArray(toJSONString, ProjectStyleTagListBean.DataBean::class.java)
//                val msg = jsonObject.getString("msg")!!
//                setSnackBar(msg, "", R.drawable.icon_fails)
                if (parseArray != null && parseArray.size > 0) {
                    mulrg_tag.removeAllViews()
                    mulrg_tag.setChoiceMode(false)
                    parseArray.indices.forEach {
                        mulrg_tag.insert(it, parseArray[it].title)
                        var biaoshi:Int? =parseArray.get(it).id
                        var pos:Int? =it
                        if(null!=selectedTagList&&selectedTagList.size>0){
                            selectedTagList.indices.forEach {
                                if(selectedTagList.get(it).id==biaoshi){
                                    mulrg_tag.setItemChecked(pos!!)
                                }
                            }
                        }
                    }
                    mulrg_tag.setOnCheckChangedListener { view, position, checked ->
                        val tagBean = parseArray[position]
                        //加载完成标签以后吧原来存的标签清空
//                        selectedTagList.clear()
                        if (checked) {
                            if (selectedTagList.size < 9) {
                                selectedTagList.forEach {
                                    if (it.id == tagBean.id) {
                                        selectedTagList.remove(it)
                                    }
                                }
                                selectedTagList.add(tagBean)
                            } else {
                                (view.getChildAt(position) as CheckBox).isChecked = false
                                setSnackBar("最多添加9个标签哦！", "", R.drawable.icon_fails)
                            }
                            CacheUtils.setString(this@ReleaseProjectActivity, "selectMusicTag", JSON.toJSONString(selectedTagList))
                        } else {

                            selectedTagList.forEach {
                                if (it.id == tagBean.id) {
                                    selectedTagList.remove(it)
                                }
                            }
                            CacheUtils.setString(this@ReleaseProjectActivity, "selectMusicTag", JSON.toJSONString(selectedTagList))
                        }
                    }
                }

            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }

    fun validate(): Boolean {
        if (et_price.text.toString() == "") {
            Toast.makeText(application, "天数不能为空", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    //获取作品用途(使用范围)
    private fun getUsescope() {
        NetWork.getusescope(this@ReleaseProjectActivity, 0, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                val jsonObject = JSON.parseObject(resultData)
                val msg = jsonObject.getString("msg")!!
                setSnackBar(msg, "", R.drawable.icon_fails)


                //作品用途
                val workPurposesBean = JSON.parseObject(resultData, WorkPurposesBean::class.java)
                val dataArray = workPurposesBean?.data
                val toJSONString = JSON.toJSONString(dataArray)
                val parse = JSON.parseArray(toJSONString, WorkPurposesBean.DataBean::class.java)
                val parseArray = ArrayList<WorkPurposesBean.DataBean>()
                parseArray.addAll(parse)
                val workPurposesAdapter = WorkPurposesAdapter(parseArray,this@ReleaseProjectActivity)
                projectdetails_lv.adapter = workPurposesAdapter


                projectdetails_lv.setOnItemClickListener { parent, view, position, id ->
                    detialBean = parseArray[position]
//                    view.setBackgroundColor(Color.WHITE)
                    lyrics.setTextColor(Color.parseColor("#14b4aa"))
                    composition.setTextColor(Color.parseColor("#1a1a1a"))
                    singer.setTextColor(Color.parseColor("#1a1a1a"))
                    arrangements.setTextColor(Color.parseColor("#1a1a1a"))
                    late.setTextColor(Color.parseColor("#1a1a1a"))
                    NetWork.getusechannel(this@ReleaseProjectActivity, detialBean!!.id, object : NetWork.TokenCallBack {
                        override fun doNext(resultData: String, headers: Headers?) {
                            //部分平台
                            val workPurposes = JSON.parseObject(resultData, WorkPurposesBean::class.java)
                            val dataArray = workPurposesBean?.data
                            val toJSONString = JSON.toJSONString(dataArray)
                            val parse = JSON.parseArray(toJSONString, WorkPurposesBean.DataBean::class.java)
                            val parseArray = ArrayList<WorkPurposesBean.DataBean>()
                            parseArray.addAll(parse)
                            val workPurposesAdapter = WorkPurposesAdapter(parseArray,this@ReleaseProjectActivity)
                            projectdetails_list_lv.adapter = workPurposesAdapter

                            tv_work_purposes.setText("")
                            tv_work_purposes.setText(detialBean!!.content)

                            projectdetails_list_lv.setOnItemClickListener { parent, view, position, id ->
                                itemdetialBean = parseArray[position]
                                tv_work_purposes.setText("")
                                tv_work_purposes.setText(detialBean!!.content+"/"+itemdetialBean!!.content)
                                dialog.cancel()
                            }

                        }

                        override fun doError(msg: String) {

                        }

                        override fun doResult() {

                        }
                    })
                }
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }


    override fun onResume() {
        super.onResume()

        if(newlist.size>0){
            var allmoney:String = ""


            for (i in newlist.indices) {
                allmoney = newlist[i].content
                str1 = allmoney.substring(0, allmoney.indexOf("-"))//截取-之前的字符串
                str2 = allmoney.substring(str1.length+1)//截取-之后的字符串
//                val str3 = str1 + str2
//                println(str3)//1419459573@qq.c

                str3=Integer.parseInt(str1);
                str3 += i
                str4=Integer.parseInt(str2);
                str4 += i
                Log.e("uuuuuuuuuu",""+str1)
                Log.e("uuuuuuuuuu",""+str2)
                Log.e("uuuuuuuuuu",""+str4)
            }
            all_budget.setText(Integer.toString(str3)+"-"+Integer.toString(str4))
        }

        //获取工种类型
//        getworktype()
    }

    //获取工种类型
    private fun getworktype() {
        NetWork.getworktype(this@ReleaseProjectActivity, 0, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                //工种类型
                val typeWorkBean = JSON.parseObject(resultData, TypeWorkBean::class.java)
                val dataArray = typeWorkBean?.data
                val toJSONString = JSON.toJSONString(dataArray)
                val parse = JSON.parseArray(toJSONString, TypeWorkBean.DataBean::class.java)
                val parseArray = ArrayList<TypeWorkBean.DataBean>()
                parseArray.addAll(parse)
                val typeWorkAdapter = TypeWorkAdapter(parseArray,this@ReleaseProjectActivity)
                releasproject_lv = findViewById(R.id.releasproject_lv)
                releasproject_lv.adapter = typeWorkAdapter
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }

    fun listToString(stringList: ArrayList<String>?): String? {
        if (stringList == null) {
            return null
        }
        val result = StringBuilder()
        var flag = false
        for (string in stringList) {
            if (flag) {
                result.append("/") // 分隔符
            } else {
                flag = true
            }
            result.append(string)
        }
        return result.toString()
    }


    private fun onViewClick() {
        RxView.clicks(release)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe {

//                    taskprogress!!.uid = 0
//                    taskprogress!!.progress_name = ""
//                    taskprogress!!.deposit_rate = 0
                    var userBean = UserInfo()
                    val uJson = CacheUtils.getString(this@ReleaseProjectActivity, Constants.User.USER_JSON)

                    UserInfoUtil.getUserInfoById(0, this@ReleaseProjectActivity) { infoBean ->
                        if (infoBean?.data != null) {
                            RxBus.getDefault().post("resetData")
                            userBean = infoBean
                            val task = Task.TaskBean()
                            var typekList = ArrayList<Task.TaskBean>()


                            task!!.uid =  userBean.data.id
                            task!!.work_type_id =0
                            task!!.min_budget = 1.0
                            task!!.max_budget = 1.0
                            task!!.recruit_days = 1.toString()
                            task!!.creation_days = 1.toString()
                            task!!.task_status = 1
                            typekList.add(task)

                            val taskprogress = Task.TaskBean.ProgressBean()
                            var typekBeanList = ArrayList<Task.TaskBean.ProgressBean>()
                            typekBeanList.add(taskprogress)
                            taskprogress!!.uid = userBean.data.id
                            taskprogress!!.progress_name = ""
                            taskprogress!!.deposit_rate = ""

                            task!!.progress = typekBeanList

                            val styleTag = CacheUtils.getString(this@ReleaseProjectActivity, "selectMusicTag", "")
                            if ((JSON.parseArray(styleTag, TypeWorkBean.DataBean::class.java) as ArrayList<ProjectStyleTagListBean.DataBean>).size>0) {
                                val stylelist = JSON.parseArray(styleTag, ProjectStyleTagListBean.DataBean::class.java)
                                val styleTaglist = ArrayList<ProjectStyleTagListBean.DataBean>()
                                styleTaglist.addAll(stylelist)
//                        for (i in styleTaglist.indices) {
//                             val id = styleTaglist.get(i).id
//
//                        }
                                for (i in styleTaglist.indices) {
                                    val id = styleTaglist[i].id.toString()
                                    ids = "$id,$id"
                                }
                            }

                            val gson = Gson()
                            val result = gson.toJson(typekList)

                            NetWork.getaddprojecTaskt(this@ReleaseProjectActivity,
                                    userBean.data.id,
                                    project_title.text.toString(),
                                    detialBean!!.id.toString(),
                                    itemdetialBean!!.id.toString(),
                                    demand_describe.text.toString(),
                                    confidentiality_period.text.toString(),
                                    ids,
                                    1,
                                    convertToFloat(str1,2015f),
                                    convertToFloat(str2,2015f),
                                    result,
                                    object : NetWork.TokenCallBack {
                                        override fun doNext(resultData: String, headers: Headers?) {
                                            //
                                            Log.e("qqqqqq",""+resultData)
                                            finish()
                                        }

                                        override fun doError(msg: String) {

                                        }

                                        override fun doResult() {

                                        }
                                    })
                        }
                    }
                }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == 2) {
            if (data != null) {
                var date= data.getStringExtra("date");
                demand_describe.setText(date)
            }
        }else if(requestCode==CHOOSE_CARD_REQUEST_CODE){
            if(null!=data){
                if(null!=data!!.getSerializableExtra(CARD_BEAN)){
                    typeBean = data!!.getSerializableExtra(CARD_BEAN) as TypeWorkBean.DataBean
                }else{
                    return
                }
            }
            //使用了数据库
//            val addWorkTypeHelper = AddWorkTypeHelper(this@ReleaseProjectActivity)
//            val addWorkTypeDb = AddWorkTypeDb(addWorkTypeHelper)
//            val temp = addWorkTypeDb.select()
//            if (temp != null) {
//                Log.e("iiiiiiiii",""+temp)
//                val typeWorkAdapter = TypeWorkAdapter(temp,this@ReleaseProjectActivity)
//                releasproject_lv = findViewById(R.id.releasproject_lv)
//                releasproject_lv.adapter = typeWorkAdapter
//            }
            val selectMusicTagTag = CacheUtils.getString(this@ReleaseProjectActivity, "typekBeanList", "")
            if ((JSON.parseArray(selectMusicTagTag, TypeWorkBean.DataBean::class.java) as ArrayList<TypeWorkBean.DataBean>).size>0){
                val list = JSON.parseArray(selectMusicTagTag, TypeWorkBean.DataBean::class.java)

                newlist = ArrayList<TypeWorkBean.DataBean>()
                newlist.addAll(list)

//                newlist = ArrayList(HashSet(newlist))


                val typeWorkAdapter = TypeWorkAdapter(newlist,this@ReleaseProjectActivity)
                releasproject_lv = findViewById(R.id.releasproject_lv)
                releasproject_lv.adapter = typeWorkAdapter

                releasproject_lv.setOnItemClickListener { parent, view, position, id ->
                    val typeBean = newlist[position]
                    Log.e("qqqqqqqqq",""+typeBean.title)
                    val intent = Intent(this@ReleaseProjectActivity, AddtypeActivity::class.java)
                    val bundle = Bundle()

                    bundle.putSerializable("typeBean",typeBean)
                    intent.putExtras(bundle)
                    startActivityForResult(intent, CHOOSE_CARD_REQUEST_CODE)
                }
            }
        }
    }

    //把String转化为float
    fun convertToFloat(number: String, defaultValue: Float): Float {
        if (TextUtils.isEmpty(number)) {
            return defaultValue
        }
        try {
            return java.lang.Float.parseFloat(number)
        } catch (e: Exception) {
            return defaultValue
        }

    }

}