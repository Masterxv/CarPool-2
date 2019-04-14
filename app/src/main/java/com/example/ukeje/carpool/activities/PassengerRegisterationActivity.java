package com.example.ukeje.carpool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ukeje.carpool.R;
import com.example.ukeje.carpool.activities.DashboardActivity;
import com.example.ukeje.carpool.response.UserResponse;
import com.example.ukeje.carpool.retrofit.ApiRequests;
import com.example.ukeje.carpool.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassengerRegisterationActivity extends AppCompatActivity {

    //iNITIALIZING UI VIEWS WILL CHANGE TO DATA BINDING LATER
    private String BASE_URL = "http://192.168.43.104:8000/";
    private EditText userName;
    private EditText email;
    private EditText password;
    private EditText passwordTwo;
    boolean isDriver = false;
    boolean isPassenger = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_registeration);

        //Initializing the xml views
        userName = findViewById(R.id.reg_pas_username);
        email = findViewById(R.id.reg_pas_email);
        password = findViewById(R.id.reg_pas_password);
        passwordTwo = findViewById(R.id.reg_pas_password_two);
    }

    public void onCLickRegister(View view ){

        String name = userName.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();
        String checkPassword = passwordTwo.getText().toString();

        ApiRequests service = RetrofitClient.getClient(BASE_URL).create(ApiRequests.class);
        Call<UserResponse> registerUser = service.registerUser(name, userEmail, userPassword,
                                        isDriver, isPassenger);

        if(userPassword.equalsIgnoreCase(checkPassword)){
            if(passwordTwo.getText().toString().length() >= 8){

                registerUser.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                        //Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                        //Log.i("SERVER RESPONSE:", response.toString());

                        //Initialize Dashboard Activity
                        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);

                        intent.putExtra("userName",response.body().getUser().getUsername());
                        intent.putExtra("walletAmount", response.body().getUser().getWallet().getBalance().toString());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "ERROR",Toast.LENGTH_LONG).show();

                    }
                });
            }
            else{
                Toast.makeText(getApplicationContext(),"PASSWORD IS TOO SHORT",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"PASSWORDS DO NOT MATCH",
                    Toast.LENGTH_SHORT).show();
        }


    }
}
