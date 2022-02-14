package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
   // going to edit text and display it
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();
       MainActivity.results output1= getIntent().getParcelableExtra("result");
        //String name = intent.getStringExtra("result");


        TextView nameEditText;

        nameEditText = findViewById(R.id.Results);

       nameEditText.setText(output1.Name+"\n"+output1.Gender+"\n"+output1.Location+"\n"+output1.Agreed, TextView.BufferType.EDITABLE);

    }
}