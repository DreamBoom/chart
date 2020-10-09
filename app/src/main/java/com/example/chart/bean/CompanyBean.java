package com.example.chart.bean;

import java.util.List;

public class CompanyBean {

    /**
     * code : 200
     * msg : success
     * result : {"totalCount":22,"totalPage":3,"list":[{"companyId":"JY0000000030","companyName":"新增企业一二","companyScale":"小型企业","companyType":"高成长型企业,上市企业","copanyArea":"北海街道","companyIndustry":"行业5","remark1":"2015"},{"companyId":"JY0000000029","companyName":"新增企业五","companyScale":"大型企业","companyType":"规上企业,上市企业,高成长型企业,重点企业","copanyArea":"承留镇","companyIndustry":"行业4","remark1":"2020"},{"companyId":"JY0000000028","companyName":"新增企业四ID我低价位ID结尾ID结尾ID鸡尾酒第五届第五季第五访问佛科沃尔卡佛问客服豆腐块","companyScale":"大型企业","companyType":"重点企业,规上企业,上市企业","copanyArea":"天坛街道","companyIndustry":"行业8,测试12","remark1":"2018"},{"companyId":"JY0000000027","companyName":"新增企业三","companyScale":"中型企业","companyType":"重点企业,规上企业","copanyArea":"克井镇","companyIndustry":"行业8,测试12","remark1":"2020"},{"companyId":"JY0000000026","companyName":"新增企业二","companyScale":"中型企业","companyType":"重点企业,规上企业","copanyArea":"玉泉街道","companyIndustry":"行业7,测试二,测试二1","remark1":"2021"},{"companyId":"JY0000000025","companyName":"豫光金铅","companyScale":"中型企业","companyType":"重点企业","copanyArea":"五龙口","companyIndustry":"行业8,测试一","remark1":"2021"},{"companyId":"JY0000000023","companyName":"0819增加企业","companyScale":"小型企业","companyType":"重点企业,规上企业","copanyArea":"天安门","companyIndustry":"行业7,测试二","remark1":"2021"},{"companyId":"JY0000000022","companyName":"新增企业一","companyScale":"小型企业","companyType":"重点企1业,重点企业,规上企业","copanyArea":"五龙口","companyIndustry":"行业8,测试12","remark1":"2020"}]}
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
         * totalCount : 22
         * totalPage : 3
         * list : [{"companyId":"JY0000000030","companyName":"新增企业一二","companyScale":"小型企业","companyType":"高成长型企业,上市企业","copanyArea":"北海街道","companyIndustry":"行业5","remark1":"2015"},{"companyId":"JY0000000029","companyName":"新增企业五","companyScale":"大型企业","companyType":"规上企业,上市企业,高成长型企业,重点企业","copanyArea":"承留镇","companyIndustry":"行业4","remark1":"2020"},{"companyId":"JY0000000028","companyName":"新增企业四ID我低价位ID结尾ID结尾ID鸡尾酒第五届第五季第五访问佛科沃尔卡佛问客服豆腐块","companyScale":"大型企业","companyType":"重点企业,规上企业,上市企业","copanyArea":"天坛街道","companyIndustry":"行业8,测试12","remark1":"2018"},{"companyId":"JY0000000027","companyName":"新增企业三","companyScale":"中型企业","companyType":"重点企业,规上企业","copanyArea":"克井镇","companyIndustry":"行业8,测试12","remark1":"2020"},{"companyId":"JY0000000026","companyName":"新增企业二","companyScale":"中型企业","companyType":"重点企业,规上企业","copanyArea":"玉泉街道","companyIndustry":"行业7,测试二,测试二1","remark1":"2021"},{"companyId":"JY0000000025","companyName":"豫光金铅","companyScale":"中型企业","companyType":"重点企业","copanyArea":"五龙口","companyIndustry":"行业8,测试一","remark1":"2021"},{"companyId":"JY0000000023","companyName":"0819增加企业","companyScale":"小型企业","companyType":"重点企业,规上企业","copanyArea":"天安门","companyIndustry":"行业7,测试二","remark1":"2021"},{"companyId":"JY0000000022","companyName":"新增企业一","companyScale":"小型企业","companyType":"重点企1业,重点企业,规上企业","copanyArea":"五龙口","companyIndustry":"行业8,测试12","remark1":"2020"}]
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
             * companyId : JY0000000030
             * companyName : 新增企业一二
             * companyScale : 小型企业
             * companyType : 高成长型企业,上市企业
             * copanyArea : 北海街道
             * companyIndustry : 行业5
             * remark1 : 2015
             */

            private String companyId;
            private String companyName;
            private String companyScale;
            private String companyType;
            private String copanyArea;
            private String companyIndustry;
            private String remark1;

            public String getCompanyId() {
                return companyId;
            }

            public void setCompanyId(String companyId) {
                this.companyId = companyId;
            }

            public String getCompanyName() {
                return companyName;
            }

            public void setCompanyName(String companyName) {
                this.companyName = companyName;
            }

            public String getCompanyScale() {
                return companyScale;
            }

            public void setCompanyScale(String companyScale) {
                this.companyScale = companyScale;
            }

            public String getCompanyType() {
                return companyType;
            }

            public void setCompanyType(String companyType) {
                this.companyType = companyType;
            }

            public String getCopanyArea() {
                return copanyArea;
            }

            public void setCopanyArea(String copanyArea) {
                this.copanyArea = copanyArea;
            }

            public String getCompanyIndustry() {
                return companyIndustry;
            }

            public void setCompanyIndustry(String companyIndustry) {
                this.companyIndustry = companyIndustry;
            }

            public String getRemark1() {
                return remark1;
            }

            public void setRemark1(String remark1) {
                this.remark1 = remark1;
            }
        }
    }
}
