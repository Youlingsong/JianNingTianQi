package com.example.lenovo.jianningtianqi.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.Weather_message;
import com.example.lenovo.jianningtianqi.fragment.ChooseAreaFragment;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by lenovo on 2017/7/27.
 */

public class WeatherActivity extends BaseActivity {

    public Weather_message weather_message;
    public Weather_message.HeWeatherBean bean;
    public String cityname;
    public String citytmp, citytime, cityweather, cityfmax, cityfmin, cityshushi, cityxiche, cityyundong, cityftime, cityfweather;
    public String cityttime, citytweather, citytmax, citytmin, citystime, citysweather, citysmax, citysmin;
    @BindView(R.id.tv_cityname)
    TextView tvCityname;
    @BindView(R.id.tv_updatatime)
    TextView tvUpdatatime;
    @BindView(R.id.tv_tmp)
    TextView tvTmp;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_fristday)
    TextView tvFristday;
    @BindView(R.id.tv_fristweather)
    TextView tvFristweather;
    @BindView(R.id.tv_fristmax)
    TextView tvFristmax;
    @BindView(R.id.tv_fristmin)
    TextView tvFristmin;
    @BindView(R.id.tv_secondday)
    TextView tvSecondday;
    @BindView(R.id.tv_secondweather)
    TextView tvSecondweather;
    @BindView(R.id.tv_secondmax)
    TextView tvSecondmax;
    @BindView(R.id.tv_secondmin)
    TextView tvSecondmin;
    @BindView(R.id.tv_thridday)
    TextView tvThridday;
    @BindView(R.id.tv_thridweather)
    TextView tvThridweather;
    @BindView(R.id.tv_thridmax)
    TextView tvThridmax;
    @BindView(R.id.tv_thridmin)
    TextView tvThridmin;
    @BindView(R.id.city_shushi)
    TextView cityShushi;
    @BindView(R.id.city_xiche)
    TextView cityXiche;
    @BindView(R.id.city_yundong)
    TextView cityYundong;
    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.imgmore)
    ImageView imgmore;
    @BindView(R.id.drawer_layout)
  public   DrawerLayout drawerLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String bingPic = sp.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);

        } else {
            loadImage();
        }
        initData();

    }

    public void initData() {
        String weatherId = getIntent().getStringExtra(ChooseAreaFragment.WEATHER_FLAG);
        String address = "http://guolin.tech/api/weather?cityid=" + weatherId + "&key=337338f1ae4a4d4597c56a5d96996fa6";
        HttpUtil.sendHttpRequest(address, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d(TAG, "onResponse: responseText" + responseText);
                weather_message = Utility.handWeathermessage(responseText);
                bean = weather_message.getHeWeather().get(0);
                handlebean();


               /* Log.d(TAG, "onResponse: beannnnnn" + bean.toString());


                cityname = bean.getBasic().getCity();

                citytmp = bean.getNow().getTmp();
                cityfweather = bean.getDaily_forecast().get(0).getCond().getTxt_d();
                cityftime = bean.getDaily_forecast().get(0).getDate();
                cityfmax = bean.getDaily_forecast().get(0).getTmp().getMax();
                cityfmin = bean.getDaily_forecast().get(0).getTmp().getMin();

                citysweather = bean.getDaily_forecast().get(1).getCond().getTxt_d();
                citystime = bean.getDaily_forecast().get(1).getDate();
                citysmax = bean.getDaily_forecast().get(1).getTmp().getMax();
                citysmin = bean.getDaily_forecast().get(1).getTmp().getMin();

                citytweather = bean.getDaily_forecast().get(2).getCond().getTxt_d();
                cityttime = bean.getDaily_forecast().get(2).getDate();
                citytmax = bean.getDaily_forecast().get(2).getTmp().getMax();
                citytmin = bean.getDaily_forecast().get(2).getTmp().getMin();

                cityxiche = bean.getSuggestion().getCw().getTxt();
                cityyundong = bean.getSuggestion().getSport().getTxt();
                cityshushi = bean.getSuggestion().getComf().getTxt();
                citytime = bean.getBasic().getUpdate().getLoc().split(" ")[1];
                cityweather = bean.getNow().getCond().getTxt();*/


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvCityname.setText(cityname);
                                tvTmp.setText(citytmp);
                                tvFristmax.setText(cityfmax);
                                tvFristmin.setText(cityfmin);
                                tvFristday.setText(cityftime);
                                tvFristweather.setText(cityfweather);

                                tvSecondmax.setText(citysmax);
                                tvSecondmin.setText(citysmin);
                                tvSecondday.setText(citystime);
                                tvSecondweather.setText(citysweather);

                                tvThridmax.setText(citytmax);
                                tvThridmin.setText(citytmin);
                                tvThridday.setText(cityttime);
                                tvThridweather.setText(citytweather);

                                tvUpdatatime.setText(citytime);
                                cityShushi.setText(cityshushi);
                                cityXiche.setText(cityxiche);
                                cityYundong.setText(cityyundong);
                                tvWeather.setText(cityweather);
                                swipeRefresh.setRefreshing(false);
                            }
                        });
                    }
                }).start();


            }
        });
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
                loadImage();
            }
        });

    }

    public void loadImage() {
        String responseBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendHttpRequest(responseBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });

            }
        });

    }


    public void handlebean() {
        cityname = bean.getBasic().getCity();

        citytmp = bean.getNow().getTmp();
        cityfweather = bean.getDaily_forecast().get(0).getCond().getTxt_d();
        cityftime = bean.getDaily_forecast().get(0).getDate();
        cityfmax = bean.getDaily_forecast().get(0).getTmp().getMax();
        cityfmin = bean.getDaily_forecast().get(0).getTmp().getMin();

        citysweather = bean.getDaily_forecast().get(1).getCond().getTxt_d();
        citystime = bean.getDaily_forecast().get(1).getDate();
        citysmax = bean.getDaily_forecast().get(1).getTmp().getMax();
        citysmin = bean.getDaily_forecast().get(1).getTmp().getMin();

        citytweather = bean.getDaily_forecast().get(2).getCond().getTxt_d();
        cityttime = bean.getDaily_forecast().get(2).getDate();
        citytmax = bean.getDaily_forecast().get(2).getTmp().getMax();
        citytmin = bean.getDaily_forecast().get(2).getTmp().getMin();

        cityxiche = bean.getSuggestion().getCw().getTxt();
        cityyundong = bean.getSuggestion().getSport().getTxt();
        cityshushi = bean.getSuggestion().getComf().getTxt();
        citytime = bean.getBasic().getUpdate().getLoc().split(" ")[1];
        cityweather = bean.getNow().getCond().getTxt();
    }

    @OnClick(R.id.imgmore)
    public void onClick() {
        drawerLayout.openDrawer(5);
    }
}
