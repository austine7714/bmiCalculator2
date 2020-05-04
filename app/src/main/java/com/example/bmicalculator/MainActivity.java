package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
EditText bmiResult;
EditText weightinput;
EditText heightinput;
TextView BMIcategory;

//Mwthod for taking action on button pressed
    public void myButtonListenerMethod() {
        Button button = (Button) findViewById(R.id.calcButton);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          //Getting the height from the user and and converting it to a double.
                                        final EditText heightinput = (EditText) findViewById(R.id.heightinput);
                                        String strHeight = heightinput.getText().toString();
                                        double height = Double.parseDouble(strHeight);
                                        //Getting the weight and converting it to double.
                                          final EditText weightinput = (EditText) findViewById(R.id.weightinput);
                                          String strWeight = weightinput.getText().toString();
                                          double weight = Double.parseDouble(strWeight);
                                          //Applying the formula for calculating the BMI
                                          double bmi = weight/(height*height);

                                          //Displaying the final answer on the BMIresult textfield.
                                          final EditText bmiResult = (EditText) findViewById(R.id.bmiResult);
                                          bmiResult.setText(Double.toString(bmi));
                                         //Checking the bmi category.
                                          String bmiCategory;

                                          if(bmi<15){
                                              bmiCategory = "Very severely underweight";

                                          }
                                          if(bmi<16){
                                              bmiCategory = "Severely underweight";
                                          }
                                          else if(bmi<18.5){
                                              bmiCategory = "Underweight";
                                          }
                                          else if(bmi<25){
                                              bmiCategory = "Normal";
                                          }
                                          else if(bmi<30){
                                              bmiCategory = "Overweight";
                                          }
                                          else if(bmi<35){
                                              bmiCategory = "Obese class 1 - Moderately Obese";
                                          }

                                          else if(bmi<40){
                                              bmiCategory = "Obese class 2 - Severely Obese";

                                          }
                                          else {
                                              bmiCategory = "Obese class 3 - Very severely Obese";
                                          }



                                          final TextView BMICategory = (TextView) findViewById(R.id.BMIcategory);
                                         BMICategory.setText(bmiCategory);
                                      }

                                  }


        );

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }
}