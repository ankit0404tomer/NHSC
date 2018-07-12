package com.nhsc.special_offers.presenters;

import com.google.gson.Gson;
import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPRestClient;
import com.nhsc.special_offers.interactors.SpecialOfferInteractorImpl;
import com.nhsc.special_offers.interactors.SpecialofferInteractor;
import com.nhsc.special_offers.model.SpecialOffersModel;
import com.nhsc.special_offers.views.SpecialOfferView;

import org.json.JSONObject;


public class SpecialOfferPresenterImpl implements SpecialOfferPresenter {

    private SpecialOfferView specialOfferView;
    private SpecialofferInteractor interactor;
    private SPRestClient mSpRestClientInstance;

    public SpecialOfferPresenterImpl(SpecialOfferView specialOfferView, SPRestClient mSpRestClientInstance) {
        this.specialOfferView = specialOfferView;
        this.mSpRestClientInstance = mSpRestClientInstance;
        this.interactor = new SpecialOfferInteractorImpl();
    }

    @Override
    public void onDestroy() {
        specialOfferView = null;
    }

    @Override
    public void getSpecialOffers(int mPageNumber) {
        if (specialOfferView != null) {

            specialOfferView.showProgress();
            interactor.getSpecialOffers(mPageNumber,mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                    specialOfferView.hideProgress();
                    specialOfferView.onSpecialOfferFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    specialOfferView.hideProgress();
                    if(response!=null){
                        Gson gson=new Gson();
                        SpecialOffersModel specialOffersModel = gson.fromJson(response.toString(), SpecialOffersModel.class);
                        specialOfferView.onSpecialOfferSuccess(specialOffersModel);
                    }

                }
            });
        }


    }
}