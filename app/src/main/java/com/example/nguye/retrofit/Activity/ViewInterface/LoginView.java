package com.example.nguye.retrofit.Activity.ViewInterface;

import com.example.nguye.retrofit.Model.DataLogin;

/**
 * Created by nguye on 04/06/2018.
 */

public interface LoginView {
    void login(DataLogin dataLogin);
    void loginFail(String mess);
}
