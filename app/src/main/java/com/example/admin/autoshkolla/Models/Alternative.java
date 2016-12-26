package com.example.admin.autoshkolla.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Alternative {
    public int id;
    public String name;
    public Boolean correctAnswer;
    public Boolean userAnswer = false;
    public int question_id;

    public static Alternative createFromJson(JSONObject r){

        Alternative a = new Alternative();
        try {
            a.name = r.getString("n");
            a.correctAnswer = r.getInt("t") == 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return a;
    }
}
