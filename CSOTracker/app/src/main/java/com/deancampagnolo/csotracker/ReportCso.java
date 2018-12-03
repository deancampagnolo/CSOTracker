package com.deancampagnolo.csotracker;

import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import  java.util.Calendar;
import java.util.Date;

import com.firebase.client.Firebase;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class ReportCSO extends AppCompatActivity {

    private FusedLocationProviderClient client;
    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_cso);

        requestPermission();
        client = LocationServices.getFusedLocationProviderClient(this);

        mRootRef = new Firebase("https://csotracker-c0a65.firebaseio.com/UserInput");

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
                    Date currentTime = Calendar.getInstance().getTime();
                    TextView textView = findViewById(R.id.location);
                    textView.setText(currentLocation.toString());
                    String value = currentTime.toString();
                    Firebase childRef = mRootRef.child(value);
                    childRef.setValue(currentLocation);
                    Toast.makeText(ReportCSO.this, "ESKETIT!!!! YOUR COORDINATES HAVE BEEN SENT!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION},1);
    }

}
