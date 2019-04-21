package com.example.duanwu.project3.ui.fragment;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.CollectP;
import com.example.duanwu.project3.presenter.SettingsP;
import com.example.duanwu.project3.view.CollectV;
import com.example.duanwu.project3.view.SettingsV;
import com.example.duanwu.project3.view.WechatV;

public class SettingsFragment extends BaseFragment <SettingsV,SettingsP>implements SettingsV{
    @Override
    protected SettingsP initPresenter() {
        return new SettingsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_settings;
    }
}
