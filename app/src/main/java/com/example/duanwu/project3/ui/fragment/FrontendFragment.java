package com.example.duanwu.project3.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.BackendAdapter;
import com.example.duanwu.project3.adapater.FrontendAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.GankBean.FrontendBean;
import com.example.duanwu.project3.presenter.FrontendP;
import com.example.duanwu.project3.view.FrontendV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FrontendFragment extends BaseFragment<FrontendV,FrontendP> implements FrontendV {
    @BindView(R.id.frontend_rew)
    RecyclerView  recyclerView;
    @BindView(R.id.frontend_images)
    ImageView  imageView;

    public FrontendFragment() {
        // Required empty public constructor
    }
private List<FrontendBean.ResultsBean> list;
private FrontendAdapter  adapater;

    @Override
    protected FrontendP initPresenter() {
        return new FrontendP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_frontend;
    }

    @Override
    protected void initView() {
        Glide.with(this).load(R.drawable.ccc).into(imageView);
        list = new ArrayList<>();
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        adapater = new FrontendAdapter(getContext(), list);
        recyclerView.setAdapter(adapater);
    }

    @Override
    protected void initData() {
        mPresenter.getQD();;

    }

    @Override
    public void setQD(FrontendBean bean) {
        List<FrontendBean.ResultsBean> results = bean.getResults();
        adapater.setData(results);
        adapater.notifyDataSetChanged();


    }
}
