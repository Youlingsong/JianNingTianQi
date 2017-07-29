package com.example.lenovo.jianningtianqi;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;


import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.litepal.LitePal;

import static android.content.ContentValues.TAG;

/**
 * Created by lenovo on 2017/7/21.
 */

public class MyApplication extends Application {
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        LitePal.initialize(context);
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.d(TAG, "sssssss "+deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d(TAG, "onSuccess:"+s+s1 );

            }
        });


    }
    public static Context getContext(){
        return context;
    }
}
