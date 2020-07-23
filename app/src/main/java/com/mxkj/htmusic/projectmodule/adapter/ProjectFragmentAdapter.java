package com.mxkj.htmusic.projectmodule.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;

import com.jakewharton.rxbinding2.view.RxView;
import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.activity.ProjectDetailsActivity;
import com.mxkj.htmusic.projectmodule.bean.ProjectListBean;
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

public class ProjectFragmentAdapter extends BaseQuickAdapter<ProjectListBean.DataBean, BaseViewHolder> {

    private FragmentManager fragmentManager;
    private Handler myhandler;

    public ProjectFragmentAdapter(List<ProjectListBean.DataBean> data, FragmentManager fragmentManager, Handler myhandler) {
        super(R.layout.item_project_fragment, data);
        this.fragmentManager = fragmentManager;
        this.myhandler = myhandler;
    }
    public ProjectFragmentAdapter(List<ProjectListBean.DataBean> data, FragmentManager fragmentManager) {
        super(R.layout.item_project_fragment, data);
        this.fragmentManager = fragmentManager;
    }
    @Override
    protected void convert(final BaseViewHolder helper, final ProjectListBean.DataBean item, final int position) {

        helper.setText(R.id.project_name, StringUtils.isEmpty(item.getProject_title()));
        helper.setText(R.id.progect_money, StringUtils.isEmpty(item.getBudget_range_text()));
        helper.setText(R.id.progect_time, StringUtils.isEmpty(item.getCreated_at()));
        helper.setText(R.id.project_musicans_name, StringUtils.isEmpty(item.getProject_title()));


//        Glide.with(mContext).load(item.getMember().getHead_info().getLink()).asBitmap().placeholder(R.drawable.ic_launcher)
//                .into((ImageView) helper.getView(R.id.project_image));
//        helper.setText(R.id.project_musicans_name, StringUtils.isEmpty(item.getMember().getNickname()));


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
