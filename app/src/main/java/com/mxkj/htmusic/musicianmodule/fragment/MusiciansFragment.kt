package com.mxkj.htmusic.messagemodule.fragment

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.GridView
import android.widget.ListView
import com.alibaba.fastjson.JSON
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.projectmodule.activity.search.SearchActivity
import com.mxkj.htmusic.projectmodule.adapter.ProjectFragmentAdapter
import com.mxkj.htmusic.projectmodule.bean.ProgectFragmentBanner
import com.mxkj.htmusic.projectmodule.bean.ProjectListBean
import com.mxkj.htmusic.toolmodule.HomeActivity
import com.mxkj.htmusic.toolmodule.base.InterfaceRefreshLoadMore
import com.mxkj.htmusic.toolmodule.utils.MultiLineRadioGroup
import com.mxkj.htmusic.toolmodule.utils.bannerLayout.HomeTopBannerLayout
import com.mxkj.htmusic.toolmodule.utils.bannerLayout.RecyclingUnlimitedPagerAdapter
import com.mxkj.htmusic.toolmodule.utils.bannerLayout.util.ViewHolder
import com.mxkj.yuanyintang.net.NetWork
import com.mxkj.yuanyintang.upush.UpushService
import com.trello.rxlifecycle2.components.support.RxFragment
import kotlinx.android.synthetic.main.fragment_project.*
import kotlinx.android.synthetic.main.fragment_project.view.*
import okhttp3.Headers
import java.util.ArrayList
import java.util.concurrent.TimeUnit

class MusiciansFragment : RxFragment(){
    private lateinit var homeActivity: HomeActivity
    private var rootView: View? = null
    internal var projectFragmentAdapter: ProjectFragmentAdapter? = null
    internal var dataBeanList: MutableList<ProjectListBean.DataBean> = ArrayList<ProjectListBean.DataBean>()
    internal var page = 1
    internal lateinit var interfaceRefreshLoadMore: InterfaceRefreshLoadMore


    internal lateinit var inflate: View
    internal lateinit var dialog: Dialog
    internal lateinit var wm: WindowManager
    internal lateinit var mulrg_tag: MultiLineRadioGroup
    internal lateinit var choose_type_lv: GridView
    internal lateinit var choose_type_lvlv: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_musicians, container, false)
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

        initView()
    }
    fun initView() {
        // 轮播图
        val list = ArrayList<ProgectFragmentBanner.ShufflingBean>()
        val shufflingBean1 = ProgectFragmentBanner.ShufflingBean()
        shufflingBean1.imgpic_link = "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2735633715,2749454924&fm=27&gp=0.jpg"
        val shufflingBean2 = ProgectFragmentBanner.ShufflingBean()
        shufflingBean2.imgpic_link = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4277820061,963510529&fm=27&gp=0.jpg"
        list.add(shufflingBean1)
        list.add(shufflingBean2)
        for (i in list.indices) {
            Log.e("lllll", "" + list[i].imgpic_link)
        }
        val bannerLayout = rootView!!.findViewById<HomeTopBannerLayout>(R.id.banner)
        var unlimitedPagerAdapter = object : RecyclingUnlimitedPagerAdapter<ProgectFragmentBanner.ShufflingBean>(bannerLayout.getAutoScrollViewPager(), homeActivity, list, R.layout.item_banner_imgae) {
            override fun onBind(position: Int, data: ProgectFragmentBanner.ShufflingBean?, holder: ViewHolder?) {
                try {
                    val layoutParams = bannerLayout.layoutParams
//                ImageLoader.with(homeActivity).getSize(710, 300).url(data!!.imgpic_link).into(holder!!.bind(R.id.img));
                    Glide.with(homeActivity)
//                            .load(data.imgpic_info.link + "/" + width + "/" + height + "/3/80?format=0")
                            .load(data!!.imgpic_link)
                            .asBitmap()
                            .centerCrop()
                            .into(holder!!.bind(R.id.img))
                } catch (e: RuntimeException) {
                }
            }
        }
        bannerLayout.setAdapter(unlimitedPagerAdapter)
        bannerLayout.showIndicator(true)
        bannerLayout.startAutoScroll()

        /*
           选择工种、报酬。时间的弹窗
         */
        dialog = Dialog(homeActivity, R.style.ActionSheetDialogStyle)
        rootView?.let {
            /*工种*/
            RxView.clicks(it.type_rl).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                //这里特效是先把布局影藏，让其顶上来在弹窗
                banner.visibility = View.GONE
                inflate = LayoutInflater.from(homeActivity).inflate(R.layout.choose_type__dialog, null)
                mulrg_tag = inflate.findViewById<MultiLineRadioGroup>(R.id.mulrg_tag)//风格标签
                choose_type_lv = inflate.findViewById<GridView>(R.id.choose_type_lv)//风格标签
                //将布局设置给Dialog
                dialog.setContentView(inflate)
                //获取当前Activity所在的窗体
                val dialogWindow1 = dialog.window
                //设置Dialog从窗体底部弹出
                dialogWindow1!!.setGravity(Gravity.TOP)
                //获得窗体的属性
                val lp1 = dialogWindow1.attributes
                lp1.y = 0//设置Dialog距离底部的距离
                wm = homeActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val d1 = wm.getDefaultDisplay() // 获取屏幕宽、高度
                val p1 = dialogWindow1.attributes // 获取对话框当前的参数值
                p1.height = (480).toInt(); // 高度设置为屏幕的0.6，根据实际情况
                p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
                //    将属性设置给窗体
                dialogWindow1.attributes = lp1
                dialog.show()//显示对话框
//                initTypeData(choose_type_lv)
            }
            /*报酬*/
            RxView.clicks(it.remuneration_rl).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                //这里特效是先把布局影藏，让其顶上来在弹窗
                banner.visibility = View.GONE
                inflate = LayoutInflater.from(homeActivity).inflate(R.layout.choose_type__dialog, null)
                mulrg_tag = inflate.findViewById<MultiLineRadioGroup>(R.id.mulrg_tag)//风格标签
                choose_type_lv = inflate.findViewById<GridView>(R.id.choose_type_lv)//风格标签

//                cancel_rl.setOnClickListener(View.OnClickListener { dialog.cancel() })
                //将布局设置给Dialog
                dialog.setContentView(inflate)
                //获取当前Activity所在的窗体
                val dialogWindow1 = dialog.window
                //设置Dialog从窗体底部弹出
                dialogWindow1!!.setGravity(Gravity.TOP)
                //获得窗体的属性
                val lp1 = dialogWindow1.attributes
                lp1.y = 0//设置Dialog距离底部的距离
                wm = homeActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val d1 = wm.getDefaultDisplay() // 获取屏幕宽、高度
                val p1 = dialogWindow1.attributes // 获取对话框当前的参数值
                p1.height = (480).toInt(); // 高度设置为屏幕的0.6，根据实际情况
                p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
                //    将属性设置给窗体
                dialogWindow1.attributes = lp1
                dialog.show()//显示对话框
//                initRemunerationData(choose_type_lv)
            }
            /*时间*/
            RxView.clicks(it.time_rl).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                //这里特效是先把布局影藏，让其顶上来在弹窗
                banner.visibility = View.GONE
                inflate = LayoutInflater.from(homeActivity).inflate(R.layout.choose_type__dialog, null)
                mulrg_tag = inflate.findViewById<MultiLineRadioGroup>(R.id.mulrg_tag)//风格标签
                choose_type_lv = inflate.findViewById<GridView>(R.id.choose_type_lv)//风格标签
                choose_type_lvlv = inflate.findViewById<ListView>(R.id.choose_type_lvlv)//风格标签
                choose_type_lv.visibility = View.GONE
                choose_type_lvlv.visibility = View.VISIBLE
                //将布局设置给Dialog
                dialog.setContentView(inflate)
                //获取当前Activity所在的窗体
                val dialogWindow1 = dialog.window
                //设置Dialog从窗体底部弹出
                dialogWindow1!!.setGravity(Gravity.TOP)
                //获得窗体的属性
                val lp1 = dialogWindow1.attributes
                lp1.y = 0//设置Dialog距离底部的距离
                wm = homeActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val d1 = wm.getDefaultDisplay() // 获取屏幕宽、高度
                val p1 = dialogWindow1.attributes // 获取对话框当前的参数值
                p1.height = (520).toInt(); // 高度设置为屏幕的0.6，根据实际情况
                p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
                //    将属性设置给窗体
                dialogWindow1.attributes = lp1
                dialog.show()//显示对话框
//                initTimeData(choose_type_lvlv)
            }
            dialog.setOnDismissListener(DialogInterface.OnDismissListener {
                banner.visibility = View.VISIBLE
                haitang.visibility = View.VISIBLE
            })

            /*首页搜索*/
            RxView.clicks(it.home_search).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                //                MobclickAgent.onEvent(activity,"mine_setting");
                UpushService.goActivity(SearchActivity::class.java, null, homeActivity)
            }

        }

        projectDate()
        val layoutManager = LinearLayoutManager(homeActivity)
        recycler.layoutManager = layoutManager
        projectFragmentAdapter = ProjectFragmentAdapter(dataBeanList, homeActivity.getSupportFragmentManager())
        recycler?.adapter = projectFragmentAdapter
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var firstVisibleItemPosition = (recyclerView?.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                if (dy < 0 && firstVisibleItemPosition == 0) {
                    app_bar.setExpanded(true, true)
                    haitang.visibility = View.VISIBLE
                }else if(dy>1){
                    haitang.visibility = View.GONE
                }
            }
        })
        interfaceRefreshLoadMore = InterfaceRefreshLoadMore(swipe_refresh, homeActivity, object : InterfaceRefreshLoadMore.RefreshLoadMoreCallback {
            override fun onRefresh() {
                page = 1
//                getMusicList()
            }

            override fun onLoadMore() {
                page++
//                initEvent()
//                getMusicList()
            }

            override fun onPushDistance(distance: Int) {

            }

            override fun onPullDistance(distance: Int) {

            }
        })

    }

    protected fun initData() {
        NetWork.getChartsHomeList(homeActivity, page, object : NetWork.TokenCallBack {

            override fun doNext(resultData: String, headers: Headers?) {
                val myCollectionBean = JSON.parseObject<Any>(resultData, ProjectListBean::class.java)
                refreshData(headers, myCollectionBean as ProjectListBean?)
            }

            override fun doError(msg: String) {
                if (page > 1) {
                    page--
                }
            }

            override fun doResult() {
                interfaceRefreshLoadMore.setStopRefreshing()
            }
        })
    }

    private fun refreshData(headers: Headers?, myCollectionBean: ProjectListBean?) {
        if (myCollectionBean != null && null != myCollectionBean!!.getData() && myCollectionBean!!.getData().size > 0) {
            if (page == 1) {
                dataBeanList.clear()
            }
            dataBeanList.addAll(myCollectionBean!!.getData())


        } else if (page == 1) {

        }

    }

    private fun projectDate() {

    }

}