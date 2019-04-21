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
import com.example.duanwu.project3.adapater.IOSAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.GankBean.IOSBean;
import com.example.duanwu.project3.presenter.IOSP;
import com.example.duanwu.project3.view.IOSV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class IOSFragment extends BaseFragment<IOSV,IOSP> implements IOSV {

@BindView(R.id.ios_image)
ImageView  imageView;
@BindView(R.id.ios_rew)
RecyclerView  recyclerView;
    public IOSFragment() {
        // Required empty public constructor
    }

        List<IOSBean.ResultsBean> list;
    private IOSAdapter  adapater;
    @Override
    protected void initData() {
        mPresenter.getIOS();

    }

    @Override
    protected void initView() {
        Glide.with(this).load(R.drawable.d).into(imageView);
        list = new ArrayList<>();
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        adapater = new IOSAdapter(getContext(), list);
        recyclerView.setAdapter(adapater);

    }

    @Override
    protected IOSP initPresenter() {
        return new IOSP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_io;
    }

    @Override
    public void setIOS(IOSBean bean) {
        List<IOSBean.ResultsBean> results = bean.getResults();
        adapater.setData(results);
        adapater.notifyDataSetChanged();

    }
}
