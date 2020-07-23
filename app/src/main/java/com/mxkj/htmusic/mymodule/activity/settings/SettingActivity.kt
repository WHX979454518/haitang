package com.mxkj.htmusic.mymodule.activity.settings

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.TextView
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity
import kotlinx.android.synthetic.main.activity_setting.*


class SettingActivity : StandardUiActivity() {
    internal lateinit var inflate: View
    internal lateinit var dialog: Dialog
    internal lateinit var wm: WindowManager
    internal lateinit var musicians_rl:RelativeLayout
    internal lateinit var recruit_people_rl:RelativeLayout
    internal lateinit var cancel_rl:RelativeLayout
    internal lateinit var recruit_people:TextView
    internal lateinit var musicians:TextView
    internal lateinit var cancel:TextView




    override val isVisibilityBottomPlayer: Boolean
        get() = false

    public override fun setLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initView() {
        setTitleText("设置")
        onViewClick()
    }

    override fun initData() {

    }

    private fun onViewClick() {
        RxView.clicks(switch_account_rl).subscribe {
            dialog = Dialog(this@SettingActivity, R.style.ActionSheetDialogStyle)
            inflate = LayoutInflater.from(this@SettingActivity).inflate(R.layout.seitch_account__dialog, null)
            //初始化
            musicians_rl = inflate.findViewById<RelativeLayout>(R.id.musicians_rl)//音乐人
            recruit_people_rl = inflate.findViewById<RelativeLayout>(R.id.recruit_people_rl)//招募人
            cancel_rl = inflate.findViewById<RelativeLayout>(R.id.cancel_rl)//取消
            musicians = inflate.findViewById<TextView>(R.id.musicians)//音乐人
            recruit_people = inflate.findViewById<TextView>(R.id.recruit_people)//招募人
            musicians_rl.setOnClickListener(View.OnClickListener {
                identity.setText("音乐人")
                dialog.cancel()
            })
            recruit_people_rl.setOnClickListener(View.OnClickListener {
                identity.setText("招募人")
                dialog.cancel()
            })
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
            p1.height = (320).toInt(); // 高度设置为屏幕的0.6，根据实际情况
            p1.width = d1.width * 1 // 宽度设置为屏幕的0.65，根据实际情况调整
            //    将属性设置给窗体
            dialogWindow1.attributes = lp1
            dialog.show()//显示对话框
        }
        //编辑资料
        RxView.clicks(edit_data).subscribe {
            goActivity(EditDataActivity::class.java)
        }
        //安全设置
        RxView.clicks(security_settings).subscribe {
            goActivity(SecuritySettingsActivity::class.java)
        }


    }

    companion object {

    }

    override fun initEvent() {

    }
}
