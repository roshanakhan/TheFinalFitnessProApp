package com.example.jerry.navi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class bmiActivity extends AppCompatActivity {
    EditText height, weight;
    TextView result, inspo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_layout);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        Button calculate = (Button) findViewById(R.id.calculateBmi);

        calculate.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             calculateBMI();
                                         }
                                     }

        );

    }

    private void calculateBMI(){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr) ) {
            float heightValue = Float.parseFloat(heightStr) /100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "very severely underweight. Watch our videos on how you can gain weight.";
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "severely underweight. Watch our videos on how you can gain weight.";
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "underweight. Watch our videos on how you can gain weight.";
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "normal weight. Great Job!";
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "overweight. Watch our videos on how to lose weight.";
        } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "obese. Watch our videos on how to lose weight.";
        } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "very obese. Watch our videos on how to lose weight.";
        } else {
            bmiLabel = "very severely obese. Watch our videos on how to lose weight.";
        }

        bmiLabel = "BMI: " + bmi + "\n" + "Your are " + bmiLabel;
        result.setText(bmiLabel);
    }
}
