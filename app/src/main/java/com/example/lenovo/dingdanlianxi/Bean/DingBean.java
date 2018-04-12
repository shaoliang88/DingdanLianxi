package com.example.lenovo.dingdanlianxi.Bean;

import java.util.List;

/**
 * Created by 亓志伟 on 2018/4/7.
 */

public class DingBean {
    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-11-08T19:38:19","orderid":1440,"price":11800,"status":2,"title":"","uid":1299},{"createtime":"2017-11-08T19:38:36","orderid":1441,"price":11800,"status":2,"title":"","uid":1299},{"createtime":"2017-11-08T19:40:08","orderid":1442,"price":11800,"status":0,"title":"","uid":1299},{"createtime":"2017-11-18T12:47:30","orderid":2250,"price":82600,"status":0,"title":null,"uid":1299},{"createtime":"2017-11-18T12:47:33","orderid":2251,"price":82600,"status":0,"title":null,"uid":1299},{"createtime":"2017-11-24T17:09:50","orderid":3267,"price":22.9,"status":0,"title":null,"uid":1299},{"createtime":"2018-01-05T15:05:54","orderid":6535,"price":999,"status":0,"title":"订单测试标题1299","uid":1299},{"createtime":"2018-01-05T15:06:52","orderid":6536,"price":234,"status":0,"title":"订单测试标题1299","uid":1299},{"createtime":"2018-01-15T12:56:45","orderid":6995,"price":524,"status":0,"title":"订单测试标题1299","uid":1299},{"createtime":"2018-01-15T12:56:55","orderid":6996,"price":524,"status":0,"title":"订单测试标题1299","uid":1299}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-11-08T19:38:19
         * orderid : 1440
         * price : 11800.0
         * status : 2
         * title :
         * uid : 1299
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
