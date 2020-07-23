package com.mxkj.htmusic.mymodule.bean;

import java.io.Serializable;
import java.util.List;

public class MyProjectRecruitBean implements Serializable {

    /**
     * data : [{"id":6,"uid":52490,"project_type_id":1,"project_title":"15200000000的项目","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"work_type_ids":"1,2,3","project_desc":"好的很","secrecy_days":"3个月","work_style_ids":"1,2,3","project_status":3,"stop_reason":"","stop_at":"","check_reason":"过","check_at":"2019-03-30 09:48:59","enroll_num":3,"min_budget":"900.00","max_budget":"2400.00","collect_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","share_counts":0,"task":[{"id":16,"uid":52490,"project_id":6,"work_type_id":1,"min_budget":"500.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:43","recruit_days_at":"","enroll_num":3,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":46,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":47,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":48,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":"","file_type_text":"音频","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"},{"id":17,"uid":52490,"project_id":6,"work_type_id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:44","recruit_days_at":"","enroll_num":3,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":49,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":50,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":51,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":2,"title":"作词","en_title":"zuoci","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作词","file_format":"PNG/JPEG","file_type":3,"status":1,"created_at":"2019-03-12 09:47:05","updated_at":"2019-03-12 09:47:06","deleted_at":"","file_type_text":"图片","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"},{"id":18,"uid":52490,"project_id":6,"work_type_id":3,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:45","recruit_days_at":"","enroll_num":0,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":52,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":53,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":54,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":3,"title":"歌手","en_title":"geshou","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是唱歌","file_format":"FLV/3GP","file_type":2,"status":1,"created_at":"2019-03-12 09:48:09","updated_at":"2019-03-12 09:48:10","deleted_at":"","file_type_text":"视频","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"}],"sea_member":{"uid":52490,"require_finish_rate":"0.00","require_credit_score":"0.00","head":"3d3d27527715c56204c6e063e34883ae60384a97","nickname":"用户641941","head_info":{"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}},"status_text":"招募中","work_style_arr":["无","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"900-2.4K"}]
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
         * id : 6
         * uid : 52490
         * project_type_id : 1
         * project_title : 15200000000的项目
         * work_use_ids : ["视听平台","部分平台","全平台"]
         * use_channel_ids : ["连续剧/动画、综艺","电视","网络"]
         * work_type_ids : 1,2,3
         * project_desc : 好的很
         * secrecy_days : 3个月
         * work_style_ids : 1,2,3
         * project_status : 3
         * stop_reason :
         * stop_at :
         * check_reason : 过
         * check_at : 2019-03-30 09:48:59
         * enroll_num : 3
         * min_budget : 900.00
         * max_budget : 2400.00
         * collect_num : 0
         * created_at : 2019-03-30 09:47:46
         * updated_at : 2019-03-30 09:47:46
         * deleted_at :
         * share_counts : 0
         * task : [{"id":16,"uid":52490,"project_id":6,"work_type_id":1,"min_budget":"500.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:43","recruit_days_at":"","enroll_num":3,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":46,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":47,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":48,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":"","file_type_text":"音频","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"},{"id":17,"uid":52490,"project_id":6,"work_type_id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:44","recruit_days_at":"","enroll_num":3,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":49,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":50,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":51,"uid":"52490","project_id":6,"project_task_id":17,"progress_name":"作词试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":2,"title":"作词","en_title":"zuoci","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作词","file_format":"PNG/JPEG","file_type":3,"status":1,"created_at":"2019-03-12 09:47:05","updated_at":"2019-03-12 09:47:06","deleted_at":"","file_type_text":"图片","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"},{"id":18,"uid":52490,"project_id":6,"work_type_id":3,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":1,"stop_reason":"","stop_at":"","is_delay":1,"delay_days":"","is_delay_at":"","check_reason":"过","check_at":"2019-03-30 10:04:45","recruit_days_at":"","enroll_num":0,"select_enroll_num":0,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":"","task_progress":[{"id":52,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":53,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":54,"uid":"52490","project_id":6,"project_task_id":18,"progress_name":"唱歌试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}],"work_type":{"id":3,"title":"歌手","en_title":"geshou","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是唱歌","file_format":"FLV/3GP","file_type":2,"status":1,"created_at":"2019-03-12 09:48:09","updated_at":"2019-03-12 09:48:10","deleted_at":"","file_type_text":"视频","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}},"status_text":"审核中"}]
         * sea_member : {"uid":52490,"require_finish_rate":"0.00","require_credit_score":"0.00","head":"3d3d27527715c56204c6e063e34883ae60384a97","nickname":"用户641941","head_info":{"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}}
         * status_text : 招募中
         * work_style_arr : ["无","ACG","VC"]
         * work_type_arr : ["作曲","作词","歌手"]
         * budget_range_text : 900-2.4K
         */

        private int id;
        private int uid;
        private int project_type_id;
        private String project_title;
        private String work_type_ids;
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
        private int collect_num;
        private String created_at;
        private String updated_at;
        private String deleted_at;
        private int share_counts;
        private SeaMemberBean sea_member;
        private String status_text;
        private String budget_range_text;
        private List<String> work_use_ids;
        private List<String> use_channel_ids;
        private List<TaskBean> task;
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

        public String getWork_type_ids() {
            return work_type_ids;
        }

        public void setWork_type_ids(String work_type_ids) {
            this.work_type_ids = work_type_ids;
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

        public SeaMemberBean getSea_member() {
            return sea_member;
        }

        public void setSea_member(SeaMemberBean sea_member) {
            this.sea_member = sea_member;
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

        public List<TaskBean> getTask() {
            return task;
        }

        public void setTask(List<TaskBean> task) {
            this.task = task;
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

        public static class SeaMemberBean implements Serializable{
            /**
             * uid : 52490
             * require_finish_rate : 0.00
             * require_credit_score : 0.00
             * head : 3d3d27527715c56204c6e063e34883ae60384a97
             * nickname : 用户641941
             * head_info : {"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}
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

        public static class TaskBean {
            /**
             * id : 16
             * uid : 52490
             * project_id : 6
             * work_type_id : 1
             * min_budget : 500.00
             * max_budget : 800.00
             * recruit_days : 30
             * creation_days : 30
             * task_status : 1
             * stop_reason :
             * stop_at :
             * is_delay : 1
             * delay_days :
             * is_delay_at :
             * check_reason : 过
             * check_at : 2019-03-30 10:04:43
             * recruit_days_at :
             * enroll_num : 3
             * select_enroll_num : 0
             * created_at : 2019-03-30 09:47:46
             * updated_at : 2019-03-30 09:47:46
             * deleted_at :
             * task_progress : [{"id":46,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听1","deposit_rate":20,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":47,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听2","deposit_rate":30,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""},{"id":48,"uid":"52490","project_id":6,"project_task_id":16,"progress_name":"作曲试听3","deposit_rate":50,"created_at":"2019-03-30 09:47:46","updated_at":"2019-03-30 09:47:46","deleted_at":""}]
             * work_type : {"id":1,"title":"作曲","en_title":"zuoqu","icon":"FE4146FBA6350ACBE1741D791D707532","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":"","file_type_text":"音频","status_text":"是","icon_info":{"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}}
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
            private WorkTypeBean work_type;
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

            public List<TaskProgressBean> getTask_progress() {
                return task_progress;
            }

            public void setTask_progress(List<TaskProgressBean> task_progress) {
                this.task_progress = task_progress;
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
                 * deleted_at :
                 * file_type_text : 音频
                 * status_text : 是
                 * icon_info : {"ext":"jpg","w":"2448","h":"3264","size":"682882","is_long":"0","md5":"FE4146FBA6350ACBE1741D791D707532","link":"http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3"}
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
                private IconInfoBean icon_info;

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

                public IconInfoBean getIcon_info() {
                    return icon_info;
                }

                public void setIcon_info(IconInfoBean icon_info) {
                    this.icon_info = icon_info;
                }

                public static class IconInfoBean {
                    /**
                     * ext : jpg
                     * w : 2448
                     * h : 3264
                     * size : 682882
                     * is_long : 0
                     * md5 : FE4146FBA6350ACBE1741D791D707532
                     * link : http://testapi.imxkj.com//image/FE4146FBA6350ACBE1741D791D707532/3
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

            public static class TaskProgressBean {
                /**
                 * id : 46
                 * uid : 52490
                 * project_id : 6
                 * project_task_id : 16
                 * progress_name : 作曲试听1
                 * deposit_rate : 20
                 * created_at : 2019-03-30 09:47:46
                 * updated_at : 2019-03-30 09:47:46
                 * deleted_at :
                 */

                private int id;
                private String uid;
                private int project_id;
                private int project_task_id;
                private String progress_name;
                private int deposit_rate;
                private String created_at;
                private String updated_at;
                private String deleted_at;

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

                public String getDeleted_at() {
                    return deleted_at;
                }

                public void setDeleted_at(String deleted_at) {
                    this.deleted_at = deleted_at;
                }
            }
        }
    }
}
