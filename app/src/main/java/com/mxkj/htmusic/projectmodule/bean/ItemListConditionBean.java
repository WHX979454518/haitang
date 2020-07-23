package com.mxkj.htmusic.projectmodule.bean;

import java.io.Serializable;
import java.util.List;

public class ItemListConditionBean implements Serializable {

    /**
     * data : {"work_type":[{"title":"全部","work_type_id":0},{"title":"作曲","work_type_id":1}],"price":[[{"title":"无偿","min_budget":0,"max_budget":0},{"title":"100-400","min_budget":100,"max_budget":400},{"title":"400-800","min_budget":400,"max_budget":800},{"title":"800-10K","min_budget":800,"max_budget":1000},{"title":"10K以上","min_budget":10000,"max_budget":9999999}],[{"title":"100-600","min_budget":100,"max_budget":600},{"title":"600-2000","min_budget":600,"max_budget":2000},{"title":"10K以上","min_budget":10000,"max_budget":9999999}]],"order":[{"title":"按照时间","order_filed":"create_time-desc"},{"title":"截止时间","order_filed":"id-desc"},{"title":"按照预算","order_filed":"id-asc"},{"title":"按信誉","order_filed":"create_time-desc"}]}
     * code : 200
     * msg : ok
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
        private List<WorkTypeBean> work_type;
        private List<List<PriceBean>> price;
        private List<OrderBean> order;

        public List<WorkTypeBean> getWork_type() {
            return work_type;
        }

        public void setWork_type(List<WorkTypeBean> work_type) {
            this.work_type = work_type;
        }

        public List<List<PriceBean>> getPrice() {
            return price;
        }

        public void setPrice(List<List<PriceBean>> price) {
            this.price = price;
        }

        public List<OrderBean> getOrder() {
            return order;
        }

        public void setOrder(List<OrderBean> order) {
            this.order = order;
        }

        public static class WorkTypeBean {
            /**
             * title : 全部
             * work_type_id : 0
             */

            private String title;
            private int work_type_id;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getWork_type_id() {
                return work_type_id;
            }

            public void setWork_type_id(int work_type_id) {
                this.work_type_id = work_type_id;
            }
        }

        public static class PriceBean {
            /**
             * title : 无偿
             * min_budget : 0
             * max_budget : 0
             */

            private String title;
            private int min_budget;
            private int max_budget;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getMin_budget() {
                return min_budget;
            }

            public void setMin_budget(int min_budget) {
                this.min_budget = min_budget;
            }

            public int getMax_budget() {
                return max_budget;
            }

            public void setMax_budget(int max_budget) {
                this.max_budget = max_budget;
            }
        }

        public static class OrderBean {
            /**
             * title : 按照时间
             * order_filed : create_time-desc
             */

            private String title;
            private String order_filed;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOrder_filed() {
                return order_filed;
            }

            public void setOrder_filed(String order_filed) {
                this.order_filed = order_filed;
            }
        }
    }
}
