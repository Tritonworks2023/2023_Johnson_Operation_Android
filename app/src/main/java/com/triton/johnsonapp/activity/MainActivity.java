package com.triton.johnsonapp.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.triton.johnsonapp.DailyAttendanceActivity;
import com.triton.johnsonapp.R;
import com.triton.johnsonapp.activitybased.ActivityBasedActivity;
import com.triton.johnsonapp.session.SessionManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String TAG ="MainActivity";

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_job)
    Button btn_job;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.btn_activity)
    Button btn_activity;

    @SuppressLint("NonConstatntResourceId")
    @BindView(R.id.btn_general)
    Button btn_general;

    @SuppressLint("NonConstatntResourceId")
    @BindView(R.id.btn_attance)
    Button btn_attance;

    @SuppressLint("NonConstatntResourceId")
    @BindView(R.id.btn_work_sheet)
    Button btn_work_sheet;

//    @SuppressLint("NonConstantResourceId")
//    @BindView(R.id.btn_webview)
//    Button btn_webview;

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.img_logout)
    ImageView img_logout;

    private SessionManager session;
    private String url = "http://smart.johnsonliftsltd.com/";
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Log.w(TAG,"Oncreate -->");
        session = new SessionManager(getApplicationContext());

        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to Logout?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                session.logoutUser();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btn_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("test", "Job");
                myEdit.commit();

                Intent intent = new Intent(MainActivity.this, StatusActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.new_right, R.anim.new_left);
            }
        });

        btn_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("test", "activity");
                myEdit.commit();

                Intent intent = new Intent(MainActivity.this, ActivityBasedActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.new_right, R.anim.new_left);

            }
        });

        btn_general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GeneralActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.new_right, R.anim.new_left);

            }
        });

        btn_attance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DailyAttendanceActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.new_right, R.anim.new_left);
            }
        });

        btn_work_sheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GeneralActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.new_right, R.anim.new_left);

            }
        });

//        btn_webview.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("SetJavaScriptEnabled")
//            @Override
//            public void onClick(View view) {
//                progDailog = ProgressDialog.show(MainActivity.this, "Loading","Please wait...", true);
//                progDailog.setCancelable(false);
//                goWebView();
//
//              /*  Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                intent.setData(Uri.parse("http://54.202.95.145/#/admin/groupdetail"));
//                startActivity(intent);*/
//
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        showWarningLogout();

    }


    private void showWarningLogout() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> {
                    session.logoutUser();
                })
                .setNegativeButton("No", null)
                .show();
    }




}