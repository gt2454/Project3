package com.example.duanwu.project3.ui.fragment;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.AboutP;
import com.example.duanwu.project3.presenter.CollectP;
import com.example.duanwu.project3.view.AboutV;
import com.example.duanwu.project3.view.CollectV;
import com.example.duanwu.project3.view.WechatV;

public class AboutFragment extends BaseFragment <AboutV,AboutP>implements AboutV{
    @Override
    protected AboutP initPresenter() {
        return new AboutP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }
}
