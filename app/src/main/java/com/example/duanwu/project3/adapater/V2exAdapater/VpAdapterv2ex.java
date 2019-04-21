package com.example.duanwu.project3.adapater.V2exAdapater;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by xts on 2018/11/9.
 */

public class VpAdapterv2ex extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;

    public VpAdapterv2ex(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
