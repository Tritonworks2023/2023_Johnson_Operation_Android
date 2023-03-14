package com.triton.johnsonapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.triton.johnsonapp.PDF_ListActivity;
import com.triton.johnsonapp.R;
import com.triton.johnsonapp.activity.ActivityStatusActivity;
import com.triton.johnsonapp.activity.JobDetailActivity;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Open_URL_PDFActivity extends AppCompatActivity {

        WebView webView;
        private ProgressBar progressBar;
        String pdf_path,job_id,UKEY;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_back)
    ImageView img_back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_open_url_pdfactivity);

        ButterKnife.bind(this);

        webView = findViewById(R.id.WV);
        progressBar = findViewById(R.id.pb);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            pdf_path = extras.getString("pdf_path");
        }
        if (extras != null) {
            job_id = extras.getString("job_id");
        }
        if (extras != null) {
            UKEY = extras.getString("UKEY");
        }

       // progressBar.setVisibility(View.VISIBLE);

        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        webView.setInitialScale(7);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onBackPressed();
            }
        });


        webView.setWebChromeClient(new WebChromeClient());

        /*webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                *//*webView.loadUrl("javascript:(function() { " +
                        "document.querySelector('[role=\"toolbar\"]').remove();})()");*//*
               // progressBar.setVisibility(View.GONE);
            }
        });*/
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+pdf_path);

//set the WebViewClient
        webView .setWebViewClient(new WebViewClient() {

            //add this line to Hide pop-out tool bar of pdfview in pagLoadFinish
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView .loadUrl("javascript:(function() {document.querySelector('[class=\"ndfHFb-c4YZDc-Wrql6b\"]').remove();})()");
            }
        });
        Log.w("uuuuu","https://docs.google.com/gview?embedded=true&url="+pdf_path);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        /*Intent intent = new Intent(Open_URL_PDFActivity.this, PDF_ListActivity.class);
        intent.putExtra("job_id",job_id);
        startActivity(intent);
        overridePendingTransition(R.anim.new_right, R.anim.new_left);*/
    }
}