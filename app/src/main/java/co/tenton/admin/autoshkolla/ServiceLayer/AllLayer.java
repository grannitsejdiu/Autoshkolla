package co.tenton.admin.autoshkolla.ServiceLayer;

import android.util.Log;

import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import co.tenton.admin.autoshkolla.Models.This;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by herolindsopjani on 12/26/16.
 */

public class AllLayer {
    public static void getAll(final ResponseData r) {

        String currentVersion = String.valueOf(This.shared.version);

        ServerLayer.get("all?v=" + currentVersion, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                r.onSuccess(response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (statusCode == 304) {
                    r.onNotModified();
                    return;
                }

                String message = throwable.getMessage();
                ErrorResponse e = ErrorResponse.create(message);
                r.onFailure(e);
            }
        });
    }
}
