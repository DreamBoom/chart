package com.example.chart.bean;

import java.util.List;

public class AreaBean {

    /**
     * code : 200
     * msg : success
     * result : {"totalCount":18,"totalPage":1,"list":[{"areaId":"20200819091204749749","areaName":"玉泉街道","sortNo":0},{"areaId":"20200819113822372688","areaName":"克井镇","sortNo":0},{"areaId":"20200820093041739348","areaName":"济水街道","sortNo":0},{"areaId":"20200820093110206939","areaName":"沁园街道","sortNo":0},{"areaId":"20200820093133821209","areaName":"天坛街道","sortNo":0},{"areaId":"20200820093219774453","areaName":"北海街道","sortNo":0},{"areaId":"20200820093244882083","areaName":"五龙口镇","sortNo":0},{"areaId":"20200820093319983748","areaName":"梨林镇","sortNo":0},{"areaId":"20200820093335410783","areaName":"轵城镇","sortNo":0},{"areaId":"20200820093347996263","areaName":"承留镇","sortNo":0},{"areaId":"20200820093402856128","areaName":"坡头镇","sortNo":0},{"areaId":"20200820093416193070","areaName":"大峪镇","sortNo":0},{"areaId":"20200820093428519586","areaName":"邵原镇","sortNo":0},{"areaId":"20200820093440382918","areaName":"思礼镇","sortNo":0},{"areaId":"20200820093455760337","areaName":"王屋镇","sortNo":0},{"areaId":"20200820093509258500","areaName":"下冶镇","sortNo":0},{"areaId":"20200920084612508456","areaName":"玉川产业集聚区","sortNo":0},{"areaId":"20200920094864816654","areaName":"虎岭产业集聚区","sortNo":0}]}
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
         * totalCount : 18
         * totalPage : 1
         * list : [{"areaId":"20200819091204749749","areaName":"玉泉街道","sortNo":0},{"areaId":"20200819113822372688","areaName":"克井镇","sortNo":0},{"areaId":"20200820093041739348","areaName":"济水街道","sortNo":0},{"areaId":"20200820093110206939","areaName":"沁园街道","sortNo":0},{"areaId":"20200820093133821209","areaName":"天坛街道","sortNo":0},{"areaId":"20200820093219774453","areaName":"北海街道","sortNo":0},{"areaId":"20200820093244882083","areaName":"五龙口镇","sortNo":0},{"areaId":"20200820093319983748","areaName":"梨林镇","sortNo":0},{"areaId":"20200820093335410783","areaName":"轵城镇","sortNo":0},{"areaId":"20200820093347996263","areaName":"承留镇","sortNo":0},{"areaId":"20200820093402856128","areaName":"坡头镇","sortNo":0},{"areaId":"20200820093416193070","areaName":"大峪镇","sortNo":0},{"areaId":"20200820093428519586","areaName":"邵原镇","sortNo":0},{"areaId":"20200820093440382918","areaName":"思礼镇","sortNo":0},{"areaId":"20200820093455760337","areaName":"王屋镇","sortNo":0},{"areaId":"20200820093509258500","areaName":"下冶镇","sortNo":0},{"areaId":"20200920084612508456","areaName":"玉川产业集聚区","sortNo":0},{"areaId":"20200920094864816654","areaName":"虎岭产业集聚区","sortNo":0}]
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
             * areaId : 20200819091204749749
             * areaName : 玉泉街道
             * sortNo : 0
             */

            private String areaId;
            private String areaName;
            private int sortNo;

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public int getSortNo() {
                return sortNo;
            }

            public void setSortNo(int sortNo) {
                this.sortNo = sortNo;
            }
        }
    }
}
