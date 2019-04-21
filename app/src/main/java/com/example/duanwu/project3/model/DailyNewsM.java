package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.DailyNewsBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;
import com.example.duanwu.project3.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class DailyNewsM extends BaseModel {
    public void getDailyNews(final ResultCallBack<DailyNewsBean> callBack) {
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.mBaseUrl, ZhihuService.class);
        Observable<DailyNewsBean> dailyNews = apiserver.getDailyNews();
        dailyNews.compose(RxUtils.<DailyNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(DailyNewsBean dailyNewsBean) {
                        callBack.onSuccess(dailyNewsBean);
                    }
                });

    }
}
