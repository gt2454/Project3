package com.example.duanwu.project3.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.AndroidAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.GankBean.AndroidBean;
import com.example.duanwu.project3.presenter.AndroidP;
import com.example.duanwu.project3.view.AndroidV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends BaseFragment<AndroidV, AndroidP> implements AndroidV {
    @BindView(R.id.gank_image)
    ImageView  imageView;
    @BindView(R.id.gank_rew)
    RecyclerView recyclerView;


    public AndroidFragment() {
        // Required empty public constructor
    }

    private List<AndroidBean.ResultsBean> list;
    AndroidAdapter adapater;

    @Override
    protected void initData() {

        mPresenter.getAndroid();
    }

    @Override
    protected void initView() {
        Glide.with(this).load(R.drawable.aaa).into(imageView);

        list = new ArrayList<>();
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        adapater = new AndroidAdapter(getContext(), list);
        recyclerView.setAdapter(adapater);

    }

    @Override
    protected AndroidP initPresenter() {
        return new AndroidP();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_android;
    }


    @Override
    public void setAndroid(AndroidBean bean) {
        List<AndroidBean.ResultsBean> results = bean.getResults();
        adapater.setData(results);
        adapater.notifyDataSetChanged();

    }
}
