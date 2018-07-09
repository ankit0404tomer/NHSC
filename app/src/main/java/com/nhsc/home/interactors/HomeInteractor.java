package com.nhsc.home.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPRestClient;

public interface HomeInteractor {

    void getNavigationDrawerData(SPRestClient mSpRestClientInstance, GenericResponseListener listener);
    void getHomeData(SPRestClient mSpRestClientInstance, GenericResponseListener listener);

    void getSignOut(SPRestClient mSpRestClientInstance, GenericResponseListener genericResponseListener);
}
