package com.example.ukeje.carpool.retrofit;

import com.example.ukeje.carpool.response.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequests {

    @POST("api/accounts/auth/register/")
    @FormUrlEncoded
    Call<UserResponse> registerUser(@Field("username")String userName, @Field("email") String email,
                                    @Field("password") String password, @Field("is_driver") boolean isDriver,
                                    @Field("is_passenger") boolean isPassenger);

    @POST("api/accounts/auth/login/")
    @FormUrlEncoded
    Call<UserResponse> loginUser(@Field("username") String userName, @Field("password") String password);
}
