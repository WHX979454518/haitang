//package com.mxkj.haitang.mymodule.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONPObject;
//import com.google.gson.JsonArray;
//import com.mxkj.haitang.R;
//import com.mxkj.haitang.mymodule.adapter.ParticipateFragmentAdapter;
//import com.mxkj.haitang.messagemodule.bean.ParticipateFragmentBean;
//import com.mxkj.haitang.mymodule.adapter.RecruitPeopleParticipateFragmentAdapter;
//import com.mxkj.haitang.projectmodule.bean.ProjectdetailsListBean;
//import com.mxkj.haitang.projectmodule.bean.SignUpMusicansBean;
//import com.mxkj.haitang.projectmodule.bean.WorkPurposesBean;
//import com.mxkj.yuanyintang.net.NetWork;
//import com.trello.rxlifecycle2.components.support.RxFragment;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import okhttp3.Headers;
//
//public class RecruitPeopleParticipateFragment extends RxFragment {
//    private View rootView;
//
//    private RecyclerView recyclerview;
//    private RecruitPeopleParticipateFragmentAdapter musicListMusicIanAdapter  = null;
//    private ArrayList<ParticipateFragmentBean.DataBean> musicListMusicIanBeanList= new ArrayList<>();
//
//
//    String work_type_id="";
//    String require_id = "";
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        if (rootView == null) {
//            rootView = inflater.inflate(R.layout.recruitpeopleparticipatefragment, container, false);
//        }
//        ViewGroup parent = (ViewGroup) rootView.getParent();
//        if (parent != null) {
//            parent.removeView(rootView);
//        }
//        initEvent();
//        return rootView;
//    }
//
//    private void initEvent() {
//        recyclerview = rootView.findViewById(R.id.recyclerview);
//
//        Bundle bundle = getArguments();
//        if(null!=bundle.getString("require_id")) {
//            work_type_id = bundle.getString("work_type_id");
//            require_id = bundle.getString("require_id");
//        }
//        initdata();
//    }
//    private void initdata() {
//        //需要请求来tinachognshuju
//        ParticipateDate();
//
//        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        if (musicListMusicIanAdapter == null) {
//            musicListMusicIanAdapter = new RecruitPeopleParticipateFragmentAdapter(musicListMusicIanBeanList);
//            recyclerview.setAdapter(musicListMusicIanAdapter);
//        } else {
//            musicListMusicIanAdapter.setNewData(musicListMusicIanBeanList);
//        }
//    }
//
//    private void ParticipateDate() {
//        NetWork.INSTANCE.getenroollist(getActivity(), 1,"desc",1,Integer.parseInt(require_id), new NetWork.TokenCallBack() {
//            @Override
//            public void doNext(String resultData, Headers headers) {
//                Log.e("jjjj",resultData);
//                SignUpMusicansBean signUpMusicansBean = JSON.parseObject(resultData, SignUpMusicansBean.class);
//            }
//
//            @Override
//            public void doError(String msg) {
//
//            }
//
//            @Override
//            public void doResult() {
//            }
//        });
//
//
//        ParticipateFragmentBean.DataBean dataBean1 = new ParticipateFragmentBean.DataBean();
//        dataBean1.setTitle("一白二穷工作室");
//        dataBean1.setHead("0");
//        ParticipateFragmentBean.DataBean dataBean2 = new ParticipateFragmentBean.DataBean();
//        dataBean2.setTitle("MortonWill莫顿");
//        dataBean2.setHead("1");
//        ParticipateFragmentBean.DataBean dataBean3 = new ParticipateFragmentBean.DataBean();
//        dataBean3.setTitle("机智过人的阿怜酱");
//        dataBean3.setHead("4");
//        ParticipateFragmentBean.DataBean dataBean4 = new ParticipateFragmentBean.DataBean();
//        dataBean4.setTitle("叶爱ryeowook");
//        dataBean4.setHead("2");
//        ParticipateFragmentBean.DataBean dataBean5 = new ParticipateFragmentBean.DataBean();
//        dataBean5.setTitle("夜雨寄北古风团队夜雨寄...");
//        dataBean5.setHead("3");
//        musicListMusicIanBeanList.add(dataBean1);
//        musicListMusicIanBeanList.add(dataBean2);
//        musicListMusicIanBeanList.add(dataBean3);
//        musicListMusicIanBeanList.add(dataBean4);
//        musicListMusicIanBeanList.add(dataBean5);
//    }
//}
