package com.mxkj.htmusic.toolmodule

import android.content.IntentFilter
import android.graphics.*
import android.os.Bundle
import android.os.Handler
import com.tbruyelle.rxpermissions2.RxPermissions
import butterknife.ButterKnife
import com.mxkj.htmusic.R
import com.mxkj.htmusic.messagemodule.fragment.MessageFragment
import com.mxkj.htmusic.messagemodule.fragment.MusiciansFragment
import com.mxkj.htmusic.messagemodule.fragment.MyFragment
import com.mxkj.htmusic.projectmodule.fragment.ProjectFragment
import com.mxkj.htmusic.mymodule.activity.QuickLoginActivityNew
import com.mxkj.htmusic.toolmodule.base.baseactivity.BaseActivity
import com.mxkj.htmusic.toolmodule.utils.CacheUtils
import com.mxkj.htmusic.toolmodule.utils.Constants
import com.mxkj.htmusic.toolmodule.utils.rxbus.RxBus
import com.mxkj.htmusic.toolmodule.utils.rxbus.event.EMECodeEvent
import com.mxkj.yuanyintang.base.dialog.CoinDialog
import io.reactivex.disposables.Disposable
import com.mxkj.yuanyintang.utils.tab.FragmentSwitchTool

open class HomeActivity : BaseActivity() {
    private var mSelectTabChangeEvent: Disposable? = null
    private var mEMEEvent: Disposable? = null
    private var appExit = false
    private val handler = object : Handler() {
        override fun handleMessage(msg: android.os.Message) {
            super.handleMessage(msg)
            when (msg.what) {
                0 -> appExit = false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ButterKnife.bind(this)
        initView()
//        startService(Intent(this, BackgroundService::class.java))

        //检查新版本更新下载
//        UpDataApkTools.getInstance().setContext(this).upDataApkData(true, "")
//        searchRecommendData()
//        CacheUtils.setBoolean(this@HomeActivity, MediaService.MEDIA_PLAY_IS_PAUSE, false)
//        getStartImg(true)//获取启动图
        requestPermissions()


        lotterFilter = IntentFilter()
        lotterFilter.addAction("hideCoinDialog")
        lotterFilter.addAction("showCoinDialog")
        lotterRecriver = LotterRecriver()
        registerReceiver(lotterRecriver, lotterFilter)

    }

    override fun showCoinDialog() {
        coinDialog = CoinDialog.newInstance()
        coinDialog.showDialog(this)
    }

    private fun initView() {
        val fragmentSwitchTool = FragmentSwitchTool(supportFragmentManager, R.id.layout_container, this)
        val projectMap = fragmentSwitchTool.TabViewMap(findViewById(R.id.line_home_home), findViewById(R.id.line_home_home_image), findViewById(R.id.line_home_home_text), ProjectFragment::class.java)
        val musiciansMap = fragmentSwitchTool.TabViewMap(findViewById(R.id.line_home_topic), findViewById(R.id.line_home_topic_img), findViewById(R.id.line_home_topic_text), MusiciansFragment::class.java)
        val mesageMap = fragmentSwitchTool.TabViewMap(findViewById(R.id.line_home_message), findViewById(R.id.line_home_message_img), findViewById(R.id.line_home_message_text), MessageFragment::class.java)
        val mineMap = fragmentSwitchTool.TabViewMap(findViewById(R.id.line_home_mine), findViewById(R.id.line_home_mine_img), findViewById(R.id.line_home_mine_text), MyFragment::class.java)
        fragmentSwitchTool.setSelectMap("project", projectMap).setSelectMap("musicans", musiciansMap).setSelectMap("message", mesageMap).setSelectMap("mine", mineMap)
        fragmentSwitchTool.changeSelectd(findViewById(R.id.line_home_mine))
        fragmentSwitchTool.changeSelectd(findViewById(R.id.line_home_home))
    }

    fun isLogin():Boolean
    {
        if (!CacheUtils.getBoolean(this@HomeActivity, Constants.User.IS_LOGIN)) {
            goActivity(QuickLoginActivityNew::class.java)
            return false
        } else {
            RxBus.getDefault().post(EMECodeEvent(100))
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        MainApplication.application?.currentActivity = this
//        emLogin()
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.getDefault().remove(mSelectTabChangeEvent)
        RxBus.getDefault().remove(mEMEEvent)
    }

    companion object {
        private val TAG = "HomeActivity"
        fun getOvalBitmap(bitmap: Bitmap): Bitmap {
            val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(output)

            val paint = Paint()
            val rect = Rect(0, 0, bitmap.width, bitmap.height)

            val rectF = RectF(rect)

            paint.isAntiAlias = true
            canvas.drawARGB(0, 0, 0, 0)

            canvas.drawOval(rectF, paint)
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(bitmap, rect, rect, paint)
            return output
        }
    }

    private fun requestPermissions() {
        val rxPermission = RxPermissions(this)
        rxPermission.requestEach(android.Manifest.permission.CAMERA, android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe { permission ->
            when {
                permission.granted -> {
                }
                permission.shouldShowRequestPermissionRationale -> {
                }
                else -> {
                }
            }
        }
    }
}