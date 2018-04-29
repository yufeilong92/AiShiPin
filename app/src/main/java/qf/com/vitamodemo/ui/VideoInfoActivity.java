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
import qf.com.vitamodemo.adapter.SourceSpinnerAdapter;
import qf.com.vitamodemo.bean.VideoBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.fragment.AboutVideoRecommandFragment;
import qf.com.vitamodemo.fragment.InfoIntroduceFragment;
import qf.com.vitamodemo.utils.VUtils;

/**
 * 电影 三级页面
 */
    public class VideoInfoActivity extends AppCompatActivity {
    private String url;
    private VideoBean videoBean;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    private ImageView imageView;
    private TextView videoName;
    private TextView actorName;
    private TextView year;
    private Spinner source;

    private ImageView toolbarImg;

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private MainFragmentPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);

        initHeadView();
        initContentView();

        if (getIntent() != null) {
            url = getIntent().getStringExtra(Config.URL);
            StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                @Override
                public void onResponse(String s) {
                    JSONObject ob = JSON.parseObject(s);
                    videoBean = JSON.parseObject(ob.toString(), VideoBean.class);
                    try {initData();
                    } catch (Exception e) {}}}, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    volleyError.printStackTrace();}});
            request.setTag(this);
            VUtils.getQueue(this).add(request);
        }
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

    private void initData() {

        toolbar.setTitle(videoBean.getTitle());

        ImageLoader.getInstance().displayImage(videoBean.getImg_url(), toolbarImg, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));

        ImageLoader.getInstance().displayImage(videoBean.getImg_url(), imageView, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
        videoName.setText(videoBean.getTitle());
        for (String s : videoBean.getActor()) {
            actorName.append(s + "  ");
        }
        year.setText("年代:" + videoBean.getPubtime());

        //视频来源spinner
        SourceSpinnerAdapter adapter = new SourceSpinnerAdapter(this, R.layout.item_source,
                videoBean.getSites());
        source.setAdapter(adapter);

        initBelowFragments();

        mAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), mFragments, mTitles);
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

        AboutVideoRecommandFragment arf = new AboutVideoRecommandFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(Config.URL, UrlConstants.URL_VIDEO_ABOUT + videoBean.getId());
        arf.setArguments(bundle1);

        mFragments.add(info);
        mFragments.add(arf);
    }

    private void initContentView() {

        imageView = (ImageView) findViewById(R.id.info_picture);
        videoName = (TextView) findViewById(R.id.info_title);
        actorName = (TextView) findViewById(R.id.info_actor);
        year = (TextView) findViewById(R.id.info_year);
        source = (Spinner) findViewById(R.id.info_spinner);

        mViewpager = (ViewPager) findViewById(R.id.viewpager);
        mViewpager.setOffscreenPageLimit(2);
        mTablayout = (TabLayout) findViewById(R.id.tabs);

        mTitles.add("简介");
        mTitles.add("相关推荐");
    }

    private void initHeadView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbarImg = (ImageView) findViewById(R.id.toolbar_image);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoInfoActivity.this, PlayWebActivity.class);
                intent.putExtra(Config.URL, ((VideoBean.SitesEntity) source.getSelectedItem())
                        .getSite_url());
                startActivity(intent);
            }
        });
    }
}
