package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.SectionsBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;
import com.example.duanwu.project3.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SectionsM extends BaseModel {
    public void getSections(final ResultCallBack<SectionsBean> resultCallBack) {
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.mBaseUrl, ZhihuService.class);
        Observable<SectionsBean> dailyNews = apiserver.getSections();
        dailyNews.compose(RxUtils.<SectionsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SectionsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(SectionsBean dailyNewsBean) {
                        resultCallBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
