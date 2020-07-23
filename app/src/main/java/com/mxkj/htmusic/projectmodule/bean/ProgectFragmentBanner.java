package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;

public class ProgectFragmentBanner implements Serializable {
    public static class ShufflingBean implements Serializable {
        /**
         * id : 107
         * title : 源音塘秋日祭音乐会
         * alias : activity
         * imgpic : 3194248a8acb66ff065ce56e3ede69566c938bf9
         * url : http://app.yuanyintang.com/autumnvote2017
         * item_type : 2
         * content : 无音乐不梦想，属于你的闪光时刻！让创作不孤单，让音乐更音乐，让世界听到你的声音！自源音塘“音乐人培养计划”上线以来，源酱与音乐人朋友们在多个领域尝试共同突破。也许我们现在还不是那个完美的自己，但是有了你们，源酱有勇气大胆的不断前行。源音塘秋日祭音乐会正式启动！丰富大赛奖励、海量曝光机会、商业合作推荐，源酱在这里等着你！
         * imgpic_link : http://yyt.demo.com/image/3194248a8acb66ff065ce56e3ede69566c938bf9
         */

        private int id;
        private String title;
        private String alias;
        private String imgpic;
        private String url;
        private int item_type;
        private String content;
        private String imgpic_link;


        private ImgpicInfoBean imgpic_info;

        public ImgpicInfoBean getImgpic_info() {
            return imgpic_info;
        }

        @Override
        public String toString() {
            return "ShufflingBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", alias='" + alias + '\'' +
                    ", imgpic='" + imgpic + '\'' +
                    ", url='" + url + '\'' +
                    ", item_type=" + item_type +
                    ", content='" + content + '\'' +
                    ", imgpic_link='" + imgpic_link + '\'' +
                    ", imgpic_info=" + imgpic_info +
                    '}';
        }

        public void setImgpic_info(ImgpicInfoBean imgpic_info) {
            this.imgpic_info = imgpic_info;
        }

        public static class ImgpicInfoBean implements Serializable {
            /**
             * ext :
             * w :
             * h :
             * size : 330492
             * is_long : 0
             * md5 : c7adcb987e5224301258c6f7efb2d53e
             * link : http://api.demo.com//image/c7adcb987e5224301258c6f7efb2d53e/3
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

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getImgpic() {
            return imgpic;
        }

        public void setImgpic(String imgpic) {
            this.imgpic = imgpic;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getItem_type() {
            return item_type;
        }

        public void setItem_type(int item_type) {
            this.item_type = item_type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImgpic_link() {
            return imgpic_link;
        }

        public void setImgpic_link(String imgpic_link) {
            this.imgpic_link = imgpic_link;
        }
    }
}
