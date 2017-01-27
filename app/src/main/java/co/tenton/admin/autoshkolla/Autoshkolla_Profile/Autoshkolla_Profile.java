package co.tenton.admin.autoshkolla.Autoshkolla_Profile;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import co.tenton.admin.autoshkolla.R;
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
    LinearLayout linearLayout;

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
        nestedScrollView.scrollTo(0,180);


        linearLayout = (LinearLayout) findViewById(R.id.hideabbleLayout);

        appbarLayout.setExpanded(false);
        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setImageResource(R.drawable.a_collapseicon);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (appbarLayout.getTop() < 0) {
                    fab.setImageResource(R.drawable.a_collapseicon);
                    linearLayout.setVisibility(View.GONE);
                    nestedScrollView.setNestedScrollingEnabled(false);
                    appbarLayout.setExpanded(true);
                }
                else{
                    fab.setImageResource(R.drawable.a_expandicon);
                    linearLayout.setVisibility(View.VISIBLE);
                    nestedScrollView.setNestedScrollingEnabled(true);
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

        double latitude = 42.655231;
        double longitude = 21.160645;

        // Add a marker in Sydney and move the camera
        LatLng prishtina = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(prishtina).title("Sony te Tony")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.a_googlemarker)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prishtina));

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(latitude + 0.004, longitude));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
    }
}
