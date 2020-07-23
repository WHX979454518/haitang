package com.mxkj.htmusic.mymodule.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;

import com.jakewharton.rxbinding2.view.RxView;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.mymodule.activity.RecruitPeopleParticipateActivity;
import com.mxkj.htmusic.mymodule.bean.MyProjectRecruitBean;
import com.mxkj.htmusic.projectmodule.activity.ProjectDetailsActivity;
import com.mxkj.htmusic.toolmodule.base.BaseQuickAdapter;
import com.mxkj.htmusic.toolmodule.base.BaseViewHolder;
import com.mxkj.htmusic.toolmodule.utils.string.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 *
 */

public class MyProjectRecruitPeopleAllFragmentAdapter extends BaseQuickAdapter<MyProjectRecruitBean.DataBean, BaseViewHolder> {

    private FragmentManager fragmentManager;
    private Handler myhandler;

    public MyProjectRecruitPeopleAllFragmentAdapter(List<MyProjectRecruitBean.DataBean> data, FragmentManager fragmentManager, Handler myhandler) {
        super(R.layout.item_myprojectrecruitpeopleall_fragment, data);
        this.fragmentManager = fragmentManager;
        this.myhandler = myhandler;
    }
    public MyProjectRecruitPeopleAllFragmentAdapter(List<MyProjectRecruitBean.DataBean> data, FragmentManager fragmentManager) {
        super(R.layout.item_myprojectrecruitpeopleall_fragment, data);
        this.fragmentManager = fragmentManager;
    }
    @Override
    protected void convert(final BaseViewHolder helper, final MyProjectRecruitBean.DataBean item, final int position) {

        helper.setText(R.id.project_name, StringUtils.isEmpty(item.getProject_title()));
        helper.setText(R.id.progect_money, StringUtils.isEmpty(item.getProject_title()));
        helper.setText(R.id.progect_time, StringUtils.isEmpty(item.getProject_title()));
        helper.setText(R.id.project_musicans_name, StringUtils.isEmpty(item.getProject_title()));


        RxView.clicks(helper.getView(R.id.project_layout))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        Intent intent = new Intent(mContext, ProjectDetailsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("projectid", StringUtils.isEmpty(item.getId()+""));
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);

                    }
                });
        RxView.clicks(helper.getView(R.id.project_state_rl))
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(@NonNull Object o) throws Exception {
                        Intent intent = new Intent(mContext, RecruitPeopleParticipateActivity.class);
                        mContext.startActivity(intent);
                    }
                });


    }

    public interface ClickCheckedSongListener {
        void onChecked(Boolean aBoolean, int position);

        void onRefreshData();
    }

    private ClickCheckedSongListener checkedSongListener;

    public void setCheckedSongListener(ClickCheckedSongListener checkedSongListener) {
        this.checkedSongListener = checkedSongListener;
    }

}
