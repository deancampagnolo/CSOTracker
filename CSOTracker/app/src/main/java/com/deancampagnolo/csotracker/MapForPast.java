package com.deancampagnolo.csotracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapForPast extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng[] mapValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_for_past);

        LatLng UCSC = new LatLng(36.9916, -122.0583);
        LatLng UCSC2 = new LatLng(36.9915, -122.0583);
        LatLng UCSC3 = new LatLng(36.99151, -122.0583);

        mapValues = new LatLng[3];

        mapValues[0] = UCSC;
        mapValues[1] = UCSC2;
        mapValues[2] = UCSC3;


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //MapController mapController = mMap.getController;
        // Add a marker in Sydney and move the camera
        //mMap.zoom
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        for(LatLng i : mapValues){
            MarkerOptions markerOptions = new MarkerOptions().position(i).title("Marker in Sydney");
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.jason));
            mMap.addMarker(markerOptions);

        }

        mMap.setMinZoomPreference(15);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mapValues[0]));
        //mMap.moveCamera(CameraUpdateFactory.zoomBy(4));

    }
}
