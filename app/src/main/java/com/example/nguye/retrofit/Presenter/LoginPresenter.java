package com.example.nguye.retrofit.Presenter;

import com.example.nguye.retrofit.Activity.ViewInterface.LoginView;
import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataLogin;
import com.example.nguye.retrofit.loadData.LoadDataReAToddo;
import com.google.gson.Gson;

/**
 * Created by nguye on 04/06/2018.
 */

public class LoginPresenter implements LoadDataLogin {
    private LoadData loadData;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loadData = new LoadData(this);
    }

    public void loadLogin(String email, String pass){
        loadData.getLogin(email, pass);
    }

    @Override
    public void onSuccessLogin(ReData<DataLogin> reData) {
        loginView.login(reData.getData());
    }

    @Override
    public void onFail(String message) {
        loginView.loginFail(message);
    }

}
