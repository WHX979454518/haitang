package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class SelectedMusicansBean implements Serializable {

    /**
     * data : [{"id":7,"project_id":12,"project_task_id":19,"work_type_id":1,"enroll_id":22,"uid":50466,"musician_id":52490,"task_progress_id":0,"money":"300.00","creation_days":30,"content":"内容","musician_status":3,"require_status":1,"musician_sign_pass_at":"","musician_sign_fail_at":"","musician_fail_reason":"","require_sign_pass_at":"","require_sign_fail_at":"","require_fail_reason":"","is_apply_stop":1,"is_apply_stop_reason":"","is_apply_stop_at":"","is_stop_reason":"","is_stop_at":"","delay_days":"","delay_at":"","is_apply_delay":1,"apply_delay_days":"","apply_delay_reason":"","apply_delay_at":"","inspect_type":"","inspect_at":"","created_at":"2019-03-28 17:45:00","updated_at":"2019-03-28 17:45:00","deleted_at":"","project":{"id":12,"uid":50466,"project_type_id":1,"project_title":"测试","work_use_ids":["视听平台"],"use_channel_ids":["部分平台"],"project_desc":"测试","secrecy_days":"三个月","work_style_ids":"ACG,VC,广播剧","project_status":3,"stop_reason":"","stop_at":"","check_reason":"过","check_at":"2019-03-27 17:39:20","enroll_num":1,"min_budget":"1000.00","max_budget":"3000.00","work_type_ids":"1,1","collect_num":0,"created_at":"2019-03-27 15:02:45","updated_at":"2019-03-27 15:02:45","deleted_at":"","share_counts":0,"status_text":"招募中","work_style_arr":[],"work_type_arr":["作曲"],"budget_range_text":"1K-3K"},"task":{"id":19,"uid":50466,"project_id":12,"work_type_id":1,"min_budget":"100.00","max_budget":"300.00","recruit_days":8,"creation_days":30,"task_status":3,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-20 17:42:02","recruit_days_at":"2019-04-04","enroll_num":1,"select_enroll_num":0,"created_at":"2019-03-27 15:02:46","updated_at":"2019-03-27 15:02:46","deleted_at":"","status_text":"招募中"},"sea_member":{"uid":52490,"musician_finish_rate":"0.00","musician_credit_score":"0.00","head":"3d3d27527715c56204c6e063e34883ae60384a97","nickname":"用户641941","head_info":{"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}},"work_type":{"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":"","file_type_text":"音频","status_text":"是"},"musician_status_text":"待签约","require_status_text":"待签约"}]
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
         * id : 7
         * project_id : 12
         * project_task_id : 19
         * work_type_id : 1
         * enroll_id : 22
         * uid : 50466
         * musician_id : 52490
         * task_progress_id : 0
         * money : 300.00
         * creation_days : 30
         * content : 内容
         * musician_status : 3
         * require_status : 1
         * musician_sign_pass_at :
         * musician_sign_fail_at :
         * musician_fail_reason :
         * require_sign_pass_at :
         * require_sign_fail_at :
         * require_fail_reason :
         * is_apply_stop : 1
         * is_apply_stop_reason :
         * is_apply_stop_at :
         * is_stop_reason :
         * is_stop_at :
         * delay_days :
         * delay_at :
         * is_apply_delay : 1
         * apply_delay_days :
         * apply_delay_reason :
         * apply_delay_at :
         * inspect_type :
         * inspect_at :
         * created_at : 2019-03-28 17:45:00
         * updated_at : 2019-03-28 17:45:00
         * deleted_at :
         * project : {"id":12,"uid":50466,"project_type_id":1,"project_title":"测试","work_use_ids":["视听平台"],"use_channel_ids":["部分平台"],"project_desc":"测试","secrecy_days":"三个月","work_style_ids":"ACG,VC,广播剧","project_status":3,"stop_reason":"","stop_at":"","check_reason":"过","check_at":"2019-03-27 17:39:20","enroll_num":1,"min_budget":"1000.00","max_budget":"3000.00","work_type_ids":"1,1","collect_num":0,"created_at":"2019-03-27 15:02:45","updated_at":"2019-03-27 15:02:45","deleted_at":"","share_counts":0,"status_text":"招募中","work_style_arr":[],"work_type_arr":["作曲"],"budget_range_text":"1K-3K"}
         * task : {"id":19,"uid":50466,"project_id":12,"work_type_id":1,"min_budget":"100.00","max_budget":"300.00","recruit_days":8,"creation_days":30,"task_status":3,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-20 17:42:02","recruit_days_at":"2019-04-04","enroll_num":1,"select_enroll_num":0,"created_at":"2019-03-27 15:02:46","updated_at":"2019-03-27 15:02:46","deleted_at":"","status_text":"招募中"}
         * sea_member : {"uid":52490,"musician_finish_rate":"0.00","musician_credit_score":"0.00","head":"3d3d27527715c56204c6e063e34883ae60384a97","nickname":"用户641941","head_info":{"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}}
         * work_type : {"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":"","file_type_text":"音频","status_text":"是"}
         * musician_status_text : 待签约
         * require_status_text : 待签约
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
        private String delay_days;
        private String delay_at;
        private int is_apply_delay;
        private String apply_delay_days;
        private String apply_delay_reason;
        private String apply_delay_at;
        private String inspect_type;
        private String inspect_at;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private ProjectBean project;
        private TaskBean task;
        private SeaMemberBean sea_member;
        private WorkTypeBean work_type;
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

        public String getDelay_days() {
            return delay_days;
        }

        public void setDelay_days(String delay_days) {
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

        public String getApply_delay_days() {
            return apply_delay_days;
        }

        public void setApply_delay_days(String apply_delay_days) {
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

        public String getInspect_type() {
            return inspect_type;
        }

        public void setInspect_type(String inspect_type) {
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

        public SeaMemberBean getSea_member() {
            return sea_member;
        }

        public void setSea_member(SeaMemberBean sea_member) {
            this.sea_member = sea_member;
        }

        public WorkTypeBean getWork_type() {
            return work_type;
        }

        public void setWork_type(WorkTypeBean work_type) {
            this.work_type = work_type;
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

        public static class ProjectBean implements Serializable{
            /**
             * id : 12
             * uid : 50466
             * project_type_id : 1
             * project_title : 测试
             * work_use_ids : ["视听平台"]
             * use_channel_ids : ["部分平台"]
             * project_desc : 测试
             * secrecy_days : 三个月
             * work_style_ids : ACG,VC,广播剧
             * project_status : 3
             * stop_reason :
             * stop_at :
             * check_reason : 过
             * check_at : 2019-03-27 17:39:20
             * enroll_num : 1
             * min_budget : 1000.00
             * max_budget : 3000.00
             * work_type_ids : 1,1
             * collect_num : 0
             * created_at : 2019-03-27 15:02:45
             * updated_at : 2019-03-27 15:02:45
             * deleted_at :
             * share_counts : 0
             * status_text : 招募中
             * work_style_arr : []
             * work_type_arr : ["作曲"]
             * budget_range_text : 1K-3K
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
            private int share_counts;
            private String status_text;
            private String budget_range_text;
            private List<String> work_use_ids;
            private List<String> use_channel_ids;
            private List<?> work_style_arr;
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

            public int getShare_counts() {
                return share_counts;
            }

            public void setShare_counts(int share_counts) {
                this.share_counts = share_counts;
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

            public List<?> getWork_style_arr() {
                return work_style_arr;
            }

            public void setWork_style_arr(List<?> work_style_arr) {
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
             * id : 19
             * uid : 50466
             * project_id : 12
             * work_type_id : 1
             * min_budget : 100.00
             * max_budget : 300.00
             * recruit_days : 8
             * creation_days : 30
             * task_status : 3
             * stop_reason :
             * stop_at :
             * is_delay : 1
             * delay_days :
             * is_delay_at :
             * check_reason : 过
             * check_at : 2019-03-20 17:42:02
             * recruit_days_at : 2019-04-04
             * enroll_num : 1
             * select_enroll_num : 0
             * created_at : 2019-03-27 15:02:46
             * updated_at : 2019-03-27 15:02:46
             * deleted_at :
             * status_text : 招募中
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
            private String recruit_days_at;
            private int enroll_num;
            private int select_enroll_num;
            private String created_at;
            private String updated_at;
            private String deleted_at;
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

            public String getRecruit_days_at() {
                return recruit_days_at;
            }

            public void setRecruit_days_at(String recruit_days_at) {
                this.recruit_days_at = recruit_days_at;
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
        }

        public static class SeaMemberBean implements Serializable{
            /**
             * uid : 52490
             * musician_finish_rate : 0.00
             * musician_credit_score : 0.00
             * head : 3d3d27527715c56204c6e063e34883ae60384a97
             * nickname : 用户641941
             * head_info : {"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}
             */

            private int uid;
            private String musician_finish_rate;
            private String musician_credit_score;
            private String head;
            private String nickname;
            private HeadInfoBean head_info;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getMusician_finish_rate() {
                return musician_finish_rate;
            }

            public void setMusician_finish_rate(String musician_finish_rate) {
                this.musician_finish_rate = musician_finish_rate;
            }

            public String getMusician_credit_score() {
                return musician_credit_score;
            }

            public void setMusician_credit_score(String musician_credit_score) {
                this.musician_credit_score = musician_credit_score;
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
                 * w : 330
                 * h : 333
                 * size : 15105
                 * is_long : 0
                 * md5 : 3d3d27527715c56204c6e063e34883ae60384a97
                 * link : http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3
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
             * id : 1
             * title : 作曲
             * en_title : zuoqu
             * icon : FE4146FBA6350ACBE1741D791D707532
             * content : 就是作曲
             * file_format : MP4/MP3
             * file_type : 1
             * status : 1
             * created_at : 2019-03-12 09:45:54
             * updated_at : 2019-03-12 09:45:55
             * deleted_at :
             * file_type_text : 音频
             * status_text : 是
             */

            private int id;
            private String title;
            private String en_title;
            private String icon;
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

            public String getEn_title() {
                return en_title;
            }

            public void setEn_title(String en_title) {
                this.en_title = en_title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
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
