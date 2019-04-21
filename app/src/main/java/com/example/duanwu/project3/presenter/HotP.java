package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;

import com.example.duanwu.project3.bean.HotBean;
import com.example.duanwu.project3.model.HotM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.HotV;

public class HotP extends BasePresenter<HotV> {
    private HotM hots;

    @Override
    protected void initModel() {
        hots = new HotM();
        mModels.add(hots);


    }

    public void getHot() {
        hots.getHot(new ResultCallBack<HotBean>() {
            @Override
            public void onSuccess(HotBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setHot(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
