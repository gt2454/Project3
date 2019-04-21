package com.example.duanwu.project3.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by asus on 2019/3/18.
 */

public class BaseApp extends Application {
    private static BaseApp sBaseApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sBaseApp = this;
    }

    public static Context getInstance() {
        return sBaseApp;
    }
}
