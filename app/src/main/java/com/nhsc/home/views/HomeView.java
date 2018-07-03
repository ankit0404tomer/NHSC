package com.nhsc.home.views;


import com.nhsc.base.BaseView;
import com.nhsc.home.model.DrawerModel;
import com.nhsc.home.model.HomeModel;

import java.util.List;

public interface HomeView extends BaseView {

    void onNavigationDrawerSuccess(List<DrawerModel.ComponentsBean> data);

    void onNavigationDrawerFailure(String message);

    void onHomeSuccess(HomeModel data);

    void onHomeFailure(String message);

}
