package com.nhsc.special_offers.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.home.interactors.HomeInteractor;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPResponseListener;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;


public class SpecialOfferInteractorImpl implements SpecialofferInteractor {



    @Override
    public void getSpecialOffers(SPRestClient mSpRestClientInstance, final GenericResponseListener genericResponseListener) {
        mSpRestClientInstance.get("" + "http://cipguru.com/nhsc/services/Categories/getCategories", null, "Home", new SPResponseListener<JSONObject>() {
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
