package com.example.ukeje.carpool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ukeje.carpool.R;


public class DriverLoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
    }

    public void onClickCreateAccount(View view){

        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);

    }

    public void onClickLogin(View view){

        Intent dashBoardIntent = new Intent(this, DashboardActivity.class);
        startActivity(dashBoardIntent);
    }

}
