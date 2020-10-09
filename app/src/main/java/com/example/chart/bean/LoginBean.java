package com.example.chart.bean;

public class LoginBean {

    /**
     * code : 200
     * msg : success
     * result : {"id":20,"companyId":null,"userName":"admin000","roleType":1,"companyName":null,"token":"e512c6c4d3e1920a1c16ba2d0aad1847"}
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
         * id : 20
         * companyId : null
         * userName : admin000
         * roleType : 1
         * companyName : null
         * token : e512c6c4d3e1920a1c16ba2d0aad1847
         */

        private int id;
        private String companyId;
        private String userName;
        private int roleType;
        private String companyName;
        private String token;

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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getRoleType() {
            return roleType;
        }

        public void setRoleType(int roleType) {
            this.roleType = roleType;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
