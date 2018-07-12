package com.nhsc.special_offers.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPResponseListener;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;


public class SpecialOfferInteractorImpl implements SpecialofferInteractor {



    @Override
    public void getSpecialOffers(int mPageNumber, SPRestClient mSpRestClientInstance, final GenericResponseListener genericResponseListener) {
        mSpRestClientInstance.get("" + "http://cipguru.com/nhsc/services/Offer/getOffer?pageno="+mPageNumber, null, "Home", new SPResponseListener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                genericResponseListener.onSuccess(response);
            }

            @Override
            public void onError(SPError error) {
                genericResponseListener.onError(error);
            }
        });
    }
}
