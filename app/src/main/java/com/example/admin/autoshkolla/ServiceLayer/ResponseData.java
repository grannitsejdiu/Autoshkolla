package com.example.admin.autoshkolla.ServiceLayer;

import com.example.admin.autoshkolla.Models.ErrorResponse;

import org.json.JSONObject;

/**
 * Created by herolindsopjani on 11/24/16.
 */

public abstract class ResponseData {
    public abstract void onSuccess(JSONObject data);
    public abstract void onFailure(ErrorResponse error);
    public abstract void onNotModified();
}
