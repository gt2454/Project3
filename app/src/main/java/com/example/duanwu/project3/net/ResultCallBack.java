package com.example.duanwu.project3.net;


import com.example.duanwu.project3.bean.LoginBean;

/**
 * Created by asus on 2019/3/18.
 */

public interface ResultCallBack<T> {
    void onSuccess(T bean);
    void onFail(String msg);
}
