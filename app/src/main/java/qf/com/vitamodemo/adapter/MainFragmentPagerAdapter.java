package qf.com.vitamodemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * 搭架子 每个页面一个标题 一个fragment
 * Created by Administrator on 2015/9/29 0029.
 */
// FragmentPagerAdapter继承自pagerAdapter 用于显示每一个页面都是一个Fragment的情况  数量较小，静态的页
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> mTitles;

    public  MainFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String>
            mTitles) {
        super(fm);
        this.fragments = fragments;
        this.mTitles = mTitles;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
