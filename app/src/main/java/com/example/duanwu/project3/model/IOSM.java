package com.example.duanwu.project3.model;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.GankBean.IOSBean;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.GankService;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class IOSM extends BaseModel {
    public void getIOS(final ResultCallBack<IOSBean> resultCallBack) {
        GankService apiserver = HttpUtils.getInstance().getApiserver(GankService.url3, GankService.class);
        Observable<IOSBean> dailyNews = apiserver.getImagesss();
        dailyNews.compose(RxUtils.<IOSBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<IOSBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(IOSBean dailyNewsBean) {
                        if(dailyNewsBean.getResults().size()>0){
                            resultCallBack.onSuccess(dailyNewsBean);

                        }
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });

    }
}
