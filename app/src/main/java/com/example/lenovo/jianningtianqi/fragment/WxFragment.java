package com.example.lenovo.jianningtianqi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.lenovo.jianningtianqi.MyApplication;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.NeiHan_message;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by lenovo on 2017/6/22.
 */

public class WxFragment extends Fragment {

    public NeiHan_message neiHan_message;
    public NeiHan_message.ResultBean bean;
    public String mmpictext, mmtitletext;
    public ArrayList<NeiHan_message.ResultBean> list = new ArrayList<>();
    public ArrayList<String> titlelist = new ArrayList<>();
    public ArrayList<String> urllist = new ArrayList<>();
    public MyListviewAdapter myListviewAdapter;

    WxFragment.ViewHolder holder = null;

    static class ViewHolder {
        public TextView tv_mmtitle;
        public ImageView im_mmcontent;
    }

    public ListView ls_mama;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.taocan_second, container, false);
        ls_mama = (ListView) view.findViewById(R.id.list_mama);
        myListviewAdapter = new MyListviewAdapter();
        ls_mama.setAdapter(myListviewAdapter);
        initData();
        return view;
    }

    class MyListviewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return urllist.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(MyApplication.getContext()).inflate(R.layout.mmlistview_item, null);
                holder = new ViewHolder();
                holder.tv_mmtitle = (TextView) convertView.findViewById(R.id.tv_mmtitle);
                holder.im_mmcontent = (ImageView) convertView.findViewById(R.id.im_mmcontent);
                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();

            }

            holder.tv_mmtitle.setText(titlelist.get(position));
            Glide.with(MyApplication.getContext()).load(urllist.get(position)).into(holder.im_mmcontent);
            Log.d(TAG, "getView: "+urllist.get(position));
            return convertView;

        }
    }

    public void initData() {
        String address = "http://api.avatardata.cn/Joke/NewstImg?key=a101a190dee54b2aa9510b68adf7cf87&page=7&rows=10";
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

            for(int i=0;i<10;i++) {
                neiHan_message = Utility.handNeihanmessage(responseText);
                bean = neiHan_message.getResult().get(i);
                Log.d(TAG, "onResponse: beannnnnn" + bean.toString());

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.add(bean);
                        myListviewAdapter.notifyDataSetChanged();
                    }
                });


                mmpictext = bean.getUrl();
                urllist.add(mmpictext);
                Log.d(TAG, "onResponse: piclist" + urllist.toString());
                mmtitletext = bean.getContent();
                titlelist.add(mmtitletext);
                Log.d(TAG, "onResponse: timelist" + titlelist.toString());
            }

            }
        });
    }
}
