package com.mxkj.htmusic.toolmodule.utils;

import android.content.Context;

/**
 *
 */
public class Toast {

    public android.widget.Toast mToast;
    public static Context mContext;
    private static Toast toast;

    public static Toast create(Context context) {
        mContext = context;
        if (toast == null) {
            toast = new Toast();
        }
        return toast;
    }

    /**
     * 显示Toast
     *
     * @param msg 显示文字
     */
    public void show(String msg) {
        if (mToast == null) {
            mToast = android.widget.Toast.makeText(mContext, "", android.widget.Toast.LENGTH_SHORT);
        }
        mToast.setText(msg);
        mToast.show();
    }
}
