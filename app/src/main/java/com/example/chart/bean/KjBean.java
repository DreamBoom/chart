package com.example.chart.bean;

import java.util.List;

public class KjBean {

    /**
     * code : 200
     * msg : success
     * result : [{"id":3,"companyId":"JY0000000030","achievementsName":"成功2号","achievementsType":"1","obtainTime":"2020-09-25","certificatePhoto":"","introduction":"<p>啊手动阀<\/p>","insertTime":"2020-09-28 16:42:23","remark1":null,"remark2":null,"companyName":"新增企业一二","copanyArea":"北海街道","number":1},{"id":1,"companyId":"JY0000000001","achievementsName":"为","achievementsType":"1","obtainTime":null,"certificatePhoto":"21","introduction":"21","insertTime":"2020-09-28 14:51:30","remark1":null,"remark2":null,"companyName":"企业1","copanyArea":"天坛街道","number":2}]
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
         * companyId : JY0000000030
         * achievementsName : 成功2号
         * achievementsType : 1
         * obtainTime : 2020-09-25
         * certificatePhoto :
         * introduction : <p>啊手动阀</p>
         * insertTime : 2020-09-28 16:42:23
         * remark1 : null
         * remark2 : null
         * companyName : 新增企业一二
         * copanyArea : 北海街道
         * number : 1
         */

        private int id;
        private String companyId;
        private String achievementsName;
        private String achievementsType;
        private String obtainTime;
        private String certificatePhoto;
        private String introduction;
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

        public String getAchievementsName() {
            return achievementsName;
        }

        public void setAchievementsName(String achievementsName) {
            this.achievementsName = achievementsName;
        }

        public String getAchievementsType() {
            return achievementsType;
        }

        public void setAchievementsType(String achievementsType) {
            this.achievementsType = achievementsType;
        }

        public String getObtainTime() {
            return obtainTime;
        }

        public void setObtainTime(String obtainTime) {
            this.obtainTime = obtainTime;
        }

        public String getCertificatePhoto() {
            return certificatePhoto;
        }

        public void setCertificatePhoto(String certificatePhoto) {
            this.certificatePhoto = certificatePhoto;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
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
