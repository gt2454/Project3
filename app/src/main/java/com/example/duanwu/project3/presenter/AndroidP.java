package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.GankBean.AndroidBean;
import com.example.duanwu.project3.model.AndroidM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.AndroidV;

public class AndroidP extends BasePresenter<AndroidV> {
    private AndroidM hots;

    @Override
    protected void initModel() {
        hots = new AndroidM();
        mModels.add(hots);


    }

    public void getAndroid() {
        hots.getAndroid(new ResultCallBack<AndroidBean>() {
            @Override
            public void onSuccess(AndroidBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setAndroid(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
