package com.example.nguye.retrofit.loadData;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;

/**
 * Created by nguye on 04/06/2018.
 */

public interface LoadDataReAToddo {
    void onSuccessLogin(ReData<Datum> reData);
    void onFail(String message);
}
