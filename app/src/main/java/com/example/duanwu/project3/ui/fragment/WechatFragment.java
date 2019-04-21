package com.example.duanwu.project3.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.adapater.ViewAdapter;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.bean.Fragment_lie;
import com.example.duanwu.project3.bean.WeChatlie;
import com.example.duanwu.project3.presenter.WechatP;
import com.example.duanwu.project3.view.WechatV;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class WechatFragment extends BaseFragment <WechatV,WechatP>implements WechatV{

   @BindView(R.id.tabLayout)
    TabLayout  tabLayout;
   @BindView(R.id.vp)
    ViewPager vp;
    private ArrayList<String> tab;
    private ArrayList<Fragment> fragments;
    private ViewAdapter viewAdapter;
   @Override
    protected WechatP initPresenter() {
        return new WechatP();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;

    }

    @Override
    protected void initData() {
        mPresenter.getWeChat();

    }

    @Override
    protected void initView() {
        tabLayout.setupWithViewPager(vp);
        tab = new ArrayList<>();
        fragments = new ArrayList<>();
        viewAdapter = new ViewAdapter(getChildFragmentManager(), tab, fragments);
        vp.setAdapter(viewAdapter);




    }


    @Override
    public void setWeChat(WeChatlie bean) {
        List<WeChatlie.ShowapiResBodyBean.TypeListBean> typeList = bean.getShowapi_res_body().getTypeList();
        for (WeChatlie.ShowapiResBodyBean.TypeListBean typeListBean : typeList) {
            String id = typeListBean.getId();
            tab.add(typeListBean.getName());
            fragments.add(new DataFragment(id));
            viewAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setData(Fragment_lie bean) {

    }



}
