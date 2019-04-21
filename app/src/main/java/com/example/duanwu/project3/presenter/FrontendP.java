package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.GankBean.FrontendBean;
import com.example.duanwu.project3.model.FontendM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.FrontendV;
import com.example.duanwu.project3.view.GoldV;

public class FrontendP extends BasePresenter<FrontendV> {
    private FontendM hots;

    @Override
    protected void initModel() {
        hots = new FontendM();
        mModels.add(hots);


    }

    public void getQD() {
        hots.getQD(new ResultCallBack<FrontendBean>() {
            @Override
            public void onSuccess(FrontendBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setQD(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
