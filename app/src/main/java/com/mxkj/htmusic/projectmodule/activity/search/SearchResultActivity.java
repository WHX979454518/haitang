package com.mxkj.htmusic.projectmodule.activity.search;

import android.view.View;
import android.widget.RelativeLayout;

import com.mxkj.htmusic.R;
import com.mxkj.htmusic.toolmodule.base.baseactivity.StandardUiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SearchResultActivity extends StandardUiActivity {

    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @Override
    public boolean isVisibilityBottomPlayer() {
        return false;
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_search_reault;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        hideTitle(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }
    @OnClick({R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
        }
    }
}
