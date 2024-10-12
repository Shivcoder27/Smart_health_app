package com.example.my_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class article extends AppCompatActivity {
    TextView name;
    ImageView imageView;
    Button back_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        name = findViewById(R.id.topic_name);
        imageView = findViewById(R.id.imageView);
        back_a = findViewById(R.id.back_a);

        Intent intent = getIntent();
        String namet = intent.getStringExtra("position");
        name.setText(namet);

        // Set image resource based on the article name
        if (namet != null) {
            switch (namet) {
                case "COVID-19":
                    imageView.setImageResource(R.drawable.covid);
                    break;
                case "SMOKING KILLS":
                    imageView.setImageResource(R.drawable.smoking);
                    break;
                case "HEALTHY EATING":
                    imageView.setImageResource(R.drawable.water);
                    break;
                case "EXERCISE DAILY":
                    imageView.setImageResource(R.drawable.exercise);
                    break;
//                case "Mental Health Matters: Coping with Anxiety and Depression":
//                    imageView.setImageResource(R.drawable.mental_health); // Add your image resource
//                    break;
//                case "Exercise for Life: The Benefits of Regular Physical Activity":
//                    imageView.setImageResource(R.drawable.exercise); // Reuse or different image
//                    break;
//                case "The Importance of Sleep: How to Get a Good Night’s Rest":
//                    imageView.setImageResource(R.drawable.sleep); // Add your image resource
//                    break;
//                case "Vaccination: Protecting Yourself and Others":
//                    imageView.setImageResource(R.drawable.vaccine); // Add your image resource
//                    break;
//                case "Heart Disease: Prevention and Management":
//                    imageView.setImageResource(R.drawable.heart_disease); // Add your image resource
//                    break;
//                case "Diabetes Awareness: Understanding and Managing the Condition":
//                    imageView.setImageResource(R.drawable.diabetes); // Add your image resource
//                    break;
//                case "The Role of Genetics in Health and Disease":
//                    imageView.setImageResource(R.drawable.genetics); // Add your image resource
//                    break;
//                case "Cancer Prevention: Steps to Reduce Your Risk":
//                    imageView.setImageResource(R.drawable.cancer_prevention); // Add your image resource
//                    break;
//                case "The Dangers of Substance Abuse: Alcohol, Drugs, and Addiction":
//                    imageView.setImageResource(R.drawable.substance_abuse); // Add your image resource
//                    break;
//                case "Managing Chronic Pain: Strategies for Relief":
//                    imageView.setImageResource(R.drawable.chronic_pain); // Add your image resource
//                    break;
//                case "Environmental Health: The Impact of Pollution on Wellness":
//                    imageView.setImageResource(R.drawable.environmental_health); // Add your image resource
//                    break;
//                case "Aging Gracefully: Tips for Healthy Aging":
//                    imageView.setImageResource(R.drawable.aging); // Add your image resource
//                    break;
//                case "The Gut-Brain Connection: How Diet Affects Mental Health":
//                    imageView.setImageResource(R.drawable.gut_brain); // Add your image resource
//                    break;
//                case "Women's Health: Addressing Unique Challenges":
//                    imageView.setImageResource(R.drawable.womens_health); // Add your image resource
//                    break;
//                case "Men's Health: Preventative Measures for a Long Life":
//                    imageView.setImageResource(R.drawable.mens_health); // Add your image resource
//                    break;
//                case "The Power of Mindfulness: Stress Reduction Techniques":
//                    imageView.setImageResource(R.drawable.mindfulness); // Add your image resource
//                    break;
//                case "Emerging Infectious Diseases: What You Need to Know":
//                    imageView.setImageResource(R.drawable.infectious_diseases); // Add your image resource
//                    break;
//                default:
//                    imageView.setImageResource(R.drawable.default_image); // Default image if no match found
//                    break;
            }
        }

        // Back button to return to the Home activity
        back_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(article.this, Home.class));
            }
        });
    }
}
