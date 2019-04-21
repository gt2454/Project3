package com.example.duanwu.project3.ui.fragment;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.TextView;


import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.EmptyP;
import com.example.duanwu.project3.view.EmptyV;

import butterknife.BindView;

/**
 * @author xts
 *         Created by asus on 2019/4/3.
 */

public class GoldDetailFragment extends BaseFragment<EmptyV,EmptyP>
    implements EmptyV{
    @BindView(R.id.tv)
    TextView mTv;

    public static GoldDetailFragment newInstance(String text){
        GoldDetailFragment goldDetailFragment = new GoldDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SyncStateContract.Constants.DATA,text);
        goldDetailFragment.setArguments(bundle);
        return goldDetailFragment;
    }

    @Override
    protected EmptyP initPresenter() {
        return new EmptyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gold_detail;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String data = arguments.getString(SyncStateContract.Constants.DATA);
        mTv.setText(data);
    }
}
