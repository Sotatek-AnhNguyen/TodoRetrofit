package com.example.nguye.retrofit.Presenter;

import com.example.nguye.retrofit.Activity.ViewInterface.UpdateView;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataReAToddo;

/**
 * Created by nguye on 04/06/2018.
 */

public class UpdatePresenter implements LoadDataReAToddo {
    private LoadData loadData;
    private UpdateView updateView;

    public UpdatePresenter(UpdateView updateView) {
        this.updateView = updateView;
        loadData = new LoadData(this);
    }

    public void loadUpdate(String id, String title, String au){
        loadData.updateATodo(id, title, au);
    }

    public void deleteATodo(String id, String au){
        loadData.deleteATodo(id, au);
    }

    @Override
    public void onSuccessLogin(ReData reData) {
        updateView.update(reData);
    }

    @Override
    public void onFail(String message) {

    }
}
