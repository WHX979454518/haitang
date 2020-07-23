package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class ProjectDetailsBean implements Serializable {

    /**
     * data : {"work_style_ids":"1,2,3","uid":222,"project_title":"来来来121","id":1,"project_desc":"好的很","created_at":"2019-03-13 14:35:22","min_budget":"900.00","max_budget":"2400.00","work_type_ids":"1,2,3","secrecy_days":"3个月","work_use_ids":["视听平台","部分平台","全平台"],"use_channel_ids":["连续剧/动画、综艺","电视","网络"],"budget_text":"900-2.4K","member":{"level":"0","id":"222","nickname":"苏莘薇","head":"bdc31db9afdc124ad30eec393967aa2c70162bb9","reputation_score":"0.00"},"select_enroll_num":0,"enroll_num":0,"task":[{"enroll_num":0,"select_enroll_num":0,"work_type_title":"作曲","id":1,"min_budget":"300.00","max_budget":"8000.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":1,"budget_text":"300-8K","can_edit":0},{"enroll_num":0,"select_enroll_num":0,"work_type_title":"作词","id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":2,"budget_text":"300-800","can_edit":0},{"enroll_num":0,"select_enroll_num":0,"work_type_title":"歌手","id":3,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":3,"budget_text":"300-800","can_edit":0}],"is_collect":0,"share_url":"http://baidu.com?id=1","can_edit":0,"status_text":null,"work_style_arr":["国风","ACG","VC"],"work_type_arr":["作曲","作词","歌手"],"budget_range_text":"900-2.4K"}
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

    public static class DataBean implements Serializable{
        /**
         * work_style_ids : 1,2,3
         * uid : 222
         * project_title : 来来来121
         * id : 1
         * project_desc : 好的很
         * created_at : 2019-03-13 14:35:22
         * min_budget : 900.00
         * max_budget : 2400.00
         * work_type_ids : 1,2,3
         * secrecy_days : 3个月
         * work_use_ids : ["视听平台","部分平台","全平台"]
         * use_channel_ids : ["连续剧/动画、综艺","电视","网络"]
         * budget_text : 900-2.4K
         * member : {"level":"0","id":"222","nickname":"苏莘薇","head":"bdc31db9afdc124ad30eec393967aa2c70162bb9","reputation_score":"0.00"}
         * select_enroll_num : 0
         * enroll_num : 0
         * task : [{"enroll_num":0,"select_enroll_num":0,"work_type_title":"作曲","id":1,"min_budget":"300.00","max_budget":"8000.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":1,"budget_text":"300-8K","can_edit":0},{"enroll_num":0,"select_enroll_num":0,"work_type_title":"作词","id":2,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":2,"budget_text":"300-800","can_edit":0},{"enroll_num":0,"select_enroll_num":0,"work_type_title":"歌手","id":3,"min_budget":"300.00","max_budget":"800.00","recruit_days":30,"creation_days":30,"task_status":"审核中","created_at":"2019-03-22 16:47:43","uid":222,"work_type_id":3,"budget_text":"300-800","can_edit":0}]
         * is_collect : 0
         * share_url : http://baidu.com?id=1
         * can_edit : 0
         * status_text : null
         * work_style_arr : ["国风","ACG","VC"]
         * work_type_arr : ["作曲","作词","歌手"]
         * budget_range_text : 900-2.4K
         */

        private String work_style_ids;
        private int uid;
        private String project_title;
        private int id;
        private String project_desc;
        private String created_at;
        private String min_budget;
        private String max_budget;
        private String work_type_ids;
        private String secrecy_days;
        private String budget_text;
        private MemberBean member;
        private int select_enroll_num;
        private int enroll_num;
        private int is_collect;
        private String share_url;
        private int can_edit;
        private Object status_text;
        private String budget_range_text;
        private List<String> work_use_ids;
        private List<String> use_channel_ids;
        private List<TaskBean> task;
        private List<String> work_style_arr;
        private List<String> work_type_arr;

        public String getWork_style_ids() {
            return work_style_ids;
        }

        public void setWork_style_ids(String work_style_ids) {
            this.work_style_ids = work_style_ids;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getProject_title() {
            return project_title;
        }

        public void setProject_title(String project_title) {
            this.project_title = project_title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProject_desc() {
            return project_desc;
        }

        public void setProject_desc(String project_desc) {
            this.project_desc = project_desc;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
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

        public String getSecrecy_days() {
            return secrecy_days;
        }

        public void setSecrecy_days(String secrecy_days) {
            this.secrecy_days = secrecy_days;
        }

        public String getBudget_text() {
            return budget_text;
        }

        public void setBudget_text(String budget_text) {
            this.budget_text = budget_text;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public int getSelect_enroll_num() {
            return select_enroll_num;
        }

        public void setSelect_enroll_num(int select_enroll_num) {
            this.select_enroll_num = select_enroll_num;
        }

        public int getEnroll_num() {
            return enroll_num;
        }

        public void setEnroll_num(int enroll_num) {
            this.enroll_num = enroll_num;
        }

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getCan_edit() {
            return can_edit;
        }

        public void setCan_edit(int can_edit) {
            this.can_edit = can_edit;
        }

        public Object getStatus_text() {
            return status_text;
        }

        public void setStatus_text(Object status_text) {
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

        public static class MemberBean implements Serializable{
            /**
             * level : 0
             * id : 222
             * nickname : 苏莘薇
             * head : bdc31db9afdc124ad30eec393967aa2c70162bb9
             * reputation_score : 0.00
             */

            private String level;
            private String id;
            private String nickname;
            private String head;
            private String reputation_score;

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHead() {
                return head;
            }

            public void setHead(String head) {
                this.head = head;
            }

            public String getReputation_score() {
                return reputation_score;
            }

            public void setReputation_score(String reputation_score) {
                this.reputation_score = reputation_score;
            }
        }

        public static class TaskBean {
            /**
             * enroll_num : 0
             * select_enroll_num : 0
             * work_type_title : 作曲
             * id : 1
             * min_budget : 300.00
             * max_budget : 8000.00
             * recruit_days : 30
             * creation_days : 30
             * task_status : 审核中
             * created_at : 2019-03-22 16:47:43
             * uid : 222
             * work_type_id : 1
             * budget_text : 300-8K
             * can_edit : 0
             */

            private int enroll_num;
            private int select_enroll_num;
            private String work_type_title;
            private int id;
            private String min_budget;
            private String max_budget;
            private int recruit_days;
            private int creation_days;
            private String task_status;
            private String created_at;
            private int uid;
            private int work_type_id;
            private String budget_text;
            private int can_edit;

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

            public String getTask_status() {
                return task_status;
            }

            public void setTask_status(String task_status) {
                this.task_status = task_status;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
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

            public String getBudget_text() {
                return budget_text;
            }

            public void setBudget_text(String budget_text) {
                this.budget_text = budget_text;
            }

            public int getCan_edit() {
                return can_edit;
            }

            public void setCan_edit(int can_edit) {
                this.can_edit = can_edit;
            }
        }
    }
}
