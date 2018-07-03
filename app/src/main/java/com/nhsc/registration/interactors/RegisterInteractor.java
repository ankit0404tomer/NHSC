package com.nhsc.registration.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPRestClient;

public interface RegisterInteractor {

    void onRegister( SPRestClient mSpRestClientInstance, GenericResponseListener listener);

}
