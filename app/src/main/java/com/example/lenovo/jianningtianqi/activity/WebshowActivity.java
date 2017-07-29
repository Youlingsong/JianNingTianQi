package com.example.lenovo.jianningtianqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.fragment.WxFragment;
import com.example.lenovo.jianningtianqi.fragment.WxFragments;

import butterknife.BindView;
import butterknife.ButterKnife;


import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by lenovo on 2017/7/23.
 */

public class WebshowActivity extends Activity {
    @BindView(R.id.webshow)
    WebView webshow;



    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webshow);
        ButterKnife.bind(this);
        Intent intent=getIntent();
        url=intent.getStringExtra(WxFragments.html_key);
        webshow.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webshow.getSettings().setJavaScriptEnabled(true);
        webshow.getSettings().setSupportZoom(true);
        webshow.getSettings().setBuiltInZoomControls(true);
        webshow.getSettings().setUseWideViewPort(true);
        webshow.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        //webshow.getSettings().setPluginsEnabled(true);
        webshow.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

     // webshow.getSettings().setDomStorageEnabled(true);
        Log.d(TAG, "onCreate: chuanru"+url);

         webshow.loadUrl(url);
        webshow.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }


        });


    }


   /* public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_test);
       webshow=(WebView)findViewById(R.id.webshow);

       // ButterKnife.bind(this);
        Intent intent=getIntent();
        url=intent.getStringExtra(WxFragment.html_key);
        Log.d(TAG, "onCreate: chuanru"+url);
       webshow.loadUrl("http://m.xxxiao.com/100820");
        /*webshow.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });*/
}

