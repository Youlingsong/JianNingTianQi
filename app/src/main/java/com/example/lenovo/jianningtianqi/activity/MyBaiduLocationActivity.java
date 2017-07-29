package com.example.lenovo.jianningtianqi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.example.lenovo.jianningtianqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.lenovo.jianningtianqi.MyApplication.getContext;

/**
 * Created by lenovo on 2017/7/28.
 */

public class MyBaiduLocationActivity extends BaseActivity {

    public LocationClient myLocationClient;
    private BaiduMap baiduMap;
    public boolean isFristLoccation=true;
    public MapView mapview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myLocationClient = new LocationClient(getContext());
        myLocationClient.registerLocationListener(new MybaiduLocationlistener() );

        SDKInitializer.initialize(getContext());
        setContentView(R.layout.activity_mybaidulocation);
        mapview=(MapView)findViewById(R.id.mapview);
        baiduMap=mapview.getMap();
        myLocationClient.start();


    }
    public class MybaiduLocationlistener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if(isFristLoccation) {
                LatLng ll = new LatLng(bdLocation.getLatitude(), bdLocation.getLongitude());
                MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
                baiduMap.animateMapStatus(update);
                update = MapStatusUpdateFactory.zoomTo(16f);
                baiduMap.animateMapStatus(update);
                isFristLoccation=false;
            }

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapview.onDestroy();
        myLocationClient.stop();
    }
}
