package com.example.nguye.retrofit.Presenter;

import com.example.nguye.retrofit.Activity.ViewInterface.MainView;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataTodo;
import com.example.nguye.retrofit.Model.Datum;

import java.util.List;

/**
 * Created by nguye on 29/05/2018.
 */

public class MainPresenter implements LoadDataTodo {
    private LoadData loadData;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        loadData = new LoadData(this);
    }

    public void loadDataMain(String au){
        loadData.getDataMain(au);
    }

    @Override
    public void onSuccessTodo(List<Datum> arrData) {
        mainView.dataMain(arrData);
    }

    @Override
    public void onFail(String message) {

    }
}
