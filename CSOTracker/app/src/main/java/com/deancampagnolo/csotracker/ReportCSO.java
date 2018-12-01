package com.deancampagnolo.csotracker;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class ReportCSO extends AppCompatActivity {

    private FusedLocationProviderClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_cso);

        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);


    }

    public void onButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.ReportButton:
                sendGeoLocation();
        }
    }

    private void sendGeoLocation() {

        if (ActivityCompat.checkSelfPermission(ReportCSO.this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {

            return;
        }
        client.getLastLocation().addOnSuccessListener(ReportCSO.this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    LatLng currentLocation = new LatLng(location.getLatitude(),location.getLongitude());
                    TextView textView = findViewById(R.id.location);
                    textView.setText(currentLocation.toString());

                }
            }
        });

    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
    }

}
