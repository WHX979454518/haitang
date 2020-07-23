package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class StateRecordsBean implements Serializable {

    /**
     * data : [{"id":12,"project_id":6,"project_task_id":17,"uid":52490,"musician_id":37997,"title":"音乐人报名","content":"报价￥300.00 预计用时10天","created_at":"2019-03-30 10:01:35","updated_at":"2019-03-30 10:01:35","deleted_at":null}]
     * code : 200
     * msg : 获取状态纪录成功
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
         * id : 12
         * project_id : 6
         * project_task_id : 17
         * uid : 52490
         * musician_id : 37997
         * title : 音乐人报名
         * content : 报价￥300.00 预计用时10天
         * created_at : 2019-03-30 10:01:35
         * updated_at : 2019-03-30 10:01:35
         * deleted_at : null
         */

        private int id;
        private int project_id;
        private int project_task_id;
        private int uid;
        private int musician_id;
        private String title;
        private String content;
        private String created_at;
        private String updated_at;
        private Object deleted_at;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getProject_id() {
            return project_id;
        }

        public void setProject_id(int project_id) {
            this.project_id = project_id;
        }

        public int getProject_task_id() {
            return project_task_id;
        }

        public void setProject_task_id(int project_task_id) {
            this.project_task_id = project_task_id;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getMusician_id() {
            return musician_id;
        }

        public void setMusician_id(int musician_id) {
            this.musician_id = musician_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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
    }
}
