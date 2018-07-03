package com.nhsc.login.presenters;

import android.content.Context;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.login.interactors.SignInInteractor;
import com.nhsc.login.interactors.SignInInteractorImpl;
import com.nhsc.login.views.SignInView;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;


public class SignInPresenterImpl implements SignInPresenter {

    private SignInView signInView;
    private SignInInteractor signInInteractor;
    private SPRestClient mSpRestClientInstance;
    private Context mContext;

    public SignInPresenterImpl(Context context, SignInView signInView, SPRestClient mSpRestClientInstance) {
        this.signInView = signInView;
        this.mContext = context;
        this.mSpRestClientInstance = mSpRestClientInstance;
        this.signInInteractor = new SignInInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {

        if (signInView != null) {

            signInView.showProgress();
            signInInteractor.singIn(username, password, mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                    signInView.hideProgress();
                    signInView.onSignInFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    signInView.hideProgress();
                    signInView.onSignInSuccess(response);
                }
            });

        }


    }


    @Override
    public void onDestroy() {
        signInView = null;
    }

}
