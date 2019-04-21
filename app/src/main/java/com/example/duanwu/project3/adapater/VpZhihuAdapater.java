package com.example.duanwu.project3.adapater;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class VpZhihuAdapater extends FragmentPagerAdapter {
    private Context mcontext;
    private ArrayList<Fragment> mFragments;
    private ArrayList<Integer> titlesRes;

    public VpZhihuAdapater(Context context, FragmentManager fm, ArrayList<Fragment> fragments,
                           ArrayList<Integer> list) {
        super(fm);
        mcontext = context;
        mFragments = fragments;
        titlesRes = list;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Integer id = titlesRes.get(position);
        return mcontext.getResources().getString(id);
    }
}
