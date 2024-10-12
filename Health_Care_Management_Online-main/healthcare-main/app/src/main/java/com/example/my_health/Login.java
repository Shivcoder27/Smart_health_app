package com.example.my_health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText login_username, login_password;
    Button login_button, adminBtn, registerBtn;
    TextView register_nu;
    private EditText email, password;
    private Button loginButton;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        email = findViewById(R.id.patient_email_login);
        password = findViewById(R.id.patient_password_login);
        loginButton = findViewById(R.id.patient_loginBtn);
        //adminBtn = findViewById(R.id.adminBtn);
        registerBtn = findViewById(R.id.patient_registered);

        // Initialize progress bar
        progressBar = findViewById(R.id.progressBar_login); // This line was missing

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                // Validate input
                if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                    Toast.makeText(Login.this, "Email and password are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Show progress bar
                if (progressBar != null) {
                    progressBar.setVisibility(View.VISIBLE);
                }

                // Create a login request
                LoginRequest loginRequest = new LoginRequest(enteredEmail, enteredPassword);

                // Make the API call
                ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
                Call<LoginResponse> call = apiService.loginUser(loginRequest);

                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        // Hide progress bar
                        if (progressBar != null) {
                            progressBar.setVisibility(View.GONE);
                        }

                        if (response.isSuccessful() && response.body() != null) {
                            // Get the patient ID and name from the response
                            LoginResponse.User user = response.body().getUser();
                            String userId = user.getId();
                            String userName = user.getName();

                            // Navigate to HomeActivity and pass the user data
                            Intent intent = new Intent(Login.this, Home.class);
                            intent.putExtra("userId", userId);
                            intent.putExtra("userName", userName);
                            startActivity(intent);

                            Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Login.this, "Login failed: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        // Hide progress bar
                        if (progressBar != null) {
                            progressBar.setVisibility(View.GONE);
                        }
                        Toast.makeText(Login.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

//        adminBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Login.this, AdminLogin.class));
//            }
//        });
    }
}
