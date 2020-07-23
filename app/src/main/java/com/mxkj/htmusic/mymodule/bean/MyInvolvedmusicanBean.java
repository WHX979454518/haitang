package com.mxkj.htmusic.mymodule.bean;

import java.io.Serializable;
import java.util.List;

public class MyInvolvedmusicanBean implements Serializable {

    /**
     * data : [{"id":4,"uid":222,"require_id":223,"project_id":2,"project_task_id":5,"work_type_id":2,"money":"300.00","creation_days":10,"remark":"4我可以的","status":2,"fail_reason":"","created_at":"2019-03-18 11:57:50","updated_at":"2019-03-18 11:57:50","deleted_at":"","contract":{"id":2,"project_id":1,"project_task_id":1,"work_type_id":1,"enroll_id":4,"uid":222,"musician_id":224,"task_progress_id":0,"money":"300.00","creation_days":70,"content":"我我我我哦我欧文我我我我我我我我我欧文我我我","musician_status":8,"require_status":7,"musician_sign_pass_at":"2019-03-20 14:57:16","musician_sign_fail_at":"2019-03-20 15:12:19","musician_fail_reason":"不想做了","require_sign_pass_at":"2019-03-15 14:31:28","require_sign_fail_at":"2019-03-20 15:17:26","require_fail_reason":"不想做了","is_apply_stop":1,"is_apply_stop_reason":"","is_apply_stop_at":"","is_stop_reason":"","is_stop_at":"","delay_days":30,"delay_at":"2019-03-20 16:48:08","is_apply_delay":2,"apply_delay_days":30,"apply_delay_reason":"再给我30天吧","apply_delay_at":"2019-03-19 17:03:36","inspect_type":1,"inspect_at":"2019-03-12 10:16:10","created_at":"2019-03-13 18:21:31","updated_at":"2019-03-20 18:02:21","deleted_at":"","musician_status_text":"待评价","require_status_text":"已完成"},"project":{"id":2,"uid":223,"project_type_id":1,"project_title":"去去去","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"project_desc":"来做啊1","secrecy_days":"3个月","work_style_ids":"1,2,3","project_status":3,"stop_reason":"","stop_at":"","check_reason":"","check_at":"","enroll_num":2,"min_budget":"0.00","max_budget":"3200.00","work_type_ids":"1,2,3","collect_num":0,"created_at":"2019-03-22 10:28:25","updated_at":"2019-03-22 18:05:44","deleted_at":"","status_text":"招募中","work_style_arr":["国风","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"0-3.2K"},"task":{"id":5,"uid":223,"project_id":2,"work_type_id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"aaaaa","check_at":"","enroll_num":0,"select_enroll_num":0,"created_at":"2019-03-13 14:35:22","updated_at":"2019-03-13 15:37:35","deleted_at":"","status_text":"审核中","recruit_days_at":"2019-04-12"},"sea_require_member":{"uid":223,"require_finish_rate":"0.00","require_credit_score":"5.00","head":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","nickname":"颜妾","head_info":{"ext":"jpg","w":"400","h":"400","size":"35355","is_long":"0","md5":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","link":"http://testapi.imxkj.com//image/eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6/1"}},"work_type":{"id":2,"title":"作词","content":"就是作词","file_format":"PNG/JPEG","file_type":3,"status":1,"created_at":"2019-03-12 09:47:05","updated_at":"2019-03-12 09:47:06","deleted_at":"","file_type_text":"图片","status_text":"是"},"status_text":"通过"}]
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
         * id : 4
         * uid : 222
         * require_id : 223
         * project_id : 2
         * project_task_id : 5
         * work_type_id : 2
         * money : 300.00
         * creation_days : 10
         * remark : 4我可以的
         * status : 2
         * fail_reason :
         * created_at : 2019-03-18 11:57:50
         * updated_at : 2019-03-18 11:57:50
         * deleted_at :
         * contract : {"id":2,"project_id":1,"project_task_id":1,"work_type_id":1,"enroll_id":4,"uid":222,"musician_id":224,"task_progress_id":0,"money":"300.00","creation_days":70,"content":"我我我我哦我欧文我我我我我我我我我欧文我我我","musician_status":8,"require_status":7,"musician_sign_pass_at":"2019-03-20 14:57:16","musician_sign_fail_at":"2019-03-20 15:12:19","musician_fail_reason":"不想做了","require_sign_pass_at":"2019-03-15 14:31:28","require_sign_fail_at":"2019-03-20 15:17:26","require_fail_reason":"不想做了","is_apply_stop":1,"is_apply_stop_reason":"","is_apply_stop_at":"","is_stop_reason":"","is_stop_at":"","delay_days":30,"delay_at":"2019-03-20 16:48:08","is_apply_delay":2,"apply_delay_days":30,"apply_delay_reason":"再给我30天吧","apply_delay_at":"2019-03-19 17:03:36","inspect_type":1,"inspect_at":"2019-03-12 10:16:10","created_at":"2019-03-13 18:21:31","updated_at":"2019-03-20 18:02:21","deleted_at":"","musician_status_text":"待评价","require_status_text":"已完成"}
         * project : {"id":2,"uid":223,"project_type_id":1,"project_title":"去去去","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"project_desc":"来做啊1","secrecy_days":"3个月","work_style_ids":"1,2,3","project_status":3,"stop_reason":"","stop_at":"","check_reason":"","check_at":"","enroll_num":2,"min_budget":"0.00","max_budget":"3200.00","work_type_ids":"1,2,3","collect_num":0,"created_at":"2019-03-22 10:28:25","updated_at":"2019-03-22 18:05:44","deleted_at":"","status_text":"招募中","work_style_arr":["国风","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"0-3.2K"}
         * task : {"id":5,"uid":223,"project_id":2,"work_type_id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"aaaaa","check_at":"","enroll_num":0,"select_enroll_num":0,"created_at":"2019-03-13 14:35:22","updated_at":"2019-03-13 15:37:35","deleted_at":"","status_text":"审核中","recruit_days_at":"2019-04-12"}
         * sea_require_member : {"uid":223,"require_finish_rate":"0.00","require_credit_score":"5.00","head":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","nickname":"颜妾","head_info":{"ext":"jpg","w":"400","h":"400","size":"35355","is_long":"0","md5":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","link":"http://testapi.imxkj.com//image/eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6/1"}}
         * work_type : {"id":2,"title":"作词","content":"就是作词","file_format":"PNG/JPEG","file_type":3,"status":1,"created_at":"2019-03-12 09:47:05","updated_at":"2019-03-12 09:47:06","deleted_at":"","file_type_text":"图片","status_text":"是"}
         * status_text : 通过
         */

        private int id;
        private int uid;
        private int require_id;
        private int project_id;
        private int project_task_id;
        private int work_type_id;
        private String money;
        private int creation_days;
        private String remark;
        private int status;
        private String fail_reason;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private ContractBean contract;
        private ProjectBean project;
        private TaskBean task;
        private SeaRequireMemberBean sea_require_member;
        private WorkTypeBean work_type;
        private String status_text;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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

        public int getWork_type_id() {
            return work_type_id;
        }

        public void setWork_type_id(int work_type_id) {
            this.work_type_id = work_type_id;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public int getCreation_days() {
            return creation_days;
        }

        public void setCreation_days(int creation_days) {
            this.creation_days = creation_days;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFail_reason() {
            return fail_reason;
        }

        public void setFail_reason(String fail_reason) {
            this.fail_reason = fail_reason;
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

        public String getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(String deleted_at) {
            this.deleted_at = deleted_at;
        }

        public ContractBean getContract() {
            return contract;
        }

        public void setContract(ContractBean contract) {
            this.contract = contract;
        }

        public ProjectBean getProject() {
            return project;
        }

        public void setProject(ProjectBean project) {
            this.project = project;
        }

        public TaskBean getTask() {
            return task;
        }

        public void setTask(TaskBean task) {
            this.task = task;
        }

        public SeaRequireMemberBean getSea_require_member() {
            return sea_require_member;
        }

        public void setSea_require_member(SeaRequireMemberBean sea_require_member) {
            this.sea_require_member = sea_require_member;
        }

        public WorkTypeBean getWork_type() {
            return work_type;
        }

        public void setWork_type(WorkTypeBean work_type) {
            this.work_type = work_type;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public static class ContractBean implements Serializable{
            /**
             * id : 2
             * project_id : 1
             * project_task_id : 1
             * work_type_id : 1
             * enroll_id : 4
             * uid : 222
             * musician_id : 224
             * task_progress_id : 0
             * money : 300.00
             * creation_days : 70
             * content : 我我我我哦我欧文我我我我我我我我我欧文我我我
             * musician_status : 8
             * require_status : 7
             * musician_sign_pass_at : 2019-03-20 14:57:16
             * musician_sign_fail_at : 2019-03-20 15:12:19
             * musician_fail_reason : 不想做了
             * require_sign_pass_at : 2019-03-15 14:31:28
             * require_sign_fail_at : 2019-03-20 15:17:26
             * require_fail_reason : 不想做了
             * is_apply_stop : 1
             * is_apply_stop_reason :
             * is_apply_stop_at :
             * is_stop_reason :
             * is_stop_at :
             * delay_days : 30
             * delay_at : 2019-03-20 16:48:08
             * is_apply_delay : 2
             * apply_delay_days : 30
             * apply_delay_reason : 再给我30天吧
             * apply_delay_at : 2019-03-19 17:03:36
             * inspect_type : 1
             * inspect_at : 2019-03-12 10:16:10
             * created_at : 2019-03-13 18:21:31
             * updated_at : 2019-03-20 18:02:21
             * deleted_at :
             * musician_status_text : 待评价
             * require_status_text : 已完成
             */

            private int id;
            private int project_id;
            private int project_task_id;
            private int work_type_id;
            private int enroll_id;
            private int uid;
            private int musician_id;
            private int task_progress_id;
            private String money;
            private int creation_days;
            private String content;
            private int musician_status;
            private int require_status;
            private String musician_sign_pass_at;
            private String musician_sign_fail_at;
            private String musician_fail_reason;
            private String require_sign_pass_at;
            private String require_sign_fail_at;
            private String require_fail_reason;
            private int is_apply_stop;
            private String is_apply_stop_reason;
            private String is_apply_stop_at;
            private String is_stop_reason;
            private String is_stop_at;
            private int delay_days;
            private String delay_at;
            private int is_apply_delay;
            private int apply_delay_days;
            private String apply_delay_reason;
            private String apply_delay_at;
            private int inspect_type;
            private String inspect_at;
            private String created_at;
            private String updated_at;
            private String deleted_at;
            private String musician_status_text;
            private String require_status_text;

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

            public int getWork_type_id() {
                return work_type_id;
            }

            public void setWork_type_id(int work_type_id) {
                this.work_type_id = work_type_id;
            }

            public int getEnroll_id() {
                return enroll_id;
            }

            public void setEnroll_id(int enroll_id) {
                this.enroll_id = enroll_id;
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

            public int getTask_progress_id() {
                return task_progress_id;
            }

            public void setTask_progress_id(int task_progress_id) {
                this.task_progress_id = task_progress_id;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public int getCreation_days() {
                return creation_days;
            }

            public void setCreation_days(int creation_days) {
                this.creation_days = creation_days;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getMusician_status() {
                return musician_status;
            }

            public void setMusician_status(int musician_status) {
                this.musician_status = musician_status;
            }

            public int getRequire_status() {
                return require_status;
            }

            public void setRequire_status(int require_status) {
                this.require_status = require_status;
            }

            public String getMusician_sign_pass_at() {
                return musician_sign_pass_at;
            }

            public void setMusician_sign_pass_at(String musician_sign_pass_at) {
                this.musician_sign_pass_at = musician_sign_pass_at;
            }

            public String getMusician_sign_fail_at() {
                return musician_sign_fail_at;
            }

            public void setMusician_sign_fail_at(String musician_sign_fail_at) {
                this.musician_sign_fail_at = musician_sign_fail_at;
            }

            public String getMusician_fail_reason() {
                return musician_fail_reason;
            }

            public void setMusician_fail_reason(String musician_fail_reason) {
                this.musician_fail_reason = musician_fail_reason;
            }

            public String getRequire_sign_pass_at() {
                return require_sign_pass_at;
            }

            public void setRequire_sign_pass_at(String require_sign_pass_at) {
                this.require_sign_pass_at = require_sign_pass_at;
            }

            public String getRequire_sign_fail_at() {
                return require_sign_fail_at;
            }

            public void setRequire_sign_fail_at(String require_sign_fail_at) {
                this.require_sign_fail_at = require_sign_fail_at;
            }

            public String getRequire_fail_reason() {
                return require_fail_reason;
            }

            public void setRequire_fail_reason(String require_fail_reason) {
                this.require_fail_reason = require_fail_reason;
            }

            public int getIs_apply_stop() {
                return is_apply_stop;
            }

            public void setIs_apply_stop(int is_apply_stop) {
                this.is_apply_stop = is_apply_stop;
            }

            public String getIs_apply_stop_reason() {
                return is_apply_stop_reason;
            }

            public void setIs_apply_stop_reason(String is_apply_stop_reason) {
                this.is_apply_stop_reason = is_apply_stop_reason;
            }

            public String getIs_apply_stop_at() {
                return is_apply_stop_at;
            }

            public void setIs_apply_stop_at(String is_apply_stop_at) {
                this.is_apply_stop_at = is_apply_stop_at;
            }

            public String getIs_stop_reason() {
                return is_stop_reason;
            }

            public void setIs_stop_reason(String is_stop_reason) {
                this.is_stop_reason = is_stop_reason;
            }

            public String getIs_stop_at() {
                return is_stop_at;
            }

            public void setIs_stop_at(String is_stop_at) {
                this.is_stop_at = is_stop_at;
            }

            public int getDelay_days() {
                return delay_days;
            }

            public void setDelay_days(int delay_days) {
                this.delay_days = delay_days;
            }

            public String getDelay_at() {
                return delay_at;
            }

            public void setDelay_at(String delay_at) {
                this.delay_at = delay_at;
            }

            public int getIs_apply_delay() {
                return is_apply_delay;
            }

            public void setIs_apply_delay(int is_apply_delay) {
                this.is_apply_delay = is_apply_delay;
            }

            public int getApply_delay_days() {
                return apply_delay_days;
            }

            public void setApply_delay_days(int apply_delay_days) {
                this.apply_delay_days = apply_delay_days;
            }

            public String getApply_delay_reason() {
                return apply_delay_reason;
            }

            public void setApply_delay_reason(String apply_delay_reason) {
                this.apply_delay_reason = apply_delay_reason;
            }

            public String getApply_delay_at() {
                return apply_delay_at;
            }

            public void setApply_delay_at(String apply_delay_at) {
                this.apply_delay_at = apply_delay_at;
            }

            public int getInspect_type() {
                return inspect_type;
            }

            public void setInspect_type(int inspect_type) {
                this.inspect_type = inspect_type;
            }

            public String getInspect_at() {
                return inspect_at;
            }

            public void setInspect_at(String inspect_at) {
                this.inspect_at = inspect_at;
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getMusician_status_text() {
                return musician_status_text;
            }

            public void setMusician_status_text(String musician_status_text) {
                this.musician_status_text = musician_status_text;
            }

            public String getRequire_status_text() {
                return require_status_text;
            }

            public void setRequire_status_text(String require_status_text) {
                this.require_status_text = require_status_text;
            }
        }

        public static class ProjectBean implements Serializable{
            /**
             * id : 2
             * uid : 223
             * project_type_id : 1
             * project_title : 去去去
             * work_use_ids : ["视听平台","部分平台","全平台"]
             * use_channel_ids : ["连续剧/动画、综艺","电视","网络"]
             * project_desc : 来做啊1
             * secrecy_days : 3个月
             * work_style_ids : 1,2,3
             * project_status : 3
             * stop_reason :
             * stop_at :
             * check_reason :
             * check_at :
             * enroll_num : 2
             * min_budget : 0.00
             * max_budget : 3200.00
             * work_type_ids : 1,2,3
             * collect_num : 0
             * created_at : 2019-03-22 10:28:25
             * updated_at : 2019-03-22 18:05:44
             * deleted_at :
             * status_text : 招募中
             * work_style_arr : ["国风","ACG","VC"]
             * work_type_arr : ["作曲","作词","歌手"]
             * budget_range_text : 0-3.2K
             */

            private int id;
            private int uid;
            private int project_type_id;
            private String project_title;
            private String project_desc;
            private String secrecy_days;
            private String work_style_ids;
            private int project_status;
            private String stop_reason;
            private String stop_at;
            private String check_reason;
            private String check_at;
            private int enroll_num;
            private String min_budget;
            private String max_budget;
            private String work_type_ids;
            private int collect_num;
            private String created_at;
            private String updated_at;
            private String deleted_at;
            private String status_text;
            private String budget_range_text;
            private List<String> work_use_ids;
            private List<String> use_channel_ids;
            private List<String> work_style_arr;
            private List<String> work_type_arr;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

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

            public String getStop_reason() {
                return stop_reason;
            }

            public void setStop_reason(String stop_reason) {
                this.stop_reason = stop_reason;
            }

            public String getStop_at() {
                return stop_at;
            }

            public void setStop_at(String stop_at) {
                this.stop_at = stop_at;
            }

            public String getCheck_reason() {
                return check_reason;
            }

            public void setCheck_reason(String check_reason) {
                this.check_reason = check_reason;
            }

            public String getCheck_at() {
                return check_at;
            }

            public void setCheck_at(String check_at) {
                this.check_at = check_at;
            }

            public int getEnroll_num() {
                return enroll_num;
            }

            public void setEnroll_num(int enroll_num) {
                this.enroll_num = enroll_num;
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

            public String getWork_type_ids() {
                return work_type_ids;
            }

            public void setWork_type_ids(String work_type_ids) {
                this.work_type_ids = work_type_ids;
            }

            public int getCollect_num() {
                return collect_num;
            }

            public void setCollect_num(int collect_num) {
                this.collect_num = collect_num;
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getStatus_text() {
                return status_text;
            }

            public void setStatus_text(String status_text) {
                this.status_text = status_text;
            }

            public String getBudget_range_text() {
                return budget_range_text;
            }

            public void setBudget_range_text(String budget_range_text) {
                this.budget_range_text = budget_range_text;
            }

            public List<String> getWork_use_ids() {
                return work_use_ids;
            }

            public void setWork_use_ids(List<String> work_use_ids) {
                this.work_use_ids = work_use_ids;
            }

            public List<String> getUse_channel_ids() {
                return use_channel_ids;
            }

            public void setUse_channel_ids(List<String> use_channel_ids) {
                this.use_channel_ids = use_channel_ids;
            }

            public List<String> getWork_style_arr() {
                return work_style_arr;
            }

            public void setWork_style_arr(List<String> work_style_arr) {
                this.work_style_arr = work_style_arr;
            }

            public List<String> getWork_type_arr() {
                return work_type_arr;
            }

            public void setWork_type_arr(List<String> work_type_arr) {
                this.work_type_arr = work_type_arr;
            }
        }

        public static class TaskBean implements Serializable{
            /**
             * id : 5
             * uid : 223
             * project_id : 2
             * work_type_id : 2
             * min_budget : 300.00
             * max_budget : 800.00
             * recruit_days : 30
             * creation_days : 30
             * task_status : 1
             * stop_reason :
             * stop_at :
             * is_delay : 1
             * delay_days :
             * is_delay_at :
             * check_reason : aaaaa
             * check_at :
             * enroll_num : 0
             * select_enroll_num : 0
             * created_at : 2019-03-13 14:35:22
             * updated_at : 2019-03-13 15:37:35
             * deleted_at :
             * status_text : 审核中
             * recruit_days_at : 2019-04-12
             */

            private int id;
            private int uid;
            private int project_id;
            private int work_type_id;
            private String min_budget;
            private String max_budget;
            private int recruit_days;
            private int creation_days;
            private int task_status;
            private String stop_reason;
            private String stop_at;
            private int is_delay;
            private String delay_days;
            private String is_delay_at;
            private String check_reason;
            private String check_at;
            private int enroll_num;
            private int select_enroll_num;
            private String created_at;
            private String updated_at;
            private String deleted_at;
            private String status_text;
            private String recruit_days_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getProject_id() {
                return project_id;
            }

            public void setProject_id(int project_id) {
                this.project_id = project_id;
            }

            public int getWork_type_id() {
                return work_type_id;
            }

            public void setWork_type_id(int work_type_id) {
                this.work_type_id = work_type_id;
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

            public int getTask_status() {
                return task_status;
            }

            public void setTask_status(int task_status) {
                this.task_status = task_status;
            }

            public String getStop_reason() {
                return stop_reason;
            }

            public void setStop_reason(String stop_reason) {
                this.stop_reason = stop_reason;
            }

            public String getStop_at() {
                return stop_at;
            }

            public void setStop_at(String stop_at) {
                this.stop_at = stop_at;
            }

            public int getIs_delay() {
                return is_delay;
            }

            public void setIs_delay(int is_delay) {
                this.is_delay = is_delay;
            }

            public String getDelay_days() {
                return delay_days;
            }

            public void setDelay_days(String delay_days) {
                this.delay_days = delay_days;
            }

            public String getIs_delay_at() {
                return is_delay_at;
            }

            public void setIs_delay_at(String is_delay_at) {
                this.is_delay_at = is_delay_at;
            }

            public String getCheck_reason() {
                return check_reason;
            }

            public void setCheck_reason(String check_reason) {
                this.check_reason = check_reason;
            }

            public String getCheck_at() {
                return check_at;
            }

            public void setCheck_at(String check_at) {
                this.check_at = check_at;
            }

            public int getEnroll_num() {
                return enroll_num;
            }

            public void setEnroll_num(int enroll_num) {
                this.enroll_num = enroll_num;
            }

            public int getSelect_enroll_num() {
                return select_enroll_num;
            }

            public void setSelect_enroll_num(int select_enroll_num) {
                this.select_enroll_num = select_enroll_num;
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getStatus_text() {
                return status_text;
            }

            public void setStatus_text(String status_text) {
                this.status_text = status_text;
            }

            public String getRecruit_days_at() {
                return recruit_days_at;
            }

            public void setRecruit_days_at(String recruit_days_at) {
                this.recruit_days_at = recruit_days_at;
            }
        }

        public static class SeaRequireMemberBean implements Serializable{
            /**
             * uid : 223
             * require_finish_rate : 0.00
             * require_credit_score : 5.00
             * head : eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6
             * nickname : 颜妾
             * head_info : {"ext":"jpg","w":"400","h":"400","size":"35355","is_long":"0","md5":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","link":"http://testapi.imxkj.com//image/eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6/1"}
             */

            private int uid;
            private String require_finish_rate;
            private String require_credit_score;
            private String head;
            private String nickname;
            private HeadInfoBean head_info;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getRequire_finish_rate() {
                return require_finish_rate;
            }

            public void setRequire_finish_rate(String require_finish_rate) {
                this.require_finish_rate = require_finish_rate;
            }

            public String getRequire_credit_score() {
                return require_credit_score;
            }

            public void setRequire_credit_score(String require_credit_score) {
                this.require_credit_score = require_credit_score;
            }

            public String getHead() {
                return head;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public HeadInfoBean getHead_info() {
                return head_info;
            }

            public void setHead_info(HeadInfoBean head_info) {
                this.head_info = head_info;
            }

            public static class HeadInfoBean implements Serializable{
                /**
                 * ext : jpg
                 * w : 400
                 * h : 400
                 * size : 35355
                 * is_long : 0
                 * md5 : eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6
                 * link : http://testapi.imxkj.com//image/eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6/1
                 */

                private String ext;
                private String w;
                private String h;
                private String size;
                private String is_long;
                private String md5;
                private String link;

                public String getExt() {
                    return ext;
                }

                public void setExt(String ext) {
                    this.ext = ext;
                }

                public String getW() {
                    return w;
                }

                public void setW(String w) {
                    this.w = w;
                }

                public String getH() {
                    return h;
                }

                public void setH(String h) {
                    this.h = h;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getIs_long() {
                    return is_long;
                }

                public void setIs_long(String is_long) {
                    this.is_long = is_long;
                }

                public String getMd5() {
                    return md5;
                }

                public void setMd5(String md5) {
                    this.md5 = md5;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }
            }
        }

        public static class WorkTypeBean implements Serializable{
            /**
             * id : 2
             * title : 作词
             * content : 就是作词
             * file_format : PNG/JPEG
             * file_type : 3
             * status : 1
             * created_at : 2019-03-12 09:47:05
             * updated_at : 2019-03-12 09:47:06
             * deleted_at :
             * file_type_text : 图片
             * status_text : 是
             */

            private int id;
            private String title;
            private String content;
            private String file_format;
            private int file_type;
            private int status;
            private String created_at;
            private String updated_at;
            private String deleted_at;
            private String file_type_text;
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

            public String getFile_format() {
                return file_format;
            }

            public void setFile_format(String file_format) {
                this.file_format = file_format;
            }

            public int getFile_type() {
                return file_type;
            }

            public void setFile_type(int file_type) {
                this.file_type = file_type;
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

            public String getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(String deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getFile_type_text() {
                return file_type_text;
            }

            public void setFile_type_text(String file_type_text) {
                this.file_type_text = file_type_text;
            }

            public String getStatus_text() {
                return status_text;
            }

            public void setStatus_text(String status_text) {
                this.status_text = status_text;
            }
        }
    }
}
