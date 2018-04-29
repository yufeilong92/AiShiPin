package qf.com.vitamodemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.OnClickListener;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.MainFragmentPagerAdapter;
import qf.com.vitamodemo.adapter.TvSourceSpinnerAdapter;
import qf.com.vitamodemo.bean.DmBean;
import qf.com.vitamodemo.bean.TvPerSectionBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.PlayWebActivity;
import qf.com.vitamodemo.ui.TvInfoActivity;
import qf.com.vitamodemo.utils.VUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DmSeasonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DmSeasonFragment extends Fragment implements OnClickListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private ImageView imageView;
    private TextView videoName;
    private TextView year;
    private Spinner source;

    private TvPerSectionBean tvPerSectionBean;
    private TvSourceSpinnerAdapter adapter;

    private ViewPager mViewpager;
    private TabLayout mTablayout;

    private List<Fragment> mFragments;
    private  List<String> mTitles;

    private MainFragmentPagerAdapter mAdapter;

    private DmBean dmBean;

    public DmSeasonFragment() {
        // Required empty public constructor
    }

    public static DmSeasonFragment newInstance(String param1, String param2) {
        DmSeasonFragment fragment = new DmSeasonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dm_season, container, false);
        imageView = (ImageView) view.findViewById(R.id.info_picture);
        videoName = (TextView) view.findViewById(R.id.info_title);
        year = (TextView) view.findViewById(R.id.info_year);
        source = (Spinner) view.findViewById(R.id.info_spinner);

        mViewpager = (ViewPager) view.findViewById(R.id.viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.tabs);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StringRequest request = new StringRequest(mParam1, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                dmBean = JSON.parseObject(s,DmBean.class);
                initData();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {}
        });
        VUtils.getQueue(getActivity()).add(request);
        request.setTag(getActivity());
    }

    private void initData() {
        ImageLoader.getInstance().displayImage(dmBean.getImg_url(), imageView, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
        videoName.setText(dmBean.getTitle());

        year.setText("年代:" + dmBean.getPubtime());

        VUtils.getQueue(getActivity()).add(new StringRequest(UrlConstants.URL_DM_SOURCE +
                dmBean.getId(), new Response
                .Listener<String>() {
            @Override
            public void onResponse(String s) {
                tvPerSectionBean = JSON.parseObject(s, TvPerSectionBean.class);
                adapter.addAll(tvPerSectionBean.getSites());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        }));
        adapter = new TvSourceSpinnerAdapter(getActivity(), R.layout.item_source,
                new ArrayList<TvPerSectionBean.SitesEntity>());
        source.setAdapter(adapter);

        initBelowFragments();
    }

    private void initBelowFragments() {
        DmInfoIntroduceFragment info = new DmInfoIntroduceFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Config.INTRODUCE, dmBean.getIntro());
        bundle.putStringArrayList(Config.TYPES, dmBean.getType());
        info.setArguments(bundle);

        TvListFragment tvListFragment = new TvListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(Config.SIZE, dmBean.getCur_episode());
        tvListFragment.setArguments(bundle2);
        tvListFragment.setListener(this);

       /* AboutTvRecommandFragment arf = new AboutTvRecommandFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(Config.URL, UrlConstants.URL_DM_ABOUT + dmBean.getId());
        arf.setArguments(bundle1);*/

        mFragments = new ArrayList<>();
        mFragments.add(info);
        mFragments.add(tvListFragment);
        //mFragments.add(arf);

        mTitles = new ArrayList<>();
        mTitles.add("简介");
        mTitles.add("剧集");
        //mTitles.add("相关推荐");

        mAdapter = new MainFragmentPagerAdapter(getChildFragmentManager(), mFragments, mTitles);
        mViewpager.setAdapter(mAdapter);
        mTablayout.setupWithViewPager(mViewpager);
    }

    @Override
    public void onClick(View v, int position) {
        start(position);
    }

    private void start(final int position) {
        TvPerSectionBean.SitesEntity sitesEntity = (TvPerSectionBean.SitesEntity) source
                .getSelectedItem();
        VUtils.getQueue(getActivity()).add(new StringRequest( String.format(UrlConstants
                .URL_DM_PLAY_SOURCE, dmBean.getId(), sitesEntity
                .getSite_url()),  new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                TvPerSectionBean tv = JSON.parseObject(s, TvPerSectionBean.class);
                Intent intent = new Intent(getActivity(), PlayWebActivity.class);
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
}
