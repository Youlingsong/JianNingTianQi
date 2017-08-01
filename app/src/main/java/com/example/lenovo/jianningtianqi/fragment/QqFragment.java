package com.example.lenovo.jianningtianqi.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jianningtianqi.MyApplication;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.entity.Joke_message;
import com.example.lenovo.jianningtianqi.util.HttpUtil;
import com.example.lenovo.jianningtianqi.util.Utility;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by lenovo on 2017/6/22.
 */

public class QqFragment extends Fragment {
    public Banner banner;
    public TextView tv_titler, tv_namer;
    public Joke_message.NewslistBean bean;
    ArrayList<Integer> imageList = new ArrayList();
    String titler, namer;
    @BindView(R.id.ll_next)
    LinearLayout llNext;
    Unbinder unbinder;
    public  static boolean flag=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.taocan_frist, container, false);
        banner = (Banner) view.findViewById(R.id.banner);
        tv_namer = (TextView) view.findViewById(R.id.tv_namer);
        tv_titler = (TextView) view.findViewById(R.id.tv_titler);
        initEvent();
        initView();
        initData();
        unbinder = ButterKnife.bind(this, view);
        return view;



    }

    public void initView() {
        for (int i = 0; i < 10; i++) {
            if(flag==true) {
                imageList.add(R.drawable.start_bg);
            }

        }
        flag=false;
        String[] titles = new String[]{"十大星级品牌联盟，全场2折起", "全场2折起", "十大星级品牌联盟", "嗨购5折不要停", "12趁现在", "嗨购5折不要停，12.12趁现在", "实打实大顶顶顶顶"};
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT    指示器居左
        //Banner.CENTER    指示器居中
        //Banner.RIGHT    指示器居右
        banner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        banner.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        banner.setDelayTime(5000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);
        banner.setImages(imageList);

      /*banner.setImages(images, new Banner.OnLoadImageListener() {
           @Override
           public void OnLoadImage(ImageView view, Object o) {
               Glide.with(MyApplication.getContext()).load(o).into(view);
           }
       });*/
        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(MyApplication.getContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initData() {
        String dater = "http://api.tianapi.com/txapi/godreply/?key=021f511a2895e4d23b5530cf69ec11ff";
        HttpUtil.sendHttpRequest(dater, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(), "访问网络失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                Joke_message joke_message = Utility.handleJokemessage(data);
                bean = joke_message.getNewslist().get(0);
                titler = bean.getTitle();
                namer = bean.getContent();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_titler.setText(titler);
                        tv_namer.setText(namer);
                    }
                });


            }
        });

    }

    public void initEvent() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ll_next)
    public void onClick() {
        initData();
    }
}