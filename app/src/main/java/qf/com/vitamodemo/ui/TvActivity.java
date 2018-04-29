package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
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
import qf.com.vitamodemo.fragment.JxTvFragment;
import qf.com.vitamodemo.fragment.OtherTvFragment;

/**
 * 电视剧
 */
public class TvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        ViewPager mViewPager;
        MainFragmentPagerAdapter adapter;
        List<String> titles;
        List<Fragment> fragments;
        Toolbar toolbar;
        TabLayout tabLayout;
        FloatingActionButton fab;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("电视剧");

        fragments = new ArrayList<>();
        fragments.add(JxTvFragment.newInstance(UrlConstants.URL_TV_JX));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_ALL));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_2015));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_INNER));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_KOREAN));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_ATTACK));
        fragments.add(OtherTvFragment.newInstance(UrlConstants.URL_TV_OLD));

        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("全部");
        titles.add("2015");
        titles.add("内地");
        titles.add("韩国");
        titles.add("战争");
        titles.add("古装");
        adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchFlyActivity.class);
                intent.putExtra(Config.URL, UrlConstants.URL_TV_BIG_ALL);
                intent.putExtra(Config.URL_TYPE, Config.TYPE_TV);
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
