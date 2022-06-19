package com.dedsec.materialui.activity.button;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.dedsec.materialui.R;
import com.dedsec.materialui.utils.Tools;

public class ButtonFabMiddle extends AppCompatActivity {

    //private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_fab_middle);

        //initMapFragment();
        Tools.setSystemBarColor(this, R.color.colorAccent);

    }

    /*
    private void initMapFragment() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = Tools.configActivityMaps(googleMap);
                CameraUpdate location;
                MarkerOptions markerOptions = new MarkerOptions().position(new LatLng(37.7610237, -122.4217785));
                mMap.addMarker(markerOptions);
                location = CameraUpdateFactory.newLatLngZoom(new LatLng(37.76496792, -122.42206407), 13);
                mMap.moveCamera(location);
            }
        });
    }
     */
}

