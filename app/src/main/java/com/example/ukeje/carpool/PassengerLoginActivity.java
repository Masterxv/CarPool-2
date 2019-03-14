package com.example.ukeje.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PassengerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_login);
    }

    public void onClickCreateAccount(View view){

        Intent intent = new Intent(this,PassengerRegisterationActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){

        //AppDatabase db = new AppDatabase();

       // db.testDb();

        Intent intent = new Intent(this,DashboardActivity.class);
        startActivity(intent);
    }
}
