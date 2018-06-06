package com.example.nguye.retrofit.Presenter;

import com.example.nguye.retrofit.Activity.ViewInterface.CreateView;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.loadData.LoadData;
import com.example.nguye.retrofit.loadData.LoadDataReAToddo;

/**
 * Created by nguye on 04/06/2018.
 */

public class CreatePresenter implements LoadDataReAToddo {
    private LoadData loadData;
    private CreateView createView;

    public CreatePresenter(CreateView createView) {
        this.createView = createView;
        loadData = new LoadData(this);
    }

    public void loadRegist(String email, String pass, String name){
        loadData.getRegister(email, pass, name);
    }

    @Override
    public void onSuccessLogin(ReData reData) {
        createView.regist(reData);
    }

    @Override
    public void onFail(String message) {

    }
}
