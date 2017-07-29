package com.example.lenovo.jianningtianqi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.example.lenovo.jianningtianqi.MyApplication;
import com.example.lenovo.jianningtianqi.R;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.hyphenate.easeui.widget.EaseTitleBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by lenovo on 2017/6/22.
 */

public class WxFragment extends Fragment {
    public EaseTitleBar titleBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.taocan_second, container, false);
        titleBar = (EaseTitleBar) view.findViewById(R.id.title_bar);
        titleBar.setTitle("张建国");
        titleBar.setRightImageResource(R.drawable.ease_mm_title_remove);
        initData();
        initVeiw();




        return view;

    }

public void  initVeiw(){

}
public void initData(){
    SDKInitializer.initialize(MyApplication.getContext());
    //环信SDK初始化
    EMOptions options = new EMOptions();
    // 默认添加好友时，是不需要验证的，改成需要验证
    options.setAcceptInvitationAlways(false);
    //初始化
    EaseUI.getInstance().init(MyApplication.getContext(), options);
    EMClient.getInstance().init(MyApplication.getContext(), options);

}


}
