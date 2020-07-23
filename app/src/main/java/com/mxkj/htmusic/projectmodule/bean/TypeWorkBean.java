package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class TypeWorkBean implements Serializable {

    /**
     * data : [{"id":1,"title":"作曲","content":"就是作曲","file_format":"MP4/MP3","file_type":1,"status":1,"created_at":"2019-03-12 09:45:54","updated_at":"2019-03-12 09:45:55","deleted_at":null,"file_type_text":"音频","status_text":"是"},{"id":2,"title":"作词","content":"就是作词","file_format":"PNG/JPEG","file_type":3,"status":1,"created_at":"2019-03-12 09:47:05","updated_at":"2019-03-12 09:47:06","deleted_at":null,"file_type_text":"图片","status_text":"是"},{"id":3,"title":"歌手","content":"就是唱歌","file_format":"FLV/3GP","file_type":2,"status":1,"created_at":"2019-03-12 09:48:09","updated_at":"2019-03-12 09:48:10","deleted_at":null,"file_type_text":"视频","status_text":"是"}]
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
         * id : 1
         * title : 作曲
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
}
