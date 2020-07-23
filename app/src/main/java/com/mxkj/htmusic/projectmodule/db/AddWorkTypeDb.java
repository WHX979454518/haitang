package com.mxkj.htmusic.projectmodule.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mxkj.htmusic.projectmodule.bean.TypeWorkBean;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class AddWorkTypeDb {
    SQLiteDatabase db;
    AddWorkTypeHelper dbuh;

    public AddWorkTypeDb(AddWorkTypeHelper dbuh) {
        this.dbuh = dbuh;
        db = dbuh.getReadableDatabase();
    }

    public void add(TypeWorkBean.DataBean u) {
        TypeWorkBean.DataBean yonhu = u;
        ContentValues cv = new ContentValues();
        cv.put("id", yonhu.getId());
        cv.put("title", yonhu.getTitle());
        cv.put("content", yonhu.getContent());
        cv.put("file_format", yonhu.getFile_format());
        cv.put("file_type", yonhu.getFile_type());
        cv.put("status", yonhu.getStatus());
        cv.put("created_at", yonhu.getCreated_at());
        cv.put("updated_at", yonhu.getUpdated_at());
//        cv.put("deleted_at", "");
        cv.put("file_type_text", yonhu.getFile_type_text());
        cv.put("status_text", yonhu.getStatus_text());
        db.insert("userinfoinfo", null, cv);
    }

    public List<TypeWorkBean.DataBean> select() {
        List<TypeWorkBean.DataBean> userInfoInfoList = new ArrayList<TypeWorkBean.DataBean>();
        Cursor cursor =db.rawQuery("select * from userinfoinfo",new String[]{});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String file_format = cursor.getString(cursor.getColumnIndex("file_format"));
                int file_type = cursor.getInt(cursor.getColumnIndex("file_type"));
                int status = cursor.getInt(cursor.getColumnIndex("status"));
                String created_at = cursor.getString(cursor.getColumnIndex("created_at"));
                String updated_at = cursor.getString(cursor.getColumnIndex("updated_at"));
//                String deleted_at = cursor.getString(cursor.getColumnIndex("deleted_at"));
                String file_type_text = cursor.getString(cursor.getColumnIndex("file_type_text"));
                String status_text = cursor.getString(cursor.getColumnIndex("status_text"));
                TypeWorkBean.DataBean userInfoInfo = new TypeWorkBean.DataBean();
                userInfoInfo.setId(id);
                userInfoInfo.setTitle(title);
                userInfoInfo.setContent(content);
                userInfoInfo.setFile_format(file_format);
                userInfoInfo.setFile_type(file_type);
                userInfoInfo.setStatus(status);
                userInfoInfo.setCreated_at(created_at);
//                userInfoInfo.setUpdated_at(updated_at);
                userInfoInfo.setFile_type_text(file_type_text);
                userInfoInfo.setStatus_text(status_text);
                userInfoInfoList.add(userInfoInfo);
            }
        }
        return userInfoInfoList;
    }

    public void deleteall() {
        //db.delete("userinfoinfo", "name >= ?", new String[]{});
        db.delete("userinfoinfo",null,null);
    }

    public TypeWorkBean.DataBean select(TypeWorkBean.DataBean userInfoInfo, Boolean bl){
        TypeWorkBean.DataBean yonhu = userInfoInfo;
        Cursor cursor =db.rawQuery("select * from userinfoinfo where name = ?",new String[] {yonhu.getTitle()});
        if(cursor!=null){
            while(cursor.moveToNext()){
                String title = cursor.getString(cursor.getColumnIndex("title"));
                if(bl) { //bl 为true的时候为匹配用户密码是否正确
                    if (title.equals(yonhu.getTitle())) {
                        return yonhu;
                    }
                }else{ //为false的时候 用于匹配用户名是否存在
                    if(title.equals(yonhu.getTitle())){
                        return yonhu;
                    }
                }
            }
            yonhu.setTitle("");
            return yonhu;
        }
        yonhu.setTitle("");
        return yonhu;
    }
}
