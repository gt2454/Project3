package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;

import com.example.duanwu.project3.bean.HotBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.HttpUtils;

import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;
import com.example.duanwu.project3.net.ZhihuService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;


public class HotM extends BaseModel {
    public void getHot (final ResultCallBack<HotBean> callBack) {
        ZhihuService apiserver = HttpUtils.getInstance().getApiserver(ZhihuService.mBaseUrl, ZhihuService.class);
        Observable<HotBean> dailyNews = apiserver.getHot();
        dailyNews.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(HotBean dailyNewsBean) {
                        if(dailyNewsBean.getRecent().size()>0){
                            callBack.onSuccess(dailyNewsBean);

                        }
                       // callBack.onSuccess(dailyNewsBean);
                    }
                });

    }


}
