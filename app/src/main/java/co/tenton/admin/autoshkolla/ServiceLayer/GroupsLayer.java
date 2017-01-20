package co.tenton.admin.autoshkolla.ServiceLayer;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

/**
 * Created by herolindsopjani on 11/25/16.
 */

public class GroupsLayer {

    public static void getAllGroups(final ResponseData r){
        ServerLayer.get("groups", null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

//                List<Group> groups = new ArrayList<Group>();
//
//                for (int i = 0; i < response.length(); i++) {
//                    if (response.optJSONObject(i) != null){
//                        Group g = Group.createFromJSON(response.optJSONObject(i));
//                        groups.add(g);
//                    }
//                }
//
//                r.onSuccess(groups);
            }
        });
    }
}
