package com.example.nguye.retrofit.Presenter;

import android.content.Context;

import com.example.nguye.retrofit.Activity.MainView;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataTodo;
import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;

import java.util.List;

/**
 * Created by nguye on 29/05/2018.
 */

public class MainPresenter implements LoadDataTodo {
    private LoadData loadData;
    private MainView mainView;

    public MainPresenter(MainView mainView, Context context) {
        this.mainView = mainView;
        loadData = new LoadData(this, context);
    }

    public void loadDataMain(String au){
        loadData.getDataMain(au);
    }

    public void loadLogin(String email, String pass){
        loadData.getLogin(email, pass);
    }

    public void loadRegist(String email, String pass, String name){
        loadData.getRegister(email, pass, name);
    }

    public void loadCreateATodo(String title, String au){
        loadData.createATodo(title, au);
    }

    public void loadUpdate(String id, String title, String au){
        loadData.updateATodo(id, title, au);
    }

    public void deleteATodo(String id, String au){
        loadData.deleteATodo(id, au);
    }

    @Override
    public void onSuccessTodo(List<Datum> arrData) {
        mainView.dataMain(arrData);
    }

    @Override
    public void onFail(String message) {

    }

    @Override
    public void onSuccessLogin(ReData reData) {
        mainView.dataLogin(reData);
    }

    @Override
    public void onSuccessDelete(ReData reData) {
        mainView.dataLogin(reData);
    }
}
