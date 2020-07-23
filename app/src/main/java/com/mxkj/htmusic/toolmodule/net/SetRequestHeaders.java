package com.mxkj.htmusic.toolmodule.net;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.model.HttpHeaders;
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo;
import com.mxkj.htmusic.toolmodule.utils.CacheUtils;
import com.mxkj.htmusic.toolmodule.utils.Constants;
import com.mxkj.htmusic.toolmodule.utils.app.GetUserAgent;
import com.mxkj.yuanyintang.utils.app.CommonUtils;

import static com.mxkj.htmusic.toolmodule.utils.Constants.User.USER_DEVICE_TOKEN;
import static com.mxkj.htmusic.toolmodule.utils.Constants.User.USER_LOGIN_TOKEN;

/**
 *
 */

public class SetRequestHeaders {
    static HttpHeaders headers = new HttpHeaders();

    public static HttpHeaders getHeader(final Context context) {
        String userAgent = new GetUserAgent().getUserAgent();
        headers.put("accesstoken", CacheUtils.INSTANCE.getString(context, "token", ""));
        headers.put("User-Agent", userAgent);
        headers.put("Accept","image/webp,image/apng,image/*,*/*;q=0.8");
//        headers.put("Accept-Encoding","gzip, deflate, br");
//        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("version", CommonUtils.INSTANCE.getAPPVersionName(context));
        headers.put("logat", "3");
        if(CacheUtils.INSTANCE.getString(context,"set_Cookie")!=null){
            headers.put("Cookie", CacheUtils.INSTANCE.getString(context,"set_Cookie"));
        }
        String userJson = CacheUtils.INSTANCE.getString(context, Constants.User.USER_JSON);
        if (!TextUtils.isEmpty(userJson)&&!userJson.equals("null")) {
            UserInfo infoBean = JSON.parseObject(userJson, UserInfo.class);
            if (infoBean != null && infoBean.getData() != null && !TextUtils.isEmpty(CacheUtils.INSTANCE.getString(context, USER_LOGIN_TOKEN, ""))) {
                headers.put("devicetoken", CacheUtils.INSTANCE.getString(context,USER_DEVICE_TOKEN,""));
                headers.put("logintoken", CacheUtils.INSTANCE.getString(context, USER_LOGIN_TOKEN, ""));
                CacheUtils.INSTANCE.setString(context, Constants.User.USER_LOGIN_TOKEN, CacheUtils.INSTANCE.getString(context, USER_LOGIN_TOKEN, ""));
                CacheUtils.INSTANCE.setString(context, USER_DEVICE_TOKEN, CacheUtils.INSTANCE.getString(context, USER_DEVICE_TOKEN, ""));
            }
        }
        return headers;
    }
}
