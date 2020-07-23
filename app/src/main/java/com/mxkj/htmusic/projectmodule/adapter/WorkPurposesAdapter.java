package com.mxkj.htmusic.projectmodule.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.bean.WorkPurposesBean;
import com.mxkj.htmusic.toolmodule.base.baseadapter.MyAdapter;

import java.util.List;

public class WorkPurposesAdapter extends MyAdapter {
    List<WorkPurposesBean.DataBean> list;
    Context context;

    private View inflate;
    private  Dialog dialog;
    private  WindowManager wm;
    RelativeLayout cancel_rl;
    TextView title,composition,lyrics;



    public WorkPurposesAdapter(List<WorkPurposesBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHorder vh = null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.workpurpurposes_item,null);
            vh = new ViewHorder();
            vh.projectdetails_lyrics= (TextView) convertView.findViewById(R.id.projectdetails_lyrics);
            vh.projectdetails_more= (ImageView) convertView.findViewById(R.id.projectdetails_more);
            vh.projectdetails_state= (TextView) convertView.findViewById(R.id.projectdetails_state);
            vh.item= (RelativeLayout) convertView.findViewById(R.id.item);

            convertView.setTag(vh);
        }
        vh= (ViewHorder) convertView.getTag();
        final WorkPurposesBean.DataBean item = list.get(position);

        vh.projectdetails_lyrics.setText(item.getContent());

//        vh.projectdetails_money.setText(item.getBudget_text());
//        vh.projectdetails_state.setText(item.getTask_status());
//
//        vh.projectdetails_more.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
//                //填充对话框的布局
//                inflate = LayoutInflater.from(context).inflate(R.layout.type_dialog, null);
//                //初始化控件
//                cancel_rl = inflate.findViewById(R.id.cancel_rl);
//
//
//                title = inflate.findViewById(R.id.title);
//                composition = inflate.findViewById(R.id.composition);
//                lyrics = inflate.findViewById(R.id.composition);
//                //将布局设置给Dialog
//                dialog.setContentView(inflate);
//                //获取当前Activity所在的窗体
//                Window dialogWindow1 = dialog.getWindow();
//                //设置Dialog从窗体底部弹出
//                dialogWindow1.setGravity(Gravity.BOTTOM);
//                //获得窗体的属性
//                WindowManager.LayoutParams lp1 = dialogWindow1.getAttributes();
//                lp1.y = 2;//设置Dialog距离底部的距离
//                wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//                Display d1 = wm.getDefaultDisplay(); // 获取屏幕宽、高度
//                WindowManager.LayoutParams p1 = dialogWindow1.getAttributes(); // 获取对话框当前的参数值
//                p1.height = (int) (780); // 高度设置为屏幕的0.6，根据实际情况调整
////                p1.height = (int) (d1.getHeight() * 0.45); // 高度设置为屏幕的0.6，根据实际情况调整
//                p1.width = (int) (d1.getWidth() * 1); // 宽度设置为屏幕的0.65，根据实际情况调整
//                //    将属性设置给窗体
//                dialogWindow1.setAttributes(lp1);
//                dialog.show();//显示对话框
//
//                NetWork.INSTANCE.getprojecttaskInfo(context, item.getId()+"", new NetWork.TokenCallBack() {
//                    @Override
//                    public void doNext(String resultData, Headers headers) {
//                        Log.e("jjjj",resultData);
//                        ProjectdetailsListBean projectdetailsListBean = JSON.parseObject(resultData, ProjectdetailsListBean.class);
//                        Log.e("jjjj",projectdetailsListBean.toString());
//                        title.setText(projectdetailsListBean.getData().getWork_type_title());
//                        composition.setText("招募截至   "+ String.valueOf(projectdetailsListBean.getData().getRecruit_days()));
//                        lyrics.setText("创作时限   "+String.valueOf(projectdetailsListBean.getData().getCreation_days()));
//                    }
//
//                    @Override
//                    public void doError(String msg) {
//
//                    }
//
//                    @Override
//                    public void doResult() {
//                    }
//                });
//
//
//                cancel_rl.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        dialog.cancel();
//                    }
//                });
//            }
//        });


        return convertView;
    }


    class ViewHorder{
        TextView projectdetails_lyrics,projectdetails_money,projectdetails_state;
        ImageView projectdetails_more;
        RelativeLayout item;
    }
}
