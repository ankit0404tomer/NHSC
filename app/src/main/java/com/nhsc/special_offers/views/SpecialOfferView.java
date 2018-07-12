package com.nhsc.special_offers.views;


import com.nhsc.base.BaseView;
import com.nhsc.special_offers.model.SpecialOffersModel;

public interface SpecialOfferView extends BaseView {


    void onSpecialOfferSuccess(SpecialOffersModel data);

    void onSpecialOfferFailure(String message);
}
