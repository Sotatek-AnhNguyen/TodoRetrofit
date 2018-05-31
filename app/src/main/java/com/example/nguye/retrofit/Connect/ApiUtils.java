package com.example.nguye.retrofit.Connect;

import android.util.Log;

/**
 * Created by nguye on 22/05/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://uetcc-todo-app.herokuapp.com";

    public static ReService getReService(){
        ReService reService = RetrofitClient.getClient(BASE_URL).create(ReService.class);
        return reService;
    }
}
