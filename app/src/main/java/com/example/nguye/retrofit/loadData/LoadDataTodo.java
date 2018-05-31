package com.example.nguye.retrofit.loadData;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;

import java.util.List;

/**
 * Created by nguye on 29/05/2018.
 */

public interface LoadDataTodo {
    void onSuccessTodo(List<Datum> arrData);
    void onFail(String message);
    void onSuccessLogin(ReData reData);
    void onSuccessDelete(ReData reData);
}
