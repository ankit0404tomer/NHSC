package com.nhsc.special_offers.model;

import java.util.List;

public class SpecialOffersModel {


    /**
     * status : success
     * statuscode : 200
     * components : [{"offerId":"2","offerName":"Buy one get one free","OfferImage":"http://cipguru.com/nhsc/services/assets/images/f7b...","OfferCategoryId":"31","OfferSubCategoryId":"17","offerProductId":"31","OfferValidFromDate":"2018-10-10","offerValidToDate":"2018-12-12","offerAmount":"12456","offerCreatedDate":"2018-06-05 13:54:50"},{"offerId":"9","offerName":"30% Off","OfferImage":"http://cipguru.com/nhsc/services/assets/images/f7bc2fc89535ab5138b35a40b70018e7.jpeg","OfferCategoryId":"36","OfferSubCategoryId":"10","offerProductId":"1","OfferValidFromDate":"0000-00-00","offerValidToDate":"0000-00-00","offerAmount":null,"offerCreatedDate":"2018-06-04 14:22:06"}]
     * totalcount : 5
     */

    private String status;
    private int statuscode;
    private int totalcount;
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

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List<ComponentsBean> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentsBean> components) {
        this.components = components;
    }

    public static class ComponentsBean {
        /**
         * offerId : 2
         * offerName : Buy one get one free
         * OfferImage : http://cipguru.com/nhsc/services/assets/images/f7b...
         * OfferCategoryId : 31
         * OfferSubCategoryId : 17
         * offerProductId : 31
         * OfferValidFromDate : 2018-10-10
         * offerValidToDate : 2018-12-12
         * offerAmount : 12456
         * offerCreatedDate : 2018-06-05 13:54:50
         */

        private String offerId;
        private String offerName;
        private String OfferImage;
        private String OfferCategoryId;
        private String OfferSubCategoryId;
        private String offerProductId;
        private String OfferValidFromDate;
        private String offerValidToDate;
        private String offerAmount;
        private String offerCreatedDate;

        public String getOfferId() {
            return offerId;
        }

        public void setOfferId(String offerId) {
            this.offerId = offerId;
        }

        public String getOfferName() {
            return offerName;
        }

        public void setOfferName(String offerName) {
            this.offerName = offerName;
        }

        public String getOfferImage() {
            return OfferImage;
        }

        public void setOfferImage(String OfferImage) {
            this.OfferImage = OfferImage;
        }

        public String getOfferCategoryId() {
            return OfferCategoryId;
        }

        public void setOfferCategoryId(String OfferCategoryId) {
            this.OfferCategoryId = OfferCategoryId;
        }

        public String getOfferSubCategoryId() {
            return OfferSubCategoryId;
        }

        public void setOfferSubCategoryId(String OfferSubCategoryId) {
            this.OfferSubCategoryId = OfferSubCategoryId;
        }

        public String getOfferProductId() {
            return offerProductId;
        }

        public void setOfferProductId(String offerProductId) {
            this.offerProductId = offerProductId;
        }

        public String getOfferValidFromDate() {
            return OfferValidFromDate;
        }

        public void setOfferValidFromDate(String OfferValidFromDate) {
            this.OfferValidFromDate = OfferValidFromDate;
        }

        public String getOfferValidToDate() {
            return offerValidToDate;
        }

        public void setOfferValidToDate(String offerValidToDate) {
            this.offerValidToDate = offerValidToDate;
        }

        public String getOfferAmount() {
            return offerAmount;
        }

        public void setOfferAmount(String offerAmount) {
            this.offerAmount = offerAmount;
        }

        public String getOfferCreatedDate() {
            return offerCreatedDate;
        }

        public void setOfferCreatedDate(String offerCreatedDate) {
            this.offerCreatedDate = offerCreatedDate;
        }
    }
}
