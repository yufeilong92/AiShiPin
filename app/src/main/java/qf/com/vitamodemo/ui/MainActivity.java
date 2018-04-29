package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.utils.NetworkManager;
import qf.com.vitamodemo.widget.CircleMenuLayout;

/**
 * 主界面
 */
public class MainActivity extends BaseActivity {

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[]{"电影 ", "电视剧", "综艺",
            "动漫"};
    private int[] mItemImgs = new int[]{R.drawable.home_mbank_1_clicked,
            R.drawable.home_mbank_2_clicked, R.drawable.home_mbank_3_clicked,
            R.drawable.home_mbank_4_clicked};

    private ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
    mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

    //条目点击
    mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
        @Override
        public void itemClick(View view, final int pos) {
            switch (pos) {
                case 0:
                    startActivity(new Intent(MainActivity.this, VideoActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, TvActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, ZyActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, DmActivity.class));
                    break;
            }
        }
        @Override
        public void itemCenterClick(View view) {

        }
    });
}

    protected void onResume() {
//        viewFlipper.setAutoStart(true);//自动播放
//        viewFlipper.setFlipInterval(3000);//设置播放时间
        viewFlipper.startFlipping();//设置播放开始
        super.onResume();
    }

    protected void onPause() {
        viewFlipper.stopFlipping();
        super.onPause();
    }

    /**
     * 设置在onStart()方法里面，可以在界面每次获得焦点的时候都进行检测
     */
    @Override
    protected void onStart() {
        NetworkManager.judgeNetwork(this);
        super.onStart();
    }
}
