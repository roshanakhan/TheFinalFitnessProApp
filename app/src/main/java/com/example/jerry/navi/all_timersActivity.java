package com.example.jerry.navi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class all_timersActivity extends AppCompatActivity {

    private Button btnTen;
    private Button btnThirty;
    private Button btnSixty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_timers_layout);

        btnTen = findViewById(R.id.btnTen);
        btnThirty = findViewById(R.id.btnThirty);
        btnSixty = findViewById(R.id.btnSixty);

        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTenMinTimer();

            }
        });

        btnThirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThirtyMinTimer();

            }
        });

        btnSixty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSixtyMinTimer();

            }
        });

}

    private void startTenMinTimer() {
        Intent intent = new Intent(this, tentimerActivity.class);
        startActivity(intent);
    }

    private void startThirtyMinTimer() {
        Intent intent = new Intent(this, thirtytimerActivity.class);
        startActivity(intent);
    }

    private void startSixtyMinTimer() {
        Intent intent = new Intent(this, sixtytimerActivity.class);
        startActivity(intent);
    }
}
