package com.example.lenovo.jianningtianqi.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.bumptech.glide.Glide;
import com.example.lenovo.jianningtianqi.MainActivity;
import com.example.lenovo.jianningtianqi.MyApplication;
import com.example.lenovo.jianningtianqi.R;
import com.example.lenovo.jianningtianqi.fragment.QqFragment;
import com.example.lenovo.jianningtianqi.fragment.WxFragment;
import com.example.lenovo.jianningtianqi.fragment.WxFragments;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/7/13.
 */

public class ShouyeActivity extends AppCompatActivity {
    private QqFragment fragment;
    private WxFragments wxFragments;
    private WxFragment wxFragment;


    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.im)
    ImageView im;
    /* @BindView(R.id.image_view)
     ImageView imageView;
     @BindView(R.id.banner)
     Banner banner;*/

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    public TextView tv_navname;
    public de.hdodenhof.circleimageview.CircleImageView cimage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        ButterKnife.bind(this);
        initView();

        initData();
        initEvent();




        // bottomNavigationBar.setTabSelectedListener(this);


       /* ArrayList<Integer> imageList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            imageList.add(R.drawable.start_bg);
        }
       /* String[] images = new String[]{
                "http://218.192.170.132/BS80.jpg",
                "http://img.zcool.cn/community/0166c756e1427432f875520f7cc838.jpg",
                "http://img.zcool.cn/community/018fdb56e1428632f875520f7b67cb.jpg",
                "http://img.zcool.cn/community/01c8dc56e1428e6ac72531cbaa5f2c.jpg",
                "http://img.zcool.cn/community/01fda356640b706ac725b2c8b99b08.jpg",
                "http://img.zcool.cn/community/01fd2756e142716ac72531cbf8bbbf.jpg",
                "http://img.zcool.cn/community/0114a856640b6d32f87545731c076a.jpg"};
        String[] titles = new String[]{"十大星级品牌联盟，全场2折起", "全场2折起", "十大星级品牌联盟", "嗨购5折不要停", "12趁现在", "嗨购5折不要停，12.12趁现在", "实打实大顶顶顶顶"};
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR_TITLE);*/

        //设置轮播样式（没有标题默认为右边,有标题时默认左边）
        //可选样式:
        //Banner.LEFT    指示器居左
        //Banner.CENTER    指示器居中
        //Banner.RIGHT    指示器居右
      /*  banner.setIndicatorGravity(Banner.CENTER);

        //设置轮播要显示的标题和图片对应（如果不传默认不显示标题）
        banner.setBannerTitle(titles);

        //设置是否自动轮播（不设置则默认自动）
        banner.isAutoPlay(true);

        //设置轮播图片间隔时间（不设置默认为2000）
        banner.setDelayTime(5000);
        //设置图片资源:可选图片网址/资源文件，默认用Glide加载,也可自定义图片的加载框架
        //所有设置参数方法都放在此方法之前执行
        //banner.setImages(images);
        banner.setImages(imageList);*/

      /* banner.setImages(images, new Banner.OnLoadImageListener() {
           @Override
           public void OnLoadImage(ImageView view, Object o) {
               Glide.with(getApplicationContext()).load(o).into(view);
           }
       });*/
       /* banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {//设置点击事件
            @Override
            public void OnBannerClick(View view, int position) {
                Toast.makeText(getApplicationContext(), "你点击了：" + position, Toast.LENGTH_LONG).show();
            }
        });*/


       /* String bingPic = sp.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(ShouyeActivity.this).load(bingPic).into(imageView);

        } else {
           // loadImage();
        }*/


    }


    @OnClick(R.id.im)
    public void onClick() {
        dl.openDrawer(GravityCompat.START);

    }


    public void initView() {
        navView.setItemIconTintList(null);

        fragment = new QqFragment();
        wxFragments = new WxFragments();
        wxFragment=new WxFragment();
       View headerview= navView.getHeaderView(0);
    tv_navname =(TextView)headerview.findViewById(R.id.tv_navname);
    cimage=(de.hdodenhof.circleimageview.CircleImageView)headerview.findViewById(R.id.nav_ci);





    }

    public void initData() {
        //拿到StartActivity传过来的QQ网名
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Intent intent = getIntent();
        String sname = intent.getStringExtra("name");
        String spic=intent.getStringExtra("pic");
        Glide.with(MyApplication.getContext()).load(spic).into(cimage);
        name.setText(sname);
        tv_navname.setText(sname);
    }

    public void initEvent() {
        //navView的切换事件
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                dl.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.it_tianqi:
                        Intent intentTheme = new Intent(ShouyeActivity.this, MainActivity.class);
                        startActivity(intentTheme);
                        break;


                    case R.id.it_about:
                         Intent aboutTheme = new Intent(ShouyeActivity.this, MylocationActivity.class);
                        startActivity(aboutTheme);
                        break;

                    case R.id.it_fuwu:
                        startActivity(new Intent(ShouyeActivity.this, ServiceActivity.class));

                        break;
                    case R.id.it_music:
                        Intent intent = new Intent(ShouyeActivity.this, MusicActivity.class);
                        startActivity(intent);

                        break;
                    case R.id.it_liulanqi:
                        Intent intenter = new Intent(ShouyeActivity.this, SplashActivity.class);
                        intenter.putExtra(SplashActivity.TAG_EXIT, true);
                        startActivity(intenter);
                        System.exit(0);


                        break;

                }
                return true;
            }
        });
        //bottomNaigationBar的添加四个页签
        bottomNavigationBar.setInActiveColor(R.color.colorPrimaryDark);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.adress_grey, "位置"))
                .addItem(new BottomNavigationItem(R.drawable.wallet_grey, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.weibo_red, "爱好"))
                .addItem(new BottomNavigationItem(R.drawable.wetchat_red, "图书"))
                .setFirstSelectedPosition(0)
                .initialise();
        //bottomNaigationBar的页签切换事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {

            @Override
            public void onTabSelected(int i) {
                switch (i) {
                    case 0: {
                        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.ll_content, fragment);
                        transaction.commit();
                        break;
                    }
                    case 1: {
                        android.support.v4.app.FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                        transaction1.replace(R.id.ll_content, wxFragment);
                        transaction1.commit();

                        break;
                    }
                    case 2: {
                        android.support.v4.app.FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                        transaction2.commit();
                        transaction2.replace(R.id.ll_content, fragment);

                        break;
                    }
                    case 3: {
                        android.support.v4.app.FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                        transaction3.replace(R.id.ll_content, wxFragments);
                        transaction3.commit();

                        break;
                    }


                }


            }

            @Override
            public void onTabUnselected(int i) {

            }

            @Override
            public void onTabReselected(int i) {

            }
        });

    }




}
