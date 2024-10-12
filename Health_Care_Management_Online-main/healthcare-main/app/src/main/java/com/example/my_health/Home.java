package com.example.my_health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Home extends AppCompatActivity {
    CardView labtest,buymedicine,findmydoc,articles,orders,logout,c_findamb,helpline;
     TextView Patient_username;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        labtest = findViewById(R.id.c_labtest);
        buymedicine= findViewById(R.id.c_buymedicine);
        findmydoc = findViewById(R.id.c_finddoc);
        articles = findViewById(R.id.c_articles);
        orders = findViewById(R.id.c_orderdetails);
        logout = findViewById(R.id.logout);
        c_findamb=findViewById(R.id.c_findamb);
        helpline=findViewById(R.id.helpline);


        Patient_username = findViewById(R.id.Patient_username);

        // Get the passed data from the intent
        String userName = getIntent().getStringExtra("userName");

        // Set the text views

        Patient_username.setText("Active User: "+userName);



        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  custom();
            }

        });


//         adding direct call to ambulance feature
        c_findamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Ambulance.class));
            }
        });

        labtest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this,labtest.class));

            }
        });

        findmydoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Home.this,findmydoc.class));

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                startActivity(new Intent(Home.this,home_firstAct.class));
            }

        });
        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,myorders.class));
            }
        });

        buymedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,medicines.class));

            }
        });
        articles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,articles.class));

            }
        });
    }//-----oncreate end


    private void custom(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Home.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        dialogBuilder.setView(dialogView);

        EditText editTextMessage = dialogView.findViewById(R.id.editTextMessage);
        Button buttonSubmit = dialogView.findViewById(R.id.buttonSubmit);


        AlertDialog alertDialog = dialogBuilder.create();


        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEmail = dialogView.findViewById(R.id.editTextEmail);
                EditText editTextMessage = dialogView.findViewById(R.id.editTextMessage);

                String email = editTextEmail.getText().toString();
                String message = editTextMessage.getText().toString();


                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject of the email");
                emailIntent.putExtra(Intent.EXTRA_TEXT, message);


                PackageManager packageManager = getPackageManager();
                if (emailIntent.resolveActivity(packageManager) != null) {

                    startActivity(Intent.createChooser(emailIntent, "Share via"));
                } else {

                    Toast.makeText(getApplicationContext(), "No app found to handle this action", Toast.LENGTH_SHORT).show();
                }

                alertDialog.dismiss();
            }
        });


        alertDialog.show();
    }


}