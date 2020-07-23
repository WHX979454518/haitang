package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class ProjectdetailsListBean implements Serializable {

    /**
     * data : {"work_type_title":"作曲","id":1,"recruit_days":30,"creation_days":30,"stop_at":"","progress_list":[{"progress_name":"作曲试听111","deposit_rate":20},{"progress_name":"作曲试听222","deposit_rate":30},{"progress_name":"作曲试听3333","deposit_rate":50}],"progress_desc":"验收节点的一些说明把,到时候读后台把","surplus_day":"还剩-17979天"}
     * code : 200
     * msg : 获取成功
     */

    private DataBean data;
    private int code;
    private String msg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        /**
         * work_type_title : 作曲
         * id : 1
         * recruit_days : 30
         * creation_days : 30
         * stop_at :
         * progress_list : [{"progress_name":"作曲试听111","deposit_rate":20},{"progress_name":"作曲试听222","deposit_rate":30},{"progress_name":"作曲试听3333","deposit_rate":50}]
         * progress_desc : 验收节点的一些说明把,到时候读后台把
         * surplus_day : 还剩-17979天
         */

        private String work_type_title;
        private int id;
        private int recruit_days;
        private int creation_days;
        private String stop_at;
        private String progress_desc;
        private String surplus_day;
        private List<ProgressListBean> progress_list;

        @Override
        public String toString() {
            return "DataBean{" +
                    "work_type_title='" + work_type_title + '\'' +
                    ", id=" + id +
                    ", recruit_days=" + recruit_days +
                    ", creation_days=" + creation_days +
                    ", stop_at='" + stop_at + '\'' +
                    ", progress_desc='" + progress_desc + '\'' +
                    ", surplus_day='" + surplus_day + '\'' +
                    ", progress_list=" + progress_list +
                    '}';
        }

        public String getWork_type_title() {
            return work_type_title;
        }

        public void setWork_type_title(String work_type_title) {
            this.work_type_title = work_type_title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRecruit_days() {
            return recruit_days;
        }

        public void setRecruit_days(int recruit_days) {
            this.recruit_days = recruit_days;
        }

        public int getCreation_days() {
            return creation_days;
        }

        public void setCreation_days(int creation_days) {
            this.creation_days = creation_days;
        }

        public String getStop_at() {
            return stop_at;
        }

        public void setStop_at(String stop_at) {
            this.stop_at = stop_at;
        }

        public String getProgress_desc() {
            return progress_desc;
        }

        public void setProgress_desc(String progress_desc) {
            this.progress_desc = progress_desc;
        }

        public String getSurplus_day() {
            return surplus_day;
        }

        public void setSurplus_day(String surplus_day) {
            this.surplus_day = surplus_day;
        }

        public List<ProgressListBean> getProgress_list() {
            return progress_list;
        }

        public void setProgress_list(List<ProgressListBean> progress_list) {
            this.progress_list = progress_list;
        }

        public static class ProgressListBean {
            /**
             * progress_name : 作曲试听111
             * deposit_rate : 20
             */

            private String progress_name;
            private int deposit_rate;

            public String getProgress_name() {
                return progress_name;
            }

            public void setProgress_name(String progress_name) {
                this.progress_name = progress_name;
            }

            public int getDeposit_rate() {
                return deposit_rate;
            }

            public void setDeposit_rate(int deposit_rate) {
                this.deposit_rate = deposit_rate;
            }
        }
    }
}
