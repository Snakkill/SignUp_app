package com.example.signupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText nameEditText; //declaration
    results UserInputs = new results();

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
        if (spinner != null) {

            spinner.setOnItemSelectedListener(this); }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        //An item was selected. You can retrieve the selected item using
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        String Location = parent.getItemAtPosition(pos).toString();
        UserInputs.Location=Location;
        Toast.makeText(this, Location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }


    public static class results implements Parcelable {
        String Gender;
        String Name;
        String Location;
        Boolean Agreed;

        protected results(Parcel in) {
            Gender = in.readString();
            Name = in.readString();
            Location = in.readString();
            byte tmpAgreed = in.readByte();
            Agreed = tmpAgreed == 0 ? null : tmpAgreed == 1;
        }

        public static final Creator<results> CREATOR = new Creator<results>() {
            @Override
            public results createFromParcel(Parcel in) {
                return new results(in);
            }

            @Override
            public results[] newArray(int size) {
                return new results[size];
            }
        };

        public results() {

        }

        public void setAgreed(Boolean agreed) {
            this.Agreed = agreed;
        }

        public void setGender(String gender) {
            this.Gender = gender;
        }

        public void setLocation(String location) {
            this.Location = location;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getGender() {
            return Gender;
        }

        public String getLocation() {
            return Location;
        }

        public Boolean getAgreed() {
            return Agreed;
        }

        public String getName() {
            return Name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(Gender);
            parcel.writeString(Name);
            parcel.writeString(Location);
            parcel.writeByte((byte) (Agreed == null ? 0 : Agreed ? 1 : 2));
        }
    }

    public void eventHandler(View view) {
        UserInputs.setName(nameEditText.getText().toString());  //name input to obj

        Intent hIntent = new Intent(this, SecondActivity.class); //explicit intent

        hIntent.putExtra("result", UserInputs);

        startActivity(hIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        return true;
    }

    public void ischecked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.maleRadio:
                if (checked)
                    Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
                UserInputs.setGender("Male");
                break;
            case R.id.femaleRadio:
                if (checked)
                    Toast.makeText(this, "female", Toast.LENGTH_SHORT).show();
                UserInputs.setGender("Male");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    public void onCheckBoxClick(View view) {
        boolean checked = ((CheckBox) view).isChecked();


        if (checked) {
            Toast.makeText(this, "check mark", Toast.LENGTH_SHORT).show();
        }
        UserInputs.setAgreed(true);

    }


}
