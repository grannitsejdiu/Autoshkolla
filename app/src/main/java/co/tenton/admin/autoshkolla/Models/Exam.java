package co.tenton.admin.autoshkolla.Models;

import android.content.Context;
import android.content.SharedPreferences;

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
            e.name = r.getString("n");

            if (!r.isNull("qs")){
                JSONArray qs = r.getJSONArray("qs");

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


    public void startNewExam(){
        for (Question q: questions) {
            q.clear();
        }
    }

    public int pointsResults() {
        int pts = 0;
        for (Question q: questions) {
            if (q.correct()){
                pts += q.points;
            }
        }

        return pts;
    }

    public float percentResults() {
        return (float) (pointsResults() / 100.0);
    }
    public boolean success(){
        return pointsResults() >= 90;
    }

    public void saveResults(Context context){
        SharedPreferences sh = context.getSharedPreferences("exams_results", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sh.edit();

        String keyName = "exam_" + id;
        String value = success() ? "1" : "0";
        editor.putString(keyName,value);
        editor.apply();
    }
    public ExamStatuses getLastResults(Context context){
        SharedPreferences sh = context.getSharedPreferences("exams_results", Context.MODE_PRIVATE);
        String result = sh.getString("exam_" + id, "");

        if (result.equals("1")){
            return ExamStatuses.Passed;
        } else if (result.equals("0")){
            return ExamStatuses.Failed;
        }else {
            return ExamStatuses.None;
        }
    }

}
