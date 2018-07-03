package com.nhsc.login.presenters;

public interface SignInPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();

}
