package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Results extends AppCompatActivity {
   // going to edit text and display it
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
        String name = intent.getStringExtra("result");

        TextView nameEditText;

        nameEditText = findViewById(R.id.Results);

        nameEditText.setText(name.toString(), TextView.BufferType.EDITABLE);

    }
}