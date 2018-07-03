package com.nhsc.home.model;

import java.util.List;

public class DrawerModel {


    /**
     * status : success
     * statuscode : 200
     * components : [{"SubCategoriesId":"14","SubCategoriesName":"BEERS","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:43:32","CategoriesId":"31"},{"SubCategoriesId":"15","SubCategoriesName":"CIDERS","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:51:07","CategoriesId":"31"},{"SubCategoriesId":"16","SubCategoriesName":"DRAUGHT BEERS","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:52:25","CategoriesId":"31"},{"SubCategoriesId":"17","SubCategoriesName":"RTD'S, MIXED DRINK","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:53:06","CategoriesId":"31"},{"SubCategoriesId":"18","SubCategoriesName":"STOUTS","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:53:52","CategoriesId":"31"},{"SubCategoriesId":"19","SubCategoriesName":"ARAK","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:54:50","CategoriesId":"35"},{"SubCategoriesId":"20","SubCategoriesName":"ARMAGNAC","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:55:19","CategoriesId":"35"},{"SubCategoriesId":"21","SubCategoriesName":"CALVADOS","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:56:09","CategoriesId":"35"},{"SubCategoriesId":"22","SubCategoriesName":"COGNAC","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:57:49","CategoriesId":"35"},{"SubCategoriesId":"23","SubCategoriesName":"GIN","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:58:11","CategoriesId":"35"},{"SubCategoriesId":"24","SubCategoriesName":"GRAPPA","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:58:33","CategoriesId":"35"},{"SubCategoriesId":"25","SubCategoriesName":"PORT","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 07:59:24","CategoriesId":"35"},{"SubCategoriesId":"26","SubCategoriesName":"RUM","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:00:07","CategoriesId":"35"},{"SubCategoriesId":"27","SubCategoriesName":"TEQUILA","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:00:27","CategoriesId":"35"},{"SubCategoriesId":"28","SubCategoriesName":"VERMOUTH","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:00:53","CategoriesId":"35"},{"SubCategoriesId":"29","SubCategoriesName":"JAPANESE WHISKY","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:01:27","CategoriesId":"43"},{"SubCategoriesId":"30","SubCategoriesName":"CANADIAN WHISKY","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:01:58","CategoriesId":"43"},{"SubCategoriesId":"31","SubCategoriesName":"MALT WHISKY","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:02:28","CategoriesId":"43"},{"SubCategoriesId":"32","SubCategoriesName":"PREMIUM WHISKY","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:03:04","CategoriesId":"43"},{"SubCategoriesId":"33","SubCategoriesName":"SCOTCH WHISKY","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:03:32","CategoriesId":"43"},{"SubCategoriesId":"34","SubCategoriesName":"AMERICAN WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:04:17","CategoriesId":"41"},{"SubCategoriesId":"35","SubCategoriesName":"ARGENTINIAN WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 12:24:03","CategoriesId":"41"},{"SubCategoriesId":"36","SubCategoriesName":"AUSTRALIAN WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 09:56:02","CategoriesId":"41"},{"SubCategoriesId":"37","SubCategoriesName":"CHILEAN WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 09:32:41","CategoriesId":"41"},{"SubCategoriesId":"38","SubCategoriesName":"FRENCH WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:06:36","CategoriesId":"41"},{"SubCategoriesId":"39","SubCategoriesName":"GERMAN WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:06:57","CategoriesId":"41"},{"SubCategoriesId":"40","SubCategoriesName":"ITALIAN WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:07:16","CategoriesId":"41"},{"SubCategoriesId":"41","SubCategoriesName":"LIGHT WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:07:42","CategoriesId":"41"},{"SubCategoriesId":"42","SubCategoriesName":"NEW ZEALAND WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:08:01","CategoriesId":"41"},{"SubCategoriesId":"43","SubCategoriesName":"PERU WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 08:08:27","CategoriesId":"41"},{"SubCategoriesId":"44","SubCategoriesName":"PORTUGAL WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-05 13:56:28","CategoriesId":"41"},{"SubCategoriesId":"47","SubCategoriesName":"SAKE JAPANESE RICE WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-06 07:07:11","CategoriesId":"41"},{"SubCategoriesId":"48","SubCategoriesName":"SOUTH AFRICAN WINES","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-06 07:07:51","CategoriesId":"41"},{"SubCategoriesId":"49","SubCategoriesName":"SPANISH WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/","SubCategoriesCreateDate":"2018-06-06 07:08:19","CategoriesId":"41"},{"SubCategoriesId":"50","SubCategoriesName":"SPARKLING WINE","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/4ec315c38324dbc532dfdefc604631af.png","SubCategoriesCreateDate":"2018-06-07 13:41:48","CategoriesId":"41"},{"SubCategoriesId":"60","SubCategoriesName":"test subcat","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/9bb92724c6cab40bc1f268826715dae0.jpeg","SubCategoriesCreateDate":"2018-06-07 13:42:36","CategoriesId":"49"},{"SubCategoriesId":"61","SubCategoriesName":"test new1","SubCategoriesImage":"http://cipguru.com/nhsc/services/assets/images/e0cf56a7ef5485a641e89ad389a62e0b.jpg","SubCategoriesCreateDate":"2018-06-12 12:49:18","CategoriesId":"31"}]
     */

    private String status;
    private int statuscode;
    private List<ComponentsBean> components;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public List<ComponentsBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentsBean> components) {
        this.components = components;
    }

    public static class ComponentsBean {
        /**
         * SubCategoriesId : 14
         * SubCategoriesName : BEERS
         * SubCategoriesImage : http://cipguru.com/nhsc/services/assets/images/
         * SubCategoriesCreateDate : 2018-06-05 07:43:32
         * CategoriesId : 31
         */

        private String SubCategoriesId;
        private String SubCategoriesName;
        private String SubCategoriesImage;
        private String SubCategoriesCreateDate;
        private String CategoriesId;

        public String getSubCategoriesId() {
            return SubCategoriesId;
        }

        public void setSubCategoriesId(String SubCategoriesId) {
            this.SubCategoriesId = SubCategoriesId;
        }

        public String getSubCategoriesName() {
            return SubCategoriesName;
        }

        public void setSubCategoriesName(String SubCategoriesName) {
            this.SubCategoriesName = SubCategoriesName;
        }

        public String getSubCategoriesImage() {
            return SubCategoriesImage;
        }

        public void setSubCategoriesImage(String SubCategoriesImage) {
            this.SubCategoriesImage = SubCategoriesImage;
        }

        public String getSubCategoriesCreateDate() {
            return SubCategoriesCreateDate;
        }

        public void setSubCategoriesCreateDate(String SubCategoriesCreateDate) {
            this.SubCategoriesCreateDate = SubCategoriesCreateDate;
        }

        public String getCategoriesId() {
            return CategoriesId;
        }

        public void setCategoriesId(String CategoriesId) {
            this.CategoriesId = CategoriesId;
        }
    }
}
