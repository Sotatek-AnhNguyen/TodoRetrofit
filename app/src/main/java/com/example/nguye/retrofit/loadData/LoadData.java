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
    private Gson gson;
    private Context context;

    public LoadData(LoadDataTodo loadDataTodo, Context context) {
        this.loadDataTodo = loadDataTodo;
        reService = ApiUtils.getReService();
        gson = new Gson();
        this.context = context;
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
        reService.login(email, pass).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataTodo.onSuccessLogin(response.body());
                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }

    public void getRegister(String email, String pass, String name){
        reService.register(email, pass, name).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataTodo.onSuccessLogin(response.body());
                    Toast.makeText(context, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }

    public void createATodo(String title, String au){
        reService.createATodo(title, au).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataTodo.onSuccessLogin(response.body());
                    Toast.makeText(context, "Tạo thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Tạo thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }

    public void updateATodo(String id, String title, String au){
        reService.update(id, title, au).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataTodo.onSuccessLogin(response.body());
                    Toast.makeText(context, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }

    public void deleteATodo(String id, String au){
        reService.deleteATodo(id, au).enqueue(new Callback<ReData>() {
            @Override
            public void onResponse(Call<ReData> call, Response<ReData> response) {
                if (response.body().getSuccess()){
                    loadDataTodo.onSuccessLogin(response.body());
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReData> call, Throwable t) {

            }
        });
    }
}
