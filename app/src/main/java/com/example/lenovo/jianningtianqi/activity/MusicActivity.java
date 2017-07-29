package com.example.lenovo.jianningtianqi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.service.MusicService;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/7/13.
 */

public class MusicActivity extends Activity {
    Intent intent;
    @BindView(R.id.frame)
    SwipeFlingAdapterView frame;
    private ArrayList<Integer> al;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        intent = new Intent(MusicActivity.this, MusicService.class);
        startService(intent);
        final Myadapt myadapt=new Myadapt();
        frame.setAdapter(myadapt);

        al = new ArrayList();
       for(int i=0;i<100;i++){
           al.add(R.drawable.meinv);
       }
        frame.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                al.remove(0);
                myadapt.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(MusicActivity.this, "左边秀秀", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(MusicActivity.this, "右边秀秀", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                Toast.makeText(MusicActivity.this, "怎么狗娘还没吃够", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = frame.getSelectedView();

            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }

    class Myadapt extends BaseAdapter {
        @Override
        public long getItemId(int position) {
            return al.get(position);
        }

        @Override
        public int getCount() {
            return al.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = View.inflate(MusicActivity.this, R.layout.photo, null);
            ImageView im = (ImageView) view.findViewById(R.id.im);
            im.setBackgroundResource(al.get(position));
            return view;
        }
    }
}