package com.mxkj.htmusic.mymodule.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzy.okgo.model.HttpParams;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.toolmodule.MainApplication;
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity;
import com.mxkj.htmusic.toolmodule.base.bean.UserInfo;
import com.mxkj.htmusic.toolmodule.utils.SaveMessage;
import com.mxkj.htmusic.toolmodule.utils.StatusBarUtil;
import com.mxkj.htmusic.toolmodule.utils.widget.EmailpopUpWindow;
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

public class SettingPwdActivity extends StandardUiActivity {
    private UMShareAPI mShareAPI;
    public static final String MOBILE = "U_MOBILE";
    @BindView(R.id.finish)
    ImageView finish;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.et_cout)
    EditText etCout;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.ck_show)
    CheckBox ckShow;
    @BindView(R.id.bt_sure)
    TextView btSure;
    @BindView(R.id.tv_switch_login)
    TextView tv_switch_login;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.delete_phone)
    ImageView delete_phone;
    @BindView(R.id.delete_pwd)
    ImageView delete_pwd;
    @BindView(R.id.rl_login)
    RelativeLayout rl_login;
    @BindView(R.id.rl_login2)
    RelativeLayout rl_login2;
    @BindView(R.id.header)
    TextView header;
    @BindView(R.id.bt_sure2)
    TextView bt_sure2;

    private PopupWindow popupWindow;
    private EmailpopUpWindow emailpopUpWindow;
    private InputMethodManager mInputManager;//软键盘管理类


    private String data = "";

    private String s,s1;
    @Override
    public int setLayoutId() {
        return R.layout.activity_pwd_setting_new;
    }

    @Override
    public boolean isVisibilityBottomPlayer() {
        return false;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        mShareAPI = UMShareAPI.get(this);
        hideTitle(true);
        StatusBarUtil.baseTransparentStatusBar(this);


        if (null!=getIntent().getExtras()){
            Bundle i=getIntent().getExtras();
            if (null!=i.getString("params")){
                data=i.getString("params");//获取数据包
            }
        }
        if(data!=""){
            header.setText("新用户请设置密码注册");
            bt_sure2.setText("注册");
        }
    }

    @Override
    protected void initEvent() {
        if (emailpopUpWindow == null) {
            emailpopUpWindow = new EmailpopUpWindow();
        }
        ckShow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                etPwd.setSelection(etPwd.getText().length());
            }
        });
        mInputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        etCout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                s = editable.toString();
                if(s!=null&&s1!=null){
                    rl_login.setVisibility(View.GONE);
                    rl_login2.setVisibility(View.VISIBLE);
                }
                if(!s.equals("")){
                    delete_phone.setVisibility(View.VISIBLE);
                }else {
                    delete_phone.setVisibility(View.GONE);
                }
                if (s.endsWith("@")) {
                    showEmailPop();
                }
            }
        });
        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                s1 = editable.toString();
                if(s!=null&&s1!=null){
                    rl_login.setVisibility(View.GONE);
                    rl_login2.setVisibility(View.VISIBLE);
                }
                if(!s1.equals("")){
                    delete_pwd.setVisibility(View.VISIBLE);
                }else {
                    delete_pwd.setVisibility(View.GONE);
                }

            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityCollector.INSTANCE.addActivity(this);
        MobclickAgent.onEvent(this,"pwd_count");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.INSTANCE.removeActivity(this);
    }

    @OnClick({R.id.finish, R.id.delete_phone, R.id.delete_pwd, R.id.qq, R.id.wechat, R.id.sina, R.id.bt_sure,R.id.rl_login,R.id.rl_login2, R.id.tv_switch_login})
    public void onClick(View view) {
//        Intent intent = new Intent(this, UserNoticeActivity.class);
        switch (view.getId()) {
            case R.id.finish:
                MobclickAgent.onEvent(this,"pwd_back");
                finish();
                break;
            case R.id.rl_login:
                if (TextUtils.isEmpty(etCout.getText().toString())) {
                    setSnackBar("请输入账号", "", R.drawable.icon_fails);
                } else {
                    showLoadingView();
                   }
                break;
            case R.id.rl_login2:
                if (TextUtils.isEmpty(etCout.getText().toString())) {
                    setSnackBar("请输入账号", "", R.drawable.icon_fails);
                } else {
                    showLoadingView();
                    NetWork.INSTANCE.getfastsetpassword(data, etPwd.getText().toString(),  this, new NetWork.TokenCallBack() {
                        @Override
                        public void doNext(String resultData, Headers headers) {
                            hideLoadingView();
                            Toast.makeText(SettingPwdActivity.this, "设置密码成功", Toast.LENGTH_SHORT).show();
                            Log.e("",""+resultData);

                            //保存一次用户的uid
                            UserInfo UserInfo = JSON.parseObject(resultData, UserInfo.class);
                            SaveMessage.SaveLoginUid(UserInfo.getData().getUid(), SettingPwdActivity.this);

                            finish();
                        }
                        @Override
                        public void doError(String msg) {

                        }

                        @Override
                        public void doResult() {

                        }
                    });
                }
                break;
            case R.id.bt_sure:
                if (TextUtils.isEmpty(etCout.getText().toString())) {
                    setSnackBar("请输入账号", "", R.drawable.icon_fails);
                } else {
                    showLoadingView();
                }
                break;
            case R.id.tv_switch_login:
                MobclickAgent.onEvent(this,"pwd_quick");
                Intent intent1 = new Intent(this, QuickLoginActivityNew.class);
                if (!TextUtils.isEmpty(etCout.getText())) {
                    intent1.putExtra(MOBILE, etCout.getText().toString());
                }
                startActivity(intent1);
                finish();
                break;
            case R.id.delete_phone:
                etCout.getText().clear();
                rl_login.setVisibility(View.VISIBLE);
                rl_login2.setVisibility(View.GONE);
                break;
            case R.id.delete_pwd:
                etPwd.getText().clear();
                rl_login.setVisibility(View.VISIBLE);
                rl_login2.setVisibility(View.GONE);
                break;
            case R.id.qq:
                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, authListener);
                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.wechat:
                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.WEIXIN, authListener);
                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);
                break;
            case R.id.sina:
//                UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.SINA, authListener);
                mShareAPI.getPlatformInfo(this, SHARE_MEDIA.SINA, authListener);
        }
    }

    public void showEmailPop() {
        mInputManager.hideSoftInputFromWindow(etCout.getWindowToken(), 0);
        if (emailpopUpWindow.isShowing()) {
            emailpopUpWindow.dismiss();
        }
        emailpopUpWindow.showPop(this, tvLine, etCout.getText().toString(), new EmailpopUpWindow.EmailPopCallBack() {
            @Override
            public void popEmailItemClick(String cout) {
                etCout.setText(cout);
                etCout.setSelection(etCout.getText().length());
                emailpopUpWindow.dismissPop();
            }
        });
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
            MobclickAgent.onEvent(SettingPwdActivity.this,"other_login");
            if (data != null && platform != null) {
                NetWork.INSTANCE.IsBind(SettingPwdActivity.this, platform, data, new NetWork.TokenCallBack() {
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
                            params.put("device_token", MainApplication.Companion.getPushAgent().getRegistrationId());

                            NetWork.INSTANCE.loginByOpenId(SettingPwdActivity.this, params, new NetWork.TokenCallBack() {
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



}
