package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.bean.VideoBean;

/**
 * 视频来源spinner的adapter
 * Created by Administrator on 2015/10/11 0011.
 */
public class SourceSpinnerAdapter extends AbsAdapter<VideoBean.SitesEntity> {

    public SourceSpinnerAdapter(Context context, int layoutRes, List<VideoBean.SitesEntity>
            datas) {
        super(context, layoutRes, datas, 0);
    }

    @Override
    public void showData(ViewHolder vHolder, VideoBean.SitesEntity data, int position) {
        ImageView icon = (ImageView) vHolder.getView(R.id.source_icon);
        ImageLoader.getInstance().displayImage(data.getSite_logo(), icon, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
        vHolder.setText(R.id.scource_sites, data.getSite_name());
    }
}
