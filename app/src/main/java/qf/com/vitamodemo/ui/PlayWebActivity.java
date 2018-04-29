package qf.com.vitamodemo.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.config.Config;

/**
 * 播放界面
 */
public class PlayWebActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar pb;
    private FrameLayout video;
    private SampleWebChromeClient chromeClient;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        // 声明video，把之后的视频放到这里面去
        video = (FrameLayout) findViewById(R.id.video);
        webView = (WebView) findViewById(R.id
                .webview);
        pb = (ProgressBar) findViewById(R.id.pb);
        pb.setMax(100);
        //设置webView的显示
        WebSettings settings = webView.getSettings();
        //用户可任意比列缩放
        settings.setUseWideViewPort(true);
        settings.setJavaScriptEnabled(true);
        //使之可以充满全屏
        settings.setLoadWithOverviewMode(true);
        //使页面可以支持缩放
        settings.setSupportZoom(true);
        settings.setDisplayZoomControls(true);

        //硬件加速
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        webView.setWebViewClient(new SampleWebViewClient());
        chromeClient = new SampleWebChromeClient();
        webView.setWebChromeClient(chromeClient);

        if (getIntent() != null) {
            String url = getIntent().getStringExtra(Config.URL);
            if (url != null) {
                webView.loadUrl(url);
            }
        }
    }

    // 手机返回键监听 不退出程序而是返回上一浏览页面：
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                // 如果是全屏状态 按返回键则变成非全屏状态，否则执行返回操作
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE ||
                        webView.getVisibility() == View.GONE) {
                    chromeClient.onHideCustomView();
                } else {
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                }
                return true;
        }
        return false;
    }

    @Override
    protected void onPause() {
        webView.pauseTimers();
        super.onPause();
    }
    @Override
    protected void onResume() {
        webView.resumeTimers();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        webView.destroy();
        super.onDestroy();
    }

    /**
     * 设置全屏
     */
    private void setFullScreen() {
        // 设置全屏的相关属性，获取当前的屏幕状态，然后设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    /**
     * 退出全屏
     */
    private void quitFullScreen() {
        // 声明当前屏幕状态的参数并获取
        final WindowManager.LayoutParams attrs = getWindow().getAttributes();
        //!=表示加上这个标志，&=表示减去这个标志
        attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setAttributes(attrs);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private class SampleWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }

    //WebChromeClient 用来辅助webView处理js的对话框，网址图标，title。加载进度条等
    private class SampleWebChromeClient extends WebChromeClient {
        // 一个回调接口使用的主机应用程序通知当前页面的自定义视图已被撤职
        CustomViewCallback customViewCallback;
        private View v;

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            pb.setProgress(newProgress);
            if (newProgress == 100) {
                pb.setVisibility(View.GONE);
            }
            
            super.onProgressChanged(view, newProgress);
        }

        // 进入全屏的时候
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            // 赋值给callback
            customViewCallback = callback;
            // 设置webView隐藏
            webView.setVisibility(View.GONE);

            // 将video放到当前视图中
            v=view;
            video.setVisibility(View.VISIBLE);
            video.addView(view);
            // 横屏显示
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            // 设置全屏
            setFullScreen();
        }

        @Override
        public void onHideCustomView() {
            if (customViewCallback != null) {
                // 隐藏掉
                customViewCallback.onCustomViewHidden();
            }

            // 用户当前的首选方向
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            // 退出全屏
            quitFullScreen();
            // 设置WebView可见
            webView.setVisibility(View.VISIBLE);
            video.removeView(v);
            video.setVisibility(View.GONE);
        }
    }
}
