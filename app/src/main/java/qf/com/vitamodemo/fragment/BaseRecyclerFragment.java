package qf.com.vitamodemo.fragment;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import qf.com.vitamodemo.adapter.AbsRecyclerAdapter;

/**
 *
 * @param <T>
 */
//swipeRefreshLayout 下拉刷新组件
public abstract class BaseRecyclerFragment<T> extends Fragment implements SwipeRefreshLayout
        .OnRefreshListener {
    //进度对话框
    public ProgressDialog dialog;
    //高度解耦控件，复用view
    protected RecyclerView recyclerView;
    //下拉刷新组件
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    //控制recycleView的显示方式
    protected RecyclerView.LayoutManager mLayoutManager;
    //
    protected int mPageIndex = 50;
    //控制recycleView的显示内容，适配器
    protected RecyclerView.Adapter mAdapter;
    //滚动条
    protected ProgressBar mProgressBar;

    private int lastVisibleItem = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*dialog = new ProgressDialog(activity);
        dialog.setMessage("正在加载");*/
    }

    public abstract int getLayoutId();//整个父类的id

    public abstract int getRecyclerViewId();//刷新子布局的id

    //获得每一个页面RecycleView的显示方式管理器
    public abstract RecyclerView.LayoutManager getLayoutManager();

    /**
     *
     * @param inflater    子空间的视图
     * @param container  父控件视图
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        initView(view);
        initOtherView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData(1);
    }

    protected void initOtherView(View view) {

    }

    public abstract void initData(int pageIndex);
    //初始化控件
    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(getRecyclerViewId());
        mLayoutManager = getLayoutManager();
        recyclerView.setLayoutManager(mLayoutManager);
        //添加头部view 这个必须在setAdapter前

        setHeaderView(recyclerView);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                super.onScrolled(recyclerView, dx, dy);

                lastVisibleItem = ((LinearLayoutManager) mLayoutManager)
                        .findLastVisibleItemPosition();
                   // firstVisibleItem：第一个可见项是ListView的第几项
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == mAdapter.getItemCount() && canLoadMore()) {
                    mPageIndex += 30;
                    initData(mPageIndex - 30);
                }
            }
        });

        mAdapter = getBaseRecyclerAdapter();
        recyclerView.setAdapter(mAdapter);

        if (getRefreshLayoutId() != 0) {
            mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(getRefreshLayoutId());
            mSwipeRefreshLayout.setOnRefreshListener(this);
            mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN, Color
                    .CYAN);//progressbar刷新式旋转的颜色
        }

        if (hasProgress()) {
            mProgressBar = (ProgressBar) view.findViewById(getProgressBarId());
        }
    }

    public boolean hasProgress() {
        return false;
    }

    public int getProgressBarId() {
        return 0;
    }

    public abstract RecyclerView.Adapter getBaseRecyclerAdapter();

    public int getRefreshLayoutId() {
        return 0;
    }

    @Override
    public void onRefresh() {
        initData(1);
    }

    public void setHeaderView(RecyclerView recyclerView) {
    }

    public boolean canLoadMore() {
        return true;
    }
}