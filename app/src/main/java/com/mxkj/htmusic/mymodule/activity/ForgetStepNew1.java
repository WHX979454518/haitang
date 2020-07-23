package com.mxkj.htmusic.mymodule.activity;

import android.content.Context;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity;
import com.mxkj.htmusic.toolmodule.utils.StatusBarUtil;
import com.mxkj.htmusic.toolmodule.utils.app.CountDownTimerUtils;
import com.mxkj.htmusic.toolmodule.utils.widget.EmailpopUpWindow;
import com.mxkj.yuanyintang.net.NetWork;
import com.mxkj.yuanyintang.utils.app.ActivityCollector;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

import static com.mxkj.htmusic.mymodule.activity.LoginRegMainPage.MOBILE;

public class ForgetStepNew1 extends StandardUiActivity {

    @BindView(R.id.finish)
    ImageView finish;
    @BindView(R.id.getCode)
    TextView getCode;
    @BindView(R.id.getCode2)
    TextView getCode2;
    @BindView(R.id.use_email)
    TextView useEmail;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id. rl_verification_code)
    RelativeLayout rl_verification_code;
    @BindView(R.id. rl_verification_code2)
    RelativeLayout rl_verification_code2;
    @BindView(R.id.header)
    TextView header;
    @BindView(R.id.header_prompt)
    TextView header_prompt;
    @BindView(R.id. area_code)
    LinearLayout area_code;
    @BindView(R.id. deleTxt)
    ImageView deleTxt;



    private boolean isPhone = true;
    public static String byWhat = "1";
    private InputMethodManager mInputManager;
    private EmailpopUpWindow emailpopUpWindow;
    private CountDownTimerUtils countDownTimerUtils;

    @Override
    public int setLayoutId() {
        return R.layout.activity_forget_step_new1;
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
        String stringExtra = getIntent().getStringExtra(MOBILE);
        if (!TextUtils.isEmpty(stringExtra)) {
            etPhone.setText(stringExtra);
            etPhone.setCursorVisible(false);
        }
    }

    @Override
    protected void initEvent() {
        mInputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (emailpopUpWindow == null) {
            emailpopUpWindow = new EmailpopUpWindow();
        }
        etPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = editable.toString();
                if(isPhone==false){
                    getCode2.setText("发送");
                }
                if(s!=null){
                    rl_verification_code.setVisibility(View.GONE);
                    rl_verification_code2.setVisibility(View.VISIBLE);
                }
                if(!s.equals("")){
                    deleTxt.setVisibility(View.VISIBLE);
                }else {
                    deleTxt.setVisibility(View.GONE);
                }
                if (s.endsWith("@")) {
                    showEmailPop();
                }
            }
        });

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.finish,R.id.getCode, R.id.use_email,R.id.rl_verification_code,R.id.deleTxt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.finish:
                MobclickAgent.onEvent(this,"forget_back");
                finish();
                break;
            case R.id.deleTxt:
                etPhone.getText().clear();
                rl_verification_code.setVisibility(View.VISIBLE);
                rl_verification_code2.setVisibility(View.GONE);
                break;
            case R.id.rl_verification_code:
                MobclickAgent.onEvent(this,"forget_back");
                goActivity(ForgetFoundPhoneAcivity.class);
                break;
            case R.id.getCode:
                if (!TextUtils.isEmpty(etPhone.getText())) {
                    MobclickAgent.onEvent(this,"forget_get_code");
                    NetWork.INSTANCE.getCode("", "find_pwd", byWhat, etPhone.getText().toString(), this, new NetWork.TokenCallBack() {
                        @Override
                        public void doNext(String resultData, Headers headers) {

                        }

                        @Override
                        public void doError(String msg) {
                            if (countDownTimerUtils != null) {
                                countDownTimerUtils.onFinish();
                            }                        }

                        @Override
                        public void doResult() {

                        }
                    });
                    countDownTimerUtils = new CountDownTimerUtils(getCode, 60000, 1000);
                    countDownTimerUtils.start();
                } else {
                    setSnackBar("账号不能为空", "", R.drawable.icon_fails);
                }
                break;
            case R.id.use_email:
                MobclickAgent.onEvent(this,"forget_email");
                if (countDownTimerUtils!=null){
                countDownTimerUtils.onFinish();}
                countDownTimerUtils = new CountDownTimerUtils(getCode, 60000, 1000);
                rl_verification_code.setVisibility(View.VISIBLE);
                rl_verification_code2.setVisibility(View.GONE);
                if (isPhone == true) {
                    isPhone = false;
                    byWhat = "2";
                    useEmail.setText("手机找回");
                    etPhone.setHint("请输入邮箱号");
                    header.setText("邮箱验证找回密码");
                    getCode.setText("发送");
                    header_prompt.setText("请发送验证邮件后至绑定的邮箱中按提示操作");
                    area_code.setVisibility(View.GONE);
                    etPhone.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                    etPhone.getText().clear();
                } else {
                    etPhone.getText().clear();
                    byWhat = "1";
                    etPhone.setInputType(InputType.TYPE_CLASS_NUMBER);
                    isPhone = true;
                    useEmail.setText("邮箱找回");
                    etPhone.setHint("请输入手机号");
                    header.setText("手机验证找回密码");
                    getCode.setText("获取验证码");
                    header_prompt.setText("请输入您绑定的手机号找回");
                    area_code.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityCollector.INSTANCE.addActivity(this);
        MobclickAgent.onEvent(this,"forget_count");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.INSTANCE.removeActivity(this);
    }

    public void showEmailPop() {
        mInputManager.hideSoftInputFromWindow(etPhone.getWindowToken(), 0);
        if (emailpopUpWindow.isShowing()) {
            emailpopUpWindow.dismiss();
        }
        emailpopUpWindow.showPop(this, etPhone, etPhone.getText().toString(), new EmailpopUpWindow.EmailPopCallBack() {
            @Override
            public void popEmailItemClick(String cout) {
                etPhone.setText(cout);
                etPhone.setSelection(etPhone.getText().length());
                emailpopUpWindow.dismissPop();
            }
        });
    }
}
