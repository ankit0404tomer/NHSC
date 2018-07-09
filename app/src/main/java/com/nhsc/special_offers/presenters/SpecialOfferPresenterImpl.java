package com.nhsc.special_offers.presenters;

import android.content.Context;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPRestClient;
import com.nhsc.special_offers.interactors.SpecialOfferInteractorImpl;
import com.nhsc.special_offers.interactors.SpecialofferInteractor;
import com.nhsc.special_offers.views.SpecialOfferView;

import org.json.JSONObject;


public class SpecialOfferPresenterImpl implements SpecialOfferPresenter {

    private SpecialOfferView specialOfferView;
    private SpecialofferInteractor interactor;
    private SPRestClient mSpRestClientInstance;
    private Context mContext;

    public SpecialOfferPresenterImpl(Context context, SpecialOfferView specialOfferView, SPRestClient mSpRestClientInstance) {
        this.specialOfferView = specialOfferView;
        this.mContext = context;
        this.mSpRestClientInstance = mSpRestClientInstance;
        this.interactor = new SpecialOfferInteractorImpl();
    }

    @Override
    public void onDestroy() {
        specialOfferView = null;
    }

    @Override
    public void getSpecialOffers() {
        if (specialOfferView != null) {

            specialOfferView.showProgress();
            interactor.getSpecialOffers(mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                    specialOfferView.hideProgress();
                    specialOfferView.onSpecialOfferFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    specialOfferView.hideProgress();
                    specialOfferView.onSpecialOfferSuccess();
                }
            });
        }


    }
}