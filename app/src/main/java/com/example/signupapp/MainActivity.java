package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameEditText; //declaration

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.editText);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.List_of_States, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    public void eventHandler(View view) {
        Toast.makeText(this,nameEditText.getText().toString(),Toast.LENGTH_SHORT).show();
        Intent hIntent = new Intent(this, Results.class); //explicit intent
        hIntent.putExtra("result",nameEditText.getText().toString());
        startActivityForResult(hIntent,123); //step 1
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

                super.onCreateOptionsMenu(menu);

        return true;
    }

    public void ischecked(View view) {
         boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.maleRadio:
                if (checked)
                    Toast.makeText(this,"Male",Toast.LENGTH_SHORT).show();
                    break;
            case R.id.femaleRadio:
                if (checked)
                    Toast.makeText(this,"female",Toast.LENGTH_SHORT).show();
                    break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    public void onCheckBoxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();


        if (checked){
            Toast.makeText(this,"check mark",Toast.LENGTH_SHORT).show();}

        }

}
