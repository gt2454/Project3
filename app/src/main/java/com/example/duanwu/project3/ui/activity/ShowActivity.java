package com.example.duanwu.project3.ui.activity;

import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.RlvShowAdapter;
import com.example.duanwu.project3.base.BaseActivity;
import com.example.duanwu.project3.bean.GoldTitleBean;
import com.example.duanwu.project3.presenter.EmptyP;
import com.example.duanwu.project3.view.EmptyV;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowActivity extends BaseActivity<EmptyV, EmptyP> implements EmptyV  {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.rlv)
    RecyclerView mRlv;
    private ArrayList<GoldTitleBean> mTitles;

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mToolBar.setTitle(R.string.special_show);
        mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        mTitles = (ArrayList<GoldTitleBean>) getIntent().getSerializableExtra(SyncStateContract.Constants.DATA);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        RlvShowAdapter adapter = new RlvShowAdapter(mTitles);
        mRlv.setAdapter(adapter);
        mRlv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(SyncStateContract.Constants.DATA,mTitles);
        setResult(RESULT_OK,intent);
        finish();
    }
}
