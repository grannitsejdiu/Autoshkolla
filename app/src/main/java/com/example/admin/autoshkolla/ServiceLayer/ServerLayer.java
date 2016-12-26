package com.example.admin.autoshkolla.ServiceLayer;

import android.app.DownloadManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.*;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class ServerLayer {
    private static final String BASE_URL = "http://autoshkolla-ks.com/api/as/v6/public/mobile/";
    private static final String BASE_URL_RESOURCE = "http://autoshkolla-ks.com/api/as/v6/public/images/v6/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        Log.e("1","Link : " + getAbsoluteUrl(url));
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
    public static String getImageUrl() {
        return BASE_URL_RESOURCE;
    }
}
