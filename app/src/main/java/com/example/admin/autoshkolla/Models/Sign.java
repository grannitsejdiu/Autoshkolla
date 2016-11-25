package com.example.admin.autoshkolla.Models;

import org.json.JSONObject;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class Sign {
    public int id;
    public String name;
    public String description;
    public Imager imager = null;
    public Subgroup subgroup = null;
    public int group_id;

    public static Sign createFromJSON(JSONObject r){
        Sign s = new Sign();

        s.id = r.optInt("id");
        s.name = r.optString("name");
        s.description = r.optString("description");
        s.group_id = r.optInt("group_id");

        if (!r.isNull("subgroup")){
            s.subgroup = Subgroup.createFromJSON(r.optJSONObject("subgroup"));
        }

        if (!r.isNull("image")){
            s.imager = Imager.createFromString(r.optString("image"), false);
        }

        return s;
    }
}
