package com.example.lenovo.jianningtianqi.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.Answer_message;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import static com.example.lenovo.jianningtianqi.MyApplication.getContext;

/**
 * Created by lenovo on 2017/7/26.
 */

public class MylocationActivity extends BaseActivity {
    public LocationClient myLocationClient;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_welcome)
    TextView tvWelcome;
    @BindView(R.id.tv_question)
    TextView tvQuestion;
    @BindView(R.id.tv_answer)
    TextView tvAnswer;
    public Answer_message answer_message;
    public static final int UPDATE_TEXT = 1;
    public Answer_message.NewslistBean bean;
    public ArrayList<Answer_message.NewslistBean> beans = new ArrayList<>();
    public ArrayList<String> questionlist = new ArrayList<>();
    public ArrayList<String> answerlist = new ArrayList<>();
    public String questiontext, answertext;
    @BindView(R.id.bt_next)
    Button btNext;
    @BindView(R.id.bt_baidu)
    Button btBaidu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getContext());
        myLocationClient = new LocationClient(getContext());
        myLocationClient.registerLocationListener(new MyLocationListener());
        setContentView(R.layout.activity_mylocation);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        myLocationClient.setLocOption(option);
        option.setOpenGps(true);
        myLocationClient.start();
        ButterKnife.bind(this);
        initData();


        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(MylocationActivity.this, permissions, 1);
        } else {
            requestLocation();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理

        myLocationClient.stop();

    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理

    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理

    }

    @OnClick({R.id.bt_next, R.id.bt_baidu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_next:
                initData();
                break;
            case R.id.bt_baidu:
                startActivity(new Intent(MylocationActivity.this,MyBaiduLocationActivity.class));
                break;
        }
    }


    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();
            StringBuilder welcomeText = new StringBuilder();
            currentPosition.append("当前位置是：  ").append(bdLocation.getCountry());
            currentPosition.append("  ").append(bdLocation.getProvince());
            currentPosition.append("  ").append(bdLocation.getCity());
            currentPosition.append("  ").append(bdLocation.getDistrict());
            currentPosition.append("  ").append(bdLocation.getStreet()).append("街道");
            welcomeText.append(bdLocation.getCity()).append("欢迎您");
            tvLocation.setText(currentPosition);
            tvWelcome.setText(welcomeText);

        }

    }


    public void requestLocation() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    for (int result : grantResults) {
                        if (result != PackageManager.PERMISSION_GRANTED) {
                            //Toast.makeText(this, "必须同意权限才能使用", Toast.LENGTH_SHORT).show();
                            finish();
                            return;

                        }
                    }
                    requestLocation();
                } else {
                    //Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    public void initData() {
        String address = "http://api.tianapi.com/txapi/wenda/?key=021f511a2895e4d23b5530cf69ec11ff";
        HttpUtil.sendHttpRequest(address, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d(TAG, "onResponse: responseText" + responseText);


                answer_message = Utility.handleAnswermessage(responseText);
                bean = answer_message.getNewslist().get(0);
                Log.d(TAG, "onResponse: beannnnnn" + bean.toString());
                beans.add(bean);
                questiontext = bean.getQuest();
                Log.d(TAG, "onResponse: " + questiontext);
                questionlist.add(questiontext);
                answertext = bean.getResult();
                Log.d(TAG, "onResponse: " + answertext);
                answerlist.add(answertext);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvAnswer.setText(answertext);
                                tvQuestion.setText(questiontext);
                            }
                        });
                    }
                }).start();


            }
        });

    }
}
