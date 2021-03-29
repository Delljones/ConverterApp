package com.example.theconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    EditText InputNumber;
    TextView ResultOne, ResultTwo, ResultThree;
    TextView TextViewOne, TextViewTwo, TextViewThree;
    Button Length, Temperature, Weight;
    String[] conversion = {"Meter", "Temperature", "Kilograms"};

    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);setContentView(R.layout.activity_main);

        InputNumber = findViewById(R.id.InputNumber);
        ResultOne = findViewById(R.id.ResultOne);
        ResultTwo = findViewById(R.id.ResultTwo);
        ResultThree = findViewById(R.id.ResultThree);
        TextViewOne = findViewById(R.id.TextViewOne);
        TextViewTwo = findViewById(R.id.TextViewTwo);
        TextViewThree = findViewById(R.id.TextViewThree);
        Length = findViewById(R.id.Length);
        Temperature = findViewById(R.id.Temperature);
        Weight = findViewById(R.id.Weight);

        // Set the Spinner //
        Spinner spinner = findViewById(R.id.Spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        // END Spinner items//

    }

    // Case for Which Spinner is selected //
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Temperature.setClickable(false);
        Weight.setClickable(false);
        Length.setClickable(false);

        switch (position)
        {
            case 0: // Meter //
                Length.setClickable(true);
                Toast.makeText(this, "Select Length", Toast.LENGTH_SHORT).show();
                break;

            case 1: // Celsius //
                Temperature.setClickable(true);
                Toast.makeText(this, "Select Temperature", Toast.LENGTH_SHORT).show();

            case 2:
                Weight.setClickable(true);
                Toast.makeText(this, "Select Weight", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "Unable to Select", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please Select", Toast.LENGTH_LONG).show();
    }

    // Metres - with formatted Decimal Places//
    public void Click_Length(View view) {
        double result_one = Double.parseDouble(InputNumber.getText().toString()) * 100;
        ResultOne.setText(String.format("%.2f", result_one));
        TextViewOne.setText("Centimetres");
        double result_two = Double.parseDouble(InputNumber.getText().toString()) * 3.281;
        ResultTwo.setText(String.format("%.2f", result_two));
        TextViewTwo.setText("Feet");
        double result_three = Double.parseDouble(InputNumber.getText().toString()) * 38.37;
        ResultThree.setText(String.format("%.2f", result_three));
        TextViewThree.setText("Inches");
    }

    // Celcius Conversions - with Decimal conversion //
    public void Click_Temperature(View view) {
        double result_one = Double.parseDouble(InputNumber.getText().toString()) * (9 / 5) + 32;
        ResultOne.setText(String.format("%.2f", result_one));
        TextViewOne.setText("Fahrenheit");
        double result_two = Double.parseDouble(InputNumber.getText().toString()) + 273.15;
        ResultTwo.setText(String.format("%.2f", result_two));
        TextViewTwo.setText("Kelvin");
        TextViewThree.setText("");
        ResultThree.setText("");
    }

    // Kilograms to pounds with decimal conversion //
    public void Click_Weight(View view) {
        double result_one = Double.parseDouble(InputNumber.getText().toString()) * 1000;
        ResultOne.setText(String.format("%.2f", result_one));
        TextViewOne.setText("Grams");
        double result_two = Double.parseDouble(InputNumber.getText().toString()) * 35.274;
        ResultTwo.setText(String.format("%.2f", result_two));
        TextViewTwo.setText("Ounces (OZ)");
        double result_three = Double.parseDouble(InputNumber.getText().toString()) * 2.205;
        ResultThree.setText(String.format("%.2f", result_three));
        TextViewThree.setText("Pounds (LB)");
    }
}









