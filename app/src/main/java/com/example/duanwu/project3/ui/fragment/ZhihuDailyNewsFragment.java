package com.example.duanwu.project3.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;



import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.VpZhihuAdapater;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.ZhihuDailyNewsP;
import com.example.duanwu.project3.view.ZhihuDailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;

public class ZhihuDailyNewsFragment extends BaseFragment<ZhihuDailyNewsV, ZhihuDailyNewsP> implements ZhihuDailyNewsV {
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private ArrayList<Integer> list;

    @Override
    protected ZhihuDailyNewsP initPresenter() {
        return new ZhihuDailyNewsP();
    }

    @Override
    protected int getLayoutId() {


        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initView() {
        initFragments();
        initTitles();
        VpZhihuAdapater vpZhihuAdapater = new VpZhihuAdapater(getContext(),getChildFragmentManager(), fragments, list);
        mVp.setAdapter(vpZhihuAdapater);

        mTabLayout.setupWithViewPager(mVp);




    }

    private void initTitles() {
        list = new ArrayList<>();
        list.add(R.string.daily_news);
        list.add(R.string.sections);
        list.add(R.string.hot);
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new DailyNewsFragment());
        fragments.add(new SectionsFragment());
        fragments.add(new HotFragment());
    }
}
