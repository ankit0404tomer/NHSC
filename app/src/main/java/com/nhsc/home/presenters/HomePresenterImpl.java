package com.nhsc.home.presenters;

import android.content.Context;

import com.google.gson.Gson;
import com.nhsc.base.GenericResponseListener;
import com.nhsc.home.interactors.HomeInteractor;
import com.nhsc.home.interactors.HomeInteractorImpl;
import com.nhsc.home.model.DrawerModel;
import com.nhsc.home.model.HomeModel;
import com.nhsc.home.views.HomeView;
import com.nhsc.networking.SPError;
import com.nhsc.networking.SPRestClient;

import org.json.JSONObject;


public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;
    private HomeInteractor homeInteractor;
    private SPRestClient mSpRestClientInstance;
    private Context mContext;

    public HomePresenterImpl(Context context, HomeView homeView, SPRestClient mSpRestClientInstance) {
        this.homeView = homeView;
        this.mContext = context;
        this.mSpRestClientInstance = mSpRestClientInstance;
        this.homeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void getNavigationDrawerData() {

        if (homeView != null) {

         //   homeView.showProgress();
            homeInteractor.getNavigationDrawerData(mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                  //  homeView.hideProgress();
                    homeView.onNavigationDrawerFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    //homeView.hideProgress();

                    Gson gson = new Gson();
                    DrawerModel drawerModel = gson.fromJson(response.toString(), DrawerModel.class);

                    if (drawerModel != null)
                        homeView.onNavigationDrawerSuccess(drawerModel.getComponents());
                }
            });

        }


    }

    @Override
    public void getHomeData() {
        if (homeView != null) {

            homeView.showProgress();
            homeInteractor.getHomeData(mSpRestClientInstance, new GenericResponseListener() {
                @Override
                public void onError(SPError spError) {
                    homeView.hideProgress();
                    homeView.onHomeFailure(spError.getMessage());
                }

                @Override
                public void onSuccess(JSONObject response) {
                    homeView.hideProgress();
                    Gson gson = new Gson();
                    HomeModel drawerModel = gson.fromJson(response.toString(), HomeModel.class);
                    if (drawerModel != null)
                        homeView.onHomeSuccess(drawerModel);
                }
            });

        }
    }


    @Override
    public void onDestroy() {
        homeView = null;
    }

}
