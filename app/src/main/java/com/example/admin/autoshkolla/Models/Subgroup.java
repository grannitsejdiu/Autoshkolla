package com.example.admin.autoshkolla.Models;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class Subgroup {
    public int id;
    public String name;
    public String description;

    public List<Sign> signs = new ArrayList<Sign>();

    public static Subgroup createFromJSON(JSONObject r){
        Subgroup s = new Subgroup();

        s.id = r.optInt("id");
        s.name = r.optString("n");
        s.description = r.optString("d");

        return s;
    }
    public void AddSign(Sign s){
        signs.add(s);
    }
}
