package com.example.lenovo.jianningtianqi.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.lenovo.jianningtianqi.R;

import java.io.IOException;

/**
 * Created by lenovo on 2017/6/6.
 */

public class MusicService extends Service {
    private MediaPlayer mp;
    @Nullable
    @Override
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        //开始播放音乐
        mp.start();
        //音乐播放完毕的事件处理
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                //循环播放
                try {
                    mp.start();
                } catch (IllegalStateException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public void onCreate() {
        // TODO Auto-generated method stub
        //初始化音乐资源
        try {
            //创建MediaPlayer对象
            mp = new MediaPlayer();
            //将音乐以Import的方式保存在res/raw/zhou.mp3
            mp = MediaPlayer.create(MusicService.this, R.raw.wan);
            //在MediaPlayer取得播放资源与stop()之后要准备PlayBack的状            态前一定要使用MediaPlayer.prepeare()
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        super.onCreate();
    }
    public void onDestroy() {
        // TODO Auto-generated method stub
        //服务停止时停止播放音乐并释放资源
        mp.stop();
        mp.release();

        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
