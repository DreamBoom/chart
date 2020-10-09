package com.example.chart.bean;

import java.util.List;

public class MoneyBean {

    /**
     * code : 200
     * msg : success
     * result : [{"id":3,"companyId":"JY0000000001","recordDate":"2022-09","grossMargin":"26","margins":"42","debt":"54","profitGrowth":"52","returnEquity":"111","insertTime":"2020-09-26 09:36:18","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":1},{"id":4,"companyId":"JY0000000001","recordDate":"2022-08","grossMargin":"26","margins":"42","debt":"54","profitGrowth":"52","returnEquity":"111","insertTime":"2020-09-26 09:36:22","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":2},{"id":5,"companyId":"JY0000000001","recordDate":"2020-03","grossMargin":"26","margins":"42","debt":"54","profitGrowth":"52","returnEquity":"111","insertTime":"2020-09-28 11:06:02","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":3},{"id":8,"companyId":"JY0000000030","recordDate":"2020-02","grossMargin":"1.567","margins":"2.4","debt":"1","profitGrowth":"3.0","returnEquity":"5.0","insertTime":"2020-09-29 10:41:24","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":4},{"id":6,"companyId":"JY0000000030","recordDate":"2020-01","grossMargin":"1.09","margins":"-0.9","debt":"0.2","profitGrowth":"0.987","returnEquity":"1.99","insertTime":"2020-09-28 15:37:19","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":5}]
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
         * id : 3
         * companyId : JY0000000001
         * recordDate : 2022-09
         * grossMargin : 26
         * margins : 42
         * debt : 54
         * profitGrowth : 52
         * returnEquity : 111
         * insertTime : 2020-09-26 09:36:18
         * remark1 : null
         * remark2 : null
         * companyName : 企业1
         * copanyArea : 天坛街道
         * number : 1
         */

        private int id;
        private String companyId;
        private String recordDate;
        private String grossMargin;
        private String margins;
        private String debt;
        private String profitGrowth;
        private String returnEquity;
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

        public String getRecordDate() {
            return recordDate;
        }

        public void setRecordDate(String recordDate) {
            this.recordDate = recordDate;
        }

        public String getGrossMargin() {
            return grossMargin;
        }

        public void setGrossMargin(String grossMargin) {
            this.grossMargin = grossMargin;
        }

        public String getMargins() {
            return margins;
        }

        public void setMargins(String margins) {
            this.margins = margins;
        }

        public String getDebt() {
            return debt;
        }

        public void setDebt(String debt) {
            this.debt = debt;
        }

        public String getProfitGrowth() {
            return profitGrowth;
        }

        public void setProfitGrowth(String profitGrowth) {
            this.profitGrowth = profitGrowth;
        }

        public String getReturnEquity() {
            return returnEquity;
        }

        public void setReturnEquity(String returnEquity) {
            this.returnEquity = returnEquity;
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
