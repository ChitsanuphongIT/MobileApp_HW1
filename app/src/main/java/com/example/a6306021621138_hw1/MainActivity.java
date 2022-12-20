package com.example.a6306021621138_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Input
    EditText inputNum1, inputNum2;

    Button btnAction;

    // Output
    EditText resultSum, resultMin, resultMax;


    private void setup() {
        // Input
        inputNum1 = (EditText) findViewById(R.id.inputNum1);
        inputNum2 = (EditText) findViewById(R.id.inputNum2);

        btnAction = (Button) findViewById(R.id.btnAction);

        // Output
        resultSum = (EditText) findViewById(R.id.resultSum);
        resultMin = (EditText) findViewById(R.id.resultMinValue);
        resultMax = (EditText) findViewById(R.id.resultMaxValue);

        resultSum.setEnabled(false);
        resultMin.setEnabled(false);
        resultMax.setEnabled(false);
    }


    private int sum(int a, int b) { return a + b; }
    private int findMax(int a, int b) { return (a > b) ? a : b; }
    private int findMin(int a, int b) { return (a < b) ? a : b; }


    private void getTwoNumberInput() {

        int num1, num2;
        int sum, max, min;
        // Validation Inputs

        if (inputNum1.getText().toString().equals("")) {
            Toast.makeText(this, "Number1 is required", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputNum2.getText().toString().equals("")) {
            Toast.makeText(this, "Number2 is required", Toast.LENGTH_SHORT).show();
            return;
        }

        num1 = Integer.parseInt(inputNum1.getText().toString());
        num2 = Integer.parseInt(inputNum2.getText().toString());

        sum = this.sum(num1, num2);
        min = this.findMin(num1, num2);
        max = this.findMax(num1, num2);

        resultSum.setText(Integer.toString(sum));
        resultMax.setText(Integer.toString(max));
        resultMin.setText(Integer.toString(min));

    }


    private void watchAction() {

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTwoNumberInput();
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setup();
        this.watchAction();
    }




}