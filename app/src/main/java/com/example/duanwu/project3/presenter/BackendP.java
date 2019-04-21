package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.GankBean.FuLiBean;
import com.example.duanwu.project3.model.BackendM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.BackendV;
import com.example.duanwu.project3.view.GoldV;

public class BackendP extends BasePresenter<BackendV> {
    private BackendM hots;

    @Override
    protected void initModel() {
        hots = new BackendM();
        mModels.add(hots);


    }

    public void getFuLi() {
        hots.getHot(new ResultCallBack<FuLiBean>() {
            @Override
            public void onSuccess(FuLiBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setFuLi(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
