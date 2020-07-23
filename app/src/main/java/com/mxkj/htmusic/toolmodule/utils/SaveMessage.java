package com.mxkj.htmusic.toolmodule.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 *
 */
public class SaveMessage {

    public static void SaveLogintoken(String logintoken, Context context){
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.putString("logintoken",logintoken);
        spfe.commit();
    }
    public static String huoquLogintoken(Context context) {
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        String logintoken = spf.getString("logintoken","");
        return logintoken;//取出共享参数
    }
    public static void clearLogintoken(Context context){
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.clear().commit();
    }
    public static String getStandardTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss",
                Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        Date date = new Date(timestamp+60*60*1000);
        sdf.format(date);
        return sdf.format(date);
    }



    public static void SaveLoginUid(int uid, Context context){
        SharedPreferences spf = context.getSharedPreferences("uid", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.putInt("uid",uid);
        spfe.commit();
    }
    public static int huoquLoginUid(Context context) {
        SharedPreferences spf = context.getSharedPreferences("uid", Context.MODE_PRIVATE);
        int uid = spf.getInt("uid",0);
        return uid;//取出共享参数
    }
    public static void clearLoginUid(Context context){
        SharedPreferences spf = context.getSharedPreferences("uid", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.clear().commit();
    }

    public static void Savelogintoken(String logintoken, Context context){
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.putString("logintoken",logintoken);
        spfe.commit();
    }
    public static String huoqulogintoken(Context context) {
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        String logintoken = spf.getString("logintoken","");
        return logintoken;//取出共享参数
    }
    public static void clearlogintoken(Context context){
        SharedPreferences spf = context.getSharedPreferences("logintoken", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.clear().commit();
    }
    public static void Savedevicetoken (String devicetoken , Context context){
        SharedPreferences spf = context.getSharedPreferences("devicetoken ", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.putString("devicetoken ",devicetoken );
        spfe.commit();
    }
    public static String huoqudevicetoken (Context context) {
        SharedPreferences spf = context.getSharedPreferences("devicetoken ", Context.MODE_PRIVATE);
        String devicetoken  = spf.getString("devicetoken ","");
        return devicetoken ;//取出共享参数
    }
    public static void cleardevicetoken (Context context){
        SharedPreferences spf = context.getSharedPreferences("devicetoken ", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfe = spf.edit();
        spfe.clear().commit();
    }
}
