package com.example.my_health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class articles extends AppCompatActivity {
    ListView art_list;
    Button art_back;
    SimpleAdapter adapt;
    String[] lists;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        art_list = findViewById(R.id.art_list);
        art_back = findViewById(R.id.art_back);

        lists=  new String[]{
                "COVID-19: Understanding the Global Pandemic",
                "Smoking Kills: The Deadly Impact of Tobacco Use",
                "Healthy Eating: A Guide to Nutritious Choices",
                "Mental Health Matters: Coping with Anxiety and Depression",
                "Exercise for Life: The Benefits of Regular Physical Activity",
                "The Importance of Sleep: How to Get a Good Night’s Rest",
                "Vaccination: Protecting Yourself and Others",
                "Heart Disease: Prevention and Management",
                "Diabetes Awareness: Understanding and Managing the Condition",
                "The Role of Genetics in Health and Disease",
                "Cancer Prevention: Steps to Reduce Your Risk",
                "The Dangers of Substance Abuse: Alcohol, Drugs, and Addiction",
                "Managing Chronic Pain: Strategies for Relief",
                "Environmental Health: The Impact of Pollution on Wellness",
                "Aging Gracefully: Tips for Healthy Aging",
                "The Gut-Brain Connection: How Diet Affects Mental Health",
                "Women's Health: Addressing Unique Challenges",
                "Men's Health: Preventative Measures for a Long Life",
                "The Power of Mindfulness: Stress Reduction Techniques",
                "Emerging Infectious Diseases: What You Need to Know"
        };

        ArrayAdapter adapt = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,lists);
        art_list.setAdapter(adapt);
        art_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(articles.this,article.class);
                intent.putExtra("position",lists[position]);
                System.out.println(lists[position]);
                startActivity(intent);
            }
        });
        art_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(articles.this,Home.class));
            }
        });
    }
}