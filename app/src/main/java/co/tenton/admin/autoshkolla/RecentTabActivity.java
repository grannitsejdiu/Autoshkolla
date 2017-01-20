package co.tenton.admin.autoshkolla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Admin on 11/14/2016.
 */

public class RecentTabActivity extends android.support.v4.app.Fragment {

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(container==null){
            return null;
        }
        //Returning the layout file after inflating
        //Change R.layout.recentstab in you classes
        return inflater.inflate(R.layout.recentstab, container, false);
    }

}
