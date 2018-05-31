package com.example.nguye.retrofit.Activity;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;

import java.util.List;

/**
 * Created by nguye on 29/05/2018.
 */

public interface MainView {
    void dataMain(List<Datum> listData);
    void dataLogin(ReData reData);

}
