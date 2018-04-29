package qf.com.vitamodemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;

import qf.com.vitamodemo.OnClickListener;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.AbsRecyclerAdapter;
import qf.com.vitamodemo.bean.TvPerSectionBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.ui.PlayWebActivity;
import qf.com.vitamodemo.utils.VUtils;

/**
 * create an instance of this fragment.
 */
public class ZyListFragment extends Fragment {

    private RecyclerView recyclerView;
    private OnClickListener listener;

    public ZyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.tv_list_recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<TvPerSectionBean.VideosEntity>
                (getActivity(), R
                        .layout.item_zy_list, new ArrayList<TvPerSectionBean.VideosEntity>()) {
            @Override
            public void showData(MyViewHolder vHolder, final TvPerSectionBean.VideosEntity data,
                                 final
            int position) {
                TextView textView = (TextView) vHolder.getView(R.id.item_zy_update);
                textView.setText(data.getEpisode() + "  :  " + data.getTitle());

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(v,position);
                    }
                });
            }
        };

        String url = getArguments().getString(Config.URL);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                TvPerSectionBean tv = JSON.parseObject(s, TvPerSectionBean.class);
                if (tv.getVideos() != null) {
                    adapter.addAll(tv.getVideos());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        });
        request.setTag(getActivity());
        VUtils.getQueue(getActivity()).add(request);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    public void setListener(OnClickListener listener){
        this.listener = listener;
    }

}
