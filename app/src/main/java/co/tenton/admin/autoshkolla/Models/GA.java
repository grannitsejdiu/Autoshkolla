package co.tenton.admin.autoshkolla.Models;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by herolindsopjani on 1/27/17.
 */

public class GA {

    private static FirebaseAnalytics mFirebaseAnalytics;
    public static void start(Context context){
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }
    public static void TrackScreen(String screenName)
    {
        if (Constants.DEBUGMODE){
            return;
        }

        if(mFirebaseAnalytics != null){
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, screenName);
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
            mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);
        }
    }
    public static void TrackAction(String activity, String action, String label){
        if (Constants.DEBUGMODE){
            return;
        }

        if(mFirebaseAnalytics != null){
            Bundle bundle = new Bundle();
            bundle.putString("controller", activity);
            bundle.putString("action", action);
            bundle.putString("description", label);

            mFirebaseAnalytics.logEvent("actions", bundle);
        }
    }
}
