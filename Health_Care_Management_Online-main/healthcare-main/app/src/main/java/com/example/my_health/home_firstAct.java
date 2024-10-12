package com.example.my_health;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class home_firstAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_first);

        // Find the appointment button and set its click listener
        Button appointmentButton = findViewById(R.id.appointment_button);
        appointmentButton.setOnClickListener(v -> {
            // Start the Login activity when the appointment button is clicked
            startActivity(new Intent(home_firstAct.this, Login.class));
        });
    }
}







//
//
//
//package com.example.my_health;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.GravityCompat;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.ActionBarDrawerToggle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.core.view.GravityCompat;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import com.google.android.material.navigation.NavigationView;
//
//import com.google.android.material.navigation.NavigationView;
//
//public class home_firstAct extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        DrawerLayout drawerLayout;
//        NavigationView navigationView;
//        Button appointmentButton;
//
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_home_first);
//
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawerLayout = findViewById(R.id.drawer_layout);
//
//
//        appointmentButton = findViewById(R.id.appointment_button);
//        appointmentButton.setOnClickListener(v -> {
//           startActivity(new Intent(home_firstAct.this,Login.class));
//        });
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
////        navigationView.setNavigationItemSelectedListener(item -> {
////            int id = item.getItemId();
////
////            switch (id) {
////                case R.id.nav_home:
////                    Toast.makeText(home_firstAct.this, "Home", Toast.LENGTH_SHORT).show();
////                    break;
////                case R.id.nav_doctors:
////                    Toast.makeText(home_firstAct.this, "Home", Toast.LENGTH_SHORT).show();
////                    break;
////                case R.id.nav_services:
////                    Toast.makeText(home_firstAct.this, "Home", Toast.LENGTH_SHORT).show();
////                    break;
////                case R.id.nav_reviews:
////                    Toast.makeText(home_firstAct.this, "Home", Toast.LENGTH_SHORT).show();
////                    break;
////            }
////
////            drawerLayout.closeDrawer(GravityCompat.START);
////            return true;
////        });
//    }
////    @Override
////    public void onBackPressed() {
////        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
////            drawerLayout.closeDrawer(GravityCompat.START);
////        } else {
////            super.onBackPressed();
////        }
////    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_bar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        // Handle action bar item clicks here.
//        if (id == R.id.action_settings) {
//            Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
//            return true;
//        } else if (id == R.id.action_profile) {
//            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//
//}