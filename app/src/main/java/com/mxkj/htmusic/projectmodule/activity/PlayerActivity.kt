package com.mxkj.htmusic.projectmodule.activity

import android.os.Bundle
import android.view.MotionEvent
import com.jakewharton.rxbinding2.view.RxView
import com.mxkj.htmusic.R
import com.mxkj.htmusic.toolmodule.base.baseactivity.BaseActivity
import com.mxkj.htmusic.toolmodule.utils.Toast
import kotlinx.android.synthetic.main.activity_player.*


class PlayerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        initView()
        initEvent()
        onViewClick()
    }

    fun initView() {

    }

    fun initData() {

    }

    private fun onViewClick() {
        //下拉关闭动画
        RxView.clicks(player_back_image).subscribe {
            overridePendingTransition(R.anim.drop_down, android.R.anim.fade_out);
            finish()
        }
        //分享
        RxView.clicks(player_image3).subscribe {
            Toast.create(this@PlayerActivity).show("分享")
        }
        //收藏
        RxView.clicks(player_image2).subscribe {
            player_image2.setImageResource(R.mipmap.icon_top_collect2)
        }
        //举报
        RxView.clicks(player_image1).subscribe {
            Toast.create(this@PlayerActivity).show("举报")
        }
        //播放
        RxView.clicks(player_star).subscribe {
            player_star.setImageResource(R.mipmap.icon_play_song)
        }



    }

    fun initEvent() {

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.drop_down, R.anim.drop_down)
    }
    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    var x1 = 0f
    var x2 = 0f
    var y1 = 0f
    var y2 = 0f
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if(event!!.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if(event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            if(y1 - y2 > 50) { } else if(y2 - y1 > 50) {
                finish()
                overridePendingTransition(R.anim.drop_down, R.anim.drop_down)
            } else if(x1 - x2 > 50) {} else if(x2 - x1 > 50) {}
        }
        return super.onTouchEvent(event);
    }
}
