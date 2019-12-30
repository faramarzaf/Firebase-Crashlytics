package com.faraaf.tictacdev.firebasecrashlytics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.google.firebase.crash.FirebaseCrash;

import java.io.IOException;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCrash;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fabric.with(this, new Crashlytics());
        btnCrash = findViewById(R.id.btnCrash);
        btnCrash.setOnClickListener(this);

    }

    public void forceCrash() {
        throw new RuntimeException("This is a crash");
    }

    @Override
    public void onClick(View v) {
        Crashlytics.log(Log.DEBUG, "tag", "message");
        try {
            forceCrash();
        } catch (Exception e) {
            Crashlytics.logException(e);
        }
    }
}
