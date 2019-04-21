package com.example.duanwu.project3.net;

import com.example.duanwu.project3.bean.DailyNewsBean;
import com.example.duanwu.project3.bean.DailyNews_detailsBean;
import com.example.duanwu.project3.bean.HotBean;
import com.example.duanwu.project3.bean.Hot_detailsBean;
import com.example.duanwu.project3.bean.SectionsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhihuService {
    String mBaseUrl="http://news-at.zhihu.com/api/4/";
  /**
   * 最新日报
   *
   * */
   @GET("news/latest")
    Observable<DailyNewsBean> getDailyNews();

/*
* 专栏
* */
   @GET("sections")
    Observable<SectionsBean> getSections();
/*
* 热门
* */
   @GET("news/hot")
    Observable<HotBean> getHot();

    /**
     * 日报详情
     */
    @GET("news/{id}")
    Observable<DailyNews_detailsBean> getDetailInfo(@Path("id") int id);

    /*
     * 热门
     * */
    @GET("news/{id}")
    Observable<Hot_detailsBean> getHotInfo(@Path("id") int id);
}
