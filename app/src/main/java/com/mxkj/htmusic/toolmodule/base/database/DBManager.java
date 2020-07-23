package com.mxkj.htmusic.toolmodule.base.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * created by LiuJie -2017/9/23
 */
public class DBManager {
    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        try {
            helper = new DatabaseHelper(context);
            db = helper.getWritableDatabase();
            db.setLocale(Locale.CHINA);
        } catch (RuntimeException e) {
            Log.e("TAG", "DBManagerException-----: " + e);
        }
    }

    /**
     * 添加搜索历史
     */
    public void addSearchHistory(String name) {
        if (db == null) return;

        db.beginTransaction();
        try {

            db.delete(DatabaseHelper.SEARCH_HISTORY, " songname= ?",
                    new String[]{name});

            db.execSQL("INSERT INTO " + DatabaseHelper.SEARCH_HISTORY
                    + " VALUES(null, ?)", new Object[]{name});
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }

    /**
     * 添加json缓存
     */
    public void setJsonCache(String params, String jsonStr) {
        if (db == null) return;
        db.beginTransaction();
        try {
            db.delete(DatabaseHelper.JSON_CACHE, " params= ?",
                    new String[]{params});
            db.execSQL("INSERT INTO " + DatabaseHelper.JSON_CACHE
                    + " VALUES(?,?,?)", new Object[]{params, jsonStr});
            db.setTransactionSuccessful();
        } catch (RuntimeException e) {
            Log.e("TAG", "setJsonCache: " + e);
        } finally {
            db.endTransaction();
        }
    }


    public String getJsonCache(String params) {
        Cursor c = null;
        try {
            c = db.rawQuery("SELECT * FROM " + DatabaseHelper.JSON_CACHE + " where params='" + params + "'", null);
            if (c.moveToFirst()) {
                String jsonStr = c.getString(c.getColumnIndex("jsonStr"));
                return jsonStr;
            }
        } catch (Exception e) {

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    /**
     * 删除某条搜索历史
     */
    public void delSrchHistrory(String name) {
        if (db == null) return;

        db.delete(DatabaseHelper.SEARCH_HISTORY, "songname = ?", new String[]{name});
    }

    @NonNull
    public List<String> querySearchhistory(int type) {
        Cursor c = null;
        try {
            c = queryTheCursor(2);
            List<String> songs = new ArrayList<>();
            while (c.moveToNext()) {
                songs.add(c.getString(c.getColumnIndex("songname")));
            }
            return songs;
        } catch (Exception e) {

        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    @Nullable
    public Cursor queryTheCursor(int type) {//1为列表，2为搜索历史,
        Cursor c = null;
        if (type == 1) {
            c = db.rawQuery("SELECT * FROM " + DatabaseHelper.CURRENT_PLAY_LIST,
                    null);
        } else if (type == 2) {
            c = db.rawQuery("SELECT * FROM " + DatabaseHelper.SEARCH_HISTORY,
                    null);
        } else if (type == 3) {
            c = db.rawQuery("SELECT * FROM " + DatabaseHelper.EMOJI,
                    null);
        }
        return c;
    }

    /**
     * close database
     */
    public void closeDB() {
        db.close();
    }

    public void deleteAllInfo(int type) {
        if (type == 0) {//播放列表
            Log.e("DBM", "deleteAllInfo: ");
            db.execSQL("delete  from " + DatabaseHelper.CURRENT_PLAY_LIST);
        } else if (type == 1) {//搜索历史
            db.execSQL("delete from " + DatabaseHelper.SEARCH_HISTORY);
        } else {//表情
            db.execSQL("delete from " + DatabaseHelper.EMOJI);
        }
    }
}