package com.example.lenovo.jianningtianqi.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jianningtianqi.MainActivity;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.activity.WeatherActivity;
import com.example.lenovo.jianningtianqi.db.City;
import com.example.lenovo.jianningtianqi.db.Country;
import com.example.lenovo.jianningtianqi.db.Province;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static org.litepal.LitePalApplication.getContext;

/**
 * Created by lenovo on 2017/7/13.
 */

public class ChooseAreaFragment extends Fragment {
    public static final int LEVEL_PROVINCE = 0;
    public static final int LEVEL_CITY = 1;
    public static final int LEVEL_COUNTY = 2;
    public ProgressDialog progressDialog;
    public List<String> datalist = new ArrayList<>();
    @BindView(R.id.iv_menus)
    ImageView ivMenus;
    @BindView(R.id.list_view)
    ListView listView;
    Unbinder unbinder;
    @BindView(R.id.tv_name)
    TextView tvName;
    private ArrayAdapter<String> adapter;
    private List<Province> provinceList;
    private List<Country> countryList;
    private List<City> cityList;
    private Province selectProvince;
    private City selectCity;
    private int currentLevel;
    public static String WEATHER_FLAG="weather_id";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_choose, container, false);

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, datalist);

        unbinder = ButterKnife.bind(this, view);
        listView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectProvince = provinceList.get(position);
                    queryCity();
                } else if (currentLevel == LEVEL_CITY) {
                    selectCity = cityList.get(position);
                    queryCounty();
                }else if(currentLevel==LEVEL_COUNTY){
                    String weatherid=countryList.get(position).getWeatherId();
                    if(getActivity()instanceof MainActivity){
                    Intent intent=new Intent(getActivity(), WeatherActivity.class);
                    intent.putExtra(WEATHER_FLAG,weatherid);
                    startActivity(intent);}else{
                        WeatherActivity activity=(WeatherActivity) getActivity();
                        activity.drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent=new Intent(getActivity(), WeatherActivity.class);
                        intent.putExtra(WEATHER_FLAG,weatherid);
                        startActivity(intent);

                    }
                }
            }
        });
        queryProvince();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_menus)
    public void onClick() {
        //Toast.makeText(getContext(), "dfsdfs", Toast.LENGTH_SHORT).show();
        if (currentLevel == LEVEL_COUNTY) {
            queryCity();
        } else if (currentLevel == LEVEL_CITY) {
            queryProvince();
        }

    }

    private void queryProvince() {
        tvName.setText("中国");
        ivMenus.setVisibility(View.INVISIBLE);
        provinceList = DataSupport.findAll(Province.class);
        if (provinceList.size() > 0) {
            datalist.clear();
            for (Province province : provinceList) {
                datalist.add(province.getProvinceName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_PROVINCE;
        } else {
            String address = "http://guolin.tech/api/china";
            queryFromServer(address, "province");
        }
    }

    private void queryCity() {
        tvName.setText(selectProvince.getProvinceName());
        ivMenus.setVisibility(View.VISIBLE);
        cityList = DataSupport.where("provinceid= ?", String.valueOf(selectProvince.getId())).find(City.class);
        if (cityList.size() > 0) {
            datalist.clear();
            for (City city : cityList) {
                datalist.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_CITY;
        } else {
            int provinceCode = selectProvince.getProvinceCode();
            String address = "http://guolin.tech/api/china/" + provinceCode;
            queryFromServer(address, "city");
        }


    }

    private void queryCounty() {
        tvName.setText(selectCity.getCityName());
        ivMenus.setVisibility(View.VISIBLE);
        countryList = DataSupport.where("cityid= ?", String.valueOf(selectCity.getId())).find(Country.class);
        if (countryList.size() > 0) {
            datalist.clear();
            for (Country country : countryList) {
                datalist.add(country.getCountryName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_COUNTY;
        } else {
            int provinceCode = selectProvince.getProvinceCode();
            int cityCode = selectCity.getCityCode();
            String address = "http://guolin.tech/api/china/" + provinceCode + "/" + cityCode;
            queryFromServer(address, "county");
        }


    }

    public void queryFromServer(String address, final String type) {
        showProgressDialof();
        HttpUtil.sendHttpRequest(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialof();
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_LONG).show();
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String responseText = response.body().string();
                boolean result = false;
                if ("city".equals(type)) {

                    result = Utility.handleCityResponse(responseText, selectProvince.getId());
                } else if ("county".equals(type)) {
                    result = Utility.handCountyResponse(responseText, selectCity.getId());

                } else if ("province".equals(type)) {
                    result = Utility.handleProvinceResponse(responseText);
                }
                if (result) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            closeProgressDialof();
                            if ("city".equals(type)) {

                                queryCity();
                            } else if ("county".equals(type)) {
                                queryCounty();

                            } else if ("province".equals(type)) {
                                queryProvince();
                            }
                        }
                    });
                }

            }
        });
    }

    private void showProgressDialof() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载");
            progressDialog.setCanceledOnTouchOutside(false);
        }

        progressDialog.show();
    }

    private void closeProgressDialof() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }


    }



}
