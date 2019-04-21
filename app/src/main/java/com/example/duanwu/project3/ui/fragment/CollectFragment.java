package com.example.duanwu.project3.ui.fragment;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.CollectP;
import com.example.duanwu.project3.presenter.GankP;
import com.example.duanwu.project3.view.CollectV;
import com.example.duanwu.project3.view.GankV;
import com.example.duanwu.project3.view.WechatV;

public class CollectFragment extends BaseFragment <CollectV,CollectP>implements CollectV{
    @Override
    protected CollectP initPresenter() {
        return new CollectP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }
}
