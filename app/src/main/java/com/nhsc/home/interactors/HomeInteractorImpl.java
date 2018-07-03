package com.nhsc.home.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPResponseListener;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;


public class HomeInteractorImpl implements HomeInteractor {


    @Override
    public void getNavigationDrawerData(SPRestClient mSpRestClientInstance, final GenericResponseListener listener) {

        mSpRestClientInstance.getDontCache("" + "http://cipguru.com/nhsc/services/SubCategories/getSubCategories", null, "drawer", new SPResponseListener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(SPError error) {
                listener.onError(error);
            }
        });
    }


    @Override
    public void getHomeData(SPRestClient mSpRestClientInstance, final GenericResponseListener listener) {

        mSpRestClientInstance.getDontCache("" + "http://cipguru.com/nhsc/services/Categories/getCategories", null, "Home", new SPResponseListener<JSONObject>() {
            @Override
            public void onSuccess(JSONObject response) {
                listener.onSuccess(response);
            }

            @Override
            public void onError(SPError error) {
                listener.onError(error);
            }
        });
    }


}
