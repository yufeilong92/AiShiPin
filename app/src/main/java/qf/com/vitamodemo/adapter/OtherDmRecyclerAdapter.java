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
import qf.com.vitamodemo.bean.OtherTvBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.DmMultiInfoActivity;
import qf.com.vitamodemo.ui.DmSingleInfoActivity;

/**
 * Created by Administrator on 2015/10/11 0011.
 */
public class OtherDmRecyclerAdapter extends AbsRecyclerAdapter<OtherTvBean> {

    public OtherDmRecyclerAdapter(Context context, int layoutRes, List<OtherTvBean> datas, int
            anmiationRes) {
        super(context, layoutRes, datas, anmiationRes);
    }

    /**
     *
     * @param vHolder 一个viewholder介绍一个项目视图和元数据对其在recyclerview地方
     * @param data
     * @param position
     */
    @Override
    public void showData(MyViewHolder vHolder, final OtherTvBean data, int
            position) {

        vHolder.setText(R.id.other_title, data.getTitle());

        ImageView img = (ImageView) vHolder.getView(R.id.other_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(data.getUpdate(), UrlConstants.URL_DM_INFO + data.getWorks_id());
            }
        });

        ImageLoader.getInstance().displayImage(data.getImg_url(), img, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
    }

    private void startActivity(String update, String url) {
        Intent intent;
        if (update.contains("季")) {
            intent = new Intent(context, DmMultiInfoActivity.class);
        } else {
            intent = new Intent(context, DmSingleInfoActivity.class);
        }
        intent.putExtra(Config.URL, url);
        context.startActivity(intent);
    }
}
