package com.example.duanwu.project3.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.VpAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.GankP;
import com.example.duanwu.project3.view.GankV;

import java.util.ArrayList;

import butterknife.BindView;

public class GankFragment extends BaseFragment<GankV, GankP> implements GankV {


    @BindView(R.id.Gank_tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.Gank_vp)
    ViewPager mVp;
    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;

    private TabLayout Gank_tabLayout;
    private ViewPager Gank_vp;

    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }


    @Override
    protected void initView() {
        initFragments();
        initViews();

    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new AndroidFragment());
        mFragments.add(new IOSFragment());
        mFragments.add(new FrontendFragment());
        mFragments.add(new BackendFragment());

        mTitles = new ArrayList<>();
        mTitles.add("Android ");
        mTitles.add("iOS ");
        mTitles.add("前端");
        mTitles.add("福利");
    }

    private void initViews() {
        //viewpager
        VpAdapter vpAdapter = new VpAdapter(getContext(),getChildFragmentManager(), mFragments, mTitles);
        mVp.setAdapter(vpAdapter);
        //TabLayout
        mTabLayout.setupWithViewPager(mVp);

    }


}
