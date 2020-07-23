package com.mxkj.htmusic.projectmodule.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.bean.LastPayInfoBean;
import com.mxkj.htmusic.projectmodule.bean.SelectedMusicansBean;
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity;
import com.mxkj.htmusic.toolmodule.utils.ExpandableLinearLayout;
import com.mxkj.htmusic.toolmodule.utils.StatusBarUtil;
import com.mxkj.yuanyintang.net.NetWork;
import com.mxkj.yuanyintang.pay.PayUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Headers;

public class RecruitPeoplePayActivity  extends StandardUiActivity {
    @BindView(R.id.paymoney)
    TextView paymoney;
    @BindView(R.id.cancel_cooperation)
    TextView cancel_cooperation;
    @BindView(R.id.music_name2)
    TextView music_name2;
    @BindView(R.id.project_name_tv_describe1)
    TextView project_name_tv_describe1;
    @BindView(R.id.remuneration1)
    TextView remuneration1;
    @BindView(R.id.allmoney)
    TextView allmoney;

    @BindView(R.id.ex_linear_layou)
    ExpandableLinearLayout exLinearLayou;

    @Override
    public boolean isVisibilityBottomPlayer() {
        return false;
    }

    @Override
    protected int setLayoutId() {
        StatusBarUtil.baseTransparentStatusBar(this);
        return R.layout.activity_recruitpeople;
    }

    @Override
    protected void initView() {
        setTitleText("待支付");
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        if(null!=getIntent().getSerializableExtra("state")) {
            SelectedMusicansBean.DataBean state = (SelectedMusicansBean.DataBean) getIntent().getSerializableExtra("state");
            music_name2.setText(state.getSea_member().getNickname());
            project_name_tv_describe1.setText(state.getProject().getProject_title());
            remuneration1.setText(state.getMoney());
            allmoney.setText(state.getMoney());
        }




        List<LastPayInfoBean> last_pay_info = new ArrayList<>();
        LastPayInfoBean lastPayInfoBean1 = new LastPayInfoBean();
        lastPayInfoBean1.setType(1);
        lastPayInfoBean1.setDesc("微信");
        LastPayInfoBean lastPayInfoBean2 = new LastPayInfoBean();
        lastPayInfoBean2.setType(2);
        lastPayInfoBean2.setDesc("支付宝");
        LastPayInfoBean lastPayInfoBean3 = new LastPayInfoBean();
        lastPayInfoBean3.setType(3);
        lastPayInfoBean3.setDesc("QQ");
        LastPayInfoBean lastPayInfoBean4 = new LastPayInfoBean();
        lastPayInfoBean4.setType(4);
        lastPayInfoBean4.setDesc("小鱼干");



        last_pay_info.add(lastPayInfoBean1);
        last_pay_info.add(lastPayInfoBean2);
        last_pay_info.add(lastPayInfoBean3);
        last_pay_info.add(lastPayInfoBean4);
        if (last_pay_info != null && last_pay_info.size() > 0) {
            initPayWayView(last_pay_info);
        }
    }

    @Override
    protected void initEvent() {

    }

    @OnClick({R.id.paymoney, R.id.cancel_cooperation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.paymoney:

                Log.e(TAG, "onClick:去支付----- " + payType);
                showLoadingView();

                //去支付
                if(null!=getIntent().getSerializableExtra("state")) {
                    SelectedMusicansBean.DataBean state = (SelectedMusicansBean.DataBean) getIntent().getSerializableExtra("state");
                    if (payId != 0) {
                        PayUtils.INSTANCE.pay(this,
                                state.getProject().getId(),
                                state.getProject_task_id(),
                                state.getId(),
                                state.getUid(),
                                state.getSea_member().getUid(),
                                payType,//支付类型1微信2支付宝3QQ4小鱼干
                                state.getMoney());

                    }
                }




                //去支付
                if(null!=getIntent().getSerializableExtra("state")) {
                    SelectedMusicansBean.DataBean state = (SelectedMusicansBean.DataBean) getIntent().getSerializableExtra("state");
                    NetWork.INSTANCE.getcreateorder(RecruitPeoplePayActivity.this,
                            state.getProject().getId(),
                            state.getProject_task_id(),
                            state.getId(),
                            state.getUid(),
                            state.getSea_member().getUid(),
                            1,//支付类型1微信2支付宝3QQ4小鱼干
                            state.getMoney(),
                            new NetWork.TokenCallBack() {
                                @Override
                                public void doNext(String resultData, Headers headers) {
                                    Log.e("uuuuuu", "" + resultData);
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
            case R.id.cancel_cooperation:
                //取消合作就是取消签约
                if(null!=getIntent().getSerializableExtra("state")) {
                    SelectedMusicansBean.DataBean state = (SelectedMusicansBean.DataBean) getIntent().getSerializableExtra("state");
                    NetWork.INSTANCE.getcancelsign(RecruitPeoplePayActivity.this, state.getId(),"太垃圾lalallalal", new NetWork.TokenCallBack() {
                                @Override
                                public void doNext(String resultData, Headers headers) {
                                    Log.e("uuuuuu", "" + resultData);
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
        }
    }


    private int payType = 1;
    private int payId;


    private void initPayWayView(final List<LastPayInfoBean> last_pay_info) {
        if (exLinearLayou.getChildCount() > 2) return;
        exLinearLayou.removeAllViews();


        Log.e(TAG, "initPayWayView: " + last_pay_info.size());
        for (int i = 0; i < last_pay_info.size(); i++) {
            View pay_view = LayoutInflater.from(this).inflate(R.layout.pay_way_layout, null);
            TextView pay_name = pay_view.findViewById(R.id.pay_name);
            ImageView iv_pay = pay_view.findViewById(R.id.iv_pay);
            setDrawable(iv_pay, last_pay_info.get(i).getType());
            final CheckBox ck_pay_way = pay_view.findViewById(R.id.ck_pay_way);
            pay_name.setText(last_pay_info.get(i).getDesc());
            final int finalI = i;
            pay_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < exLinearLayou.getChildCount(); i++) {
                        View childAt = exLinearLayou.getChildAt(i);
                        final CheckBox ck_pay_way = childAt.findViewById(R.id.ck_pay_way);
                        if (ck_pay_way != null) {
                            ck_pay_way.setChecked(false);
                        }
                    }
                    if(null!=getIntent().getSerializableExtra("state")&&ck_pay_way.isChecked()==true) {
                        SelectedMusicansBean.DataBean state = (SelectedMusicansBean.DataBean) getIntent().getSerializableExtra("state");
                        paymoney.setText("确认支付￥" + state.getMoney());
                    }
                    ck_pay_way.setChecked(true);
                    payType = last_pay_info.get(finalI).getType();
                }
            });
            if (last_pay_info.get(i).getIs_last() == 1) {
                ck_pay_way.setChecked(true);
                payType = last_pay_info.get(i).getType();
                Log.e(TAG, "默认的---: " + payType);
                exLinearLayou.addItem(pay_view, 0);
            } else {
                ck_pay_way.setChecked(false);
                exLinearLayou.addItem(pay_view, -1);
            }

        }
    }
    private void setDrawable(ImageView tv, int type) {
            switch (type) {
                case 4:
                    tv.setImageResource(R.mipmap.icon_fish);
                    payId = 4;
                    break;
                case 3:
                    tv.setImageResource(R.mipmap.icon_qq);
                    payId = 3;
                    break;
                case 1:
                    tv.setImageResource(R.mipmap.icon_payment_wechat);
                    payId = 1;
                    break;
                case 2:
                    tv.setImageResource(R.mipmap.icon_payment_alipay);
                    payId = 2;
                    break;
            }
    }
}
