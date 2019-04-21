package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.Fragment_lie;
import com.example.duanwu.project3.bean.WeChatlie;
import com.example.duanwu.project3.model.WechatM;
import com.example.duanwu.project3.net.ResultCallBack;
import com.example.duanwu.project3.view.WechatV;
import com.example.duanwu.project3.view.ZhihuDailyNewsV;

import java.util.HashMap;
import java.util.Map;

public class WechatP extends BasePresenter<WechatV> {
    private WechatM hots;



    @Override
    protected void initModel() {
        hots = new WechatM();
        mModels.add(hots);
    }

    public void getWeChat() {
        hots.getWeChat(new ResultCallBack<WeChatlie>() {
            @Override
            public void onSuccess(WeChatlie bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setWeChat(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    public void getData(final String id ) {
        hots.getData(id,new ResultCallBack<Fragment_lie>() {
            @Override
            public void onSuccess(Fragment_lie bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setData(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }


}
