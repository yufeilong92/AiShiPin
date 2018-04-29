package qf.com.vitamodemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.adapter.AbsRecyclerAdapter;
import qf.com.vitamodemo.bean.AboutTv;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.TvInfoActivity;
import qf.com.vitamodemo.utils.VUtils;

public class AboutTvRecommandFragment extends Fragment {
    private AboutTv aboutTv;

    public AboutTvRecommandFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_about_recommand, container, false);

        final LinearLayout layout1 = (LinearLayout) view.findViewById(R.id.about_line1);
        final LinearLayout layout2 = (LinearLayout) view.findViewById(R.id.about_line2);
        final LinearLayout layout3 = (LinearLayout) view.findViewById(R.id.about_line3);

        final RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id
                .about_similar_recyclerview);
        final RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id
                .about_actor_recyclerview);
        final RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id
                .about_director_recyclerview);

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);

        StringRequest request = new StringRequest(getArguments()
                .getString(Config.URL), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    aboutTv = JSON.parseObject(s, AboutTv.class);
                } catch (Exception e) {
                }
                if (aboutTv != null) {
                    if (aboutTv.getActor() != null && aboutTv.getActor().size() > 0) {
                        layout2.setVisibility(View.VISIBLE);
                        AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutTv.ActorEntity>
                                (getActivity(), R.layout.item_about, aboutTv.getActor()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutTv.ActorEntity
                                    data, int position) {
                                vHolder.setText(R.id.other_title, data.getTitle());
                                ImageView img = (ImageView) vHolder.getView(R.id.other_img);
                                ImageLoader.getInstance().displayImage(data.getBig_poster(), img,
                                        BaseApp.getDisplayImageOptions(new FadeInBitmapDisplayer
                                                (0)));
                                img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(data.getWorks_id());
                                    }
                                });
                            }
                        };
                        recyclerView2.setAdapter(adapter);
                    }

                    if (aboutTv.getSimilary() != null && aboutTv.getSimilary().size() > 0) {
                        layout1.setVisibility(View.VISIBLE);
                        AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutTv.SimilaryEntity
                                >(getContext(), R.layout.item_about, aboutTv
                                .getSimilary()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutTv.SimilaryEntity
                                    data, int position) {
                                vHolder.setText(R.id.other_title, data.getTitle());
                                ImageView img = (ImageView) vHolder.getView(R.id.other_img);
                                ImageLoader.getInstance().displayImage(data.getBig_poster(), img,
                                        BaseApp.getDisplayImageOptions(new FadeInBitmapDisplayer
                                                (0)));
                                img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(data.getWorks_id());
                                    }
                                });
                            }
                        };
                        recyclerView1.setAdapter(adapter);
                    }

                    if (aboutTv.getDirector() != null && aboutTv.getDirector().size() > 0) {
                        layout3.setVisibility(View.VISIBLE);
                        final AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutTv
                                .DirectorEntity>(getContext(), R.layout.item_about, aboutTv
                                .getDirector()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutTv
                                    .DirectorEntity
                                    data, int position) {
                                vHolder.setText(R.id.other_title, data.getTitle());
                                ImageView img = (ImageView) vHolder.getView(R.id.other_img);
                                ImageLoader.getInstance().displayImage(data.getBig_poster(), img,
                                        BaseApp.getDisplayImageOptions(new FadeInBitmapDisplayer
                                                (0)));
                                img.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(data.getWorks_id());
                                    }
                                });
                            }
                        };
                        recyclerView3.setAdapter(adapter);
                    }
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
        return view;
    }

    public void startActivity(String id) {
        Intent intent = new Intent(getActivity(), TvInfoActivity.class);
        intent.putExtra(Config.URL, UrlConstants.URL_TV_INFO + id);
        getActivity().startActivity(intent);
    }
}
