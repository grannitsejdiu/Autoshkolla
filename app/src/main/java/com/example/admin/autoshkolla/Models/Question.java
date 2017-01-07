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
            q.name = r.getString("n");
            q.points = r.getInt("p");

            if (!r.isNull("i") &&
                    (r.getString("i") != "")){
                q.image = Imager.createFromString(r.getString("i"), false);
            }

            if (!r.isNull("als")){
                JSONArray qs = r.getJSONArray("als");

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

    public void clear() {
        for (Alternative a: alternatives) {
            a.userAnswer = false;
        }
    }

    public boolean correct() {
        for (Alternative a:alternatives) {
            if (a.correctAnswer != a.userAnswer){
                return false;
            }
        }
        return true;
    }
}
