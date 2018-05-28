package com.example.jerry.navi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FeedbackForm extends AppCompatActivity

    {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback_form);
        WebView webView = (WebView) findViewById(R.id.web_view1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://docs.google.com/forms/d/1i2am9M3Ag1u06gyXjaIfRfG8PtE2ZIV4WbaQ6qXuC40/edit");
    }
    }

