package com.mxkj.htmusic.projectmodule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 */

public class AddWorkTypeHelper extends SQLiteOpenHelper {
    public AddWorkTypeHelper(Context context) {
        super(context, "UserInfoInfo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table userinfoinfo(id integer primary key autoincrement,title text,content text,file_format text," +
                "file_type integer,status integer,created_at text,updated_at text,file_type_text text,status_text text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

