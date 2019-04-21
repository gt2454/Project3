package com.example.duanwu.project3.ui.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.DataFragment_Adapater;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.Fragment_lie;
import com.example.duanwu.project3.bean.WeChatlie;
import com.example.duanwu.project3.presenter.WechatP;
import com.example.duanwu.project3.utils.Logger;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class DataFragment extends BaseFragment <WechatV,WechatP>implements WechatV {
    @BindView(R.id.rv)
    RecyclerView recyclerView;
    String ids = "";
    private List<Fragment_lie.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist;
    private List<Fragment_lie.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list;
    private DataFragment_Adapater wxAdapter;

    public DataFragment(String id) {
        // Required empty public constructor
        this.ids = id;
    }


    @Override
    protected WechatP initPresenter() {

        return new WechatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_data;
    }

    @Override
    public void setWeChat(WeChatlie bean) {

    }

    @Override
    public void setData(Fragment_lie bean) {
        contentlist = bean.getShowapi_res_body().getPagebean().getContentlist();
        Logger.logD("-----", contentlist +"");
       // list.addAll(contentlist);
        wxAdapter.setDate(contentlist);
        wxAdapter.notifyDataSetChanged();
    }


    @Override
    protected void initData() {
        /*HashMap<String, String> map = new HashMap<>();
        if(!TextUtils.isEmpty(ids)){
            map.put("typeId",ids);
        }*/
        mPresenter.getData(ids);


    }

    @Override
    protected void initView() {
     //   contentlist = fragmentBean.getShowapi_res_body().getPagebean().getContentlist();
       list = new ArrayList<>();
        wxAdapter = new DataFragment_Adapater(list, getContext());
        recyclerView.setAdapter(wxAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
