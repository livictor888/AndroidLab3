package com.example.androidlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;


public class Page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");

        String age;
        if (bundle.getString("age") != null) {
            age = bundle.getString("age") + "\n";
        } else {
            age = "";
        }

        String nationality;
        if (bundle.getString("nationality") != null) {
            nationality = bundle.getString("nationality") + "\n";
        } else {
            nationality = "";
        }

        String business;
        if (bundle.getString("business") != null) {
            business = bundle.getString("business") + "\n";
        } else {
            business = "";
        }

        String relaxation;
        if (bundle.getString("relaxation") != null) {
            relaxation = bundle.getString("relaxation") + "\n";
        } else {
            relaxation = "";
        }

        String medicalReason;
        if (bundle.getString("medicalReason") != null) {
            medicalReason = bundle.getString("medicalReason") + "\n";
        } else {
            medicalReason = "";
        }

        String family;
        if (bundle.getString("family") != null) {
            family = bundle.getString("family") + "\n";
        } else {
            family = "";
        }

        String other;
        if (bundle.getString("other") != null) {
            other = bundle.getString("other") + "\n";
        } else {
            other = "";
        }

        String rating;
        if (bundle.getString("rating") != null) {
            rating = bundle.getString("rating");
        } else {
            rating = "";
        }

        TextView summaryText = findViewById(R.id.textView7);
        String info = "Country:\n" + nationality + "\n\n" + "Age Range:\n" + age + "\n\n"
                + "Most Recent Travel Purposes:\n" + business + relaxation
                + medicalReason + family + other + "\n\n"
                + "Most Recent Travel Rating:\n" + rating + " Stars";
        summaryText.setText(info);

        Button to_fourth = findViewById(R.id.button4);
        to_fourth.setOnClickListener(view -> {
            Intent intentToFourth = new Intent(this, Page4.class);
            startActivity(intentToFourth);
        });

    }

}