package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class WorkPurposesBean implements Serializable {

    /**
     * data : [{"id":1,"type":1,"p_id":0,"content":"视听平台","is_all":1,"status":1,"created_at":"2019-03-12 10:05:29","updated_at":"2019-03-12 10:05:30","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":4,"type":1,"p_id":0,"content":"连续剧/动画、综艺","is_all":1,"status":1,"created_at":"2019-03-12 10:06:05","updated_at":"2019-03-12 10:06:06","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":8,"type":1,"p_id":0,"content":"电影/微电影","is_all":1,"status":1,"created_at":"2019-03-12 10:07:54","updated_at":"2019-03-12 10:07:55","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":13,"type":1,"p_id":0,"content":"商业广告/宣传片","is_all":1,"status":1,"created_at":"2019-03-12 10:10:50","updated_at":"2019-03-12 10:10:51","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":18,"type":1,"p_id":0,"content":"网络短视频","is_all":1,"status":1,"created_at":"2019-03-12 10:12:28","updated_at":"2019-03-12 10:12:29","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":22,"type":1,"p_id":0,"content":"游戏/app内置音乐","is_all":1,"status":1,"created_at":"2019-03-12 10:13:39","updated_at":"2019-03-12 10:13:40","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":26,"type":1,"p_id":0,"content":"线下/活动/硬件","is_all":1,"status":1,"created_at":"2019-03-12 10:14:47","updated_at":"2019-03-12 10:14:48","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"},{"id":30,"type":1,"p_id":0,"content":"家庭/学校/公开课","is_all":1,"status":1,"created_at":"2019-03-12 10:16:15","updated_at":"2019-03-12 10:16:16","deleted_at":null,"type_text":"使用范围","status_text":"是","is_all_text":"否"}]
     * code : 200
     * msg : 获取成功
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * type : 1
         * p_id : 0
         * content : 视听平台
         * is_all : 1
         * status : 1
         * created_at : 2019-03-12 10:05:29
         * updated_at : 2019-03-12 10:05:30
         * deleted_at : null
         * type_text : 使用范围
         * status_text : 是
         * is_all_text : 否
         */

        private int id;
        private int type;
        private int p_id;
        private String content;
        private int is_all;
        private int status;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private String type_text;
        private String status_text;
        private String is_all_text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getP_id() {
            return p_id;
        }

        public void setP_id(int p_id) {
            this.p_id = p_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getIs_all() {
            return is_all;
        }

        public void setIs_all(int is_all) {
            this.is_all = is_all;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public String getType_text() {
            return type_text;
        }

        public void setType_text(String type_text) {
            this.type_text = type_text;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public String getIs_all_text() {
            return is_all_text;
        }

        public void setIs_all_text(String is_all_text) {
            this.is_all_text = is_all_text;
        }
    }
}
