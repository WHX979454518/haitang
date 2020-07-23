package com.mxkj.htmusic.toolmodule.utils.app;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.mxkj.htmusic.R;


/**
 */

public class CountDownTimerUtils extends CountDownTimer {
    public TextView mTextView;
    public String showTv;
    private ForegroundColorSpan span;
    private int bckColor;
    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
    }

    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval, int bckColor) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
        this.bckColor = bckColor;
    }

    public CountDownTimerUtils(TextView textView, long millisInFuture, long countDownInterval, String showTv) {
        super(millisInFuture, countDownInterval);
        this.mTextView = textView;
        this.showTv = showTv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        if (bckColor!=0){
            mTextView.setBackgroundResource(bckColor);
        }
        if (showTv != null) {
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
            mTextView.setText(millisUntilFinished / 1000 + showTv);  //设置倒计时时间
        } else {
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
            mTextView.setText(millisUntilFinished / 1000 + "s");  //设置倒计时时间
        }
        SpannableString spannableString = new SpannableString(mTextView.getText().toString());  //获取按钮上的文字
        if (showTv != null) {
            span = new ForegroundColorSpan(Color.parseColor("#aab0b3"));
        } else {
            span = new ForegroundColorSpan(Color.parseColor("#aab0b3"));
        }
        spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//将倒计时的时间设置为红色
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("重新发送");
        if (showTv != null) {
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
        } else if (bckColor!=0){
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
            mTextView.setBackgroundResource(R.drawable.shape_bck_white);
        }else {
            mTextView.setTextColor(Color.parseColor("#aab0b3"));
        }
        mTextView.setClickable(true);//重新获得点击
        cancel();
    }
}
