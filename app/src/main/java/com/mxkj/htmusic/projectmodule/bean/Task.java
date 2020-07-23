package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class Task implements Serializable {

    /**
     * uid : 222
     * project_type_id : 1
     * project_title : 来来来
     * work_use_ids : 1,2,3
     * use_channel_ids : 4,5,6
     * project_desc : 好的很
     * secrecy_days : 3个月
     * work_style_ids : 1,2,3
     * project_status : -1
     * min_budget : 900.00
     * max_budget : 2400.00
     * task : [{"uid":222,"work_type_id":1,"min_budget":300,"max_budget":800,"recruit_days":"30","creation_days":"30","task_status":1,"progress":[{"uid":222,"progress_name":"作曲试听1","deposit_rate":"20"},{"uid":222,"progress_name":"作曲试听2","deposit_rate":"30"},{"uid":222,"progress_name":"作曲试听3","deposit_rate":"50"}]},{"uid":222,"work_type_id":2,"min_budget":300,"max_budget":800,"recruit_days":"30","creation_days":"30","task_status":1,"progress":[{"uid":222,"progress_name":"作词试听1","deposit_rate":"20"},{"uid":222,"progress_name":"作词试听2","deposit_rate":"30"},{"uid":222,"progress_name":"作词试听3","deposit_rate":"50"}]},{"uid":222,"work_type_id":3,"min_budget":300,"max_budget":800,"recruit_days":"30","creation_days":"30","task_status":1,"progress":[{"uid":222,"progress_name":"唱歌试听1","deposit_rate":"20"},{"uid":222,"progress_name":"唱歌试听2","deposit_rate":"30"},{"uid":222,"progress_name":"唱歌试听3","deposit_rate":"50"}]}]
     */

    private int uid;
    private int project_type_id;
    private String project_title;
    private String work_use_ids;
    private String use_channel_ids;
    private String project_desc;
    private String secrecy_days;
    private String work_style_ids;
    private int project_status;
    private String min_budget;
    private String max_budget;
    private List<TaskBean> task;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getProject_type_id() {
        return project_type_id;
    }

    public void setProject_type_id(int project_type_id) {
        this.project_type_id = project_type_id;
    }

    public String getProject_title() {
        return project_title;
    }

    public void setProject_title(String project_title) {
        this.project_title = project_title;
    }

    public String getWork_use_ids() {
        return work_use_ids;
    }

    public void setWork_use_ids(String work_use_ids) {
        this.work_use_ids = work_use_ids;
    }

    public String getUse_channel_ids() {
        return use_channel_ids;
    }

    public void setUse_channel_ids(String use_channel_ids) {
        this.use_channel_ids = use_channel_ids;
    }

    public String getProject_desc() {
        return project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }

    public String getSecrecy_days() {
        return secrecy_days;
    }

    public void setSecrecy_days(String secrecy_days) {
        this.secrecy_days = secrecy_days;
    }

    public String getWork_style_ids() {
        return work_style_ids;
    }

    public void setWork_style_ids(String work_style_ids) {
        this.work_style_ids = work_style_ids;
    }

    public int getProject_status() {
        return project_status;
    }

    public void setProject_status(int project_status) {
        this.project_status = project_status;
    }

    public String getMin_budget() {
        return min_budget;
    }

    public void setMin_budget(String min_budget) {
        this.min_budget = min_budget;
    }

    public String getMax_budget() {
        return max_budget;
    }

    public void setMax_budget(String max_budget) {
        this.max_budget = max_budget;
    }

    public List<TaskBean> getTask() {
        return task;
    }

    public void setTask(List<TaskBean> task) {
        this.task = task;
    }

    public static class TaskBean {
        /**
         * uid : 222
         * work_type_id : 1
         * min_budget : 300.0
         * max_budget : 800.0
         * recruit_days : 30
         * creation_days : 30
         * task_status : 1
         * progress : [{"uid":222,"progress_name":"作曲试听1","deposit_rate":"20"},{"uid":222,"progress_name":"作曲试听2","deposit_rate":"30"},{"uid":222,"progress_name":"作曲试听3","deposit_rate":"50"}]
         */

        private int uid;
        private int work_type_id;
        private double min_budget;
        private double max_budget;
        private String recruit_days;
        private String creation_days;
        private int task_status;
        private List<ProgressBean> progress;


        @Override
        public String toString() {
            return "{" +uid + work_type_id + min_budget + max_budget + recruit_days + creation_days +task_status + progress + '}';
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getWork_type_id() {
            return work_type_id;
        }

        public void setWork_type_id(int work_type_id) {
            this.work_type_id = work_type_id;
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

        public String getRecruit_days() {
            return recruit_days;
        }

        public void setRecruit_days(String recruit_days) {
            this.recruit_days = recruit_days;
        }

        public String getCreation_days() {
            return creation_days;
        }

        public void setCreation_days(String creation_days) {
            this.creation_days = creation_days;
        }

        public int getTask_status() {
            return task_status;
        }

        public void setTask_status(int task_status) {
            this.task_status = task_status;
        }

        public List<ProgressBean> getProgress() {
            return progress;
        }

        public void setProgress(List<ProgressBean> progress) {
            this.progress = progress;
        }

        public static class ProgressBean implements Serializable{
            /**
             * uid : 222
             * progress_name : 作曲试听1
             * deposit_rate : 20
             */

            private int uid;
            private String progress_name;
            private String deposit_rate;

            @Override
            public String toString() {
                return "{" + uid + progress_name +deposit_rate + '}';
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getProgress_name() {
                return progress_name;
            }

            public void setProgress_name(String progress_name) {
                this.progress_name = progress_name;
            }

            public String getDeposit_rate() {
                return deposit_rate;
            }

            public void setDeposit_rate(String deposit_rate) {
                this.deposit_rate = deposit_rate;
            }
        }
    }
}
