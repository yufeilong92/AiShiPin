package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.bean.VideoCategory;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.VideoInfoActivity;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class VideoJxRecyclerAdapter extends AbsRecyclerAdapter<VideoCategory> {

    public VideoJxRecyclerAdapter(Context context, int layoutRes, List<VideoCategory> datas, int
            anmiationRes) {
        super(context, layoutRes, datas, anmiationRes);
    }

        @Override
        public void showData(AbsRecyclerAdapter.MyViewHolder vHolder, final VideoCategory data, int
                position) {

        if (!data.getName().equals("index_flash") && position != 0) {
            vHolder.setText(R.id.item_jx_title, data.getName());
            vHolder.setText(R.id.item_jx_title1, data.getVideos().get(0).getTitle());
            vHolder.setText(R.id.item_jx_title2, data.getVideos().get(1).getTitle());
            vHolder.setText(R.id.item_jx_title3, data.getVideos().get(2).getTitle());
            vHolder.setText(R.id.item_jx_title4, data.getVideos().get(3).getTitle());
            vHolder.setText(R.id.item_jx_title5, data.getVideos().get(4).getTitle());

            vHolder.setText(R.id.item_jx_title11, data.getVideos().get(0).getBrief());
            vHolder.setText(R.id.item_jx_title22, data.getVideos().get(1).getBrief());
            vHolder.setText(R.id.item_jx_title33, data.getVideos().get(2).getBrief());
            vHolder.setText(R.id.item_jx_title44, data.getVideos().get(3).getBrief());
            vHolder.setText(R.id.item_jx_title55, data.getVideos().get(4).getBrief());

            ImageView img1 = (ImageView) vHolder.getView(R.id.item_jx_img1);
            ImageView img2 = (ImageView) vHolder.getView(R.id.item_jx_img2);
            ImageView img3 = (ImageView) vHolder.getView(R.id.item_jx_img3);
            ImageView img4 = (ImageView) vHolder.getView(R.id.item_jx_img4);
            ImageView img5 = (ImageView) vHolder.getView(R.id.item_jx_img5);

            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos()
                            .get(0).getWorks_id());
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(data.getVideos()
                            .get(1).getWorks_id());
                }
            });
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos()
                            .get(2).getWorks_id());
                }
            });
            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos()
                            .get(3).getWorks_id());
                }
            });
            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos()
                            .get(4).getWorks_id());
                }
            });

                ImageLoader.getInstance().displayImage(data.getVideos().get(0).getImgh_url() == null ?
                        data.getVideos().get(0)
                                .getImgv_url() : data.getVideos().get(0).getImgh_url(), img1, BaseApp
                        .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));

            ImageLoader.getInstance().displayImage(data.getVideos().get(1).getImgh_url() == null ?
                    data.getVideos().get(1)
                            .getImgv_url() : data.getVideos().get(1).getImgh_url(), img2, BaseApp
                    .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));

            ImageLoader.getInstance().displayImage(data.getVideos().get(2).getImgh_url() == null ?
                    data.getVideos().get(2)
                            .getImgv_url() : data.getVideos().get(2).getImgh_url(), img3, BaseApp
                    .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));

            ImageLoader.getInstance().displayImage(data.getVideos().get(3).getImgh_url() == null ?
                    data.getVideos().get(3)
                            .getImgv_url() : data.getVideos().get(3).getImgh_url(), img4, BaseApp
                    .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));

            ImageLoader.getInstance().displayImage(data.getVideos().get(4).getImgh_url() == null ?
                    data.getVideos().get(4)
                            .getImgv_url() : data.getVideos().get(4).getImgh_url(), img5, BaseApp
                    .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));
        } else {
            try {
            ImageView head = (ImageView) vHolder.getView(R.id.item_jx_header);
            ImageLoader.getInstance().displayImage(data.getVideos().get(0).getImgh_url() == null ?
                    data.getVideos().get(0)
                            .getImgv_url() : data.getVideos().get(0).getImgh_url(), head, BaseApp
                    .getDisplayImageOptions(new FadeInBitmapDisplayer(0)));
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(data.getVideos().get(0).getWorks_id());
                    }
                });
            vHolder.setText(R.id.item_jx_title,data.getVideos().get(0).getBrief());}catch (Exception e){}
        }
    }

    private void startActivity(String id) {
        Intent intent = new Intent(context, VideoInfoActivity.class);
        intent.putExtra(Config.URL, UrlConstants.URL_VIDEO_INFO + id);
        context.startActivity(intent);
    }

    @Override
    public boolean hasHeader() {
        return true;
    }
}
