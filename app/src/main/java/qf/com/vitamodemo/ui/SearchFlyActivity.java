package qf.com.vitamodemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import qf.com.vitamodemo.R;
import qf.com.vitamodemo.bean.OtherVideoBean;
import qf.com.vitamodemo.config.Config;
import qf.com.vitamodemo.config.UrlConstants;
import qf.com.vitamodemo.utils.VUtils;
import qf.com.vitamodemo.widget.KeywordsFlow;

public class SearchFlyActivity extends AppCompatActivity implements OnClickListener {

    private KeywordsFlow keywordsFlow;
    private Button btnIn, btnOut;
    private ArrayList<OtherVideoBean> datas = new ArrayList<>();
    private List<HashMap<String, String>> list = new ArrayList<>();

    //在动画里面填入文字
    private void feedKeywordsFlow(KeywordsFlow keywordsFlow, List<HashMap<String, String>>
            arr) {
        Random random = new Random();
        for (int i = 0; i < KeywordsFlow.MAX; i++) {
            //随机产生一个小于arr.size()的数
            int ran = random.nextInt(arr.size());
            //把map集合放在set集合里
            Set<Map.Entry<String, String>> entries = arr.get(ran).entrySet();

            //遍历集合
            for (Map.Entry<String, String> entry : entries) {
                keywordsFlow.feedKeyword(entry.getKey());
            }
        }
    }
    //初始化数据
    public void initData() {
        //联网获得数据
        StringRequest request = new StringRequest(getIntent().getStringExtra(Config.URL), new
                Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        //解析数据
                        JSONArray array = JSON.parseObject(s).getJSONObject("video_list")
                                .getJSONArray("videos");
                        datas.addAll(JSON.parseArray(array.toString(), OtherVideoBean.class));
                        for (int i = 0; i < datas.size(); i++) {
                            HashMap<String, String> m = new HashMap<>();
                            OtherVideoBean bean = datas.get(i);
                            m.put(bean.getTitle(), bean.getWorks_id());
                            list.add(m);
                        }
                        // 添加文字
                        feedKeywordsFlow(keywordsFlow, list);
                        keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.printStackTrace();
            }
        });
        request.setTag(this);
        VUtils.getQueue(this).add(request);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VUtils.getQueue(this).cancelAll(this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("搜索");

        btnIn = (Button) findViewById(R.id.button1);
        btnOut = (Button) findViewById(R.id.button2);
        btnIn.setOnClickListener(this);
        btnOut.setOnClickListener(this);
        keywordsFlow = (KeywordsFlow) findViewById(R.id.frameLayout1);
        keywordsFlow.setDuration(800l);
        keywordsFlow.setOnItemClickListener(this);

        initData();
    }

    //条目的点击事件
    @Override
    public void onClick(View v) {
        if (v == btnIn) {
            //显示之前先把原来的清除
            keywordsFlow.rubKeywords();
            //重新显示
            feedKeywordsFlow(keywordsFlow, list);
            keywordsFlow.go2Show(KeywordsFlow.ANIMATION_IN);
        } else if (v == btnOut) {
            keywordsFlow.rubKeywords();
            feedKeywordsFlow(keywordsFlow, list);//随机查找10个关键字
            keywordsFlow.go2Show(KeywordsFlow.ANIMATION_OUT);
        } else if (v instanceof TextView) {
            String keyword = ((TextView) v).getText().toString();
            for (HashMap<String, String> map : list) {
                Set<Map.Entry<String, String>> entries = map.entrySet();
                for (Map.Entry entry : entries) {
                    if (entry.getKey().equals(keyword)) {
                        Intent intent = null;
                        //接受前面传过来的视频类型
                        String type = getIntent().getStringExtra(Config.URL_TYPE);
                        if (type == null) {
                            return;
                        }
                        switch (type) {
                            case Config.TYPE_VIDEO:
                                intent = new Intent(getApplicationContext(), VideoInfoActivity
                                        .class);
                                intent.putExtra(Config.URL, UrlConstants.URL_VIDEO_INFO +
                                        entry.getValue());
                                break;
                            case Config.TYPE_DM:
                                intent = new Intent(getApplicationContext(), DmSingleInfoActivity
                                        .class);
                                intent.putExtra(Config.URL, UrlConstants.URL_DM_INFO +
                                        entry.getValue());
                                break;
                            case Config.TYPE_TV:
                                intent = new Intent(getApplicationContext(), TvInfoActivity
                                        .class);
                                intent.putExtra(Config.URL, UrlConstants.URL_TV_INFO +
                                        entry.getValue());
                                break;
                            case Config.TYPE_ZY:
                                intent = new Intent(getApplicationContext(), ZyInfoActivity
                                        .class);
                                intent.putExtra(Config.URL, UrlConstants.URL_ZY_INFO +
                                        entry.getValue());
                                break;
                        }
                        startActivity(intent);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}