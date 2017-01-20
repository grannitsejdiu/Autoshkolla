package co.tenton.admin.autoshkolla.ServiceLayer;

import android.util.Log;

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
