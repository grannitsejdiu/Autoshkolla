package com.example.admin.autoshkolla.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class Exam {
    public int id;
    public String name;
    public String description;
    public List<Question> questions = new ArrayList<Question>();
    public static Exam createFromJSON(JSONObject r) {

        Exam e = new Exam();

        try {
            e.id = r.getInt("id");
            e.name = r.getString("name");
            e.description = r.getString("description");

            if (!r.isNull("questions")){
                JSONArray qs = r.getJSONArray("questions");

                for(int i=0; i<qs.length(); i++){
                    JSONObject qo = qs.getJSONObject(i);

                    Question q = Question.createFromJSON(qo);
                    e.questions.add(q);
                }
            }
            return e;
        } catch (JSONException e1) {

        }

        return e;
    }
}
