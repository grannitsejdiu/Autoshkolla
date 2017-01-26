package co.tenton.admin.autoshkolla.ServiceLayer;

import android.media.Image;
import android.os.Build;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RangeFileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.io.File;

import co.tenton.admin.autoshkolla.Models.ErrorResponse;
import cz.msebera.android.httpclient.Header;

/**
 * Created by herolindsopjani on 1/26/17.
 */

public class ReportLayer {
    public static void report(String message, final ResponseData result){

        String deviceModel = Build.MODEL;
        String deviceId = Build.ID;
        String deviceSystemVersion = Build.VERSION.RELEASE;
        String deviceName = Build.MODEL;
        String deviceLocalizedModel = Build.MANUFACTURER;


        RequestParams params = new RequestParams();

        params.add("deviceModel", deviceModel);
        params.add("deviceId", deviceId);
        params.add("deviceSystemVersion", deviceSystemVersion);
        params.add("deviceName", deviceName);
        params.add("deviceLocalizedModel", deviceLocalizedModel);
        params.add("message", message);


        ServerLayer.post("report", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                result.onSuccess(null);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ErrorResponse e = ErrorResponse.create("Nuk mund te dergohet raportimi. Shikoni lidhjen me internet.");
                result.onFailure(e);
            }
        });
    }
}
