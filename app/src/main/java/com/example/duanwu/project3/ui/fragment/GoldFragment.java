package com.example.duanwu.project3.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.VpGoldAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.GoldTitleBean;
import com.example.duanwu.project3.presenter.GankP;
import com.example.duanwu.project3.presenter.GoldP;
import com.example.duanwu.project3.ui.activity.ShowActivity;
import com.example.duanwu.project3.view.GankV;
import com.example.duanwu.project3.view.GoldV;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class GoldFragment extends BaseFragment <GoldV,GoldP>implements GoldV{
    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.iv)
    ImageView mIv;
    private ArrayList<GoldTitleBean> mTitles;
    private ArrayList<BaseFragment> mFragments;
    private ArrayList<GoldTitleBean> mList;

    @Override
    protected GoldP initPresenter() {
        return new GoldP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold;
    }

    @Override
    protected void initView() {
        initTitles();
        setFragments();
    }

    private void setFragments() {
        initFragments();
        VpGoldAdapter adapter = new VpGoldAdapter(getChildFragmentManager(), mFragments, mTitles);
        mVp.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mVp);
    }

    @OnClick({R.id.iv})
    public void click(View v){
        switch (v.getId()) {
            case R.id.iv:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(SyncStateContract.Constants.DATA,mTitles);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null){
            if (requestCode == 100 && resultCode == Activity.RESULT_OK){
                mTitles = (ArrayList<GoldTitleBean>) data.getSerializableExtra(SyncStateContract.Constants.DATA);
                setFragments();
            }
        }
    }

    private void initFragments() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTitles.size(); i++) {
            GoldTitleBean goldTitleBean = mTitles.get(i);
            if (goldTitleBean.isChecked){
                mFragments.add(GoldDetailFragment.newInstance(goldTitleBean.title));
            }
        }
    }

    private void initTitles() {
        mTitles = new ArrayList<>();
        mTitles.add(new GoldTitleBean("Android",true));
        mTitles.add(new GoldTitleBean("iOS",true));
        mTitles.add(new GoldTitleBean("设计",true));
        mTitles.add(new GoldTitleBean("工具资源",true));
        mTitles.add(new GoldTitleBean("产品",true));
        mTitles.add(new GoldTitleBean("阅读",true));
        mTitles.add(new GoldTitleBean("前端",true));
        mTitles.add(new GoldTitleBean("后端",true));
    }
}
