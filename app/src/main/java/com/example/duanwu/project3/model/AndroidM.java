package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.GankBean.AndroidBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.GankService;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class AndroidM extends BaseModel {

    public void getAndroid(final ResultCallBack<AndroidBean> resultCallBack) {

        GankService apiserver = HttpUtils.getInstance().getApiserver(GankService.url, GankService.class);
        Observable<AndroidBean> dailyNews = apiserver.getImage();
        dailyNews.compose(RxUtils.<AndroidBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<AndroidBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(AndroidBean dailyNewsBean) {
                        if(dailyNewsBean.getResults().size()>0){
                            resultCallBack.onSuccess(dailyNewsBean);

                        }
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
