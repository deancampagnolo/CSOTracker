package com.deancampagnolo.csotracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);



    }

    public void onButtonClicked(View v){
        switch(v.getId()){
            case R.id.MapButton:
                startActivity(new Intent(this, MapForPast.class));
                break;

            case R.id.ReportCSOButton:
                startActivity(new Intent(this, ReportCSO.class));
                break;
        }

    }


}
