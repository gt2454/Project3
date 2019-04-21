package com.example.duanwu.project3.net;

import com.example.duanwu.project3.bean.Fragment_lie;
import com.example.duanwu.project3.bean.WeChatlie;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface  WeChatService {
    String url = "http://ali-weixin-hot.showapi.com/";
    @GET("articleTypeList")
    Observable<WeChatlie> getTab(@Header("Authorization") String head);

    @GET("articleDetalList?")
    @Headers("Authorization:APPCODE 7852685c7273469a910dccacf69a38a1")
    Observable<Fragment_lie>getFragment( @QueryMap Map<String, String> map);
}
