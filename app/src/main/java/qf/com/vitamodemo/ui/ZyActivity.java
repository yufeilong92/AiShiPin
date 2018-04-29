package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
import qf.com.vitamodemo.fragment.JxZyFragment;
import qf.com.vitamodemo.fragment.OtherTvFragment;
import qf.com.vitamodemo.fragment.OtherZyFragment;

public class ZyActivity extends AppCompatActivity {

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("综艺");

        fragments = new ArrayList<>();
        fragments.add(JxZyFragment.newInstance(UrlConstants.URL_ZY_JX));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_ALL));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_INNER));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_ZY));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_JS));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_QG));
        fragments.add(OtherZyFragment.newInstance(UrlConstants.URL_ZY_RH));

        titles = new ArrayList<>();
        titles.add("精选");
        titles.add("全部");
        titles.add("内地");
        titles.add("综艺");
        titles.add("纪实");
        titles.add("情感");
        titles.add("日韩");
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
                intent.putExtra(Config.URL,UrlConstants.URL_ZY_BIG_ALL);
                intent.putExtra(Config.URL_TYPE,Config.TYPE_ZY);
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
