package com.example.nguye.retrofit.Presenter;

import com.example.nguye.retrofit.Activity.ViewInterface.CreateATodoView;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataReAToddo;
import com.google.gson.Gson;

/**
 * Created by nguye on 04/06/2018.
 */

public class CreateATodoPresenter implements LoadDataReAToddo {
    private LoadData loadData;
    private CreateATodoView createATodoView;
    private Gson gson;

    public CreateATodoPresenter(CreateATodoView createATodoView) {
        this.createATodoView = createATodoView;
        loadData = new LoadData(this);
        gson = new Gson();
    }

    public void loadCreateATodo(String title, String au){
        loadData.createATodo(title, au);
    }


    @Override
    public void onSuccessLogin(ReData<Datum> reData) {
        createATodoView.dataCreateATodo(reData.getData());
    }

    @Override
    public void onFail(String message) {

    }
}
