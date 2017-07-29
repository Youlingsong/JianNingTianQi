package com.example.lenovo.jianningtianqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.lenovo.jianningtianqi.R;

/**
 * Created by lenovo on 2017/7/14.
 */

public class SplashActivity extends BaseActivity {
    private boolean timeOver = false;
    public static final String TAG_EXIT = "exit";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                timeOver = true;
               Intent intent = new Intent(SplashActivity.this, StartActivity.class);
                if(intent != null){
                    startActivity(intent);
                    finish();
                }
            }
        },3000);
    }
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            boolean isExit = intent.getBooleanExtra(TAG_EXIT, false);
            if (isExit) {
                this.finish();
            }
        }
    }
}
