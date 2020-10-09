package com.example.chart.bean;

public class NoticeInfoBean {

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
         * id : 25
         * noticeTitle : 保护环境
         * addMember : 30
         * noticeUrl : hnyfkj-file-server/plugins//hnyfkj-jyindustry/20201009/application/vnd.ms-excel1602225565299/1602225565300_区域经济指标(月报)模板.xls
         * noticeContent : 环境保护就是指人类为解决现实或潜在的环境问题，协调人类与环境的关系，保障经济社会的持续发展而采取的各种行动的总称。
         其方法和手段有工程技术、行政管理、也有法、经济、宣传教育……
         保护环境是人类有意识地保护自然资源并使其得到合理的利用，防止自然环境受到污染和破坏；对受到污染和破坏的环境做好综合的治理，以创造出适合于人类生活、工作的环境，协调人与自然的关系，让人们做到与自然和谐相处的概念。
         * isHide : 0
         * insertTime : 2020-10-09 16:39:30
         * modifyTime : null
         * userName : 222admin
         */

        private int id;
        private String noticeTitle;
        private int addMember;
        private String noticeUrl;
        private String noticeContent;
        private String isHide;
        private String insertTime;
        private Object modifyTime;
        private String userName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNoticeTitle() {
            return noticeTitle;
        }

        public void setNoticeTitle(String noticeTitle) {
            this.noticeTitle = noticeTitle;
        }

        public int getAddMember() {
            return addMember;
        }

        public void setAddMember(int addMember) {
            this.addMember = addMember;
        }

        public String getNoticeUrl() {
            return noticeUrl;
        }

        public void setNoticeUrl(String noticeUrl) {
            this.noticeUrl = noticeUrl;
        }

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }

        public String getIsHide() {
            return isHide;
        }

        public void setIsHide(String isHide) {
            this.isHide = isHide;
        }

        public String getInsertTime() {
            return insertTime;
        }

        public void setInsertTime(String insertTime) {
            this.insertTime = insertTime;
        }

        public Object getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(Object modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
