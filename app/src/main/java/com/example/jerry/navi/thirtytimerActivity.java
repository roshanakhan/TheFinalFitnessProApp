package com.example.jerry.navi;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class thirtytimerActivity extends AppCompatActivity {

    private static final long startTimeMilliseconds = 1800000;
    private TextView countDown;
    private Button btnPause;
    private Button btnReset;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long timeLeftInMilliseconds = startTimeMilliseconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thirty_timer_layout);

        countDown = findViewById(R.id.text_view_countdown);
        btnPause = findViewById(R.id.button_start_pause);
        btnReset = findViewById(R.id.button_reset);

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                btnPause.setText("Start");
                btnPause.setVisibility(View.INVISIBLE);
                btnReset.setVisibility(View.VISIBLE);
            }
        }.start();

        timerRunning = true;
        btnPause.setText("pause");
        btnReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
        btnPause.setText("Start");
        btnReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        timeLeftInMilliseconds = startTimeMilliseconds;
        updateCountDownText();
        btnReset.setVisibility(View.INVISIBLE);
        btnPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMilliseconds / 1000) / 60;
        int seconds = (int) (timeLeftInMilliseconds / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        countDown.setText(timeLeftFormatted);
    }

}
