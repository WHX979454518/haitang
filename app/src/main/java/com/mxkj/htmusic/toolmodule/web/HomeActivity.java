package com.mxkj.htmusic.toolmodule.web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.bean.ProgectFragmentBanner;
import com.mxkj.htmusic.projectmodule.bean.TypeWorkBean;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ProgectFragmentBanner.ShufflingBean> list = new ArrayList< ProgectFragmentBanner.ShufflingBean>();
        ProgectFragmentBanner.ShufflingBean shufflingBean1 =new  ProgectFragmentBanner.ShufflingBean();
        shufflingBean1.setImgpic_link("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2735633715,2749454924&fm=27&gp=0.jpg");
        ProgectFragmentBanner.ShufflingBean shufflingBean2 = new ProgectFragmentBanner.ShufflingBean();
        shufflingBean2.setImgpic_link("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4277820061,963510529&fm=27&gp=0.jpg");
        list.add(shufflingBean1);
        list.add(shufflingBean2);
        for(int i=0;i<list.size();i++){
            Log.i("lllll",""+list.get(i).getImgpic_link());
        }
        String allmoney;
        List<TypeWorkBean.DataBean> newlist = new ArrayList<TypeWorkBean.DataBean>();
        for(int i=0;i<newlist.size();i++){
            allmoney = newlist.get(i).getContent();
            allmoney = allmoney+allmoney;
        }
    }
}
