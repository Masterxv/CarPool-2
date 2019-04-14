package com.example.ukeje.carpool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ukeje.carpool.R;

public class LoginSelectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_selector);
    }

    public void onClickPassenger(View view){

        Intent intent = new Intent(this, PassengerLoginActivity.class);
        startActivity(intent);
    }

    public void onClickDriver(View view){

        Intent intent = new Intent(this, DriverLoginActivity.class);
        startActivity(intent);
    }


}
