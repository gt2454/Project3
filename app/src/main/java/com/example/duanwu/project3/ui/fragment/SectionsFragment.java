package com.example.duanwu.project3.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.SectionsAdapater;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.SectionsBean;
import com.example.duanwu.project3.presenter.AboutP;
import com.example.duanwu.project3.presenter.SectionsP;
import com.example.duanwu.project3.view.AboutV;
import com.example.duanwu.project3.view.SectionsV;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SectionsFragment extends BaseFragment<SectionsV, SectionsP> implements SectionsV {
    @BindView(R.id.sections)
    RecyclerView recyclerView;
    private SectionsAdapater adapater;
    private List<SectionsBean.DataBean> list;

    @Override
    protected SectionsP initPresenter() {
        return new SectionsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sections;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapater = new SectionsAdapater(getContext(), list);
        recyclerView.setAdapter(adapater);


    }

    @Override
    protected void initData() {
        mPresenter.getSections();;
    }

    @Override
    public void setSections(SectionsBean bean) {
        List<SectionsBean.DataBean> data = bean.getData();
        adapater.setData(data);
        adapater.notifyDataSetChanged();


    }
}
