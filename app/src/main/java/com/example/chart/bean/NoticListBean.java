package com.example.chart.bean;

import java.util.List;

public class NoticListBean {

    /**
     * code : 200
     * msg : success
     * result : {"totalCount":1,"totalPage":1,"list":[{"id":24,"noticeTitle":"某某某声明书","addMember":30,"userName":"222admin","noticeUrl":"hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/application/pdf1597930797139/1597930797151_33333.pdf","noticeContent":"<p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公<\/p><p>告新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p><br><\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p class=\"ql-align-center\"><img src=\"hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/image/png1597930842576/1597930842576_24.png\"><\/p>","isHide":"0","insertTime":"2020-08-20 21:41:03"}]}
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
         * totalCount : 1
         * totalPage : 1
         * list : [{"id":24,"noticeTitle":"某某某声明书","addMember":30,"userName":"222admin","noticeUrl":"hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/application/pdf1597930797139/1597930797151_33333.pdf","noticeContent":"<p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公<\/p><p>告新增的公告新增的公告新增的公告新增的公告<\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p><br><\/p><p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告<\/p><p class=\"ql-align-center\"><img src=\"hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/image/png1597930842576/1597930842576_24.png\"><\/p>","isHide":"0","insertTime":"2020-08-20 21:41:03"}]
         */

        private int totalCount;
        private int totalPage;
        private List<ListBean> list;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 24
             * noticeTitle : 某某某声明书
             * addMember : 30
             * userName : 222admin
             * noticeUrl : hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/application/pdf1597930797139/1597930797151_33333.pdf
             * noticeContent : <p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告</p><p>新增的公告新增的公告新增的公告新增的公告</p><p>新增的公告新增的公告新增的公告</p><p>新增的公告新增的公告新增的公告新增的公告新增的公</p><p>告新增的公告新增的公告新增的公告新增的公告</p><p>新增的公告新增的公告新增的公告新增的公告新增的公告</p><p><br></p><p>新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告新增的公告</p><p class="ql-align-center"><img src="hnyfkj-file-server/plugins//hnyfkj-jyindustry/20200820/image/png1597930842576/1597930842576_24.png"></p>
             * isHide : 0
             * insertTime : 2020-08-20 21:41:03
             */

            private int id;
            private String noticeTitle;
            private int addMember;
            private String userName;
            private String noticeUrl;
            private String noticeContent;
            private String isHide;
            private String insertTime;

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

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
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
        }
    }
}
