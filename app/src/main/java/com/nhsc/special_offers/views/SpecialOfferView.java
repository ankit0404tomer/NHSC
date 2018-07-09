package com.nhsc.special_offers.views;


import com.nhsc.base.BaseView;

public interface SpecialOfferView extends BaseView {


    void onSpecialOfferSuccess();

    void onSpecialOfferFailure(String message);
}
