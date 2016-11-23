package com.example.admin.autoshkolla.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Exam {
    public int id;
    public String name;
    public String description;
    public List<Question> questions;
    public static Exam createFromJSON(JSONObject r) {

        Exam e = new Exam();

        try {
            e.id = r.getInt("id");
            e.name = r.getString("name");
            e.description = r.getString("description");

            return e;
        } catch (JSONException e1) {

        }

        return e;
    }
}
