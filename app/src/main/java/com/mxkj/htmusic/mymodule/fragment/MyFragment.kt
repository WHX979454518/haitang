package com.mxkj.htmusic.messagemodule.fragment

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.mymodule.activity.*
import com.mxkj.htmusic.mymodule.activity.settings.EditProfileActivity
import com.mxkj.htmusic.mymodule.activity.settings.SettingActivity
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil
import com.mxkj.htmusic.toolmodule.HomeActivity
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo
import com.mxkj.htmusic.toolmodule.utils.*
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.htmusic.toolmodule.utils.string.StringUtils
import com.mxkj.yuanyintang.base.fragment.BaseFragment
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.fragment_my_head.*
import kotlinx.android.synthetic.main.fragment_my_head.view.*
import java.util.concurrent.TimeUnit

class MyFragment : BaseFragment() {
    private lateinit var homeActivity: HomeActivity
    override val layoutId: Int

    get() {
        StatusBarUtil.baseTransparentStatusBar(activity)
        return R.layout.fragment_my
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeActivity = activity as HomeActivity
        initView()
    }
    private fun initView() {

        rootView?.let {
            /*个人主页*/
            RxView.clicks(it.layout_personal).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                MobclickAgent.onEvent(activity, "mine_icon");
                goActivity(MusiciansPersonalHomePageActivity::class.java) }
            /*登录注册*/
            RxView.clicks(it.tv_name).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                MobclickAgent.onEvent(activity, "mine_icon");
                goActivity(QuickLoginActivityNew::class.java)
                 }

            /*切换身份   现在是编辑简介*/
            RxView.clicks(it.switch_identity).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                goActivity(EditProfileActivity::class.java)
//                val logintoken = "biaoshi"
//                SaveMessage.SaveLogintoken(logintoken, homeActivity)
                    }
            /*设置*/
            RxView.clicks(it.ivSetting).throttleFirst(1, TimeUnit.SECONDS).subscribe {
                MobclickAgent.onEvent(activity,"mine_setting");
                goActivity(SettingActivity::class.java) }
            /*我参与的*/
            RxView.clicks(it.llLocalMusic)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe {
//                        goActivity(ParticipateActivity::class.java)
//                        goActivity(RecruitPeopleParticipateActivity::class.java)
                        goActivity(MyProjectRecruitPeopleParticipateActivity::class.java)
                    }
            /*我的收藏*/
            RxView.clicks(it.myCollection)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe({
                        goActivity(ParticipateActivity::class.java)
                    })
            /*粉丝*/
            RxView.clicks(it.download_layout)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe {

                    }
            /*关注*/
            RxView.clicks(it.playHistory)
                    .throttleFirst(1, TimeUnit.SECONDS)
                    .subscribe {

                    }
        }
    }

    override fun onResume() {
        super.onResume()
        netData()
    }


    private var userInfos: UserInfo? = null

    private fun netData() {
        if (!CacheUtils.getBoolean(activity, Constants.User.IS_LOGIN)) {
            outLoginView()
            return
        }
        ll_topic.visibility = View.VISIBLE
//            val userJson = CacheUtils.getString(context, Constants.User.USER_JSON)
//            Log.e("ppppppppp",""+userJson)
        UserInfoUtil.getUserInfoById(0, activity) { infoBean ->
            if (infoBean?.data != null) {
                RxBus.getDefault().post("resetData")
                userInfos = infoBean
                userInfos?.let {
                    if(null!=it.data?.head_info){
                        Glide.with(this).load(it.data?.head_info!!.link)
                                .asBitmap().into(rootView.civ_headimg)
//                        ImageLoader.with(activity)
//                                .override(80, 80)
//                                .url(it.data?.head_info!!.link)
//                                .into(rootView.civ_headimg)
                    }
                    rootView.tv_name.text = StringUtils.isEmpty(it.data?.nickname)
                }
            }
        }
    }
    fun outLoginView() {
        activity!!.runOnUiThread {
            rootView.tv_name.text = "登录海塘"
//            ImageLoader.with(activity)
//                    .res(R.mipmap.icon_banklogo_china)
//                    .into(rootView.civ_headimg)
        }
    }

}