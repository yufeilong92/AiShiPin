package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import qf.com.vitamodemo.ui.DmMultiInfoActivity;
import qf.com.vitamodemo.ui.DmSingleInfoActivity;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class DmJxRecyclerAdapter extends AbsRecyclerAdapter<VideoCategory> {

    public DmJxRecyclerAdapter(Context context, int layoutRes, List<VideoCategory> datas, int
            anmiationRes) {
        super(context, layoutRes, datas, anmiationRes);
    }

    @Override
    public void showData(MyViewHolder vHolder, final VideoCategory data, int
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

            vHolder.setText(R.id.item_jx_update_title1, data.getVideos().get(0).getUpdate());
            vHolder.setText(R.id.item_jx_update_title2, data.getVideos().get(1).getUpdate());
            vHolder.setText(R.id.item_jx_update_title3, data.getVideos().get(2).getUpdate());
            vHolder.setText(R.id.item_jx_update_title4, data.getVideos().get(3).getUpdate());
            vHolder.setText(R.id.item_jx_update_title5, data.getVideos().get(4).getUpdate());

            ImageView img1 = (ImageView) vHolder.getView(R.id.item_jx_img1);
            ImageView img2 = (ImageView) vHolder.getView(R.id.item_jx_img2);
            ImageView img3 = (ImageView) vHolder.getView(R.id.item_jx_img3);
            ImageView img4 = (ImageView) vHolder.getView(R.id.item_jx_img4);
            ImageView img5 = (ImageView) vHolder.getView(R.id.item_jx_img5);

            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos().get(0).getUpdate(), data.getVideos()
                            .get(0).getWorks_id());
                }
            });
            img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos().get(1).getUpdate(), data.getVideos()
                            .get(1).getWorks_id());
                }
            });
            img3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos().get(2).getUpdate(), data.getVideos()
                            .get(2).getWorks_id());
                }
            });
            img4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos().get(3).getUpdate(), data.getVideos()
                            .get(3).getWorks_id());
                }
            });
            img5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(data.getVideos().get(4).getUpdate(), data.getVideos()
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
                ImageLoader.getInstance().displayImage(data.getVideos().get(0).getImgh_url() ==
                                null ? data.getVideos().get(0).getImgv_url() : data.getVideos()
                                .get(0).getImgh_url(), head,
                        BaseApp.getDisplayImageOptions(new FadeInBitmapDisplayer(0)));
                head.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(data.getVideos().get(0).getUpdate(), data.getVideos().get
                                (0).getWorks_id());
                    }
                });
                vHolder.setText(R.id.item_jx_title, data.getVideos().get(0).getBrief());
            } catch (Exception e) {
            }
        }
    }

    @Override
    public boolean hasHeader() {
        return true;
    }

    private void startActivity(String update, String id) {
        Intent intent;
        //有完结和跟新 分开显示
        if (update != null && update.contains("季")) {
            intent = new Intent(context, DmMultiInfoActivity.class);
        } else {
            intent = new Intent(context, DmSingleInfoActivity.class);
        }
        intent.putExtra(Config.URL, UrlConstants.URL_DM_INFO + id);
        Log.i("houbin", "test---" + UrlConstants.URL_DM_INFO + id);
        context.startActivity(intent);
    }
}
