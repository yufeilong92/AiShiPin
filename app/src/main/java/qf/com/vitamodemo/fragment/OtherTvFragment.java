package qf.com.vitamodemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.OtherTvRecyclerAdapter;
import qf.com.vitamodemo.bean.OtherTvBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.utils.VUtils;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class OtherTvFragment extends BaseRecyclerFragment {

    private OtherTvRecyclerAdapter adapter;

    public static OtherTvFragment newInstance(String url) {
        OtherTvFragment f = new OtherTvFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Config.URL, url);
        f.setArguments(bundle);

        return f;
    }

    @Override
    public int getProgressBarId() {
        return R.id.progressbar;
    }

    @Override
    public boolean hasProgress() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public int getRecyclerViewId() {
        return R.id.main_recyclerview;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager() {
        //return new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        return gridLayoutManager;
    }

    @Override
    public void initData(final int pageIndex) {
        String url = getArguments().getString(Config.URL);
        String format = url + "&beg=" + pageIndex + "&end=" + mPageIndex;
        Log.i("houbin", ".." + format);
        StringRequest request = new StringRequest(format,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if(pageIndex==1){
                            adapter.clear();
                        }
                        JSONArray array = JSON.parseObject(s).getJSONObject("video_list")
                                .getJSONArray("videos");
                        adapter.addAll(JSON.parseArray(array.toString(), OtherTvBean.class));
                        mSwipeRefreshLayout.setRefreshing(false);
                        mProgressBar.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        request.setTag(getActivity());
        VUtils.getQueue(getContext()).add(request);
    }

    @Override
    public RecyclerView.Adapter getBaseRecyclerAdapter() {
        adapter = new OtherTvRecyclerAdapter(getContext(), R.layout.item_other, new
                ArrayList<OtherTvBean>(), R.anim.list_anim);
        return adapter;
    }

    @Override
    public int getRefreshLayoutId() {
        return R.id.swiperefresh;
    }
}
