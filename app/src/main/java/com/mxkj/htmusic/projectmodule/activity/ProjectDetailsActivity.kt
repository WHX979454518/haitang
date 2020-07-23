package com.mxkj.htmusic.projectmodule.activity

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.*
import butterknife.ButterKnife
import com.alibaba.fastjson.JSON
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.activity.RecruitPeopleParticipateActivity
import com.mxkj.htmusic.projectmodule.adapter.ProjectDetailsListViewAdapter
import com.mxkj.htmusic.projectmodule.adapter.ReportOperationAdapter
import com.mxkj.htmusic.projectmodule.bean.*
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import com.mxkj.htmusic.toolmodule.base.baseactivity.screenshoot.DiaLogBuilder
import com.mxkj.htmusic.toolmodule.base.basedialog.MusicBean
import com.mxkj.htmusic.toolmodule.base.basedialog.ShareBottomDialog
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import com.mxkj.htmusic.toolmodule.utils.MyListView
import com.mxkj.yuanyintang.net.NetWork
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_projectdetails.*
import okhttp3.Headers
import java.util.ArrayList
import java.util.concurrent.TimeUnit

/*
项目详情
 */
class ProjectDetailsActivity: StandardUiActivity(), AppBarLayout.OnOffsetChangedListener {
    lateinit var projectdetails_back_image: ImageView
    lateinit var projectdetails_image1: ImageView
    lateinit var projectdetails_image2: ImageView
    lateinit var projectdetails_image3: ImageView
    private lateinit var wm:WindowManager;
    private var inflate:View? = null
    private var dialog: Dialog? = null
    private lateinit var tv_cancle:TextView
    private lateinit var recyclerview:RecyclerView
    private lateinit var reportOperationAdapter: ReportOperationAdapter
    private var reportOperationBeanList: MutableList<ReportOperationBean.DataBean> = ArrayList()

    lateinit var projectid:String


    var flag:Boolean = false

    internal var itemInfoBean: ProjectDetailsBean.DataBean? = null

    internal lateinit var projectdetails_lv:MyListView
    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val isVisibilityBottomPlayer: Boolean
        get() = false

    override fun setLayoutId(): Int {
        return R.layout.activity_projectdetails
    }

    override fun initView() {
        hideTitle(true)
        hideRightButton()
        hideLeftButton()
        projectdetails_title.setText("项目详情")
        ButterKnife.bind(this)


        if(null!=intent.getStringExtra("projectid")){
            projectid = intent.getStringExtra("projectid")
        }

        projectdata()

        initOtherReasonsDialog()
        onViewClick()
    }

    override fun initEvent() {
        initdetailslabelData()
        projectdetails_lv = findViewById(R.id.projectdetails_lv)
    }

    override fun initData() {
        projectdetails_image1 = findViewById(R.id.projectdetails_image1)
        projectdetails_image2 = findViewById(R.id.projectdetails_image2)
        projectdetails_image3 = findViewById(R.id.projectdetails_image3)
        projectdetails_image1.setOnClickListener {
            dialog = Dialog(this@ProjectDetailsActivity, R.style.ActionSheetDialogStyle)
            //填充对话框的布局
            inflate = LayoutInflater.from(this@ProjectDetailsActivity).inflate(R.layout.dialog_report_operation, null)
            //初始化控件
            recyclerview = inflate.run { this!!.findViewById<RecyclerView>(R.id.recyclerview) as RecyclerView }
            tv_cancle = inflate.run { this!!.findViewById<TextView>(R.id.tv_cancle) as TextView }
            recyclerview!!.layoutManager = LinearLayoutManager(this@ProjectDetailsActivity)
            jubaoData()
            reportOperationAdapter = ReportOperationAdapter(reportOperationBeanList, this@ProjectDetailsActivity)
            recyclerview!!.adapter = reportOperationAdapter
//            reportOperationAdapter.onItemClickListener = com.mxkj.yuanyintang.mainui.home.homebaseadapter.BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
//                //                                 if (null == musicBean) {
////                                     return@OnItemClickListener
////                                 }
//                if (reportOperationBeanList[position].id == 0) {
//                } else {
//                    var intent = Intent(this@MvVideoActivitykt, ReportActivity::class.java)
//                    val bundle = Bundle()
//                    bundle.putInt(ReportActivity.REPORT_ITEM_ID, urlid)
//                    bundle.putInt(ReportActivity.REPORT_PID, reportOperationBeanList[position].id)
////                                     bundle.putInt(ReportActivity.REPORT_PID, 1)
//                    intent.putExtras(bundle);
//                    this@MvVideoActivitykt.startActivity(intent)
//                    //                                    goActivity(ReportActivity::class.java, bundle)
//                }
//            }
            //将布局设置给Dialog
            dialog!!.setContentView(inflate)
            //获取当前Activity所在的窗体
            val dialogWindow1 = dialog!!.window
            //设置Dialog从窗体底部弹出
            dialogWindow1!!.setGravity(Gravity.BOTTOM)
            //获得窗体的属性
            val lp1 = dialogWindow1.attributes
            lp1.y = 5//设置Dialog距离底部的距离
            wm = this@ProjectDetailsActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val m1 = wm;
            val d1 = m1.getDefaultDisplay() // 获取屏幕宽、高度
            val p1 = dialogWindow1.attributes // 获取对话框当前的参数值
            p1.height = (d1.getHeight() * 0.6).toInt() // 高度设置为屏幕的0.6，根据实际情况调整
            p1.width = (d1.getWidth() * 1).toInt() // 宽度设置为屏幕的0.65，根据实际情况调整
            //    将属性设置给窗体
            dialogWindow1.attributes = lp1
            dialog!!.show()//显示对话框
            tv_cancle.setOnClickListener {
                dialog!!.cancel()
                }
            }
        projectdetails_image2.setOnClickListener {
            //这里是一个弹框，可输入文字的弹框
//            if (null != diaLogBuilder) {
//                diaLogBuilder.show()
//            }
            if(flag == true){
                NetWork.getprojectuncollection(this@ProjectDetailsActivity, projectid, object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        val jsonObject = JSON.parseObject(resultData)
                        val msg = jsonObject.getString("msg")!!
                        setSnackBar(msg, "", R.drawable.icon_fails)
                        projectdetails_image2.setImageResource(R.mipmap.icon_top_collect)
                        flag == false
                    }

                    override fun doError(msg: String) {

                    }

                    override fun doResult() {

                    }
                })
            }else{
                //收藏
                NetWork.getprojectcollection(this@ProjectDetailsActivity, projectid, object : NetWork.TokenCallBack {
                    override fun doNext(resultData: String, headers: Headers?) {
                        val jsonObject = JSON.parseObject(resultData)
                        val msg = jsonObject.getString("msg")!!
                        setSnackBar(msg, "", R.drawable.icon_fails)
                        projectdetails_image2.setImageResource(R.mipmap.icon_top_collect2)
                        flag == true
                    }

                    override fun doError(msg: String) {

                    }

                    override fun doResult() {

                    }
                })
            }


        }
        projectdetails_image3.setOnClickListener {
            val musicBean = MusicBean()
            val shareDataBean = MusicBean.ShareDataBean()
            shareDataBean.webImgUrl = ""
            shareDataBean.shareUrl = ""
            shareDataBean.nickname = ""
            shareDataBean.type = "web"
            musicBean.setShareDataBean(shareDataBean)
            val shareBottomDialog = ShareBottomDialog(this@ProjectDetailsActivity, musicBean)
            shareBottomDialog.show()
        }
    }

    private var selectedTagList = ArrayList<ProjectStyleTagListBean.DataBean>()
    private fun initdetailslabelData() {
        //                val pondHotTagBean = JSON.parseObject(resultData, ProjectStyleTagListBean::class.java)
//                val dataArray = pondHotTagBean?.data
//                val toJSONString = JSON.toJSONString(dataArray)
//                val parseArray = JSON.parseArray(toJSONString, ProjectStyleTagListBean.DataBean.TagBean::class.java)
        val parseArray = ArrayList<ProjectStyleTagListBean.DataBean>()
        val tagBean1 = ProjectStyleTagListBean.DataBean()
        tagBean1.title = "另类1"
        val tagBean2 = ProjectStyleTagListBean.DataBean()
        tagBean2.title = "另类2"
        val tagBean3 = ProjectStyleTagListBean.DataBean()
        tagBean3.title = "另类3"
        val tagBean4 = ProjectStyleTagListBean.DataBean()
        tagBean4.title = "另类4"
        parseArray.add(tagBean1)
        parseArray.add(tagBean2)
        parseArray.add(tagBean3)
        parseArray.add(tagBean4)

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
                    CacheUtils.setString(this@ProjectDetailsActivity, "selectMusicTag", JSON.toJSONString(selectedTagList))
                } else {

                    selectedTagList.forEach {
                        if (it.id == tagBean.id) {
                            selectedTagList.remove(it)
                        }
                    }
                    CacheUtils.setString(this@ProjectDetailsActivity, "selectMusicTag", JSON.toJSONString(selectedTagList))
                }
            }
        }
    }

    private fun initListViewData(choose_time_lv:ListView) {
        val parseArray = ArrayList<ProjectDetailsBean.DataBean.TaskBean>()
//        val tagBean1 = ProjectDetailsBean.DataBean.TaskBean()
//        tagBean1.work_type_title = "作词"
//        val tagBean2 = ProjectDetailsBean.DataBean.TaskBean()
//        tagBean2.work_type_title = "唱见"
//        val tagBean3 = ProjectDetailsBean.DataBean.TaskBean()
//        tagBean3.work_type_title = "PV"
//        parseArray.add(tagBean1)
//        parseArray.add(tagBean2)
//        parseArray.add(tagBean3)
        val projectDetailsListViewAdapter = ProjectDetailsListViewAdapter(parseArray,this@ProjectDetailsActivity)
        choose_time_lv.adapter = projectDetailsListViewAdapter
    }

    private fun jubaoData() {
        val tagBean1 = ReportOperationBean.DataBean()
        tagBean1.title = "lalallala"
        val tagBean2 = ReportOperationBean.DataBean()
        tagBean2.title = "谩骂"
        val tagBean3 = ReportOperationBean.DataBean()
        tagBean3.title = "我我iwiwiwi"
        reportOperationBeanList.add(tagBean1)
        reportOperationBeanList.add(tagBean2)
        reportOperationBeanList.add(tagBean3)
    }

    private fun initOtherReasonsDialog() {
        val view = View.inflate(this, R.layout.dialog_new_song, null)
        val tv_cancel = view.findViewById<TextView>(R.id.tv_cancle)
        val tv_confirm = view.findViewById<TextView>(R.id.tv_confirm)
        val et_song_content = view.findViewById<EditText>(R.id.et_song_content)
        diaLogBuilder = DiaLogBuilder(this)
                .setContentView(view)
                .setFullScreen()
                .setGrvier(Gravity.CENTER)
                .setCanceledOnTouchOutside(true)
                .setAniMo(R.anim.popup_in)
        RxView.clicks(tv_confirm)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(Consumer {
                    if (TextUtils.isEmpty(et_song_content.text.toString())) {
//                        Toast.create(this@MyCollectionSongActivity).show("请输入歌单名字")
                        return@Consumer
                    }
//                    newSong(et_song_content.text.toString())
                    diaLogBuilder.setDismiss()
                })
        tv_cancel.setOnClickListener { diaLogBuilder.setDismiss() }
    }

    private fun onViewClick() {

    }

    private fun projectdata() {
        NetWork.getprojectInfo(this@ProjectDetailsActivity, projectid, object : NetWork.TokenCallBack {
            override fun doNext(resultData: String, headers: Headers?) {
                Log.e("jjjjjjjjjj",""+resultData)
                val projectDetailsBean = JSON.parseObject(resultData, ProjectDetailsBean::class.java)
                project_details_name.setText(projectDetailsBean.data.project_title)
                project_details_budget.setText(projectDetailsBean.data.budget_range_text)
                project_details_created_at.setText(projectDetailsBean.data.created_at)
                projectdetails_name.setText(projectDetailsBean.data.member.nickname)
                project_details_reputation_score.setText("信誉评分"+projectDetailsBean.data.member.reputation_score)


//                val obj = JSON.parseObject(resultData)
//                val jObj = obj.getJSONObject("data")
//                val task = jObj.getJSONArray("task")
//                val musicclassificationListBean = JSON.parseArray(task.toString(), ProjectDetailsBean.DataBean.TaskBean::class.java)
//
                //需求工种
                val dataArray = projectDetailsBean?.data!!.task
                val toJSONString = JSON.toJSONString(dataArray)
                val parse = JSON.parseArray(toJSONString, ProjectDetailsBean.DataBean.TaskBean::class.java)
//                initListViewData(projectdetails_lv)
                val parseArray = ArrayList<ProjectDetailsBean.DataBean.TaskBean>()
                parseArray.addAll(parse)
                val projectDetailsListViewAdapter = ProjectDetailsListViewAdapter(parseArray,this@ProjectDetailsActivity)
                projectdetails_lv.adapter = projectDetailsListViewAdapter


                var taskids :String= ""
                for (i in parseArray.indices) {
                    val id = parseArray[i].id.toString()
                    taskids = "$id"
                }

                //报名
                RxView.clicks(projectdetails_sign_up).subscribe {
                    val bundle = Bundle()
//                    val wokrtypedataArray = projectDetailsBean?.data
                    bundle.putString("uid", projectDetailsBean?.data!!.uid.toString())//
                    bundle.putString("require_id", projectDetailsBean?.data!!.id.toString())//当前报名项目的发布人ID(招募人ID)
                    bundle.putString("project_id", projectDetailsBean?.data!!.id.toString())//项目ID
                    bundle.putString("project_task_id", projectDetailsBean?.data!!.uid.toString())//项目工种ID
                    bundle.putString("work_type_id", projectDetailsBean?.data!!.uid.toString())//工种类型ID
                    bundle.putString("money", projectDetailsBean?.data!!.uid.toString())//	我的报价 格式如0.00
                    bundle.putString("creation_days", projectDetailsBean?.data!!.uid.toString())//	预计总用时
                    bundle.putString("remark", projectDetailsBean?.data!!.uid.toString())//
                    // 	留言
                    bundle.putString("taskids", taskids)
                    goActivity(SignUpActivity::class.java,bundle)
                }

                //去除tack看里面的数据大于1.证明是多工种
//                if(projectDetailsBean.data.task.size>1){
//                    projectdetails_apply_number_rl.visibility = View.VISIBLE
//                    projectdetails_apply_number.setText("共"+projectDetailsBean.data.enroll_num+"人应征，选定"+projectDetailsBean.data.select_enroll_num+"人")
//                }else{
//                    projectdetails_apply_number_rl.visibility = View.GONE
//                }
                projectdetails_apply_number_rl.visibility = View.VISIBLE
                projectdetails_apply_number.setText("共"+projectDetailsBean.data.enroll_num+"人应征，选定"+projectDetailsBean.data.select_enroll_num+"人")

                //应征列表
                RxView.clicks(projectdetails_apply_number_rl).subscribe {
                    val bundle = Bundle()
                    bundle.putString("work_type_id", projectDetailsBean?.data!!.work_type_ids)//	工种类型 取值见 工种类型API说明
                    bundle.putString("require_id", projectDetailsBean?.data!!.id.toString())//项目id
                    goActivity(RecruitPeopleParticipateActivity::class.java,bundle)
                }



                //作品用途
                val workpurposesdataArray = projectDetailsBean?.data!!.use_channel_ids
                val workpurposestoJSONString = JSON.toJSONString(workpurposesdataArray)
                projectdetails_work_purposes.setText(workpurposestoJSONString)

                projectdetails_confidentiality_period.setText(projectDetailsBean.data.secrecy_days)

                expandableTextView.setText(projectDetailsBean.data.project_desc)
//                refreshData(headers, projectListBean as ProjectListBean?)

                if(projectDetailsBean.data.is_collect == 1){
                    flag = true
                    projectdetails_image2.setImageResource(R.mipmap.icon_top_collect2)
                }else{
                    flag = false
                    projectdetails_image2.setImageResource(R.mipmap.icon_top_collect)
                }
            }

            override fun doError(msg: String) {

            }

            override fun doResult() {

            }
        })
    }
}