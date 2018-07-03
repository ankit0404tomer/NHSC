package com.nhsc.registration.presenters;

import android.content.Context;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPRestClient;
import com.nhsc.registration.interactors.RegisterInteractor;
import com.nhsc.registration.interactors.RegisterInteractorImpl;
import com.nhsc.registration.views.RegisterView;

import org.json.JSONObject;


public class RegisterPresenterImpl implements RegisterPresenter {

    private RegisterView registerView;
    private RegisterInteractor registerInteractor;
    private SPRestClient mSpRestClientInstance;
    private Context mContext;

    public RegisterPresenterImpl(Context context, RegisterView registerView, SPRestClient mSpRestClientInstance) {
        this.registerView = registerView;
        this.mContext = context;
        this.mSpRestClientInstance = mSpRestClientInstance;
        this.registerInteractor = new RegisterInteractorImpl();
    }


    @Override
    public void onRegister( ) {
        if (registerView != null) {

            registerView.showProgress();
            registerInteractor.onRegister(mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                    registerView.hideProgress();
                    registerView.onRegisterFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    registerView.hideProgress();
                    registerView.onRegisterSuccess(response);
                }
            });

        }

    }

    @Override
    public void onDestroy() {
        registerView = null;
    }

}
