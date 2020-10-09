package com.example.chart.bean;

import java.util.List;

public class OutBean {

    /**
     * code : 200
     * msg : success
     * result : [{"id":7,"companyId":"JY0000000030","marketDate":"2020-04","marketFlow":"销售流向二","revenuesMonth":"666","profitMonth":"1.45","insertTime":"2020-09-29 10:35:10","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":1},{"id":11,"companyId":"JY0000000030","marketDate":"2020-01","marketFlow":"132","revenuesMonth":"345","profitMonth":"46","insertTime":"2020-09-29 11:35:11","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":2},{"id":10,"companyId":"JY0000000030","marketDate":"2020-06","marketFlow":"123123","revenuesMonth":"213139856","profitMonth":"123","insertTime":"2020-09-29 11:35:05","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":3},{"id":5,"companyId":"JY0000000030","marketDate":"2020-02","marketFlow":"流向2","revenuesMonth":"16778456.05","profitMonth":"52.15","insertTime":"2020-09-28 14:25:18","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":4},{"id":8,"companyId":"JY0000000030","marketDate":"2020-03","marketFlow":"销售流向4","revenuesMonth":"15656.23","profitMonth":"4.55","insertTime":"2020-09-29 10:36:22","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":5}]
     */

    private int code;
    private String msg;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 7
         * companyId : JY0000000030
         * marketDate : 2020-04
         * marketFlow : 销售流向二
         * revenuesMonth : 666
         * profitMonth : 1.45
         * insertTime : 2020-09-29 10:35:10
         * remark1 : null
         * remark2 : null
         * companyName : 新增企业一二
         * copanyArea : 北海街道
         * number : 1
         */

        private int id;
        private String companyId;
        private String marketDate;
        private String marketFlow;
        private String revenuesMonth;
        private String profitMonth;
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

        public String getMarketDate() {
            return marketDate;
        }

        public void setMarketDate(String marketDate) {
            this.marketDate = marketDate;
        }

        public String getMarketFlow() {
            return marketFlow;
        }

        public void setMarketFlow(String marketFlow) {
            this.marketFlow = marketFlow;
        }

        public String getRevenuesMonth() {
            return revenuesMonth;
        }

        public void setRevenuesMonth(String revenuesMonth) {
            this.revenuesMonth = revenuesMonth;
        }

        public String getProfitMonth() {
            return profitMonth;
        }

        public void setProfitMonth(String profitMonth) {
            this.profitMonth = profitMonth;
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
