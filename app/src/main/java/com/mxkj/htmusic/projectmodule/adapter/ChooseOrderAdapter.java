package com.mxkj.htmusic.projectmodule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mxkj.htmusic.R;
import com.mxkj.htmusic.projectmodule.bean.ItemListConditionBean;
import com.mxkj.htmusic.toolmodule.base.baseadapter.MyAdapter;

import java.util.List;

public class ChooseOrderAdapter extends MyAdapter {
    List<ItemListConditionBean.DataBean.OrderBean> list;
    Context context;

    public ChooseOrderAdapter(List<ItemListConditionBean.DataBean.OrderBean> list, Context context) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.choose_type_item,null);
            vh = new ViewHorder();
            vh.title= (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(vh);
        }
        vh= (ViewHorder) convertView.getTag();
        final ItemListConditionBean.DataBean.OrderBean item = list.get(position);

        vh.title.setText(item.getTitle());
        return convertView;
    }


    class ViewHorder{
        TextView title;
    }
}
