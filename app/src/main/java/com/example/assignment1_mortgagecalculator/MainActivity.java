package com.example.assignment1_mortgagecalculator;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText principal, rate, loanTerm;
    TextView t1;
    double num1, num2, num3;

    public boolean getNumbers() {

        //checkAndClear();
        // defining the edit text 1 to principal
        principal = (EditText) findViewById(R.id.num1);

        // defining the edit text 2 to rate
        rate = (EditText) findViewById(R.id.num2);

        // defining the edit text 3 to loanTerm
        loanTerm = (EditText) findViewById(R.id.num3);

        // defining the text view to t1
        t1 = (TextView) findViewById(R.id.result);

        // taking input from text box 1
        String s1 = principal.getText().toString();

        // taking input from text box 2
        String s2 = rate.getText().toString();

        // taking input from text box 3
        String s3 = loanTerm.getText().toString();



        if(s1.equals("Please enter value 1") && s2.equals(null))
        {
            String result = "Please enter value 2";
            rate.setText(result);
            return false;
        }
        if(s1.equals(null) && s2.equals("Please enter value 2"))
        {
            String result = "Please enter value 1";
            principal.setText(result);
            return false;
        }
        if(s1.equals("Please enter value 1") || s2.equals("Please enter value 2") || s3.equals("Please enter value 2"))
        {
            return false;
        }

        if((!s1.equals(null) && s2.equals(null) && s3.equals(null))|| (!s1.equals("") && s2.equals("") && s3.equals("")) ){

            String result = "Please enter value 2";

            rate.setText(result);
            return false;
        }
        if((s1.equals(null) && !s2.equals(null))|| (s1.equals("") && !s2.equals("")) ){
            //checkAndClear();
            String result = "Please enter value 1";
            principal.setText(result);
            return false;
        }
        if((s1.equals(null) && s2.equals(null))|| (s1.equals("") && s2.equals("")) ){
            //checkAndClear();
            String result1 = "Please enter value 1";
            principal.setText(result1);
            String result2 = "Please enter value 2";
            rate.setText(result2);
            String result3 = "Please enter value 3";
            loanTerm.setText(result3);
            return false;
        }

        else {
            // converting string to int.
            num1 = Double.parseDouble(s1);

            // converting string to int.
            num2 = Double.parseDouble(s2);

            // converting string to int.
            num3 = Double.parseDouble(s3);


        }

        return true;
    }

    public void doEmi(View v) {

        // get the input numbers
        if (getNumbers()) {
            double percent = (num2/100)/12;
            double temp = Math.pow(1 + percent, num3);
            double emi = (num1 * percent * temp)/(temp - 1);
            t1.setText(Double.toString(emi));
        }
        else
        {
            t1.setText("Error Please enter Required Values");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        principal = (EditText) findViewById(R.id.num1);
        rate = (EditText) findViewById(R.id.num2);
        loanTerm = (EditText) findViewById(R.id.num3);
    }
}
