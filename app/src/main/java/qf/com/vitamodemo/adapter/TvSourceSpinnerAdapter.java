package qf.com.vitamodemo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.List;

import qf.com.vitamodemo.BaseApp;
import qf.com.vitamodemo.R;
import qf.com.vitamodemo.bean.TvPerSectionBean;

/**
 * 每一季的视频 主要是用于动漫
 * Created by Administrator on 2015/10/11 0011.
 */
public class TvSourceSpinnerAdapter extends AbsAdapter<TvPerSectionBean.SitesEntity> {

    public TvSourceSpinnerAdapter(Context context, int layoutRes, List<TvPerSectionBean.SitesEntity>
            datas) {
        super(context, layoutRes, datas, 0);
    }

    @Override
    public void showData(ViewHolder vHolder, TvPerSectionBean.SitesEntity data, int position) {
        ImageView icon = (ImageView) vHolder.getView(R.id.source_icon);
        //data指的是每一季的视频
        ImageLoader.getInstance().displayImage(data.getSite_logo(), icon, BaseApp
                // FadeInBitmapDisplayer(1000) 图片变淡的时间
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
        vHolder.setText(R.id.scource_sites, data.getSite_name());
    }
}
