package com.example.jerry.navi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class caloriesActivity extends AppCompatActivity {
    EditText breakfastCal, lunchCal, dinnerCal, snacksCal, drinksCal;
    TextView totalCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_layout);

        breakfastCal = (EditText) findViewById(R.id.breakfastCal);
        lunchCal = (EditText) findViewById(R.id.lunchCal);
        dinnerCal = (EditText) findViewById(R.id.dinnerCal);
        snacksCal = (EditText) findViewById(R.id.snacksCal);
        drinksCal = (EditText) findViewById(R.id.drinksCal);
        totalCal = (TextView) findViewById(R.id.totalCal);
        Button calculate = (Button) findViewById(R.id.calculateTotalCal);

        calculate.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             calculateTotalCalories();
                                         }
                                     }

        );

    }

    private void calculateTotalCalories(){
        String breakfastStr = breakfastCal.getText().toString();
        String lunchStr = lunchCal.getText().toString();
        String dinnerStr = dinnerCal.getText().toString();
        String snacksStr = snacksCal.getText().toString();
        String drinksStr = drinksCal.getText().toString();


        if (breakfastStr != null && !"".equals(breakfastStr) && lunchStr != null && !"".equals(lunchStr)
                && dinnerStr != null && !"".equals(dinnerStr) && snacksStr != null && !"".equals(snacksStr)
                && drinksStr != null && !"".equals(drinksStr)) {

            int breakfastCal = Integer.parseInt(breakfastStr);
            int lunchCal = Integer.parseInt(lunchStr);
            int dinnerCal = Integer.parseInt(dinnerStr);
            int snacksCal = Integer.parseInt(snacksStr);
            int drinksCal = Integer.parseInt(drinksStr);


            int totCal = breakfastCal + lunchCal + dinnerCal + snacksCal + drinksCal;

            displaytotalCal(totCal);
        }
    }



    private void displaytotalCal(int totalCalories) {
        String calLabel = "";

        calLabel = "Calories consumed today: " + totalCalories;
        totalCal.setText(calLabel);
    }


}
