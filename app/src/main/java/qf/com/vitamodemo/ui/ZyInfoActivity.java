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
import android.widget.Spinner;
import android.widget.TextView;

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
import qf.com.vitamodemo.adapter.TvSourceSpinnerAdapter;
import qf.com.vitamodemo.bean.TvPerSectionBean;
import qf.com.vitamodemo.bean.VideoBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.fragment.InfoIntroduceFragment;
import qf.com.vitamodemo.fragment.ZyListFragment;
import qf.com.vitamodemo.utils.VUtils;

/**
 * 综艺
 */
public class ZyInfoActivity extends AppCompatActivity implements qf.com.vitamodemo.OnClickListener {
    private VideoBean videoBean;
    private Toolbar toolbar;

    private ImageView imageView;
    private TextView videoName;
    private TextView actorName;
    private TextView year;
    private Spinner source;

    private ImageView toolbarImg;

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private TvPerSectionBean tvPerSectionBean;
    private TvSourceSpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);

        initHeadView();
        initContentView();

        if (getIntent() != null) {

            String url = getIntent().getStringExtra(Config.URL);
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    JSONObject ob = JSON.parseObject(s);
                    videoBean = JSON.parseObject(ob.toString(), VideoBean.class);
                    initData();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                }
            });
            request.setTag(this);
            VUtils.getQueue(this).add(request);
        }
    }

    private void initData() {

        toolbar.setTitle(videoBean.getTitle());
        ImageLoader.getInstance().displayImage(videoBean.getImg_url(), toolbarImg, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));

        ImageLoader.getInstance().displayImage(videoBean.getImg_url(), imageView, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
        videoName.setText(videoBean.getTitle());
        actorName.setText("主持人: ");
        if (videoBean.getDirector() != null) {
            ArrayList<String> director = videoBean.getDirector();
            for (String s : director) {
                actorName.append(s + "  ");
            }
        } else {
            actorName.setVisibility(View.GONE);
        }
        year.setText("年代:" + videoBean.getPubtime());

        VUtils.getQueue(this).add(new StringRequest(UrlConstants.URL_ZY_SOURCE + videoBean
                .getId(), new Response
                .Listener<String>() {
            @Override
            public void onResponse(String s) {
                tvPerSectionBean = JSON.parseObject(s, TvPerSectionBean.class);
                if (tvPerSectionBean.getDsites() != null) {
                    adapter.addAll(tvPerSectionBean.getSites());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        }));
        adapter = new TvSourceSpinnerAdapter(this, R.layout.item_source,
                new ArrayList<TvPerSectionBean.SitesEntity>());
        source.setAdapter(adapter);

        initBelowFragments();

        MainFragmentPagerAdapter mAdapter = new MainFragmentPagerAdapter
                (getSupportFragmentManager(), mFragments, mTitles);
        mViewpager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }

    private void initBelowFragments() {
        InfoIntroduceFragment info = new InfoIntroduceFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(Config.ACTORS, videoBean.getActor());
        bundle.putStringArrayList(Config.TYPES, videoBean.getType());
        bundle.putStringArrayList(Config.DIRECTOR, videoBean.getDirector());
        bundle.putString(Config.INTRODUCE, videoBean.getIntro());
        info.setArguments(bundle);

        ZyListFragment zyListFragment = new ZyListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(Config.URL, UrlConstants.URL_ZY_SOURCE + videoBean.getId());
        zyListFragment.setArguments(bundle2);
        zyListFragment.setListener(this);

        mFragments.add(info);
        mFragments.add(zyListFragment);
    }

    private void initContentView() {

        imageView = (ImageView) findViewById(R.id.info_picture);
        videoName = (TextView) findViewById(R.id.info_title);
        actorName = (TextView) findViewById(R.id.info_actor);
        year = (TextView) findViewById(R.id.info_year);
        source = (Spinner) findViewById(R.id.info_spinner);

        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        mTitles.add("简介");
        mTitles.add("剧集");
    }

    private void initHeadView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarImg = (ImageView) findViewById(R.id.toolbar_image);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                start(0);
            }
        });
    }

    @Override
    public void onClick(View v, final int position) {
        start(position);
    }

    private void start(final int position) {
        TvPerSectionBean.SitesEntity selectedItem = (TvPerSectionBean.SitesEntity) source
                .getSelectedItem();

        Log.i("hb",String.format(
                UrlConstants.URL_PLAY_ZY, videoBean.getId(), selectedItem.getSite_url()));
        StringRequest request = new StringRequest(String.format(
                UrlConstants.URL_PLAY_ZY, videoBean.getId(), selectedItem.getSite_url()),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        TvPerSectionBean tv = JSON.parseObject(s, TvPerSectionBean.class);
                        Intent intent = new Intent(ZyInfoActivity.this, PlayWebActivity.class);
                        intent.putExtra(Config.URL, tv.getVideos().get(position).getUrl());
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        });
        request.setTag(this);
        VUtils.getQueue(ZyInfoActivity.this).add(request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VUtils.getQueue(this).cancelAll(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
