package com.example.nguye.retrofit.loadData;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;

/**
 * Created by nguye on 05/06/2018.
 */

public interface LoadDataLogin {
    void onSuccessLogin(ReData<DataLogin> reData);
    void onFail(String message);
}
