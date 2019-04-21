package com.example.duanwu.project3.presenter;

import android.text.TextUtils;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.LoginBean;
import com.example.duanwu.project3.model.LoginM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.utils.Logger;
import com.example.duanwu.project3.utils.ToastUtil;
import com.example.duanwu.project3.view.LoginView;


/**
 * Created by asus on 2019/3/18.
 */

public class LoginP extends BasePresenter<LoginView> {

    private static final String TAG = "LoginP";
    private LoginM mLoginM;

    public void login() {
        String name = mMvpView.getName();
        String psd = mMvpView.getPsd();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(psd)){
            ToastUtil.showShort("用户名或者密码不能为空");
            return;
        }

        mLoginM.login(name,psd, new ResultCallBack<LoginBean>() {
            @Override
            public void onSuccess(LoginBean bean) {
                Logger.logD(TAG,bean.toString());
                //数据没没回来,退出界面
                //1.有必要网络请求----停止请求
                //2.防止空指针
                /*if (mMvpView != null){
                    mMvpView.setData();
                }*/
            }

            @Override
            public void onFail(String msg) {
                Logger.logD(TAG,msg);
            }
        });
    }

    @Override
    protected void initModel() {
        mLoginM = new LoginM();
        mModels.add(mLoginM);
    }
}
