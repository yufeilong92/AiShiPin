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
import qf.com.vitamodemo.bean.OtherVideoBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.ui.VideoInfoActivity;

/**其他分类fragment电影的adapter
 * Created by Administrator on 2015/10/11 0011.
 */
    public class OtherVideoRecyclerAdapter extends AbsRecyclerAdapter<OtherVideoBean>{

        public OtherVideoRecyclerAdapter(Context context, int layoutRes, List<OtherVideoBean> datas, int
                anmiationRes) {
            super(context, layoutRes, datas, anmiationRes);
        }

    @Override
    public void showData(MyViewHolder vHolder, final OtherVideoBean data, int
            position) {

        vHolder.setText(R.id.other_title, data.getTitle());

        ImageView img = (ImageView) vHolder.getView(R.id.other_img);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( UrlConstants.URL_VIDEO_INFO + data.getWorks_id());
            }
        });
        ImageLoader.getInstance().displayImage(data.getImg_url(), img, BaseApp
                .getDisplayImageOptions(new FadeInBitmapDisplayer(1000)));
      }

    private void startActivity(String url) {
        Intent intent = new Intent(context, VideoInfoActivity.class);
        intent.putExtra(Config.URL, url);
        context.startActivity(intent);
    }
}
