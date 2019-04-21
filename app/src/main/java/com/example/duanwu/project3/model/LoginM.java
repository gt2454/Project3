package com.example.duanwu.project3.model;



import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.LoginBean;
import com.example.duanwu.project3.net.ApiService;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asus on 2019/3/18.
 */
public class LoginM extends BaseModel {
    public void login(String name, String psd, final ResultCallBack callBack) {
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.mBaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Observable<LoginBean> login = retrofit.create(ApiService.class).login(name, psd);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                       // d.dispose();
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.mBaseUrl, ApiService.class);
        apiserver.login(name,psd)
                .compose(RxUtils.<LoginBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        callBack.onSuccess(loginBean);
                    }
                });
    }
}
