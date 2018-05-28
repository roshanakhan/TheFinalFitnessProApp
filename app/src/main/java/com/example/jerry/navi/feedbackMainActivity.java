package com.example.jerry.navi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class feedbackMainActivity extends AppCompatActivity {
    private Button feedbackBtn;

    private Button ratingBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_activity_main);


        //反馈按钮

        feedbackBtn = (Button)findViewById(R.id.Feedback);
        feedbackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                gotoFeedbackActivity();
            }

        });

        //打分按钮
        ratingBtn = (Button)findViewById(R.id.RatingBtn);
        ratingBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                gotoRatingPage();
            }
        });


    }
    public void gotoFeedbackActivity(){
        Intent toFeedbackForm = new Intent (feedbackMainActivity.this,FeedbackForm.class);
        startActivity(toFeedbackForm);
}
    public void gotoRatingPage(){
        Intent toRatingPage = new Intent (feedbackMainActivity.this,RatingPart.class);
        startActivity(toRatingPage);
    }



}
