package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.MainFragmentPagerAdapter;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.fragment.JxVideoFragment;
import qf.com.vitamodemo.fragment.OtherVideoFragment;

/**
 * 电影 二级页面
 */
public class VideoActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MainFragmentPagerAdapter adapter;
    private List<String> titles;
    private List<Fragment> fragments;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        //toolbar相当于标题栏
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //把标题栏加进去
        setSupportActionBar(toolbar);
        //给左上角的图标加上一个返回的小图标

        toolbar.setTitle("电影");

        //一个小标题对应一个fragment
        fragments = new ArrayList<>();
        //精选fragment 把地址传过去
        fragments.add(JxVideoFragment.newInstance(UrlConstants.URL_VIDEO_JX));

        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_ALL));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_2015));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_2014));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_COMMIDES));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_AMERICA));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_ACTION));
        fragments.add(OtherVideoFragment.newInstance(UrlConstants.URL_VIDEO_LOVE));

        //标题的名字
        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("全部");
        titles.add("2015");
        titles.add("2014");
        titles.add("喜剧");
        titles.add("美国");
        titles.add("动作");
        titles.add("爱情");
        adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        //悬浮搜索框 跟tabLayout来自一家
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFlyActivity.class);
                intent.putExtra(Config.URL,UrlConstants.URL_VIDEO_BIG_ALL);
                intent.putExtra(Config.URL_TYPE,Config.TYPE_VIDEO);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
