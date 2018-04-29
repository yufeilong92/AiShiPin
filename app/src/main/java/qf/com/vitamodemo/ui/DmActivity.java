package qf.com.vitamodemo.ui;

import android.content.BroadcastReceiver;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.MainFragmentPagerAdapter;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.fragment.JxDmFragment;
import qf.com.vitamodemo.fragment.OtherDmFragment;
import qf.com.vitamodemo.utils.VUtils;

/**
 * 动漫
 */
public class DmActivity extends AppCompatActivity {

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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置其左上表图标可以点击
        toolbar.setTitle("动漫");

        fragments = new ArrayList<>();
        fragments.add(JxDmFragment.newInstance(UrlConstants.URL_DM_JX));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_ALL));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_RB));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_QG));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_RX));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_GC));
        fragments.add(OtherDmFragment.newInstance(UrlConstants.URL_DM_SN));

        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("全部");
        titles.add("日本");
        titles.add("情感");
        titles.add("热血");
        titles.add("国产");
        titles.add("少女");
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
                intent.putExtra(Config.URL, UrlConstants.URL_DM_BIG_ALL);
                intent.putExtra(Config.URL_TYPE, Config.TYPE_DM);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VUtils.getQueue(this).cancelAll(this);
    }
}
