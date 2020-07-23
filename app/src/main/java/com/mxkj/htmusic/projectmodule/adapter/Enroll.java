package com.mxkj.htmusic.projectmodule.adapter;

import java.io.Serializable;
import java.util.List;

public class Enroll implements Serializable {

    private List<EnrollBean> enroll;

    public List<EnrollBean> getEnroll() {
        return enroll;
    }

    public void setEnroll(List<EnrollBean> enroll) {
        this.enroll = enroll;
    }

    public static class EnrollBean {
        /**
         * uid : 222
         * require_id : 223
         * project_id : 1
         * project_task_id : 1
         * work_type_id : 1
         * money : 300.00
         * creation_days : 10
         * remark : 我可以的
         */

        private int uid;
        private int require_id;
        private String project_id;
        private String project_task_id;
        private String work_type_id;
        private String money;
        private String creation_days;
        private String remark;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public int getRequire_id() {
            return require_id;
        }

        public void setRequire_id(int require_id) {
            this.require_id = require_id;
        }

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getProject_task_id() {
            return project_task_id;
        }

        public void setProject_task_id(String project_task_id) {
            this.project_task_id = project_task_id;
        }

        public String getWork_type_id() {
            return work_type_id;
        }

        public void setWork_type_id(String work_type_id) {
            this.work_type_id = work_type_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getCreation_days() {
            return creation_days;
        }

        public void setCreation_days(String creation_days) {
            this.creation_days = creation_days;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}
