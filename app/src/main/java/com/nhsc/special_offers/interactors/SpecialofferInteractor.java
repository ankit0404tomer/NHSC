package com.nhsc.special_offers.interactors;

import com.nhsc.base.GenericResponseListener;
import com.nhsc.networking.SPRestClient;

public interface SpecialofferInteractor {


    void getSpecialOffers(SPRestClient mSpRestClientInstance, GenericResponseListener genericResponseListener);
}
