package com.nhsc.login.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPRestClient;

public interface SignInInteractor {

    void singIn(String username, String password, SPRestClient mSpRestClientInstance, GenericResponseListener listener);

}
