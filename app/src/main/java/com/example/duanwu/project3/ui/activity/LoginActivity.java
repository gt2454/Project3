package com.example.duanwu.project3.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseActivity;
import com.example.duanwu.project3.presenter.LoginP;
import com.example.duanwu.project3.view.LoginView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * View: 只负责处理ui;
 * P: 负责业务逻辑,链接View和M
 * M: 负责处理数据,网络/数据库/计算,耗时操作
 */
public class LoginActivity extends BaseActivity<LoginView, LoginP> implements LoginView {

    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_psd)
    EditText mEtPsd;
    @BindView(R.id.btn)
    Button mBtn;

    @Override
    protected LoginP initPresenter() {
        return new LoginP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.et_name, R.id.et_psd, R.id.btn})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.et_name:
                break;
            case R.id.et_psd:
                break;
            case R.id.btn:
                mPresenter.login();
                break;
        }
    }

    @Override
    public String getName() {
        return mEtName.getText().toString().trim();
    }

    @Override
    public String getPsd() {
        return mEtPsd.getText().toString().trim();
    }

}
