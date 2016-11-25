package com.example.admin.autoshkolla.ServiceLayer;

import android.util.Log;

import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.Group;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class GroupsLayer {

    public static void getAllGroups(final ResponseData r){
        ServerLayer.get("groups", null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                List<Group> groups = new ArrayList<Group>();

                for (int i = 0; i < response.length(); i++) {
                    if (response.optJSONObject(i) != null){
                        Group g = Group.createFromJSON(response.optJSONObject(i));
                        groups.add(g);
                    }
                }

                r.onSuccess(groups);
            }
        });
    }
}
