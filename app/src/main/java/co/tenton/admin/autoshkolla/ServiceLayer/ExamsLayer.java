package co.tenton.admin.autoshkolla.ServiceLayer;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

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
