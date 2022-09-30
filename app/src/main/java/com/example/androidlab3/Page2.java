package com.example.androidlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;


public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");


        CheckBox business = findViewById(R.id.checkBox);
        business.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {

                String businessVal = business.getText().toString();
                bundle.putString("business", businessVal);

            } else {
                bundle.remove("business");
            }
        });


        CheckBox relaxation = findViewById(R.id.checkBox2);
        relaxation.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {

                String relaxationVal = relaxation.getText().toString();
                bundle.putString("relaxation", relaxationVal);

            } else {
                bundle.remove("relaxation");
            }
        });


        CheckBox medicalReason = findViewById(R.id.checkBox4);
        medicalReason.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {

                String medicalReasonVal = medicalReason.getText().toString();
                bundle.putString("medicalReason", medicalReasonVal);

            } else {
                bundle.remove("medicalReason");
            }
        });

        CheckBox family = findViewById(R.id.checkBox3);
        family.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {

                String familyVal = family.getText().toString();
                bundle.putString("family", familyVal);

            } else {
                bundle.remove("family");
            }
        });

        CheckBox other = findViewById(R.id.checkBox5);
        other.setOnCheckedChangeListener((compoundButton, b) -> {
            if (b) {

                String otherVal = other.getText().toString();
                bundle.putString("other", otherVal);

            } else {
                bundle.remove("other");
            }
        });

        RatingBar rating = findViewById(R.id.ratingBar);
        rating.setOnRatingBarChangeListener((ratingBar, v, b) -> {
            String ratingVal = String.valueOf(rating.getRating());
            bundle.putString("rating", ratingVal);

        });

        Button to_third = findViewById(R.id.next_button_2);
        to_third.setOnClickListener(view -> {
            Intent newIntent = new Intent(this, Page3.class);
            newIntent.putExtra("bundle", bundle);
            startActivity(newIntent);
        });
    }
}
