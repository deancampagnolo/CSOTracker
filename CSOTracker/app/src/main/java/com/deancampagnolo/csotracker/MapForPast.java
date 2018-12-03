package com.deancampagnolo.csotracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapForPast extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng[] mapValues;
    private ArrayList<String> times = new ArrayList<>();
    String url = "https://csotracker-c0a65.firebaseio.com/UserInput";


    private ArrayList<LatLng> coords = new ArrayList<>();
    private Firebase mRef;
    private Firebase mChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_for_past);



//        mRef = new Firebase(url);

        LatLng UCSC = new LatLng(36.9916, -122.0583);
        LatLng UCSC2 = new LatLng(36.9915, -122.0583);
        LatLng UCSC3 = new LatLng(36.99151, -122.0583);
        LatLng UCSC4 = new LatLng(37,-122);
        LatLng UCSC5 = new LatLng(37.01,-122.01);
        LatLng UCSC6 = new LatLng(36.98151, -122.0583);
        LatLng UCSC7 = new LatLng(36.9916,-122.0483);
        LatLng UCSC8 = new LatLng(37.02, -122.0583);
        LatLng UCSC9 = new LatLng(36.96, -122.0683);



      //  final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, times);

        /*mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.getValue(String.class);
                times.add(value);
                arrayAdapter.notifyDataSetChanged();

                int timesLength = times.size();

                mapValues =

                 h = (LatLng)dataSnapshot.child(times.get(times.size()-1)).getValue();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }
        });*/
        mapValues = new LatLng[9];

        mapValues[0] = UCSC;
        mapValues[1] = UCSC2;
        mapValues[2] = UCSC3;
        mapValues[3] = UCSC4;
        mapValues[4] = UCSC5;
        mapValues[5] = UCSC6;
        mapValues[6] = UCSC7;
        mapValues[7] = UCSC8;
        mapValues[8] = UCSC9;



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
