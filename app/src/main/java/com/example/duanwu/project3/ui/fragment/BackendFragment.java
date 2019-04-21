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

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.BackendAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.GankBean.FuLiBean;
import com.example.duanwu.project3.presenter.BackendP;
import com.example.duanwu.project3.view.BackendV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BackendFragment extends BaseFragment<BackendV,BackendP> implements BackendV {

    @BindView(R.id.gank_Fuli)
    RecyclerView  recyclerView;
    BackendAdapter adapater;
    public BackendFragment() {
        // Required empty public constructor
    }
        private List<FuLiBean.ResultsBean> list;
    @Override
    protected void initView() {
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapater = new BackendAdapter(getContext(), list);
        recyclerView.setAdapter(adapater);

    }

    @Override
    protected void initData() {

        mPresenter.getFuLi();

    }

    @Override
    protected BackendP initPresenter() {
        return new BackendP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_backend;
    }

    @Override
    public void setFuLi(FuLiBean bean) {
        List<FuLiBean.ResultsBean> results = bean.getResults();
        adapater.setData(results);
        adapater.notifyDataSetChanged();

    }
}
