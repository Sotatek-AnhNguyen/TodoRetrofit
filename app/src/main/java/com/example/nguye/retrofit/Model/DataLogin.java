package com.example.nguye.retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nguye on 28/05/2018.
 */

public class DataLogin {
    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("user")
    @Expose
    private User user;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
