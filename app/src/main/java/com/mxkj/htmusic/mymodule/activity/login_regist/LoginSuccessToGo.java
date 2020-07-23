package com.mxkj.htmusic.mymodule.activity.login_regist;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mxkj.htmusic.mymodule.bean.UserInfoUtil;
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo;
import com.mxkj.htmusic.toolmodule.utils.CacheUtils;
import com.mxkj.htmusic.toolmodule.utils.Constants;


public class LoginSuccessToGo {
    public static void goNext(final Context context) {
        String uJson = CacheUtils.INSTANCE.getString(context, Constants.User.USER_JSON);
        if (TextUtils.isEmpty(uJson)) {
            return;
        }
        UserInfoUtil.getUserInfoByJson(uJson, new UserInfoUtil.UserCallBack() {
            @Override
            public void doNext(UserInfo infoBean) {
                if (infoBean != null && infoBean.getData() != null) {
//                    int log_num = infoBean.getData().getLog_num();
//                    if (log_num == 0) {
                        context.startActivity(new Intent(context, RegSuccessRecommend2.class));

//                    }
                }
            }
        });
    }
}
