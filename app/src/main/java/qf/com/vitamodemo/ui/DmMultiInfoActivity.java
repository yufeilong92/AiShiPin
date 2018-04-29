package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.MainFragmentPagerAdapter;
import qf.com.vitamodemo.bean.DmBean;
import qf.com.vitamodemo.bean.TvPerSectionBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.fragment.DmSeasonFragment;
import qf.com.vitamodemo.utils.VUtils;

/**
 * 动漫已完结的 新增加一个toolbar 显示第几季 每一季设置一个点击事件
 */
public class DmMultiInfoActivity extends AppCompatActivity implements ViewPager
        .OnPageChangeListener {
    private String url;
    private DmBean dmBean;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    private ImageView toolbarImg;

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private MainFragmentPagerAdapter mAdapter;

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private List<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm_multi_info);

        initHeadView();
        mViewpager = (ViewPager) findViewById(R.id.dm_head_viewpager);
        mTablayout = (TabLayout) findViewById(R.id.dm_head_tabs);

        if (getIntent() != null) {
            url = getIntent().getStringExtra(Config.URL);
            VUtils.getQueue(this).add(new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    JSONObject ob = JSON.parseObject(s);
                    dmBean = JSON.parseObject(ob.toString(), DmBean.class);
                    try {
                        initData();
                    } catch (Exception e) {
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                }
            }));
        }
    }

    private void initData() {
        ImageLoader.getInstance().displayImage(dmBean.getImg_url(), toolbarImg, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));

        int seasonNum = dmBean.getSeason_num();
        for (int i = 0; i < seasonNum; i++) {
            DmBean.SeasonsEntity season = dmBean.getSeasons().get(i);
            mTitles.add(season.getSeason_name());
            mFragments.add(DmSeasonFragment.newInstance(UrlConstants.URL_DM_INFO + season
                    .getSeason_id(), i + ""));

            StringRequest request = new StringRequest(UrlConstants.URL_DM_INFO + season
                    .getSeason_id(), new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    DmBean dmBean = JSON.parseObject(s, DmBean.class);
                    urls.add(dmBean.getImg_url());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    volleyError.printStackTrace();
                }
            });
            request.setTag(this);
            VUtils.getQueue(this).add(request);
        }

        mAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewpager.setAdapter(mAdapter);
        mViewpager.setOffscreenPageLimit(mFragments.size());
        mTablayout.setupWithViewPager(mViewpager);

        mViewpager.setOnPageChangeListener(this);
    }

    //已完结 图片下面加一个toolbar 分别显示第几季 然后设置点击事件
    private void initHeadView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarImg = (ImageView) findViewById(R.id.toolbar_image);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                start(0);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VUtils.getQueue(this).cancelAll(this);
    }

    private void start(final int position) {
        VUtils.getQueue(this).add(new StringRequest(UrlConstants
                .URL_DM_SOURCE + dmBean.getId(), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                TvPerSectionBean tv = JSON.parseObject(s, TvPerSectionBean.class);
                Intent intent = new Intent(getApplicationContext(), PlayWebActivity.class);
                intent.putExtra(Config.URL, tv.getVideos().get(position).getUrl());
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ImageLoader.getInstance().displayImage(urls.get(position), toolbarImg, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
