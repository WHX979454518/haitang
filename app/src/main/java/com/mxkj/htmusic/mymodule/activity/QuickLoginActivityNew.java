package com.mxkj.htmusic.mymodule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ReplacementTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.model.HttpParams;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.toolmodule.MainApplication;
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity;
import com.mxkj.htmusic.toolmodule.utils.CacheUtils;
import com.mxkj.htmusic.toolmodule.utils.Constants;
import com.mxkj.htmusic.toolmodule.utils.StatusBarUtil;
import com.mxkj.htmusic.toolmodule.utils.VerifyCodeView;
import com.mxkj.htmusic.toolmodule.utils.app.CountDownTimerUtils;
import com.mxkj.yuanyintang.net.NetWork;
import com.mxkj.yuanyintang.utils.app.ActivityCollector;
import com.umeng.analytics.MobclickAgent;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

import static com.mxkj.htmusic.toolmodule.utils.Constants.Other.EM_LOGIN;

public class QuickLoginActivityNew extends StandardUiActivity {
    private CountDownTimerUtils countDownTimerUtils;
    private UMShareAPI mShareAPI;
    public String inviteCode = "";
    @BindView(R.id.finish)
    ImageView finish;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.et_cout)
    EditText etCout;
    @BindView(R.id.tv_verification_code)
    TextView tv_verification_code;
    @BindView(R.id.rl_verification_code)
    RelativeLayout rl_verification_code;
    @BindView(R.id.rl_verification_code2)
    RelativeLayout rl_verification_code2;
    @BindView(R.id.ll_phone)
    LinearLayout ll_phone;
    @BindView(R.id.ll_code)
    LinearLayout ll_code;
    @BindView(R.id.header_prompt)
    TextView header_prompt;
    @BindView(R.id.tv_switch_login)
    TextView tv_switch_login;
    @BindView(R.id.deleTxt)
    ImageView deleTxt;

    @BindView(R.id.verify_code_view)
    VerifyCodeView verifyCodeView;

    @BindView(R.id.countdown_tv)
    TextView countdown_tv;


     ;
    @Override
    public int setLayoutId() {
        return R.layout.activity_quick_login_new;
    }

    @Override
    public boolean isVisibilityBottomPlayer() {
        return false;
    }

    @Override
    protected void initView() {
        hideTitle(true);
        ButterKnife.bind(this);
        StatusBarUtil.baseTransparentStatusBar(this);
        mShareAPI = UMShareAPI.get(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {
        countdown_tv = findViewById(R.id.countdown_tv);
        verifyCodeView = (VerifyCodeView) findViewById(R.id.verify_code_view);
        verifyCodeView.setInputCompleteListener(new VerifyCodeView.InputCompleteListener() {
            @Override
            public void inputComplete() {
                NetWork.INSTANCE.getfastlogin(etCout.getText().toString(), "86", verifyCodeView.getEditContent(), QuickLoginActivityNew.this, new NetWork.TokenCallBack() {
                    @Override
                    public void doNext(String resultData, Headers headers) {
                        hideLoadingView();
                        Log.e("",""+resultData);
                        MobclickAgent.onEvent(QuickLoginActivityNew.this,"quick_log_success");
                        CacheUtils.INSTANCE.setString(QuickLoginActivityNew.this, Constants.User.USER_JSON, resultData);
                        hideLoadingView();


                        JSONObject jsonObject = JSON.parseObject(resultData);
                        Integer code = jsonObject.getInteger("code");
                        JSONObject dataObj = jsonObject.getJSONObject("data");
                        if(code==0){
                            com.mxkj.htmusic.toolmodule.utils.Toast.create(QuickLoginActivityNew.this).show("是第一次登录");
                            CacheUtils.INSTANCE.setBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN, false);
                            Bundle bundle = new Bundle();
                            bundle.putString("params", dataObj.getString("key"));
                            goActivity(SettingPwdActivity.class,bundle);
                        }else {
                            com.mxkj.htmusic.toolmodule.utils.Toast.create(QuickLoginActivityNew.this).show("不是第一次登录");
                        }


//                        Log.e("rrrrrrrr", CacheUtils.INSTANCE.getBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN)+"");
//                        if (CacheUtils.INSTANCE.getBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN)) {
//
//                        } else if(CacheUtils.INSTANCE.getBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN, false)){
//
//                        }

//                        UserInfoUtil.getUserInfoByJson(resultData, new UserInfoUtil.UserCallBack() {
//                            @Override
//                            public void doNext(UserInfo infoBean) {
//                                if (infoBean.getData().getLog_num() == 0) {
//                                    LoginSuccessToGo.goNext(QuickLoginActivityNew.this);
//                                }
//                            }
//                        });
                        CacheUtils.INSTANCE.setString(QuickLoginActivityNew.this, Constants.User.USER_JSON, resultData);
                        CacheUtils.INSTANCE.setBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN, true);
                        sendBroadcast(new Intent(EM_LOGIN));
                        ActivityCollector.INSTANCE.finishAll();
                    }
                    @Override
                    public void doError(String msg) {

                    }

                    @Override
                    public void doResult() {

                    }
                });

            }

            @Override
            public void invalidContent() {

            }
        });


        etCout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if(s!=null){
                    rl_verification_code.setVisibility(View.GONE);
                    rl_verification_code2.setVisibility(View.VISIBLE);
                }
                if(!s.equals("")){
                    deleTxt.setVisibility(View.VISIBLE);
                }else {
                    deleTxt.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityCollector.INSTANCE.addActivity(this);
        MobclickAgent.onEvent(this, "quick_login");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.INSTANCE.removeActivity(this);
    }

    @OnClick({R.id.countdown_tv,R.id.rl_verification_code,R.id.rl_verification_code2, R.id.tv_verification_code, R.id.finish,R.id.back , R.id.qq, R.id.wechat, R.id.sina,R.id.tv_switch_login,R.id.deleTxt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish:
                finish();
                break;
            case R.id.deleTxt:
                etCout.getText().clear();
                rl_verification_code.setVisibility(View.VISIBLE);
                rl_verification_code2.setVisibility(View.GONE);
                break;
            case R.id.back:
                ll_phone.setVisibility(View.VISIBLE);
                finish.setVisibility(View.VISIBLE);
                back.setVisibility(View.GONE);
                ll_code.setVisibility(View.GONE);
                header_prompt.setText("请输入您的手机号码进行登录或注册");
                break;
            case R.id.qq:
                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, authListener);
                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
                Toast.makeText(this, "qq", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wechat:
                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.WEIXIN, authListener);
                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
                Toast.makeText(this, "wechat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sina:
//                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.SINA, authListener);
                Toast.makeText(this, "sina", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_verification_code:
                Toast.makeText(this, "请填写手机号在发送~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_verification_code:
                Toast.makeText(this, "请填写手机号在发送~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_verification_code2:

                if (TextUtils.isEmpty(etCout.getText())) return;
                MobclickAgent.onEvent(QuickLoginActivityNew.this, "getQuickCode");



                NetWork.INSTANCE.getCode("86", "1", "", etCout.getText().toString(), this, new NetWork.TokenCallBack() {
                    @Override
                    public void doNext(String resultData, Headers headers) {
                        hideLoadingView();
                        Log.e("",""+resultData);

                        countDownTimerUtils = new CountDownTimerUtils(countdown_tv, 60000, 1000);
                        countDownTimerUtils.start();
                        countDownTimerUtils.start();

                        com.mxkj.htmusic.toolmodule.utils.Toast.create(QuickLoginActivityNew.this).show("验证码为"+resultData+"");
                    }
                    @Override
                    public void doError(String msg) {
                        if (countDownTimerUtils != null) {
                            countDownTimerUtils.onFinish();
                        }                    }

                    @Override
                    public void doResult() {

                    }


                });


                Toast.makeText(this, "rl_verification_code", Toast.LENGTH_SHORT).show();
                ll_phone.setVisibility(View.GONE);
                finish.setVisibility(View.GONE);
                back.setVisibility(View.VISIBLE);
                ll_code.setVisibility(View.VISIBLE);
                header_prompt.setText("已发送验证码至"+etCout.getText().toString());
                break;

            case R.id.tv_switch_login:
                goActivity(LoginRegMainPage.class);
                finish();
                break;


        }
    }

    public class UpperCaseTransform extends ReplacementTransformationMethod {
        @Override
        protected char[] getOriginal() {
            char[] aa = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            return aa;
        }

        @Override
        protected char[] getReplacement() {
            char[] cc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            return cc;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            showLoadingView();
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(final SHARE_MEDIA platform, int action, final Map<String, String> data) {
            if (data != null && platform != null) {
                MobclickAgent.onEvent(QuickLoginActivityNew.this,"other_login");

                NetWork.INSTANCE.IsBind(QuickLoginActivityNew.this, platform, data, new NetWork.TokenCallBack() {
                    @Override
                    public void doNext(final String resultData, Headers headers) {
                        JSONObject jsonObject = JSON.parseObject(resultData);
                        int code = jsonObject.getInteger("code");
                        if (code == 0) {//没有绑定，直接登录(以前是跳转绑定页面，暂时留着，后台说不定优惠改回去)
                            HttpParams params = new HttpParams();
                            params.put("openid", data.get("uid") + "");
                            params.put("nickname", data.get("name") + "");
                            params.put("head", data.get("iconurl") + "");
                            if (platform.equals(SHARE_MEDIA.QQ)) {
                                params.put("type", "2");
                            } else if (platform.equals(SHARE_MEDIA.WEIXIN)) {
                                params.put("type", "1");
                            } else if (platform.equals(SHARE_MEDIA.SINA)) {
                                params.put("type", "3");
                            }
                            if (!TextUtils.isEmpty(inviteCode)){
                                params.put("incode", inviteCode);
                            }
                            params.put("device_token", MainApplication.Companion.getPushAgent().getRegistrationId());

                            NetWork.INSTANCE.loginByOpenId(QuickLoginActivityNew.this, params, new NetWork.TokenCallBack() {
                                @Override
                                public void doNext(String resultData, Headers headers) {
//                                    loginSuccess(resultData);
                                }

                                @Override
                                public void doError(String msg) {
                                    setSnackBar("登录失败，请稍后再试", "", R.drawable.ic_launcher);
                                }

                                @Override
                                public void doResult() {

                                }
                            });
                        } else {
//                            loginSuccess(resultData);
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
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            hideLoadingView();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            hideLoadingView();
        }
    };

    private void loginSuccess(String resultData) {
        CacheUtils.INSTANCE.setString(QuickLoginActivityNew.this, Constants.User.USER_JSON, resultData);
        CacheUtils.INSTANCE.setBoolean(QuickLoginActivityNew.this, Constants.User.IS_LOGIN, true);

        ActivityCollector.INSTANCE.finishAll();
    }

}
