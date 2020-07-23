package com.mxkj.htmusic.toolmodule.base.bean;


import java.io.Serializable;


public class UserInfo implements Serializable {

    /**
     * data : {"uid":51322,"fish":"0.00","school":"","last_login_time":1553239320,"last_login_ip":"192.168.1.187","area_code":86,"mobile":"139****5555","nickname":"源音塘214295","password":"37e8550794efabfef027ed6e03c47e79","sex":2,"create_time":0,"signature":"","head":"3d3d27527715c56204c6e063e34883ae60384a97","email":"","province":"","city":"","state":1,"back":"95aedf87a3ec22279d8c21a34a7b0e0dddbd5947","vip":0,"sea_status":1,"id":51322,"day":"","qq":"","city_name":"","province_name":"","is_auth":0,"login_day":0,"distinction":0,"active_day":0,"login_times":1,"level":0,"experience_val":0,"follow_number":0,"fans_number":0,"cooperation_offer":"","self_evaluation":"","musician_finish_rate":"0.00","require_finish_rate":"0.00","musician_credit_score":"0.00","require_credit_score":"0.00","auth_work_type_text":"","auth_work_type":"","auth_musician":-1,"display_works":"","works_number":0,"spread_sort":0,"works_desc":"","recruit_desc":"","head_info":{"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}}
     * code : 200
     * msg : 设置密码成功
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
         * uid : 51322
         * fish : 0.00
         * school :
         * last_login_time : 1553239320
         * last_login_ip : 192.168.1.187
         * area_code : 86
         * mobile : 139****5555
         * nickname : 源音塘214295
         * password : 37e8550794efabfef027ed6e03c47e79
         * sex : 2
         * create_time : 0
         * signature :
         * head : 3d3d27527715c56204c6e063e34883ae60384a97
         * email :
         * province :
         * city :
         * state : 1
         * back : 95aedf87a3ec22279d8c21a34a7b0e0dddbd5947
         * vip : 0
         * sea_status : 1
         * id : 51322
         * day :
         * qq :
         * city_name :
         * province_name :
         * is_auth : 0
         * login_day : 0
         * distinction : 0
         * active_day : 0
         * login_times : 1
         * level : 0
         * experience_val : 0
         * follow_number : 0
         * fans_number : 0
         * cooperation_offer :
         * self_evaluation :
         * musician_finish_rate : 0.00
         * require_finish_rate : 0.00
         * musician_credit_score : 0.00
         * require_credit_score : 0.00
         * auth_work_type_text :
         * auth_work_type :
         * auth_musician : -1
         * display_works :
         * works_number : 0
         * spread_sort : 0
         * works_desc :
         * recruit_desc :
         * head_info : {"ext":"jpg","w":"330","h":"333","size":"15105","is_long":"0","md5":"3d3d27527715c56204c6e063e34883ae60384a97","link":"http://testapi.imxkj.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3"}
         */

        private int uid;
        private String fish;
        private String school;
        private int last_login_time;
        private String last_login_ip;
        private int area_code;
        private String mobile;
        private String nickname;
        private String password;
        private int sex;
        private int create_time;
        private String signature;
        private String head;
        private String email;
        private String province;
        private String city;
        private int state;
        private String back;
        private int vip;
        private int sea_status;
        private int id;
        private String day;
        private String qq;
        private String city_name;
        private String province_name;
        private int is_auth;
        private int login_day;
        private int distinction;
        private int active_day;
        private int login_times;
        private int level;
        private int experience_val;
        private int follow_number;
        private int fans_number;
        private String cooperation_offer;
        private String self_evaluation;
        private String musician_finish_rate;
        private String require_finish_rate;
        private String musician_credit_score;
        private String require_credit_score;
        private String auth_work_type_text;
        private String auth_work_type;
        private int auth_musician;
        private String display_works;
        private int works_number;
        private int spread_sort;
        private String works_desc;
        private String recruit_desc;
        private HeadInfoBean head_info;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getFish() {
            return fish;
        }

        public void setFish(String fish) {
            this.fish = fish;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public int getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(int last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getLast_login_ip() {
            return last_login_ip;
        }

        public void setLast_login_ip(String last_login_ip) {
            this.last_login_ip = last_login_ip;
        }

        public int getArea_code() {
            return area_code;
        }

        public void setArea_code(int area_code) {
            this.area_code = area_code;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getBack() {
            return back;
        }

        public void setBack(String back) {
            this.back = back;
        }

        public int getVip() {
            return vip;
        }

        public void setVip(int vip) {
            this.vip = vip;
        }

        public int getSea_status() {
            return sea_status;
        }

        public void setSea_status(int sea_status) {
            this.sea_status = sea_status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public int getIs_auth() {
            return is_auth;
        }

        public void setIs_auth(int is_auth) {
            this.is_auth = is_auth;
        }

        public int getLogin_day() {
            return login_day;
        }

        public void setLogin_day(int login_day) {
            this.login_day = login_day;
        }

        public int getDistinction() {
            return distinction;
        }

        public void setDistinction(int distinction) {
            this.distinction = distinction;
        }

        public int getActive_day() {
            return active_day;
        }

        public void setActive_day(int active_day) {
            this.active_day = active_day;
        }

        public int getLogin_times() {
            return login_times;
        }

        public void setLogin_times(int login_times) {
            this.login_times = login_times;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getExperience_val() {
            return experience_val;
        }

        public void setExperience_val(int experience_val) {
            this.experience_val = experience_val;
        }

        public int getFollow_number() {
            return follow_number;
        }

        public void setFollow_number(int follow_number) {
            this.follow_number = follow_number;
        }

        public int getFans_number() {
            return fans_number;
        }

        public void setFans_number(int fans_number) {
            this.fans_number = fans_number;
        }

        public String getCooperation_offer() {
            return cooperation_offer;
        }

        public void setCooperation_offer(String cooperation_offer) {
            this.cooperation_offer = cooperation_offer;
        }

        public String getSelf_evaluation() {
            return self_evaluation;
        }

        public void setSelf_evaluation(String self_evaluation) {
            this.self_evaluation = self_evaluation;
        }

        public String getMusician_finish_rate() {
            return musician_finish_rate;
        }

        public void setMusician_finish_rate(String musician_finish_rate) {
            this.musician_finish_rate = musician_finish_rate;
        }

        public String getRequire_finish_rate() {
            return require_finish_rate;
        }

        public void setRequire_finish_rate(String require_finish_rate) {
            this.require_finish_rate = require_finish_rate;
        }

        public String getMusician_credit_score() {
            return musician_credit_score;
        }

        public void setMusician_credit_score(String musician_credit_score) {
            this.musician_credit_score = musician_credit_score;
        }

        public String getRequire_credit_score() {
            return require_credit_score;
        }

        public void setRequire_credit_score(String require_credit_score) {
            this.require_credit_score = require_credit_score;
        }

        public String getAuth_work_type_text() {
            return auth_work_type_text;
        }

        public void setAuth_work_type_text(String auth_work_type_text) {
            this.auth_work_type_text = auth_work_type_text;
        }

        public String getAuth_work_type() {
            return auth_work_type;
        }

        public void setAuth_work_type(String auth_work_type) {
            this.auth_work_type = auth_work_type;
        }

        public int getAuth_musician() {
            return auth_musician;
        }

        public void setAuth_musician(int auth_musician) {
            this.auth_musician = auth_musician;
        }

        public String getDisplay_works() {
            return display_works;
        }

        public void setDisplay_works(String display_works) {
            this.display_works = display_works;
        }

        public int getWorks_number() {
            return works_number;
        }

        public void setWorks_number(int works_number) {
            this.works_number = works_number;
        }

        public int getSpread_sort() {
            return spread_sort;
        }

        public void setSpread_sort(int spread_sort) {
            this.spread_sort = spread_sort;
        }

        public String getWorks_desc() {
            return works_desc;
        }

        public void setWorks_desc(String works_desc) {
            this.works_desc = works_desc;
        }

        public String getRecruit_desc() {
            return recruit_desc;
        }

        public void setRecruit_desc(String recruit_desc) {
            this.recruit_desc = recruit_desc;
        }

        public HeadInfoBean getHead_info() {
            return head_info;
        }

        public void setHead_info(HeadInfoBean head_info) {
            this.head_info = head_info;
        }

        public static class HeadInfoBean {
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
}
//package com.mxkj.haitang.toolmodule.base.bean;
//
//
//import java.io.Serializable;
//import java.util.List;
//
//
//public class UserInfo implements Serializable {
//
//    private int code;
//    private String msg;
//    private DataBean data;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public static class DataBean implements Serializable {
//        public int getTo_relation() {
//            return to_relation;
//        }
//        public void setTo_relation(int to_relation) {
//            this.to_relation = to_relation;
//        }
//
//        /**
//         * id : 50963
//         * source : 0
//         * mobile :
//         * nickname : 4月
//         * easemob : 1
//         * sex : 0
//         * signature :
//         * head : 3d3d27527715c56204c6e063e34883ae60384a97
//         * back : 95aedf87a3ec22279d8c21a34a7b0e0dddbd5947
//         * email :
//         * province : 1
//         * city : 34
//         * reg_time : 1524555037
//         * reg_ip : 192.168.1.50
//         * ips_num : 0
//         * tip :
//         * qq :
//         * day : 2018-04-24
//         * last_login_time : 1534487256
//         * last_login_ip : 192.168.1.50
//         * is_auth : 1
//         * is_music : 0
//         * incode :
//         * tag :
//         * mycode : YPX2EJ
//         * coin_counts : 299409
//         * x : 104.0647
//         * y : 30.548356
//         * auth_state : 0
//         * distinction : 0
//         * share_counts : 0
//         * log_num : 24
//         * log_at : 1
//         * fans_num : 0
//         * today_coin : 0
//         * comment_counts : 0
//         * fish : 10000
//         * interest_tag : [{"id":0,"title":"翻唱","code":"interest_music_type","selected":1},{"id":1,"title":"原创 ","code":"interest_music_type","selected":1},{"id":5,"title":"动漫游戏","code":"interest_music_class","selected":1},{"id":6,"title":"古风","code":"interest_music_class","selected":1},{"id":7,"title":"三次元","code":"interest_music_class","selected":0},{"id":19,"title":"Vocaloid","code":"interest_music_class","selected":0},{"id":22,"title":"活动作品","code":"interest_music_class","selected":0},{"id":222,"title":"招募","code":"interest_tag_class","selected":0},{"id":256,"title":"游戏","code":"interest_tag_class","selected":0},{"id":314,"title":"技能GET","code":"interest_tag_class","selected":0}]
//         * identity_tag : [{"id":420,"title":"身份的标签1","code":"identity","selected":0},{"id":421,"title":"身份的标签2","code":"identity","selected":0},{"id":438,"title":"shenf1","code":"identity","selected":0},{"id":442,"title":"音乐人","code":"musician","selected":0},{"id":462,"title":"身份标签1","code":"identity","selected":0},{"id":463,"title":"身份标签2","code":"identity","selected":0},{"id":464,"title":"音乐人1","code":"musician","selected":0}]
//         * day_txt : 04-24
//         * province_text : 北京市
//         * city_text : 北京市
//         * bind : [{"id":1746,"type":1,"nickname":"4月","name":"4月","head":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjHnUTMRMZ9XwWLePLVtzotc3J58AibbibbVoggz3KicPDSLVoibJNMVibj0Iw1cjQ8c460tqq5A1WprQ/132","openid":"o1tB2wZd1MUtHsfn2rzZTacz26So","head_link":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjHnUTMRMZ9XwWLePLVtzotc3J58AibbibbVoggz3KicPDSLVoibJNMVibj0Iw1cjQ8c460tqq5A1WprQ/132"}]
//         * count : {"attention":39,"fans":0,"coin_counts":299409,"playlogCount":16,"releaseCount":0,"collection":2,"collectionCount":0,"topicCount":0,"songCount":1,"mycodeCount":0,"musicCount":0,"collection_text":"2"}
//         * attention_num : 39
//         * share_mycode_url : http://wap.demo.com/invite?code=YPX2EJ
//         * share_mycode_url_link : http://api.demo.com/files/image/incode/code/YPX2EJ
//         * number :
//         * realname :
//         * logintoken : E9AC87689FA17174884C47BD0359F69A
//         * device_token : AkmtXhbQ03XuiDON_Xla3WVrQlC-R9iiZXmxgamHpD7B
//         * head_link : http://testapi.demo.com//image/3d3d27527715c56204c6e063e34883ae60384a97/3
//         * head_info :
//         * back_link : http://testapi.demo.com//image/95aedf87a3ec22279d8c21a34a7b0e0dddbd5947/3
//         * back_info :
//         * share_counts_text : 0
//         */
//
//        private int id;
//        private int code;
//
//        public int getCode() {
//            return code;
//        }
//
//        public void setCode(int code) {
//            this.code = code;
//        }
//        private int is_relation;
//        private int to_relation;
//        private int source;
//        private String age;
//        private String mobile;
//        private String nickname;
//        private int easemob;
//        private int sex;
//        private String signature;
//        private String head;
//        private String back;
//        private String email;
//        private int province;
//        private int city;
//        private int reg_time;
//        private String reg_ip;
//        private int ips_num;
//        private String tip;
//        private String qq;
//        private String day;
//        private int last_login_time;
//        private String last_login_ip;
//        private int is_auth;
//        private int is_music;
//        private String incode;
//        private String tag;
//        private String mycode;
//        private int coin_counts;
//        private double x;
//        private double y;
//        private int auth_state;
//        private int distinction;
//        private int share_counts;
//        private int log_num;
//        private int log_at;
//        private int fans_num;
//        private int today_coin;
//        private int comment_counts;
//        private int fish;
//        private int play_log_counts;
//        private String day_txt;
//        private String province_text;
//        private String city_text;
//        private CountBean count;
//        private int attention_num;
//        private int release_num;
//        private String share_mycode_url;
//        private String share_mycode_url_link;
//        private String number;
//        private String realname;
//        private String logintoken;
//        private String device_token;
//        private String head_link;
//        private String head_info;
//        private String back_link;
//        private String back_info;
//        private String share_counts_text;
//
//        private String is_self;
//
//        private List<InterestTagBean> interest_tag;
//        private List<IdentityTagBean> identity_tag;
//        private List<BindBean> bind;
//
//        private List<MusicBean> music;
//
//        public List<MusicBean> getMusic() {
//            return music;
//        }
//
//        public void setMusic(List<MusicBean> music) {
//            this.music = music;
//        }
//
//        public String getIs_self() {
//            return is_self;
//        }
//
//        public void setIs_self(String is_self) {
//            this.is_self = is_self;
//        }
//
//        public String getAge() {
//            return age;
//        }
//
//        public void setAge(String age) {
//            this.age = age;
//        }
//
//        public int getRelease_num() {
//            return release_num;
//        }
//
//        public void setRelease_num(int release_num) {
//            this.release_num = release_num;
//        }
//
//        public int getPlay_log_counts() {
//            return play_log_counts;
//        }
//
//        public void setPlay_log_counts(int play_log_counts) {
//            this.play_log_counts = play_log_counts;
//        }
//
//        public int getIs_relation() {
//            return is_relation;
//        }
//
//        public void setIs_relation(int is_relation) {
//            this.is_relation = is_relation;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public int getSource() {
//            return source;
//        }
//
//        public void setSource(int source) {
//            this.source = source;
//        }
//
//        public String getMobile() {
//            return mobile;
//        }
//
//        public void setMobile(String mobile) {
//            this.mobile = mobile;
//        }
//
//        public String getNickname() {
//            return nickname;
//        }
//
//        public void setNickname(String nickname) {
//            this.nickname = nickname;
//        }
//
//        public int getEasemob() {
//            return easemob;
//        }
//
//        public void setEasemob(int easemob) {
//            this.easemob = easemob;
//        }
//
//        public int getSex() {
//            return sex;
//        }
//
//        public void setSex(int sex) {
//            this.sex = sex;
//        }
//
//        public String getSignature() {
//            return signature;
//        }
//
//        public void setSignature(String signature) {
//            this.signature = signature;
//        }
//
//        public String getHead() {
//            return head;
//        }
//
//        public void setHead(String head) {
//            this.head = head;
//        }
//
//        public String getBack() {
//            return back;
//        }
//
//        public void setBack(String back) {
//            this.back = back;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public int getProvince() {
//            return province;
//        }
//
//        public void setProvince(int province) {
//            this.province = province;
//        }
//
//        public int getCity() {
//            return city;
//        }
//
//        public void setCity(int city) {
//            this.city = city;
//        }
//
//        public int getReg_time() {
//            return reg_time;
//        }
//
//        public void setReg_time(int reg_time) {
//            this.reg_time = reg_time;
//        }
//
//        public String getReg_ip() {
//            return reg_ip;
//        }
//
//        public void setReg_ip(String reg_ip) {
//            this.reg_ip = reg_ip;
//        }
//
//        public int getIps_num() {
//            return ips_num;
//        }
//
//        public void setIps_num(int ips_num) {
//            this.ips_num = ips_num;
//        }
//
//        public String getTip() {
//            return tip;
//        }
//
//        public void setTip(String tip) {
//            this.tip = tip;
//        }
//
//        public String getQq() {
//            return qq;
//        }
//
//        public void setQq(String qq) {
//            this.qq = qq;
//        }
//
//        public String getDay() {
//            return day;
//        }
//
//        public void setDay(String day) {
//            this.day = day;
//        }
//
//        public int getLast_login_time() {
//            return last_login_time;
//        }
//
//        public void setLast_login_time(int last_login_time) {
//            this.last_login_time = last_login_time;
//        }
//
//        public String getLast_login_ip() {
//            return last_login_ip;
//        }
//
//        public void setLast_login_ip(String last_login_ip) {
//            this.last_login_ip = last_login_ip;
//        }
//
//        public int getIs_auth() {
//            return is_auth;
//        }
//
//        public void setIs_auth(int is_auth) {
//            this.is_auth = is_auth;
//        }
//
//        public int getIs_music() {
//            return is_music;
//        }
//
//        public void setIs_music(int is_music) {
//            this.is_music = is_music;
//        }
//
//        public String getIncode() {
//            return incode;
//        }
//
//        public void setIncode(String incode) {
//            this.incode = incode;
//        }
//
//        public String getTag() {
//            return tag;
//        }
//
//        public void setTag(String tag) {
//            this.tag = tag;
//        }
//
//        public String getMycode() {
//            return mycode;
//        }
//
//        public void setMycode(String mycode) {
//            this.mycode = mycode;
//        }
//
//        public int getCoin_counts() {
//            return coin_counts;
//        }
//
//        public void setCoin_counts(int coin_counts) {
//            this.coin_counts = coin_counts;
//        }
//
//        public double getX() {
//            return x;
//        }
//
//        public void setX(double x) {
//            this.x = x;
//        }
//
//        public double getY() {
//            return y;
//        }
//
//        public void setY(double y) {
//            this.y = y;
//        }
//
//        public int getAuth_state() {
//            return auth_state;
//        }
//
//        public void setAuth_state(int auth_state) {
//            this.auth_state = auth_state;
//        }
//
//        public int getDistinction() {
//            return distinction;
//        }
//
//        public void setDistinction(int distinction) {
//            this.distinction = distinction;
//        }
//
//        public int getShare_counts() {
//            return share_counts;
//        }
//
//        public void setShare_counts(int share_counts) {
//            this.share_counts = share_counts;
//        }
//
//        public int getLog_num() {
//            return log_num;
//        }
//
//        public void setLog_num(int log_num) {
//            this.log_num = log_num;
//        }
//
//        public int getLog_at() {
//            return log_at;
//        }
//
//        public void setLog_at(int log_at) {
//            this.log_at = log_at;
//        }
//
//        public int getFans_num() {
//            return fans_num;
//        }
//
//        public void setFans_num(int fans_num) {
//            this.fans_num = fans_num;
//        }
//
//        public int getToday_coin() {
//            return today_coin;
//        }
//
//        public void setToday_coin(int today_coin) {
//            this.today_coin = today_coin;
//        }
//
//        public int getComment_counts() {
//            return comment_counts;
//        }
//
//        public void setComment_counts(int comment_counts) {
//            this.comment_counts = comment_counts;
//        }
//
//        public int getFish() {
//            return fish;
//        }
//
//        public void setFish(int fish) {
//            this.fish = fish;
//        }
//
//        public String getDay_txt() {
//            return day_txt;
//        }
//
//        public void setDay_txt(String day_txt) {
//            this.day_txt = day_txt;
//        }
//
//        public String getProvince_text() {
//            return province_text;
//        }
//
//        public void setProvince_text(String province_text) {
//            this.province_text = province_text;
//        }
//
//        public String getCity_text() {
//            return city_text;
//        }
//
//        public void setCity_text(String city_text) {
//            this.city_text = city_text;
//        }
//
//        public CountBean getCount() {
//            return count;
//        }
//
//        public void setCount(CountBean count) {
//            this.count = count;
//        }
//
//        public int getAttention_num() {
//            return attention_num;
//        }
//
//        public void setAttention_num(int attention_num) {
//            this.attention_num = attention_num;
//        }
//
//        public String getShare_mycode_url() {
//            return share_mycode_url;
//        }
//
//        public void setShare_mycode_url(String share_mycode_url) {
//            this.share_mycode_url = share_mycode_url;
//        }
//
//        public String getShare_mycode_url_link() {
//            return share_mycode_url_link;
//        }
//
//        public void setShare_mycode_url_link(String share_mycode_url_link) {
//            this.share_mycode_url_link = share_mycode_url_link;
//        }
//
//        public String getNumber() {
//            return number;
//        }
//
//        public void setNumber(String number) {
//            this.number = number;
//        }
//
//        public String getRealname() {
//            return realname;
//        }
//
//        public void setRealname(String realname) {
//            this.realname = realname;
//        }
//
//        public String getLogintoken() {
//            return logintoken;
//        }
//
//        public void setLogintoken(String logintoken) {
//            this.logintoken = logintoken;
//        }
//
//        public String getDevice_token() {
//            return device_token;
//        }
//
//        public void setDevice_token(String device_token) {
//            this.device_token = device_token;
//        }
//
//        public String getHead_link() {
//            return head_link;
//        }
//
//        public void setHead_link(String head_link) {
//            this.head_link = head_link;
//        }
//
//        public String getHead_info() {
//            return head_info;
//        }
//
//        public void setHead_info(String head_info) {
//            this.head_info = head_info;
//        }
//
//        public String getBack_link() {
//            return back_link;
//        }
//
//        public void setBack_link(String back_link) {
//            this.back_link = back_link;
//        }
//
//        public String getBack_info() {
//            return back_info;
//        }
//
//        public void setBack_info(String back_info) {
//            this.back_info = back_info;
//        }
//
//        public String getShare_counts_text() {
//            return share_counts_text;
//        }
//
//        public void setShare_counts_text(String share_counts_text) {
//            this.share_counts_text = share_counts_text;
//        }
//
//        public List<InterestTagBean> getInterest_tag() {
//            return interest_tag;
//        }
//
//        public void setInterest_tag(List<InterestTagBean> interest_tag) {
//            this.interest_tag = interest_tag;
//        }
//
//        public List<IdentityTagBean> getIdentity_tag() {
//            return identity_tag;
//        }
//
//        public void setIdentity_tag(List<IdentityTagBean> identity_tag) {
//            this.identity_tag = identity_tag;
//        }
//
//        public List<BindBean> getBind() {
//            return bind;
//        }
//
//        public void setBind(List<BindBean> bind) {
//            this.bind = bind;
//        }
//
////        @Override
//        public int getItemType() {
//            return 0;
//        }
//
//        public static class CountBean implements Serializable {
//            /**
//             * attention : 39
//             * fans : 0
//             * coin_counts : 299409
//             * playlogCount : 16
//             * releaseCount : 0
//             * collection : 2
//             * collectionCount : 0
//             * topicCount : 0
//             * songCount : 1
//             * mycodeCount : 0
//             * musicCount : 0
//             * collection_text : 2
//             */
//
//            private int attention;
//            private int fans;
//            private int coin_counts;
//            private int playlogCount=0;
//            private int releaseCount;
//            private int collection;
//            private int collectionCount;
//            private int topicCount;
//            private int songCount;
//            private int mycodeCount;
//            private int musicCount;
//            private String collection_text;
//
//            public int getAttention() {
//                return attention;
//            }
//
//            public void setAttention(int attention) {
//                this.attention = attention;
//            }
//
//            public int getFans() {
//                return fans;
//            }
//
//            public void setFans(int fans) {
//                this.fans = fans;
//            }
//
//            public int getCoin_counts() {
//                return coin_counts;
//            }
//
//            public void setCoin_counts(int coin_counts) {
//                this.coin_counts = coin_counts;
//            }
//
//            public int getPlaylogCount() {
//                return playlogCount;
//            }
//
//            public void setPlaylogCount(int playlogCount) {
//                this.playlogCount = playlogCount;
//            }
//
//            public int getReleaseCount() {
//                return releaseCount;
//            }
//
//            public void setReleaseCount(int releaseCount) {
//                this.releaseCount = releaseCount;
//            }
//
//            public int getCollection() {
//                return collection;
//            }
//
//            public void setCollection(int collection) {
//                this.collection = collection;
//            }
//
//            public int getCollectionCount() {
//                return collectionCount;
//            }
//
//            public void setCollectionCount(int collectionCount) {
//                this.collectionCount = collectionCount;
//            }
//
//            public int getTopicCount() {
//                return topicCount;
//            }
//
//            public void setTopicCount(int topicCount) {
//                this.topicCount = topicCount;
//            }
//
//            public int getSongCount() {
//                return songCount;
//            }
//
//            public void setSongCount(int songCount) {
//                this.songCount = songCount;
//            }
//
//            public int getMycodeCount() {
//                return mycodeCount;
//            }
//
//            public void setMycodeCount(int mycodeCount) {
//                this.mycodeCount = mycodeCount;
//            }
//
//            public int getMusicCount() {
//                return musicCount;
//            }
//
//            public void setMusicCount(int musicCount) {
//                this.musicCount = musicCount;
//            }
//
//            public String getCollection_text() {
//                return collection_text;
//            }
//
//            public void setCollection_text(String collection_text) {
//                this.collection_text = collection_text;
//            }
//        }
//
//        public static class InterestTagBean implements Serializable {
//            /**
//             * id : 0
//             * title : 翻唱
//             * code : interest_music_type
//             * selected : 1
//             */
//
//            private int id;
//            private String title;
//            private String code;
//            private int selected;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public void setCode(String code) {
//                this.code = code;
//            }
//
//            public int getSelected() {
//                return selected;
//            }
//
//            public void setSelected(int selected) {
//                this.selected = selected;
//            }
//        }
//
//        public static class IdentityTagBean implements Serializable {
//            /**
//             * id : 420
//             * title : 身份的标签1
//             * code : identity
//             * selected : 0
//             */
//
//            private int id;
//            private String title;
//            private String code;
//            private int selected;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public void setCode(String code) {
//                this.code = code;
//            }
//
//            public int getSelected() {
//                return selected;
//            }
//
//            public void setSelected(int selected) {
//                this.selected = selected;
//            }
//        }
//
//        public static class BindBean implements Serializable {
//            /**
//             * id : 1746
//             * type : 1
//             * nickname : 4月
//             * name : 4月
//             * head : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjHnUTMRMZ9XwWLePLVtzotc3J58AibbibbVoggz3KicPDSLVoibJNMVibj0Iw1cjQ8c460tqq5A1WprQ/132
//             * openid : o1tB2wZd1MUtHsfn2rzZTacz26So
//             * head_link : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjHnUTMRMZ9XwWLePLVtzotc3J58AibbibbVoggz3KicPDSLVoibJNMVibj0Iw1cjQ8c460tqq5A1WprQ/132
//             */
//
//            private int id;
//            private int type;
//            private String nickname;
//            private String name;
//            private String head;
//            private String openid;
//            private String head_link;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public int getType() {
//                return type;
//            }
//
//            public void setType(int type) {
//                this.type = type;
//            }
//
//            public String getNickname() {
//                return nickname;
//            }
//
//            public void setNickname(String nickname) {
//                this.nickname = nickname;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getHead() {
//                return head;
//            }
//
//            public void setHead(String head) {
//                this.head = head;
//            }
//
//            public String getOpenid() {
//                return openid;
//            }
//
//            public void setOpenid(String openid) {
//                this.openid = openid;
//            }
//
//            public String getHead_link() {
//                return head_link;
//            }
//
//            public void setHead_link(String head_link) {
//                this.head_link = head_link;
//            }
//        }
//
//        public static class MusicBean implements Serializable {
//            /**
//             * item_id : 1746
//             * title : "【翻唱】若当来世—《狐妖小红娘》OP"
//             */
//
//            private int item_id;
//            private String title;
//
//            @Override
//            public String toString() {
//                return "MusicBean{" +
//                        "item_id=" + item_id +
//                        ", title='" + title + '\'' +
//                        '}';
//            }
//
//            public int getItem_id() {
//                return item_id;
//            }
//
//            public void setItem_id(int item_id) {
//                this.item_id = item_id;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//        }
//
//    }
//}
