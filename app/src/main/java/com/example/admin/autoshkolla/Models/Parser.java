package com.example.admin.autoshkolla.Models;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by herolindsopjani on 12/26/16.
 */

public class Parser {

    public static Boolean createFromLocalRepository(){

        return false;
    }

    public static void createFromJSONObject(JSONObject data){

        if (!data.isNull("version")){
            This.version = data.optInt("version",0);
        }

        if (!data.isNull("exams")){

            List<Exam> examList = new ArrayList<Exam>();
            try {
                JSONArray jsonsExams = data.getJSONArray("exams");
                for (int i = 0; i < jsonsExams.length(); i++){
                    Exam ex = Exam.createFromJSON(jsonsExams.getJSONObject(i));
                    examList.add(ex);
                }

                This.exams = examList;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // get subgroups
        if (!data.isNull("subgroups")){
            List<Subgroup> subgroupList = new ArrayList<Subgroup>();
            try {
                JSONArray jsonSubgroups = data.getJSONArray("subgroups");
                for (int i = 0; i < jsonSubgroups.length(); i++){
                    Subgroup sg = Subgroup.createFromJSON(jsonSubgroups.getJSONObject(i));
                    subgroupList.add(sg);
                }

                This.subgroups = subgroupList;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // get groups
        if (!data.isNull("groups")){
            List<Group> groupList = new ArrayList<Group>();
            try {
                JSONArray jsonGroups = data.getJSONArray("groups");
                for (int i = 0; i < jsonGroups.length(); i++){
                    Group g = Group.createFromJSON(jsonGroups.getJSONObject(i));
                    groupList.add(g);
                }
                This.groups = groupList;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        if (!data.isNull("ilustrations")){
            List<Sign> signList = new ArrayList<Sign>();

            try {
                JSONArray jsonSigns = data.getJSONArray("ilustrations");
                for (int i = 0; i < jsonSigns.length(); i++){
                    Sign s = Sign.createFromJSON(jsonSigns.getJSONObject(i));
                    signList.add(s);
                }
                This.illustraions = signList;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static Boolean saveToShared(Context currentContext, String response){
        SharedPreferences sh = currentContext.getSharedPreferences("current", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sh.edit();
        editor.putString("data",response);
        editor.apply();
        return true;
    }

    public static String getFromShared(Context currentContext){
        SharedPreferences sh = currentContext.getSharedPreferences("current", Context.MODE_PRIVATE);
        return sh.getString("data","");
    }
}
