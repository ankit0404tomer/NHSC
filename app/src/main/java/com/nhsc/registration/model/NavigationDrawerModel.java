package com.nhsc.registration.model;

import java.util.List;

public class NavigationDrawerModel {


    /**
     * status : success
     * statuscode : 200
     * components : [{"categoriesId":"31","categoriesName":"BEERS, RTD'S & CIDERS","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/42f6007cc73026b616fac3e5c68a3682.png","categoriesCreateDate":"2018-06-07 06:46:51"},{"categoriesId":"33","categoriesName":"INDIAN SPIRITS","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/75a9cc879951b9082806fab37048a757.png","categoriesCreateDate":"2018-06-05 08:21:52"},{"categoriesId":"34","categoriesName":"LIQUEURS","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/cd754dbae437832f8f91deaf9a4bcbed.jpg","categoriesCreateDate":"2018-06-05 09:16:05"},{"categoriesId":"35","categoriesName":"OTHER SPIRITS","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/180314550986da662f8a6d3c56033914.jpg","categoriesCreateDate":"2018-06-04 08:54:08"},{"categoriesId":"40","categoriesName":"BRANDY","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/8051fe6afa046cbf66dc281627642b07.jpg","categoriesCreateDate":"2018-06-05 07:38:47"},{"categoriesId":"41","categoriesName":"WINES","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/e459f6a2b6680aa79ba7c89026cd982a.jpeg","categoriesCreateDate":"2018-06-05 07:39:32"},{"categoriesId":"42","categoriesName":"VODKA","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/bc21ca74a734aa6ac2d949ff9d1fe5fe.jpg","categoriesCreateDate":"2018-06-05 07:40:59"},{"categoriesId":"43","categoriesName":"WHISKY","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/8a5e498259311d91de9b0970778d7a6c.jpg","categoriesCreateDate":"2018-06-06 06:48:31"},{"categoriesId":"49","categoriesName":"testing 1","categoriesImage":"http://cipguru.com/nhsc/services/assets/images/f911ea7011e026a7f87898b8d6bce80b.jpeg","categoriesCreateDate":"2018-06-07 13:41:24"}]
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
         * categoriesId : 31
         * categoriesName : BEERS, RTD'S & CIDERS
         * categoriesImage : http://cipguru.com/nhsc/services/assets/images/42f6007cc73026b616fac3e5c68a3682.png
         * categoriesCreateDate : 2018-06-07 06:46:51
         */

        private String categoriesId;
        private String categoriesName;
        private String categoriesImage;
        private String categoriesCreateDate;

        public String getCategoriesId() {
            return categoriesId;
        }

        public void setCategoriesId(String categoriesId) {
            this.categoriesId = categoriesId;
        }

        public String getCategoriesName() {
            return categoriesName;
        }

        public void setCategoriesName(String categoriesName) {
            this.categoriesName = categoriesName;
        }

        public String getCategoriesImage() {
            return categoriesImage;
        }

        public void setCategoriesImage(String categoriesImage) {
            this.categoriesImage = categoriesImage;
        }

        public String getCategoriesCreateDate() {
            return categoriesCreateDate;
        }

        public void setCategoriesCreateDate(String categoriesCreateDate) {
            this.categoriesCreateDate = categoriesCreateDate;
        }
    }
}
