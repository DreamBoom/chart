package com.example.chart.bean;

import java.util.List;

public class InMoney {

    /**
     * status : 0
     * msg : success
     * data : [{"id":1,"companyId":"JY0000000001","revenueYear":"2021","lowerFeeYear":"26","grossOutput":"42","lowerFeeLastYear":"52","lowerFeeTheYear":"54","insertTime":"2020-09-25 18:12:02","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":1},{"id":3,"companyId":"JY0000000001","revenueYear":"2020","lowerFeeYear":"26","grossOutput":"42","lowerFeeLastYear":"52","lowerFeeTheYear":"54","insertTime":"2020-09-25 18:12:05","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":2},{"id":4,"companyId":"JY0000000001","revenueYear":"2020","lowerFeeYear":"10.23","grossOutput":"30.34","lowerFeeLastYear":"-10.98","lowerFeeTheYear":"-4.32","insertTime":"2020-09-28 15:10:47","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":3},{"id":5,"companyId":"JY0000000030","revenueYear":"2020","lowerFeeYear":"10","grossOutput":"100","lowerFeeLastYear":"1.09","lowerFeeTheYear":"1","insertTime":"2020-09-28 15:12:16","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":4},{"id":7,"companyId":"JY0000000030","revenueYear":"2014","lowerFeeYear":"10","grossOutput":"100","lowerFeeLastYear":"1","lowerFeeTheYear":"3","insertTime":"2020-09-28 15:18:34","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":5}]
     */

    private int status;
    private String msg;
    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public static class DataBean {
        /**
         * id : 1
         * companyId : JY0000000001
         * revenueYear : 2021
         * lowerFeeYear : 26
         * grossOutput : 42
         * lowerFeeLastYear : 52
         * lowerFeeTheYear : 54
         * insertTime : 2020-09-25 18:12:02
         * remark1 : null
         * remark2 : null
         * companyName : 企业1
         * copanyArea : 天坛街道
         * number : 1
         */

        private int id;
        private String companyId;
        private String revenueYear;
        private String lowerFeeYear;
        private String grossOutput;
        private String lowerFeeLastYear;
        private String lowerFeeTheYear;
        private String insertTime;
        private Object remark1;
        private Object remark2;
        private String companyName;
        private String copanyArea;
        private int number;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getRevenueYear() {
            return revenueYear;
        }

        public void setRevenueYear(String revenueYear) {
            this.revenueYear = revenueYear;
        }

        public String getLowerFeeYear() {
            return lowerFeeYear;
        }

        public void setLowerFeeYear(String lowerFeeYear) {
            this.lowerFeeYear = lowerFeeYear;
        }

        public String getGrossOutput() {
            return grossOutput;
        }

        public void setGrossOutput(String grossOutput) {
            this.grossOutput = grossOutput;
        }

        public String getLowerFeeLastYear() {
            return lowerFeeLastYear;
        }

        public void setLowerFeeLastYear(String lowerFeeLastYear) {
            this.lowerFeeLastYear = lowerFeeLastYear;
        }

        public String getLowerFeeTheYear() {
            return lowerFeeTheYear;
        }

        public void setLowerFeeTheYear(String lowerFeeTheYear) {
            this.lowerFeeTheYear = lowerFeeTheYear;
        }

        public String getInsertTime() {
            return insertTime;
        }

        public void setInsertTime(String insertTime) {
            this.insertTime = insertTime;
        }

        public Object getRemark1() {
            return remark1;
        }

        public void setRemark1(Object remark1) {
            this.remark1 = remark1;
        }

        public Object getRemark2() {
            return remark2;
        }

        public void setRemark2(Object remark2) {
            this.remark2 = remark2;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCopanyArea() {
            return copanyArea;
        }

        public void setCopanyArea(String copanyArea) {
            this.copanyArea = copanyArea;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
