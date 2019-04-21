package com.example.duanwu.project3.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.RlvDailyNewsAdapater;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.DailyNewsBean;
import com.example.duanwu.project3.presenter.AboutP;
import com.example.duanwu.project3.presenter.DailyNewsP;
import com.example.duanwu.project3.ui.fragment.DataNews_details.DailyNews_details;
import com.example.duanwu.project3.view.AboutV;
import com.example.duanwu.project3.view.DailyNewsV;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;

import butterknife.BindView;

public class DailyNewsFragment extends BaseFragment <DailyNewsV,DailyNewsP>implements DailyNewsV{
    @BindView(R.id.rlv)
    RecyclerView  recyclerView;
    private ArrayList<DailyNewsBean.StoriesBean> storiesBeans;
    private ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans;
    private RlvDailyNewsAdapater rlvDailyNewsAdapater;

    @Override
    protected DailyNewsP initPresenter() {
        return new DailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView() {
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        storiesBeans = new ArrayList<>();
        topStoriesBeans = new ArrayList<>();
        rlvDailyNewsAdapater = new RlvDailyNewsAdapater(getContext(),storiesBeans,topStoriesBeans);
        recyclerView.setAdapter(rlvDailyNewsAdapater);
        rlvDailyNewsAdapater.setOnItemCLickListener(new RlvDailyNewsAdapater.OnItemCLickListener() {
            @Override
            public void onItemClick(View v, int position) {
                int id = storiesBeans.get(position).getId();
                Intent  intent=new Intent(getContext(), DailyNews_details.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void initData() {
         mPresenter.getDailyNews();

    }

    @Override
    public void setData(DailyNewsBean bean) {
        rlvDailyNewsAdapater.setData(bean);

    }
}

