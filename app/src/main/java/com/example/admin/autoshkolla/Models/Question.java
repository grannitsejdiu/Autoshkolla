package com.example.admin.autoshkolla.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Question {
    public int id;
    public String name;
    public int exam_id;
    public int points;
    public Imager image = null;

    public List<Alternative> alternatives = new ArrayList<Alternative>();

    public static Question createFromJSON(JSONObject r){

        Question q = new Question();

        try {
            q.id = r.getInt("id");
            q.name = r.getString("name");
            q.points = r.getInt("points");
            q.exam_id = r.getInt("exam_id");

            if (!r.isNull("image") &&
                    (r.getString("image") != "")){
                q.image = Imager.createFromString(r.getString("image"), false);
            }

            if (!r.isNull("alternatives")){
                JSONArray qs = r.getJSONArray("alternatives");

                for(int i=0; i<qs.length(); i++){
                    JSONObject qo = qs.getJSONObject(i);

                    //create alternative from json object
                    Alternative a = Alternative.createFromJson(qo);
                    q.alternatives.add(a);
                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return q;
    }

}
