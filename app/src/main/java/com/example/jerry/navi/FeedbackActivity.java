package com.example.jerry.navi;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
    private EditText addcontentET;
    private Button SubmitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        addcontentET = (EditText)findViewById(R.id.add_content);
        SubmitBtn = (Button)findViewById(R.id.Submit);
        Intent intent_accept = getIntent();

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoSubmitActivity();
            }
        });
    }
    private void gotoSubmitActivity() {

        String str1 = "";
        str1 = addcontentET.getText().toString();
        if ("".equals(str1.trim())){
            Toast.makeText(getApplicationContext(), "You have input nothing",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Thanks for your Feedback! We will improve our application",Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
    }
}
