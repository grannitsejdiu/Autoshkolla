package com.example.admin.autoshkolla.ServiceLayer;

import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Response;
import com.example.admin.autoshkolla.Models.Exam;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.loopj.android.http.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cz.msebera.android.httpclient.Header;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class ExamsLayer {
    public static void getAllExams(final ResponseData r) {
        ServerLayer.get("exams", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

//                List<Exam> examsList = new ArrayList<Exam>();
//                // If the response is JSONObject instead of expected JSONArray
//                for (int i = 0; i < response.length(); i++) {
//                    try {
//                        JSONObject exam = response.getJSONObject(i);
//                        //create model from object
//                        Exam e = Exam.createFromJSON(exam);
//                        if (e != null) {
//                            examsList.add(e);
//                            Log.e("Exam", e.name);
//                        }
//                    } catch (JSONException e) {
//                        continue;
//                    }
//                }
//                r.onSuccess(examsList);
            }
        });
    }
}
