package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class AllTaskBean implements Serializable {

    /**
     * data : [{"work_type_title":"作词","id":1,"recruit_days":30,"creation_days":30,"min_budget":30,"max_budget":1030,"stop_at":null,"progress_list":[{"progress_name":"作曲试听1","deposit_rate":20},{"progress_name":"作曲试听2","deposit_rate":30},{"progress_name":"作曲试听3","deposit_rate":50}],"progress_desc":"验收节点的一些说明把","surplus_day":"还剩-17970天"}]
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

    public static class DataBean implements Serializable{
        /**
         * work_type_title : 作词
         * id : 1
         * recruit_days : 30
         * creation_days : 30
         * min_budget : 30.0
         * max_budget : 1030.0
         * stop_at : null
         * progress_list : [{"progress_name":"作曲试听1","deposit_rate":20},{"progress_name":"作曲试听2","deposit_rate":30},{"progress_name":"作曲试听3","deposit_rate":50}]
         * progress_desc : 验收节点的一些说明把
         * surplus_day : 还剩-17970天
         */

        private String work_type_title;
        private int id;
        private int recruit_days;
        private int creation_days;
        private double min_budget;
        private double max_budget;
        private Object stop_at;
        private String progress_desc;
        private String surplus_day;
        private List<ProgressListBean> progress_list;

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

        public double getMin_budget() {
            return min_budget;
        }

        public void setMin_budget(double min_budget) {
            this.min_budget = min_budget;
        }

        public double getMax_budget() {
            return max_budget;
        }

        public void setMax_budget(double max_budget) {
            this.max_budget = max_budget;
        }

        public Object getStop_at() {
            return stop_at;
        }

        public void setStop_at(Object stop_at) {
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
             * progress_name : 作曲试听1
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
