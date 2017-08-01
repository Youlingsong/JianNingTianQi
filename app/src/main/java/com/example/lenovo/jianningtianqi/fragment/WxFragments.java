package com.example.lenovo.jianningtianqi.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.jianningtianqi.MyApplication;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.activity.WebshowActivity;
import com.example.lenovo.jianningtianqi.adapter.Myadapter;
import com.example.lenovo.jianningtianqi.entity.Girl_message;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by lenovo on 2017/6/22.
 */

public class WxFragments extends Fragment {
    public static String htmltext;
    public static final String html_key = "html";
    ViewHolder holder = null;
    public Girl_message girl_message;
    public Girl_message.NewslistBean bean;
    public String pictext, timetext, titletext = "3333";
    public ArrayList<Girl_message.NewslistBean> list;
    public ArrayList<String> piclist;
    public ArrayList<String> timelist;
    public ArrayList<String> titlelist;
    public ArrayList<String> htmllist;
    public ListView ll_web;
    public myAdapter myadapter;

    static class ViewHolder {
        public TextView tv_title, tv_time;
        public de.hdodenhof.circleimageview.CircleImageView Cimage;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_webshows, container, false);
        ll_web = (ListView) view.findViewById(R.id.lv_shows);
        myadapter = new myAdapter();
        ll_web.setAdapter(myadapter);
        initEvent();
        return view;

    }


    public class myAdapter extends BaseAdapter {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.taocan_thrid, null);
                holder = new ViewHolder();
                holder.Cimage = (de.hdodenhof.circleimageview.CircleImageView) convertView.findViewById(R.id.Cimage);
                holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();

            }

            holder.tv_title.setText(titlelist.get(position));
            Log.d(TAG, "getView: sssssss" + titletext);
            holder.tv_time.setText(timelist.get(position));
            Glide.with(MyApplication.getContext()).load(piclist.get(position)).into(holder.Cimage);
            return convertView;
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    public void initData() {
        String address = "http://api.tianapi.com/meinv/?key=021f511a2895e4d23b5530cf69ec11ff&num=30";
        HttpUtil.sendHttpRequest(address, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_LONG).show();
                    }
                });


            }


            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String responseText = response.body().string();
                Log.d(TAG, "onResponse: responseText" + responseText);



                for (int i = 0; i < 30; i++) {
                    girl_message = Utility.handleGirlmessage(responseText);
                    bean = girl_message.getNewslist().get(i);
                    Log.d(TAG, "onResponse: beannnnnn" + bean.toString());

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            list.add(bean);
                            myadapter.notifyDataSetChanged();
                        }
                    });


                    pictext = bean.getPicUrl();
                    piclist.add(pictext);
                    Log.d(TAG, "onResponse: piclist" + piclist.toString());
                    timetext = bean.getCtime();

                    timelist.add(timetext);
                    Log.d(TAG, "onResponse: timelist" + timelist.toString());
                    titletext = bean.getTitle();

                    titlelist.add(titletext);
                    Log.d(TAG, "onResponse: titlelist" + titlelist.toString());
                    htmltext = bean.getUrl();

                    htmllist.add(htmltext);
                    Log.d(TAG, "onResponse: htmllist" + htmllist.toString());
                }
            }
        });


    }

    public void initView() {
        list = new ArrayList<>();
        piclist = new ArrayList<>();
        timelist = new ArrayList<>();
        titlelist = new ArrayList<>();
        htmllist = new ArrayList<>();

    }

    public void initEvent() {
        //listview 条目点击事件
        ll_web.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebshowActivity.class);
                intent.putExtra(html_key, htmllist.get(position));
                Log.d(TAG, "onClick: chuanchu" + htmltext);
                startActivity(intent);
            }
        });

    }

}






