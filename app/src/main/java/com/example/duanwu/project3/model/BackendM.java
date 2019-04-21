package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.GankBean.FuLiBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.GankService;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class BackendM extends BaseModel {
    public void getHot(final ResultCallBack<FuLiBean> resultCallBack) {
        GankService apiserver = HttpUtils.getInstance().getApiserver(GankService.url2, GankService.class);
        Observable<FuLiBean> dailyNews = apiserver.getImages();
        dailyNews.compose(RxUtils.<FuLiBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuLiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(FuLiBean dailyNewsBean) {
                        if(dailyNewsBean.getResults().size()>0){
                            resultCallBack.onSuccess(dailyNewsBean);

                        }
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });
    }
}
