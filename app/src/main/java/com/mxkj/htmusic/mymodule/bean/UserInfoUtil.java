package com.mxkj.htmusic.mymodule.bean;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.lzy.okgo.model.HttpParams;
import com.mxkj.htmusic.toolmodule.MainApplication;
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo;
import com.mxkj.htmusic.toolmodule.utils.CacheUtils;
import com.mxkj.htmusic.toolmodule.utils.Constants;
import com.mxkj.htmusic.toolmodule.utils.SaveMessage;
import com.mxkj.yuanyintang.net.ApiAddress;
import com.mxkj.yuanyintang.net.NetWork;

import okhttp3.Headers;

public class UserInfoUtil {
    private static UserInfo userInfoBean;
    static HttpParams params = new HttpParams();
    public static void getUserInfoById(int uid, final Context context, final UserCallBack callBack) {
        String url = ApiAddress.READ;
        if(0 != SaveMessage.huoquLoginUid(context)){
            params.put("uid", SaveMessage.huoquLoginUid(context) + "");
            params = new HttpParams();
            url = ApiAddress.READ;
        }
//        if (uid == 0) {//获取个人信息，登录状态下
//            params = new HttpParams();
//            url = ApiAddress.READ;
//        }
        NetWork.INSTANCE.getUserInfo(context, params, url, new NetWork.TokenCallBack() {
            @Override
            public void doNext(String resultData, Headers headers) {
                userInfoBean = JSON.parseObject(resultData, UserInfo.class);
//                CacheUtils.INSTANCE.setString(context, Constants.User.USER_ID, userInfoBean.getData().getId() + "");
                CacheUtils.INSTANCE.setString(context, Constants.User.USER_JSON, resultData);
                if (userInfoBean != null) {
                    callBack.doNext(userInfoBean);
                }
            }

            @Override
            public void doError(String msg) {

            }

            @Override
            public void doResult() {

            }
        });
    }

    public static void getUserInfoByJson(String s, final UserCallBack callBack) {
        userInfoBean = null;
        String json = CacheUtils.INSTANCE.getString(MainApplication.Companion.getApplication(), Constants.User.USER_JSON);
        if (!TextUtils.isEmpty(json)&&!json.equals("null")) {
             userInfoBean = JSON.parseObject(json, UserInfo.class);

        }
        if (userInfoBean == null) return;
        callBack.doNext(userInfoBean);
    }

    public interface UserCallBack {
        void doNext(UserInfo infoBean);
    }
}
