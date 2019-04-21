package com.example.duanwu.project3.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by asus on 2019/3/18.
 */

public abstract class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        //在这里把网络请求和订阅关系打断
        //clear清空的时候会调用Disposable.dispose()切断观察者和被观察者的连接
        mCompositeDisposable.clear();
    }
}
