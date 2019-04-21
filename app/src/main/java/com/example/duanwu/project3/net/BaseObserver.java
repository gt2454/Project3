package com.example.duanwu.project3.net;

import android.util.Log;


import com.example.duanwu.project3.utils.Logger;
import com.example.duanwu.project3.utils.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by asus on 2019/3/4.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    private final String TAG = getClass().getName();

    @Override
    public void onError(Throwable e) {
        Logger.logD(TAG, "onError: "+e.toString());
        ToastUtil.showShort("数据加载失败");
    }

    @Override
    public void onComplete() {
        Logger.logD(TAG, "onComplete: ");
    }
}
