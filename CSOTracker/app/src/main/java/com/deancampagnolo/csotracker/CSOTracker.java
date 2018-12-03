package com.deancampagnolo.csotracker;

import android.app.Application;

import com.firebase.client.Firebase;

public class CSOTracker extends Application {
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
