package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class ContractBean implements Serializable {

    /**
     * data : {"id":1,"project_id":1,"project_task_id":1,"work_type_id":1,"enroll_id":33,"uid":222,"musician_id":223,"task_progress_id":0,"money":"400.00","creation_days":701,"content":"我我我我哦我欧文我我我我我我我我我欧文我我我","musician_status":9,"require_status":7,"musician_sign_pass_at":"2019-03-20 14:57:16","musician_sign_fail_at":"2019-03-20 15:12:19","musician_fail_reason":"不想做了","require_sign_pass_at":"2019-03-15 14:31:28","require_sign_fail_at":"2019-03-20 15:17:26","require_fail_reason":"不想做了","is_apply_stop":1,"is_apply_stop_reason":null,"is_apply_stop_at":null,"is_stop_reason":null,"is_stop_at":null,"delay_days":30,"delay_at":"2019-03-20 16:48:08","is_apply_delay":2,"apply_delay_days":30,"apply_delay_reason":"再给我30天吧","apply_delay_at":"2019-03-19 17:03:36","inspect_type":1,"inspect_at":"2019-03-02 10:16:10","created_at":"2019-03-13 18:21:31","updated_at":"2019-03-23 16:15:28","deleted_at":null,"project":{"id":1,"uid":222,"project_type_id":1,"project_title":"来来来121","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"project_desc":"好的很","secrecy_days":"3个月","work_style_ids":"1,2,3","project_status":3,"stop_reason":null,"stop_at":null,"check_reason":"过","check_at":"2019-03-27 17:39:16","enroll_num":6,"min_budget":"900.00","max_budget":"2400.00","work_type_ids":"1,2,3","collect_num":3,"created_at":"2019-03-13 14:35:22","updated_at":"2019-03-22 18:05:23","deleted_at":null,"share_counts":0,"status_text":"招募中","work_style_arr":["无","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"900-2.4K"},"task":{"id":1,"uid":222,"project_id":1,"work_type_id":1,"min_budget":"300.00","max_budget":"8000.00","recruit_days":1,"creation_days":30,"task_status":1,"stop_reason":null,"stop_at":null,"is_delay":1,"delay_days":null,"is_delay_at":null,"check_reason":null,"check_at":null,"recruit_days_at":"2019-03-23","enroll_num":2,"select_enroll_num":0,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null,"task_progress":[{"id":1,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听111","deposit_rate":20,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":2,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听222","deposit_rate":30,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":3,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听3333","deposit_rate":50,"created_at":"2019-03-22 16:47:44","updated_at":"2019-03-22 16:47:44","deleted_at":null}],"status_text":"审核中"},"sea_member":{"uid":223,"musician_finish_rate":"0.50","musician_credit_score":"4.87","head":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","nickname":"颜妾"},"sea_require_member":{"uid":222,"require_finish_rate":"1.50","require_credit_score":"4.85","head":"bdc31db9afdc124ad30eec393967aa2c70162bb9","nickname":"苏莘薇"},"work_type":{"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":null,"file_type_text":"音频","status_text":"是"},"creative":[{"id":1,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":1,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":null,"file_format":"PNG/JPEG","file_type":3,"status":3,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":2,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":1,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":2,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":3,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":2,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":3,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":4,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":3,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":2,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"}],"evaluate":[{"id":2,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:56:11","updated_at":"2019-03-20 17:56:11","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":3,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:57:42","updated_at":"2019-03-20 17:57:42","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":4,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:59:44","updated_at":"2019-03-20 17:59:44","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":5,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:59:55","updated_at":"2019-03-20 17:59:55","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":6,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.4,"work_quality":null,"description":5,"attitude":4,"response":5,"punctual":null,"inspect_punctual":3,"remark":"下次再合作","identity_type":2,"type":1,"created_at":"2019-03-20 18:02:21","updated_at":"2019-03-20 18:02:21","deleted_at":null,"identity_type_text":"音乐人","type_text":"手动评价"},{"id":7,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":null,"description":5,"attitude":5,"response":5,"punctual":null,"inspect_punctual":5,"remark":"系统好评","identity_type":2,"type":2,"created_at":"2019-03-21 12:05:15","updated_at":"2019-03-21 12:05:15","deleted_at":null,"identity_type_text":"音乐人","type_text":"系统评价"},{"id":10,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":null,"description":5,"attitude":5,"response":5,"punctual":null,"inspect_punctual":5,"remark":"系统好评","identity_type":2,"type":2,"created_at":"2019-03-21 14:24:54","updated_at":"2019-03-21 14:24:54","deleted_at":null,"identity_type_text":"音乐人","type_text":"系统评价"},{"id":13,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":5,"description":null,"attitude":5,"response":5,"punctual":5,"inspect_punctual":null,"remark":"系统好评","identity_type":1,"type":2,"created_at":"2019-03-21 14:24:54","updated_at":"2019-03-21 14:24:54","deleted_at":null,"identity_type_text":"招募人","type_text":"系统评价"}],"order":{"id":1,"project_id":1,"project_task_id":1,"user_coupon_id":null,"contract_id":1,"order_sn":"OR20190314WEB0001","uid":222,"musician_id":223,"pay_type":2,"order_money":"300.00","coupon_money":"84.29","pay_money":"215.71","real_money":"199.89","refund_moeny":"0.00","refund_reason":null,"remark":null,"trade_no":null,"pay_status":2,"created_at":"2019-03-14 16:02:17","updated_at":"2019-03-26 15:24:40","deleted_at":null,"pay_type_text":"支付宝","pay_status_text":"支付成功"},"musician_status_text":"已完成","require_status_text":"已完成"}
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
         * id : 1
         * project_id : 1
         * project_task_id : 1
         * work_type_id : 1
         * enroll_id : 33
         * uid : 222
         * musician_id : 223
         * task_progress_id : 0
         * money : 400.00
         * creation_days : 701
         * content : 我我我我哦我欧文我我我我我我我我我欧文我我我
         * musician_status : 9
         * require_status : 7
         * musician_sign_pass_at : 2019-03-20 14:57:16
         * musician_sign_fail_at : 2019-03-20 15:12:19
         * musician_fail_reason : 不想做了
         * require_sign_pass_at : 2019-03-15 14:31:28
         * require_sign_fail_at : 2019-03-20 15:17:26
         * require_fail_reason : 不想做了
         * is_apply_stop : 1
         * is_apply_stop_reason : null
         * is_apply_stop_at : null
         * is_stop_reason : null
         * is_stop_at : null
         * delay_days : 30
         * delay_at : 2019-03-20 16:48:08
         * is_apply_delay : 2
         * apply_delay_days : 30
         * apply_delay_reason : 再给我30天吧
         * apply_delay_at : 2019-03-19 17:03:36
         * inspect_type : 1
         * inspect_at : 2019-03-02 10:16:10
         * created_at : 2019-03-13 18:21:31
         * updated_at : 2019-03-23 16:15:28
         * deleted_at : null
         * project : {"id":1,"uid":222,"project_type_id":1,"project_title":"来来来121","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"project_desc":"好的很","secrecy_days":"3个月","work_style_ids":"1,2,3","project_status":3,"stop_reason":null,"stop_at":null,"check_reason":"过","check_at":"2019-03-27 17:39:16","enroll_num":6,"min_budget":"900.00","max_budget":"2400.00","work_type_ids":"1,2,3","collect_num":3,"created_at":"2019-03-13 14:35:22","updated_at":"2019-03-22 18:05:23","deleted_at":null,"share_counts":0,"status_text":"招募中","work_style_arr":["无","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"900-2.4K"}
         * task : {"id":1,"uid":222,"project_id":1,"work_type_id":1,"min_budget":"300.00","max_budget":"8000.00","recruit_days":1,"creation_days":30,"task_status":1,"stop_reason":null,"stop_at":null,"is_delay":1,"delay_days":null,"is_delay_at":null,"check_reason":null,"check_at":null,"recruit_days_at":"2019-03-23","enroll_num":2,"select_enroll_num":0,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null,"task_progress":[{"id":1,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听111","deposit_rate":20,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":2,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听222","deposit_rate":30,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":3,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听3333","deposit_rate":50,"created_at":"2019-03-22 16:47:44","updated_at":"2019-03-22 16:47:44","deleted_at":null}],"status_text":"审核中"}
         * sea_member : {"uid":223,"musician_finish_rate":"0.50","musician_credit_score":"4.87","head":"eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6","nickname":"颜妾"}
         * sea_require_member : {"uid":222,"require_finish_rate":"1.50","require_credit_score":"4.85","head":"bdc31db9afdc124ad30eec393967aa2c70162bb9","nickname":"苏莘薇"}
         * work_type : {"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":null,"file_type_text":"音频","status_text":"是"}
         * creative : [{"id":1,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":1,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":null,"file_format":"PNG/JPEG","file_type":3,"status":3,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":2,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":1,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":2,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":3,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":2,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":3,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"},{"id":4,"uid":223,"project_id":1,"project_task_id":1,"project_task_progress_id":3,"contract_id":1,"work_title":"我的201903170906","work_md5":"12123ADSA234QWQE","fail_remark":"就是不过","file_format":"PNG/JPEG","file_type":3,"status":2,"created_at":"2019-03-17 09:36:17","updated_at":"2019-03-17 09:36:17","deleted_at":null,"file_type_text":"图片"}]
         * evaluate : [{"id":2,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:56:11","updated_at":"2019-03-20 17:56:11","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":3,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:57:42","updated_at":"2019-03-20 17:57:42","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":4,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:59:44","updated_at":"2019-03-20 17:59:44","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":5,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.8,"work_quality":5,"description":null,"attitude":4,"response":5,"punctual":5,"inspect_punctual":null,"remark":"下次再合作","identity_type":1,"type":1,"created_at":"2019-03-20 17:59:55","updated_at":"2019-03-20 17:59:55","deleted_at":null,"identity_type_text":"招募人","type_text":"手动评价"},{"id":6,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":4.4,"work_quality":null,"description":5,"attitude":4,"response":5,"punctual":null,"inspect_punctual":3,"remark":"下次再合作","identity_type":2,"type":1,"created_at":"2019-03-20 18:02:21","updated_at":"2019-03-20 18:02:21","deleted_at":null,"identity_type_text":"音乐人","type_text":"手动评价"},{"id":7,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":null,"description":5,"attitude":5,"response":5,"punctual":null,"inspect_punctual":5,"remark":"系统好评","identity_type":2,"type":2,"created_at":"2019-03-21 12:05:15","updated_at":"2019-03-21 12:05:15","deleted_at":null,"identity_type_text":"音乐人","type_text":"系统评价"},{"id":10,"uid":223,"to_uid":222,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":null,"description":5,"attitude":5,"response":5,"punctual":null,"inspect_punctual":5,"remark":"系统好评","identity_type":2,"type":2,"created_at":"2019-03-21 14:24:54","updated_at":"2019-03-21 14:24:54","deleted_at":null,"identity_type_text":"音乐人","type_text":"系统评价"},{"id":13,"uid":222,"to_uid":223,"project_id":1,"project_task_id":1,"contract_id":1,"global_score":5,"work_quality":5,"description":null,"attitude":5,"response":5,"punctual":5,"inspect_punctual":null,"remark":"系统好评","identity_type":1,"type":2,"created_at":"2019-03-21 14:24:54","updated_at":"2019-03-21 14:24:54","deleted_at":null,"identity_type_text":"招募人","type_text":"系统评价"}]
         * order : {"id":1,"project_id":1,"project_task_id":1,"user_coupon_id":null,"contract_id":1,"order_sn":"OR20190314WEB0001","uid":222,"musician_id":223,"pay_type":2,"order_money":"300.00","coupon_money":"84.29","pay_money":"215.71","real_money":"199.89","refund_moeny":"0.00","refund_reason":null,"remark":null,"trade_no":null,"pay_status":2,"created_at":"2019-03-14 16:02:17","updated_at":"2019-03-26 15:24:40","deleted_at":null,"pay_type_text":"支付宝","pay_status_text":"支付成功"}
         * musician_status_text : 已完成
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
        private Object is_apply_stop_reason;
        private Object is_apply_stop_at;
        private Object is_stop_reason;
        private Object is_stop_at;
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
        private Object deleted_at;
        private ProjectBean project;
        private TaskBean task;
        private SeaMemberBean sea_member;
        private SeaRequireMemberBean sea_require_member;
        private WorkTypeBean work_type;
        private OrderBean order;
        private String musician_status_text;
        private String require_status_text;
        private List<CreativeBean> creative;
        private List<EvaluateBean> evaluate;

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

        public Object getIs_apply_stop_reason() {
            return is_apply_stop_reason;
        }

        public void setIs_apply_stop_reason(Object is_apply_stop_reason) {
            this.is_apply_stop_reason = is_apply_stop_reason;
        }

        public Object getIs_apply_stop_at() {
            return is_apply_stop_at;
        }

        public void setIs_apply_stop_at(Object is_apply_stop_at) {
            this.is_apply_stop_at = is_apply_stop_at;
        }

        public Object getIs_stop_reason() {
            return is_stop_reason;
        }

        public void setIs_stop_reason(Object is_stop_reason) {
            this.is_stop_reason = is_stop_reason;
        }

        public Object getIs_stop_at() {
            return is_stop_at;
        }

        public void setIs_stop_at(Object is_stop_at) {
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

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
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

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
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

        public List<CreativeBean> getCreative() {
            return creative;
        }

        public void setCreative(List<CreativeBean> creative) {
            this.creative = creative;
        }

        public List<EvaluateBean> getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(List<EvaluateBean> evaluate) {
            this.evaluate = evaluate;
        }

        public static class ProjectBean {
            /**
             * id : 1
             * uid : 222
             * project_type_id : 1
             * project_title : 来来来121
             * work_use_ids : ["视听平台","部分平台","全平台"]
             * use_channel_ids : ["连续剧/动画、综艺","电视","网络"]
             * project_desc : 好的很
             * secrecy_days : 3个月
             * work_style_ids : 1,2,3
             * project_status : 3
             * stop_reason : null
             * stop_at : null
             * check_reason : 过
             * check_at : 2019-03-27 17:39:16
             * enroll_num : 6
             * min_budget : 900.00
             * max_budget : 2400.00
             * work_type_ids : 1,2,3
             * collect_num : 3
             * created_at : 2019-03-13 14:35:22
             * updated_at : 2019-03-22 18:05:23
             * deleted_at : null
             * share_counts : 0
             * status_text : 招募中
             * work_style_arr : ["无","ACG","VC"]
             * work_type_arr : ["作曲","作词","歌手"]
             * budget_range_text : 900-2.4K
             */

            private int id;
            private int uid;
            private int project_type_id;
            private String project_title;
            private String project_desc;
            private String secrecy_days;
            private String work_style_ids;
            private int project_status;
            private Object stop_reason;
            private Object stop_at;
            private String check_reason;
            private String check_at;
            private int enroll_num;
            private String min_budget;
            private String max_budget;
            private String work_type_ids;
            private int collect_num;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private int share_counts;
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

            public Object getStop_reason() {
                return stop_reason;
            }

            public void setStop_reason(Object stop_reason) {
                this.stop_reason = stop_reason;
            }

            public Object getStop_at() {
                return stop_at;
            }

            public void setStop_at(Object stop_at) {
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
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

        public static class TaskBean {
            /**
             * id : 1
             * uid : 222
             * project_id : 1
             * work_type_id : 1
             * min_budget : 300.00
             * max_budget : 8000.00
             * recruit_days : 1
             * creation_days : 30
             * task_status : 1
             * stop_reason : null
             * stop_at : null
             * is_delay : 1
             * delay_days : null
             * is_delay_at : null
             * check_reason : null
             * check_at : null
             * recruit_days_at : 2019-03-23
             * enroll_num : 2
             * select_enroll_num : 0
             * created_at : 2019-03-22 16:47:43
             * updated_at : 2019-03-22 16:47:43
             * deleted_at : null
             * task_progress : [{"id":1,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听111","deposit_rate":20,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":2,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听222","deposit_rate":30,"created_at":"2019-03-22 16:47:43","updated_at":"2019-03-22 16:47:43","deleted_at":null},{"id":3,"uid":"222","project_id":1,"project_task_id":1,"progress_name":"作曲试听3333","deposit_rate":50,"created_at":"2019-03-22 16:47:44","updated_at":"2019-03-22 16:47:44","deleted_at":null}]
             * status_text : 审核中
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
            private Object stop_reason;
            private Object stop_at;
            private int is_delay;
            private Object delay_days;
            private Object is_delay_at;
            private Object check_reason;
            private Object check_at;
            private String recruit_days_at;
            private int enroll_num;
            private int select_enroll_num;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String status_text;
            private List<TaskProgressBean> task_progress;

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

            public Object getStop_reason() {
                return stop_reason;
            }

            public void setStop_reason(Object stop_reason) {
                this.stop_reason = stop_reason;
            }

            public Object getStop_at() {
                return stop_at;
            }

            public void setStop_at(Object stop_at) {
                this.stop_at = stop_at;
            }

            public int getIs_delay() {
                return is_delay;
            }

            public void setIs_delay(int is_delay) {
                this.is_delay = is_delay;
            }

            public Object getDelay_days() {
                return delay_days;
            }

            public void setDelay_days(Object delay_days) {
                this.delay_days = delay_days;
            }

            public Object getIs_delay_at() {
                return is_delay_at;
            }

            public void setIs_delay_at(Object is_delay_at) {
                this.is_delay_at = is_delay_at;
            }

            public Object getCheck_reason() {
                return check_reason;
            }

            public void setCheck_reason(Object check_reason) {
                this.check_reason = check_reason;
            }

            public Object getCheck_at() {
                return check_at;
            }

            public void setCheck_at(Object check_at) {
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

            public List<TaskProgressBean> getTask_progress() {
                return task_progress;
            }

            public void setTask_progress(List<TaskProgressBean> task_progress) {
                this.task_progress = task_progress;
            }

            public static class TaskProgressBean {
                /**
                 * id : 1
                 * uid : 222
                 * project_id : 1
                 * project_task_id : 1
                 * progress_name : 作曲试听111
                 * deposit_rate : 20
                 * created_at : 2019-03-22 16:47:43
                 * updated_at : 2019-03-22 16:47:43
                 * deleted_at : null
                 */

                private int id;
                private String uid;
                private int project_id;
                private int project_task_id;
                private String progress_name;
                private int deposit_rate;
                private String created_at;
                private String updated_at;
                private Object deleted_at;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
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

        public static class SeaMemberBean {
            /**
             * uid : 223
             * musician_finish_rate : 0.50
             * musician_credit_score : 4.87
             * head : eeb36fb957d0ac7e69af8ff0ed2100dc419f68c6
             * nickname : 颜妾
             */

            private int uid;
            private String musician_finish_rate;
            private String musician_credit_score;
            private String head;
            private String nickname;

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
        }

        public static class SeaRequireMemberBean {
            /**
             * uid : 222
             * require_finish_rate : 1.50
             * require_credit_score : 4.85
             * head : bdc31db9afdc124ad30eec393967aa2c70162bb9
             * nickname : 苏莘薇
             */

            private int uid;
            private String require_finish_rate;
            private String require_credit_score;
            private String head;
            private String nickname;

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
        }

        public static class WorkTypeBean {
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
             * deleted_at : null
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
            private Object deleted_at;
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
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

        public static class OrderBean {
            /**
             * id : 1
             * project_id : 1
             * project_task_id : 1
             * user_coupon_id : null
             * contract_id : 1
             * order_sn : OR20190314WEB0001
             * uid : 222
             * musician_id : 223
             * pay_type : 2
             * order_money : 300.00
             * coupon_money : 84.29
             * pay_money : 215.71
             * real_money : 199.89
             * refund_moeny : 0.00
             * refund_reason : null
             * remark : null
             * trade_no : null
             * pay_status : 2
             * created_at : 2019-03-14 16:02:17
             * updated_at : 2019-03-26 15:24:40
             * deleted_at : null
             * pay_type_text : 支付宝
             * pay_status_text : 支付成功
             */

            private int id;
            private int project_id;
            private int project_task_id;
            private Object user_coupon_id;
            private int contract_id;
            private String order_sn;
            private int uid;
            private int musician_id;
            private int pay_type;
            private String order_money;
            private String coupon_money;
            private String pay_money;
            private String real_money;
            private String refund_moeny;
            private Object refund_reason;
            private Object remark;
            private Object trade_no;
            private int pay_status;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String pay_type_text;
            private String pay_status_text;

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

            public Object getUser_coupon_id() {
                return user_coupon_id;
            }

            public void setUser_coupon_id(Object user_coupon_id) {
                this.user_coupon_id = user_coupon_id;
            }

            public int getContract_id() {
                return contract_id;
            }

            public void setContract_id(int contract_id) {
                this.contract_id = contract_id;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
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

            public int getPay_type() {
                return pay_type;
            }

            public void setPay_type(int pay_type) {
                this.pay_type = pay_type;
            }

            public String getOrder_money() {
                return order_money;
            }

            public void setOrder_money(String order_money) {
                this.order_money = order_money;
            }

            public String getCoupon_money() {
                return coupon_money;
            }

            public void setCoupon_money(String coupon_money) {
                this.coupon_money = coupon_money;
            }

            public String getPay_money() {
                return pay_money;
            }

            public void setPay_money(String pay_money) {
                this.pay_money = pay_money;
            }

            public String getReal_money() {
                return real_money;
            }

            public void setReal_money(String real_money) {
                this.real_money = real_money;
            }

            public String getRefund_moeny() {
                return refund_moeny;
            }

            public void setRefund_moeny(String refund_moeny) {
                this.refund_moeny = refund_moeny;
            }

            public Object getRefund_reason() {
                return refund_reason;
            }

            public void setRefund_reason(Object refund_reason) {
                this.refund_reason = refund_reason;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getTrade_no() {
                return trade_no;
            }

            public void setTrade_no(Object trade_no) {
                this.trade_no = trade_no;
            }

            public int getPay_status() {
                return pay_status;
            }

            public void setPay_status(int pay_status) {
                this.pay_status = pay_status;
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

            public String getPay_type_text() {
                return pay_type_text;
            }

            public void setPay_type_text(String pay_type_text) {
                this.pay_type_text = pay_type_text;
            }

            public String getPay_status_text() {
                return pay_status_text;
            }

            public void setPay_status_text(String pay_status_text) {
                this.pay_status_text = pay_status_text;
            }
        }

        public static class CreativeBean {
            /**
             * id : 1
             * uid : 223
             * project_id : 1
             * project_task_id : 1
             * project_task_progress_id : 1
             * contract_id : 1
             * work_title : 我的201903170906
             * work_md5 : 12123ADSA234QWQE
             * fail_remark : null
             * file_format : PNG/JPEG
             * file_type : 3
             * status : 3
             * created_at : 2019-03-17 09:36:17
             * updated_at : 2019-03-17 09:36:17
             * deleted_at : null
             * file_type_text : 图片
             */

            private int id;
            private int uid;
            private int project_id;
            private int project_task_id;
            private int project_task_progress_id;
            private int contract_id;
            private String work_title;
            private String work_md5;
            private Object fail_remark;
            private String file_format;
            private int file_type;
            private int status;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String file_type_text;

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

            public int getProject_task_id() {
                return project_task_id;
            }

            public void setProject_task_id(int project_task_id) {
                this.project_task_id = project_task_id;
            }

            public int getProject_task_progress_id() {
                return project_task_progress_id;
            }

            public void setProject_task_progress_id(int project_task_progress_id) {
                this.project_task_progress_id = project_task_progress_id;
            }

            public int getContract_id() {
                return contract_id;
            }

            public void setContract_id(int contract_id) {
                this.contract_id = contract_id;
            }

            public String getWork_title() {
                return work_title;
            }

            public void setWork_title(String work_title) {
                this.work_title = work_title;
            }

            public String getWork_md5() {
                return work_md5;
            }

            public void setWork_md5(String work_md5) {
                this.work_md5 = work_md5;
            }

            public Object getFail_remark() {
                return fail_remark;
            }

            public void setFail_remark(Object fail_remark) {
                this.fail_remark = fail_remark;
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

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }

            public String getFile_type_text() {
                return file_type_text;
            }

            public void setFile_type_text(String file_type_text) {
                this.file_type_text = file_type_text;
            }
        }

        public static class EvaluateBean {
            /**
             * id : 2
             * uid : 222
             * to_uid : 223
             * project_id : 1
             * project_task_id : 1
             * contract_id : 1
             * global_score : 4.8
             * work_quality : 5
             * description : null
             * attitude : 4
             * response : 5
             * punctual : 5
             * inspect_punctual : null
             * remark : 下次再合作
             * identity_type : 1
             * type : 1
             * created_at : 2019-03-20 17:56:11
             * updated_at : 2019-03-20 17:56:11
             * deleted_at : null
             * identity_type_text : 招募人
             * type_text : 手动评价
             */

            private int id;
            private int uid;
            private int to_uid;
            private int project_id;
            private int project_task_id;
            private int contract_id;
            private double global_score;
            private int work_quality;
            private Object description;
            private int attitude;
            private int response;
            private int punctual;
            private Object inspect_punctual;
            private String remark;
            private int identity_type;
            private int type;
            private String created_at;
            private String updated_at;
            private Object deleted_at;
            private String identity_type_text;
            private String type_text;

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

            public int getTo_uid() {
                return to_uid;
            }

            public void setTo_uid(int to_uid) {
                this.to_uid = to_uid;
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

            public int getContract_id() {
                return contract_id;
            }

            public void setContract_id(int contract_id) {
                this.contract_id = contract_id;
            }

            public double getGlobal_score() {
                return global_score;
            }

            public void setGlobal_score(double global_score) {
                this.global_score = global_score;
            }

            public int getWork_quality() {
                return work_quality;
            }

            public void setWork_quality(int work_quality) {
                this.work_quality = work_quality;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public int getAttitude() {
                return attitude;
            }

            public void setAttitude(int attitude) {
                this.attitude = attitude;
            }

            public int getResponse() {
                return response;
            }

            public void setResponse(int response) {
                this.response = response;
            }

            public int getPunctual() {
                return punctual;
            }

            public void setPunctual(int punctual) {
                this.punctual = punctual;
            }

            public Object getInspect_punctual() {
                return inspect_punctual;
            }

            public void setInspect_punctual(Object inspect_punctual) {
                this.inspect_punctual = inspect_punctual;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getIdentity_type() {
                return identity_type;
            }

            public void setIdentity_type(int identity_type) {
                this.identity_type = identity_type;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public String getIdentity_type_text() {
                return identity_type_text;
            }

            public void setIdentity_type_text(String identity_type_text) {
                this.identity_type_text = identity_type_text;
            }

            public String getType_text() {
                return type_text;
            }

            public void setType_text(String type_text) {
                this.type_text = type_text;
            }
        }
    }
}
