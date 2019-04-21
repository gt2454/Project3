package com.example.duanwu.project3.net;



import com.example.duanwu.project3.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by asus on 2019/3/18.
 */

public interface ApiService {
    String mBaseUrl = "http://yun918.cn/study/public/index.php/";

    @POST("login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("username") String name,
                                @Field("password") String psd);
}
