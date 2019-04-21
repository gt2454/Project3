package com.example.duanwu.project3.net;

import com.example.duanwu.project3.bean.GankBean.AndroidBean;
import com.example.duanwu.project3.bean.GankBean.FrontendBean;
import com.example.duanwu.project3.bean.GankBean.FuLiBean;
import com.example.duanwu.project3.bean.GankBean.IOSBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GankService {
    String url="http://gank.io/api/";
    @GET("data/Android/10/1")
    Observable<AndroidBean> getImage();

    String url2="http://gank.io/api/";
    @GET("data/福利/10/1")
    Observable<FuLiBean> getImages();

    String url3="http://gank.io/api/";
    @GET("data/iOS/10/1")
    Observable<IOSBean> getImagesss();



    String url4="http://gank.io/api/";
    @GET("data/前端/10/1")
    Observable<FrontendBean> getImagessss();
}
