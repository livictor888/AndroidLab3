package com.example.androidlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Spinner nationalitySpinner = findViewById(R.id.nationality_spinner);
        ArrayList<String> countries = new ArrayList<>();
        Intent intent = new Intent(this, Page2.class);
        Bundle bundle = new Bundle();

        InputStream inputStream = getBaseContext().getResources().openRawResource(R.raw.countries);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            try {
                line = bufferedReader.readLine();
                countries.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> data = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nationalitySpinner.setAdapter(data);

        RadioGroup radio = findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener((radioGroup, i) -> {
            RadioButton chosenButton = findViewById(i);
            String buttonValue = chosenButton.getText().toString();
            bundle.putString("age", buttonValue);
        });

        nationalitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String chosenNationality = adapterView.getItemAtPosition(i).toString();
                bundle.putString("nationality",chosenNationality);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        intent.putExtra("bundle", bundle);
        Button next = findViewById(R.id.next_button_1);
        next.setOnClickListener(view -> startActivity(intent));
    }
}