package qf.com.vitamodemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.DmJxRecyclerAdapter;
import qf.com.vitamodemo.bean.VideoCategory;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.utils.VUtils;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class JxDmFragment extends BaseRecyclerFragment {

    private List<VideoCategory> datas = new ArrayList<>();
    private DmJxRecyclerAdapter adapter;

    public static JxDmFragment newInstance(String url) {
        JxDmFragment f = new JxDmFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Config.URL, url);
        f.setArguments(bundle);

        return f;
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
            return new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        //return new GridLayoutManager(activity,3);
    }

    @Override
    public void initData(final int pageIndex) {
        StringRequest request = new StringRequest(getArguments().getString(Config.URL), new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if(pageIndex==1){
                            adapter.clear();
                        }
                        JSONArray array = JSON.parseObject(s).getJSONArray("slices");
                        adapter.addAll(JSON.parseArray(array.toString(), VideoCategory.class));
                        mSwipeRefreshLayout.setRefreshing(false);

                        mProgressBar.setVisibility(View.GONE);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        VUtils.getQueue(getContext()).add(request);
        request.setTag(getActivity());
    }
    @Override
    public boolean canLoadMore() {
        return false;
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
    public RecyclerView.Adapter getBaseRecyclerAdapter() {
        adapter = new DmJxRecyclerAdapter(getContext(), R.layout.item_tv_jx, datas, R.anim
                .list_anim);
        return adapter;
    }

    @Override
    public int getRefreshLayoutId() {
        return R.id.swiperefresh;
    }

    @Override
    public void setHeaderView(RecyclerView recyclerView) {

    }
}
