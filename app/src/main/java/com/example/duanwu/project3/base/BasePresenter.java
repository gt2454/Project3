package com.example.duanwu.project3.base;

import java.util.ArrayList;

/**
 * Created by asus on 2019/3/18.
 */

public abstract class BasePresenter<T extends BaseView> {
    protected  T mMvpView;
    protected ArrayList<BaseModel> mModels = new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();

    public void bind(T view) {
        this.mMvpView = view;
    }

    public void onDestroy(){
        mMvpView = null;
        if (mModels.size()>0){
            for (int i = 0; i < mModels.size(); i++) {
                BaseModel baseModel = mModels.get(i);
                baseModel.onDestory();
            }
        }
    };
}
