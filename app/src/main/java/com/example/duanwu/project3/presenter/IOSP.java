package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.GankBean.IOSBean;
import com.example.duanwu.project3.model.IOSM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.GoldV;
import com.example.duanwu.project3.view.IOSV;

public class IOSP extends BasePresenter<IOSV> {
    private IOSM hots;

    @Override
    protected void initModel() {
        hots = new IOSM();
        mModels.add(hots);


    }

    public void getIOS() {
            hots.getIOS(new ResultCallBack<IOSBean>() {
            @Override
            public void onSuccess(IOSBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setIOS(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
