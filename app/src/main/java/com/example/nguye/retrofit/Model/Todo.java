package com.example.nguye.retrofit.Model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by nguye on 22/05/2018.
 */

public class Todo {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private List<JsonObject> data = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<JsonObject> getData() {
        return data;
    }

    public void setData(List<JsonObject> data) {
        this.data = data;
    }
}
