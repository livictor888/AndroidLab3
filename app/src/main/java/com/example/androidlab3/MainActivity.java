package com.example.androidlab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonStart(View view) {
        EditText courseCodeText = findViewById(R.id.courseCodeInputBox);
        String value = courseCodeText.getText().toString();

//        if (value.equals("COMP3717")) {
        if (value.equals("q")) {
            Intent page1Intent = new Intent(this, Page1.class);
            startActivity(page1Intent);
        } else {
            Toast wrongCodeToast = Toast.makeText(getApplicationContext(), "WRONG CODE", Toast.LENGTH_SHORT);
            TextView toastText = wrongCodeToast.getView().findViewById(android.R.id.message);
            toastText.setTextColor(Color.RED);
            wrongCodeToast.show();
        }
    }
}