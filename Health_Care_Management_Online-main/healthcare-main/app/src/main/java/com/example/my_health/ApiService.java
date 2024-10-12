package com.example.my_health;

// ApiService.java
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("auth/register/patient")
    Call<Void> registerPatient(@Body Patient_model patient);

    @POST("auth/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
}
