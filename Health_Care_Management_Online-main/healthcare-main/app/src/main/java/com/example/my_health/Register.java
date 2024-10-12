package com.example.my_health;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {

    // Declare views
    private EditText name, email, phone, password, r_Cpassword;
    private Button register_button;
    private ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // Make sure this XML file is correct

        // Initialize views
        name = findViewById(R.id.patient_name);
        email = findViewById(R.id.patient_email);
        phone = findViewById(R.id.phone_number);
        password = findViewById(R.id.patient_password);
        r_Cpassword = findViewById(R.id.confirm_password);
        register_button = findViewById(R.id.patient_register_button);
        simpleProgressBar = findViewById(R.id.progress_bar1);

        // Null checks to prevent potential crashes
        if (name == null || email == null || phone == null || password == null || r_Cpassword == null || register_button == null || simpleProgressBar == null) {
            Log.e("RegisterActivity", "One or more views are not initialized properly. Check your XML layout file.");
            return; // Exit if any view is null
        }

        // Handle registration button click
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from the fields
                String enteredName = name.getText().toString().trim();
                String enteredEmail = email.getText().toString().trim();
                String enteredPhone = phone.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();
                String confirmedPassword = r_Cpassword.getText().toString().trim();

                // Validate input
                if (enteredName.isEmpty() || enteredEmail.isEmpty() || enteredPhone.isEmpty() || enteredPassword.isEmpty() || confirmedPassword.isEmpty()) {
                    Toast.makeText(Register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!enteredPassword.equals(confirmedPassword)) {
                    Toast.makeText(Register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Show progress bar during registration process
                simpleProgressBar.setVisibility(View.VISIBLE);

                // Create an instance of Patient
                Patient_model patient = new Patient_model(enteredName, enteredEmail, enteredPhone, enteredPassword);

                // Get the Retrofit instance and the API service
                ApiService apiService = RetrofitClient.getClient().create(ApiService.class);

                // Call the registerPatient method
                Call<Void> call = apiService.registerPatient(patient);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        // Hide progress bar when the request is finished
                        simpleProgressBar.setVisibility(View.GONE);

                        if (response.isSuccessful()) {
                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Login.class));
                        } else {
                            Toast.makeText(Register.this, "Registration failed: " + response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        // Hide progress bar if the request fails
                        simpleProgressBar.setVisibility(View.GONE);
                        Toast.makeText(Register.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

//
//        name = findViewById(R.id.patient_name);
//        email = findViewById(R.id.patient_email);
//        phone = findViewById(R.id.phone_number);
//        password = findViewById(R.id.patient_password);
//        r_Cpassword = findViewById(R.id.r_Cpassword);
//
//        register_button = findViewById(R.id.patient_register_button);
////        login_nu = findViewById(R.id.registered);
//        simpleProgressBar = findViewById(R.id.simpleProgressBar);
//
//
//
//
//        // Create an instance of Patient
//        Patient_model patient = new Patient_model(name, email, phone, password);
//
//
//
//        // Get the Retrofit instance and the API service
//        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
//
//        // Call the registerPatient method
//
//        Call<Void> call = apiService.registerPatient(patient);
//
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(Register.this, Login.class));
//                } else {
//                    Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                Toast.makeText(Register.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//
//
//
//
//






















//        r_email = findViewById(R.id.r_email);
//        r_username = findViewById(R.id.med_name);
//        r_phone = findViewById(R.id.baddress);
//        r_password = findViewById(R.id.med_price);
//        r_Cpassword = findViewById(R.id.r_Cpassword);
//        register_button = findViewById(R.id.add_cart_med);
//        login_nu = findViewById(R.id.registered);
//        simpleProgressBar = findViewById(R.id.simpleProgressBar);
//        login_nu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Register.this,Login.class));
//            }
//        });
//        register_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = r_username.getText().toString();
//                String email = r_email.getText().toString();
//                String phone = r_phone.getText().toString();
//                String password = r_password.getText().toString();
//                String Cpassword = r_Cpassword.getText().toString();
//
//                simpleProgressBar.setVisibility(View.VISIBLE);
//
//
//                //  Database db = new Database(getApplicationContext(),"myhealth",null,1);
//                if (username.length() == 0 || password.length() == 0 || email.length() == 0 || phone.length() == 0 || Cpassword.length() == 0) {
//                    Toast.makeText(getApplicationContext(), "Please fill the complete information", Toast.LENGTH_SHORT).show();
//                } else {
//                    if (password.compareTo(Cpassword) == 0) {
//                        if (valid(password)) {
//                            //----------------------------
//                            String url = "https://onlineshp.scopesoftwarecompany.com/greentest/signup.php?email=" + email
//                                    + "&username=" + username + "&phone=" + phone + "&password=" + password;
//                            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//                                    simpleProgressBar.setVisibility(View.GONE);
//
//
//
//
//                                }
//                            }, new Response.ErrorListener() {
//                                @Override
//                                public void onErrorResponse(VolleyError error) {
//
//                                }
//                            });
//
//                            RequestQueue requestQueue = Volley.newRequestQueue(Register.this);
//                            requestQueue.add(stringRequest);
//                            //---------------
//                            Toast.makeText(getApplicationContext(), "REGISTERED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(Register.this, Login.class));
//                        } else {
//                            Toast.makeText(getApplicationContext(), "PASSWORD MUST CONTAIN AT LEAST 8 CHARACTERS , HAVING LETTERS AND DIGITS", Toast.LENGTH_SHORT).show();
//                        }
//                    } else {
//                        Toast.makeText(getApplicationContext(), "CONFIRM PASSWORD DIDN'T MATCH", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//
//
//
//
//
//
//            }
//        });


//
//    }
//    public static boolean valid(String password){
//        int failure1=0,failure2=0;
//
//        if(password.length()<8){
//            return false;
//        }
//        else{
//            for (int d=0 ;  d< password.length();d++){
//                if (Character.isDigit(password.charAt(d))){
//                    failure1 = 1;
//                }}
//            for (int l=0 ;  l< password.length();l++){
//                if (Character.isLetter(password.charAt(l))){
//                    failure2 = 1;
//                }}
//            if(failure1 == 1 && failure2 == 1){
//
//
//                return true;
//            }
//            return false;
//
//        }
//
//    }
//}