package com.example.chart.bean;

public class CompanyNumBean {

    /**
     * code : 200
     * msg : success
     * result : {"companyCount":22,"completed":11,"unfinished":11}
     */

    private int code;
    private String msg;
    private ResultBean result;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * companyCount : 22
         * completed : 11
         * unfinished : 11
         */

        private int companyCount;
        private int completed;
        private int unfinished;

        public int getCompanyCount() {
            return companyCount;
        }

        public void setCompanyCount(int companyCount) {
            this.companyCount = companyCount;
        }

        public int getCompleted() {
            return completed;
        }

        public void setCompleted(int completed) {
            this.completed = completed;
        }

        public int getUnfinished() {
            return unfinished;
        }

        public void setUnfinished(int unfinished) {
            this.unfinished = unfinished;
        }
    }
}
