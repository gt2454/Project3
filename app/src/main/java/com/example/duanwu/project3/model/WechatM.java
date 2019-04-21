package com.example.duanwu.project3.model;

import android.text.SpannableString;
import android.util.ArrayMap;

import com.example.duanwu.project3.base.BaseModel;
import com.example.duanwu.project3.bean.Fragment_lie;
import com.example.duanwu.project3.bean.WeChatlie;
import com.example.duanwu.project3.net.BaseObserver;
import com.example.duanwu.project3.net.HttpUtils;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.net.RxUtils;
import com.example.duanwu.project3.net.WeChatService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class WechatM extends BaseModel {
    public void getWeChat(final ResultCallBack<WeChatlie> resultCallBack) {
        WeChatService apiserver = HttpUtils.getInstance().getApiserver(WeChatService.url, WeChatService.class);
        Observable<WeChatlie> dailyNews = apiserver.getTab("APPCODE 7852685c7273469a910dccacf69a38a1");
        dailyNews.compose(RxUtils.<WeChatlie>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WeChatlie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(WeChatlie dailyNewsBean) {
                      //  List<WeChatlie.ShowapiResBodyBean.TypeListBean> typeList = dailyNewsBean.getShowapi_res_body().getTypeList();
                            resultCallBack.onSuccess(dailyNewsBean);
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });
    }

    public void getData(String id, final ResultCallBack<Fragment_lie> resultCallBack) {
        WeChatService apiserver = HttpUtils.getInstance().getApiserver(WeChatService.url, WeChatService.class);
            Map<String,String> map=new HashMap<>();
            map.put("typeId",id);
        Observable<Fragment_lie> dailyNews = apiserver.getFragment(map);
        dailyNews.compose(RxUtils.<Fragment_lie>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Fragment_lie>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);


                    }

                    @Override
                    public void onNext(Fragment_lie dailyNewsBean) {
                        //  List<WeChatlie.ShowapiResBodyBean.TypeListBean> typeList = dailyNewsBean.getShowapi_res_body().getTypeList();
                        resultCallBack.onSuccess(dailyNewsBean);
                        // callBack.onSuccess(dailyNewsBean);
                    }
                });

    }
}
