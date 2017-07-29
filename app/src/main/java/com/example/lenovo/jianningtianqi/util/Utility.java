package com.example.lenovo.jianningtianqi.util;

import android.nfc.Tag;
import android.text.TextUtils;
import android.util.Log;

import com.example.lenovo.jianningtianqi.db.City;
import com.example.lenovo.jianningtianqi.db.Country;
import com.example.lenovo.jianningtianqi.db.Province;
import com.example.lenovo.jianningtianqi.entity.Answer_message;
import com.example.lenovo.jianningtianqi.entity.Girl_message;
import com.example.lenovo.jianningtianqi.entity.Joke_message;
import com.example.lenovo.jianningtianqi.entity.QQ_message;
import com.example.lenovo.jianningtianqi.entity.Weather_message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by lenovo on 2017/7/13.
 */

public class Utility {



    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvince=new JSONArray(response);
                for(int i=0;i<allProvince.length();i++){
                    JSONObject provinceObject=allProvince.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCity=new JSONArray(response);
                for(int i=0;i<allCity.length();i++) {
                    JSONObject cityObject = allCity.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

          return  true;
        }
        return  false;
    }


    public static boolean handCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounty=new JSONArray(response);
                for(int i=0;i<allCounty.length();i++){
                    JSONObject countyObject=allCounty.getJSONObject(i);
                    Country country=new Country();
                    country.setCityId(cityId);
                    country.setCountryName(countyObject.getString("name"));
                    country.setWeatherId(countyObject.getString("weather_id"));
                    country.save();


                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return  false;

    }
    public static QQ_message handleQQmessage(String response) {

        if (!TextUtils.isEmpty(response)) {
            String Data = response;
           Gson gson = new Gson();
            QQ_message bean = gson.fromJson(Data,QQ_message.class);
            return bean;

        }
        return null;
    }

    public static Girl_message handleGirlmessage(String response) {

        if (!TextUtils.isEmpty(response)) {
            String Data = response;
            Log.d(TAG, "handleGirlmessage: Data");
            Gson gson = new Gson();
            Girl_message bean = gson.fromJson(Data,Girl_message.class);
            return bean;

        }
        return null;
    }

    public static Joke_message handleJokemessage(String response) {

        if (!TextUtils.isEmpty(response)) {
            String Data = response;
            Log.d(TAG, "handleJokemessage: Data");
            Gson gson = new Gson();
           Joke_message bean = gson.fromJson(Data,Joke_message.class);
            return bean;

        }
        return null;
    }

    public static Answer_message handleAnswermessage(String response) {

        if (!TextUtils.isEmpty(response)) {
            String Data = response;
            Log.d(TAG, "handleAnser: Data");
            Gson gson = new Gson();
            Answer_message bean = gson.fromJson(Data,Answer_message.class);
            return bean;

        }
        return null;
    }
    public static Weather_message handWeathermessage(String response) {

        if (!TextUtils.isEmpty(response)) {
            String Data = response;
            Log.d(TAG, "handleAnser: Data");
            Gson gson = new Gson();
            Weather_message bean = gson.fromJson(Data,Weather_message.class);
            return bean;
        }
        return null;
    }



}
