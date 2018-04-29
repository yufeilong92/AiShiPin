package qf.com.vitamodemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import qf.com.vitamodemo.adapter.OtherVideoRecyclerAdapter;
import qf.com.vitamodemo.bean.OtherVideoBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.utils.VUtils;

/**其他定影分类 比如2014 动作 爱情
 * Created by Administrator on 2015/10/11 0011.
 */
public class OtherVideoFragment extends BaseRecyclerFragment {

    private List<OtherVideoBean> datas = new ArrayList<>();
    private OtherVideoRecyclerAdapter adapter;

    public static OtherVideoFragment newInstance(String url) {
        OtherVideoFragment f = new OtherVideoFragment();
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
        //return new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        return gridLayoutManager;
    }

    @Override
    public void initData(final int pageIndex) {
        String url = getArguments().getString(Config.URL);
        String format = url + "&beg=" + pageIndex + "&end=" + mPageIndex;
        StringRequest request = new StringRequest(format, new
                Response .Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if (pageIndex == 1) {
                            adapter.clear();
                        }
                        JSONArray array = JSON.parseObject(s).getJSONObject("video_list")
                                .getJSONArray("videos");
                        datas.addAll(JSON.parseArray(array.toString(), OtherVideoBean.class));
                        adapter.notifyDataSetChanged();
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
    public int getProgressBarId() {
        return R.id.progressbar;
    }

    @Override
    public boolean hasProgress() {
        return true;
    }

    @Override
    public RecyclerView.Adapter getBaseRecyclerAdapter() {
        adapter = new OtherVideoRecyclerAdapter(getContext(), R.layout.item_other, datas, R.anim.list_anim);
        return adapter;
    }

    @Override
    public int getRefreshLayoutId() {
        return R.id.swiperefresh;
    }
}
