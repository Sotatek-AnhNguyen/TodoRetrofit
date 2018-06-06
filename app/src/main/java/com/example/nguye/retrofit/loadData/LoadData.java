package com.example.nguye.retrofit.loadData;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.nguye.retrofit.Connect.ApiUtils;
import com.example.nguye.retrofit.Connect.ReService;
import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Model.Todo;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nguye on 29/05/2018.
 */

public class LoadData {
    private ReService reService;
    private LoadDataTodo loadDataTodo;
    private LoadDataReAToddo loadDataReAToddo;
    private LoadDataLogin loadDataLogin;
    private Gson gson;

    public LoadData(LoadDataTodo loadDataTodo) {
        this.loadDataTodo = loadDataTodo;
        reService = ApiUtils.getReService();
        gson = new Gson();
    }

    public LoadData(LoadDataReAToddo loadDataReAToddo) {
        this.loadDataReAToddo = loadDataReAToddo;
        reService = ApiUtils.getReService();
        gson = new Gson();
    }

    public LoadData(LoadDataLogin loadDataLogin) {
        this.loadDataLogin = loadDataLogin;
        reService = ApiUtils.getReService();
    }

    public void getDataMain(String au){
        reService.getAu(au).enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                ArrayList<Datum> arrData = new ArrayList<>();
                for (int i = 0; i< response.body().getData().size(); i++) {
                    Datum datum = gson.fromJson(response.body().getData().get(i), Datum.class);
                    arrData.add(datum);
                }
                loadDataTodo.onSuccessTodo(arrData);
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {

            }

        });
    }

    public void getLogin(String email, String pass){

        reService.login(email, pass).enqueue(new Callback<ReData<DataLogin>>() {
            @Override
            public void onResponse(Call<ReData<DataLogin>> call, Response<ReData<DataLogin>> response) {
                if (response.body().getSuccess()){
                    loadDataLogin.onSuccessLogin(response.body());
                }else {
                    loadDataLogin.onFail("fail");
                }
            }

            @Override
            public void onFailure(Call<ReData<DataLogin>> call, Throwable t) {

            }
        });
    }

    public void getRegister(String email, String pass, String name){

        reService.register(email, pass, name).enqueue(new Callback<ReData<Datum>>() {
            @Override
            public void onResponse(Call<ReData<Datum>> call, Response<ReData<Datum>> response) {
                if (response.body().getSuccess()){
                    loadDataReAToddo.onSuccessLogin(response.body());

                }else {

                }
            }

            @Override
            public void onFailure(Call<ReData<Datum>> call, Throwable t) {

            }
        });
    }

    public void createATodo(String title, String au){
        reService.createATodo(title, au).enqueue(new Callback<ReData<Datum>>() {
            @Override
            public void onResponse(Call<ReData<Datum>> call, Response<ReData<Datum>> response) {
                if (response.body().getSuccess()){
                    loadDataReAToddo.onSuccessLogin(response.body());

                }else {

                }
            }

            @Override
            public void onFailure(Call<ReData<Datum>> call, Throwable t) {

            }
        });
    }

    public void updateATodo(String id, String title, String au){
        reService.update(id, title, au).enqueue(new Callback<ReData<Datum>>() {
            @Override
            public void onResponse(Call<ReData<Datum>> call, Response<ReData<Datum>> response) {
                if (response.body().getSuccess()){
                    loadDataReAToddo.onSuccessLogin(response.body());

                }else {

                }
            }

            @Override
            public void onFailure(Call<ReData<Datum>> call, Throwable t) {

            }
        });
    }

    public void deleteATodo(String id, String au){
        reService.deleteATodo(id, au).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataReAToddo.onSuccessLogin(response.body());

                }else {

                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }
}
