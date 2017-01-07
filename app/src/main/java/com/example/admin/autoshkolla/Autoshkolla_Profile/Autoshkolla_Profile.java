package com.example.admin.autoshkolla.Autoshkolla_Profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.autoshkolla.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Autoshkolla_Profile extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button autoshkolla_BackButton;
    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoshkolla__profile);

        autoshkolla_BackButton = (Button) findViewById(R.id.autoshkolla_FormBackButton);
        autoshkolla_BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Autoshkolla_Profile.super.onBackPressed();
            }
        });

        final AppBarLayout appbarLayout = (AppBarLayout)findViewById(R.id.app_bar);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScroll);
        nestedScrollView.scrollTo(0,200);
        
        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setImageResource(R.drawable.a_collapseicon);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appbarLayout.getTop() < 0) {
                    fab.setImageResource(R.drawable.a_collapseicon);
                    appbarLayout.setExpanded(true);
                }
                else{
                    fab.setImageResource(R.drawable.a_expandicon);
                    appbarLayout.setExpanded(false);
                }
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        final CoordinatorLayout mainScrollView = (CoordinatorLayout) findViewById(R.id.cscroll);
        ImageView transparentImageView = (ImageView) findViewById(R.id.imagetrans);

        transparentImageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        mainScrollView.requestDisallowInterceptTouchEvent(true);
                        // Disable touch on transparent view
                        return false;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        mainScrollView.requestDisallowInterceptTouchEvent(false);
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        mainScrollView.requestDisallowInterceptTouchEvent(true);
                        return false;

                    default:
                        return true;
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng prishtina = new LatLng(42.655231, 21.160645);
        mMap.addMarker(new MarkerOptions().position(prishtina).title("Sony te Tony")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prishtina));

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(42.655231, 21.160645));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
}
