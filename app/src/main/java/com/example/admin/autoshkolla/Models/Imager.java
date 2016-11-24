package com.example.admin.autoshkolla.Models;

import com.example.admin.autoshkolla.ServiceLayer.ServerLayer;

import org.json.JSONObject;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Imager {
    public String link;
    public Boolean isFromFb;

    public static Imager createFromJSON(JSONObject r) {

        return null;
    }
    public static Imager createFromString(String s, Boolean isFromFb) {

        Imager i = new Imager();
        i.link = s;
        i.isFromFb = isFromFb;

        return i;
    }

    public String getUrl(){
        if (isFromFb) {
            return  "";
        }else{
            return ServerLayer.getImageUrl() + link;
        }
    }
}
