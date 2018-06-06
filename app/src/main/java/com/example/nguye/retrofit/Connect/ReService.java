package com.example.nguye.retrofit.Connect;

import com.example.nguye.retrofit.Model.DataLogin;
import com.example.nguye.retrofit.Model.Datum;
import com.example.nguye.retrofit.Model.ReData;
import com.example.nguye.retrofit.Model.Todo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by nguye on 22/05/2018.
 */

public interface ReService {
    @GET("/todos?page=1")
    Call<Todo> getAu(@Header("Authorization") String au);

   @POST("/login")
   @FormUrlEncoded
    Call<ReData<DataLogin>> login(@Field("email") String email, @Field("password") String pass);

   @POST("/register")
   @FormUrlEncoded
    Call<ReData<Datum>> register(@Field("email") String email, @Field("password") String pass, @Field("name") String name);

   @POST("/todos")
   @FormUrlEncoded
    Call<ReData<Datum>> createATodo(@Field("title") String title, @Header("Authorization") String au);

   @PUT("/todos/{id}")
   @FormUrlEncoded
    Call<ReData<Datum>> update(@Path("id") String id, @Field("title") String title, @Header("Authorization") String au);

   @DELETE("/todos/{id}")
    Call<ReData> deleteATodo(@Path("id") String id, @Header("Authorization") String au);

}
