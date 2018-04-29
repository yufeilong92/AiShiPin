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
import qf.com.vitamodemo.bean.AboutVideo;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.VideoInfoActivity;
import qf.com.vitamodemo.utils.VUtils;

/**
 * 三级页面 电影的相关介绍 有主演 年代 还有播放来源 以及该电影的简介 相关的推荐：类似作品，同主演作品，同导演作品等
 */
public class AboutVideoRecommandFragment extends Fragment {
    private AboutVideo aboutVideo;

    public AboutVideoRecommandFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // 相关推荐
        final View view = inflater.inflate(R.layout.fragment_about_recommand, container, false);

        final LinearLayout layout1 = (LinearLayout) view.findViewById(R.id.about_line1);
        final LinearLayout layout2 = (LinearLayout) view.findViewById(R.id.about_line2);
        final LinearLayout layout3 = (LinearLayout) view.findViewById(R.id.about_line3);

        //类似作品
        final RecyclerView recyclerView1 = (RecyclerView) view.findViewById(R.id
                .about_similar_recyclerview);
        //同主演作品
        final RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id
                .about_actor_recyclerview);
        //同导演作品
        final RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id
                .about_director_recyclerview);
        //设置recycleView的显示方 水平放置
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, false);

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);

        //StringRequset三个参数为：url，服务器响应监听
        VUtils.getQueue(getContext().getApplicationContext()).add(new StringRequest(getArguments()
                .getString(Config.URL), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    //拿到数据S。解析数据成Bean
                    aboutVideo = JSON.parseObject(s, AboutVideo.class);
                } catch (Exception e) {
                }
                //解析完了之后 判断 有相关的作品。就展示在recycleView上
                if (aboutVideo != null) {
                    //有同主演的作品，就显示出来
                    if (aboutVideo.getActor() != null && aboutVideo.getActor().size() > 0) {
                        layout2.setVisibility(View.VISIBLE);
                        AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutVideo
                                .ActorEntity>(getContext(), R.layout.item_about, aboutVideo.getActor
                                ()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutVideo.ActorEntity
                                    data, int position) {
                                //标题 图片
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

                    if (aboutVideo.getSimilary() != null && aboutVideo.getSimilary().size() > 0) {
                        layout1.setVisibility(View.VISIBLE);
                        AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutVideo
                                .SimilaryEntity>(getContext(), R.layout.item_about, aboutVideo
                                .getSimilary()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutVideo
                                    .SimilaryEntity
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

                    if (aboutVideo.getDirector() != null && aboutVideo.getDirector().size() > 0) {
                        layout3.setVisibility(View.VISIBLE);
                        final AbsRecyclerAdapter adapter = new AbsRecyclerAdapter<AboutVideo
                                .DirectorEntity>(getContext(), R.layout.item_about, aboutVideo
                                .getDirector()) {
                            @Override
                            public void showData(MyViewHolder vHolder, final AboutVideo
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
            //以及响应失败的错误信息
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        }));
        return view;
    }

    //页面跳转 url拼接
    public void startActivity(String id) {
        Intent intent = new Intent(getContext(), VideoInfoActivity.class);
        //避免硬编码 相当于一个标识
        intent.putExtra(Config.URL, UrlConstants.URL_VIDEO_INFO + id);
        getContext().startActivity(intent);
    }
}
