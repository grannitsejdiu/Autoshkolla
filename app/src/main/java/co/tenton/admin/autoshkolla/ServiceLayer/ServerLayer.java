package co.tenton.admin.autoshkolla.ServiceLayer;

import android.provider.SyncStateContract;
import android.util.Log;

import com.loopj.android.http.*;

import co.tenton.admin.autoshkolla.Models.Constants;

/**
 * Created by herolindsopjani on 11/23/16.
 */

public class ServerLayer {
    private static final String BASE_URL = "http://autoshkolla-ks.com/api/as/v6/public/mobile/";
    private static final String BASE_URL_RESOURCE = "http://autoshkolla-ks.com/api/as/v6/public/images/v6/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        String urlToken = url + "&token=" + Constants.getToken();

        Log.e("1","Link : " + getAbsoluteUrl(urlToken));
        client.get(getAbsoluteUrl(urlToken), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        String urlToken = url + "&token=" + Constants.getToken();
        client.post(getAbsoluteUrl(urlToken), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
    public static String getImageUrl() {
        return BASE_URL_RESOURCE;
    }
}
