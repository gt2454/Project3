package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.GankBean.FrontendBean;

import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.GankService;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class FontendM extends BaseModel {
    public void getQD(final ResultCallBack<FrontendBean> resultCallBack) {
        GankService apiserver = HttpUtils.getInstance().getApiserver(GankService.url4, GankService.class);
        Observable<FrontendBean> dailyNews = apiserver.getImagessss();
        dailyNews.compose(RxUtils.<FrontendBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FrontendBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(FrontendBean dailyNewsBean) {
                        if(dailyNewsBean.getResults().size()>0){
                            resultCallBack.onSuccess(dailyNewsBean);

                        }
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
