package com.example.lenovo.jianningtianqi.util;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/7/12.
 */

public class HttpUtil {
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    static OkHttpClient client = new OkHttpClient();
//发送get请求
    public static void sendHttpRequest(String address, okhttp3.Callback callback) {

        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);

    }


    //Post json 数据
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    //Post 表单数据
    String postFormBody (String url, String json) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add("type","1")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
