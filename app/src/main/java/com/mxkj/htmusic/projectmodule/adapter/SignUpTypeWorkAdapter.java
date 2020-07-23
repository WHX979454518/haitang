package com.mxkj.htmusic.projectmodule.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.bean.AllTaskBean;
import com.mxkj.htmusic.toolmodule.base.baseadapter.MyAdapter;
import com.mxkj.htmusic.toolmodule.utils.customkeyboard.KeyboardUtil;

import java.util.List;

public class SignUpTypeWorkAdapter extends MyAdapter {
    List<AllTaskBean.DataBean> list;
    Context context;
    int checkcount = 0;
    int count = 1;

    private Handler myhandler;

    public SignUpTypeWorkAdapter(List<AllTaskBean.DataBean> list, Context context, Handler myhandler) {
        this.list = list;
        this.context = context;
        this.myhandler = myhandler;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHorder vh = null;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.signuptypework_item,null);
            vh = new ViewHorder();
            vh.sign_up_lyrics= (TextView) convertView.findViewById(R.id.sign_up_lyrics);
            vh.project_open= (ImageView) convertView.findViewById(R.id.project_open);
            vh.project_lyrics_rl1 = (RelativeLayout) convertView.findViewById(R.id.project_lyrics_rl1);
            vh.cb_lyrics = (CheckBox) convertView.findViewById(R.id.cb_lyrics);
            vh.project_offer_image= (ImageView) convertView.findViewById(R.id.project_offer_image);
            vh.project_when_image= (ImageView) convertView.findViewById(R.id.project_when_image);

            vh.ll_price_select= (LinearLayout) convertView.findViewById(R.id.ll_price_select);
            vh.et_price= (TextView) convertView.findViewById(R.id.et_price);
            vh.project_offer= (TextView) convertView.findViewById(R.id.project_offer);
            vh.project_when= (TextView) convertView.findViewById(R.id.project_when);
            vh.project_leave_message= (EditText) convertView.findViewById(R.id.project_leave_message);


            convertView.setTag(vh);
        }
        vh= (ViewHorder) convertView.getTag();
        final AllTaskBean.DataBean item = list.get(position);
        vh.sign_up_lyrics.setText(item.getWork_type_title());

        ViewHorder finalVh = vh;
        vh.project_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    finalVh.project_open.setImageResource(R.mipmap.icon_type_shouqi);
                    finalVh.project_lyrics_rl1.setVisibility(View.GONE);
                }else{
                    finalVh.project_lyrics_rl1.setVisibility(View.VISIBLE);
                    finalVh.project_open.setImageResource(R.mipmap.icon_type_zhankai);
                }
            }
        });

        vh.cb_lyrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkcount++;
                if(checkcount%2==0){
                    finalVh.cb_lyrics.setChecked(false);
                }else{
                    finalVh.cb_lyrics.setChecked(true);
                    Message message = Message.obtain();
                    message.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item",item);
                    bundle.putString("project_offer",finalVh.project_offer.getText().toString());
                    bundle.putString("project_when",finalVh.project_when.getText().toString());
                    bundle.putString("project_leave_message",finalVh.project_leave_message.getText().toString());
                    message.setData(bundle);
                    myhandler.sendMessage(message);
                }
            }
        });


        //自定义键盘
        KeyboardUtil keyboardUtil =new KeyboardUtil((Activity) context);
        keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {
                if (validate(finalVh.et_price)) {
                    finalVh.ll_price_select.setVisibility(View.GONE);
                    finalVh.project_offer.setText(finalVh.et_price.getText().toString());
                }
            }
        });
        keyboardUtil.setOnCancelClick(new KeyboardUtil.onCancelClick() {
            @Override
            public void onCancellClick() {
                finalVh.ll_price_select.setVisibility(View.GONE);
                finalVh.project_offer.setText(finalVh.et_price.getText().toString());
            }
        });

//        //这里是预计用时的自定义键盘
//        KeyboardUtil whenkeyboardUtil = new KeyboardUtil((Activity) context)
//        whenkeyboardUtil.setOnOkClick {
//            if (validate()) {
//                ll_price_select.visibility = View.GONE
//                project_when.setText(et_price.text)
//            }
//        }
//        whenkeyboardUtil.setOnCancelClick {
//            ll_price_select.visibility = View.GONE
//            project_when.setText(et_price.text)
//        }



//        vh.project_offer_image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalVh.ll_price_select.setVisibility(View.VISIBLE);
//                finalVh.et_price.setText("");
//                keyboardUtil.attachTo((EditText) finalVh.et_price);
//                finalVh.et_price.setFocusable(true);
//                finalVh.et_price.setFocusableInTouchMode(true);
//                finalVh.et_price.requestFocus();
//            }
//        });
        return convertView;
    }


    class ViewHorder{
        TextView sign_up_lyrics;
        ImageView project_open,project_offer_image,project_when_image;
        RelativeLayout project_lyrics_rl1;
        CheckBox cb_lyrics;

        LinearLayout ll_price_select;
        TextView et_price,project_offer,project_when;
        EditText project_leave_message;
    }

    //自定義键盘
    private boolean validate(TextView et_price){
        if (et_price.getText().toString() == "") {
            Toast.makeText(context, "天数不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
