package com.example.ukeje.carpool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ukeje.carpool.R;
import com.example.ukeje.carpool.response.UserResponse;
import com.example.ukeje.carpool.retrofit.ApiRequests;
import com.example.ukeje.carpool.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassengerLoginActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private String BASE_URL = "http://192.168.43.104:8000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_login);

        userName = findViewById(R.id.username_box);
        password = findViewById(R.id.password_box);
    }

    public void onClickCreateAccount(View view){

        Intent intent = new Intent(this,PassengerRegisterationActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){

       String name = userName.getText().toString();
       String pWord = password.getText().toString();

        ApiRequests service = RetrofitClient.getClient(BASE_URL).create(ApiRequests.class);
        Call<UserResponse> loginUser = service.loginUser(name, pWord);

        if(!name.isEmpty() && !pWord.isEmpty()){

            loginUser.enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                    Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);

                    intent.putExtra("userName",response.body().getUser().getUsername());
                    intent.putExtra("walletAmount", response.body().getUser().getWallet().getBalance().toString());
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), "incorrect username and password",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
        else{

            Toast.makeText(getApplicationContext(),"ENTER USERNAME AND PASSWORD",
                    Toast.LENGTH_LONG).show();
        }

       // Intent intent = new Intent(this,DashboardActivity.class);
        //startActivity(intent);
    }
}
