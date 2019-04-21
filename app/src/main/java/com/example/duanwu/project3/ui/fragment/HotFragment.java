package com.example.duanwu.project3.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.HotAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.HotBean;
import com.example.duanwu.project3.presenter.AboutP;
import com.example.duanwu.project3.presenter.HotP;
import com.example.duanwu.project3.ui.fragment.DataNews_details.Hot_details;
import com.example.duanwu.project3.utils.Logger;
import com.example.duanwu.project3.view.AboutV;
import com.example.duanwu.project3.view.HotV;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;



public class HotFragment extends BaseFragment <HotV,HotP>implements HotV{
    @BindView(R.id.hot)
    RecyclerView recyclerView;

   private  List<HotBean.RecentBean> list;
     private HotAdapter  adapater;
    //private int news_id;

    @Override
    protected HotP initPresenter() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        adapater = new HotAdapter(getContext(), list);
        recyclerView.setAdapter(adapater);

        //1808  管涛
    }

    @Override
    protected void initData() {
        mPresenter.getHot();
    }


    @Override
    public void setHot(HotBean bean) {
       // news_id = bean.getRecent().get(i).getNews_id();
      //  Log.e( "pppppppppp",""+ news_id);
        Logger.logD("====",bean+"");
        adapater.setData(bean.getRecent());
        adapater.notifyDataSetChanged();
    }
}
