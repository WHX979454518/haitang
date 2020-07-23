package com.mxkj.htmusic.projectmodule.bean;


import java.util.List;

public class ProjectStyleTagListBean {

    /**
     * data : [{"id":1,"title":"国风","content":"中国风","status":1,"created_at":"2019-03-12 09:49:07","updated_at":"2019-03-12 09:49:08","deleted_at":null,"status_text":"是"},{"id":2,"title":"ACG","content":"ACG","status":1,"created_at":"2019-03-12 09:50:13","updated_at":"2019-03-12 09:50:14","deleted_at":null,"status_text":"是"},{"id":3,"title":"VC","content":"VC","status":1,"created_at":"2019-03-12 09:50:15","updated_at":"2019-03-12 09:50:16","deleted_at":null,"status_text":"是"},{"id":4,"title":"广播剧","content":"广播剧","status":1,"created_at":"2019-03-12 09:50:17","updated_at":"2019-03-12 09:50:18","deleted_at":null,"status_text":"是"},{"id":5,"title":"三次元","content":"三次元","status":1,"created_at":"2019-03-12 09:50:19","updated_at":"2019-03-12 09:50:19","deleted_at":null,"status_text":"是"}]
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
         * title : 国风
         * content : 中国风
         * status : 1
         * created_at : 2019-03-12 09:49:07
         * updated_at : 2019-03-12 09:49:08
         * deleted_at : null
         * status_text : 是
         */

        private int id;
        private String title;
        private String content;
        private int status;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private String status_text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }
    }
}
