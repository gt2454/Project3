package com.example.duanwu.project3.presenter;

import com.example.duanwu.project3.base.BasePresenter;
import com.example.duanwu.project3.bean.SectionsBean;
import com.example.duanwu.project3.model.SectionsM;
import com.example.duanwu.project3.net.ResultCallBack;

import com.example.duanwu.project3.view.SectionsV;

public class SectionsP extends BasePresenter<SectionsV> {
    private SectionsM sections;

    @Override
    protected void initModel() {
        sections = new SectionsM();
        mModels.add(sections);


    }

    public void getSections() {
        sections.getSections(new ResultCallBack<SectionsBean>() {
            @Override
            public void onSuccess(SectionsBean bean) {
                if(bean!=null){
                    if(mMvpView!=null){
                        mMvpView.setSections(bean);
                    }

                }

            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
