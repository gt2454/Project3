package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.DailyNewsBean;
import com.example.duanwu.project3.model.DailyNewsM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.AboutV;
import com.example.duanwu.project3.view.DailyNewsV;

public class DailyNewsP extends BasePresenter<DailyNewsV> {

    private DailyNewsM dailyNewsM;

    @Override
    protected void initModel() {
        dailyNewsM = new DailyNewsM();
        mModels.add(dailyNewsM);


    }

    public void getDailyNews() {
        dailyNewsM.getDailyNews(new ResultCallBack<DailyNewsBean>() {
            @Override
            public void onSuccess(DailyNewsBean bean) {
                if(bean!=null){
                       if(mMvpView!=null){
                           mMvpView.setData(bean);
                       }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
