package com.example.admin.autoshkolla.Models;

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

        return null;
    }
}
