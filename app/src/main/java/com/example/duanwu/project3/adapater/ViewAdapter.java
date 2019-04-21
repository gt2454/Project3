package com.example.duanwu.project3.adapater;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewAdapter extends FragmentStatePagerAdapter {
    private ArrayList<String> tab;
    private ArrayList<Fragment> fragments;

    public ViewAdapter(FragmentManager fm, ArrayList<String> tab, ArrayList<Fragment> fragments) {
        super(fm);
        this.tab = tab;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tab.get(position);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {

    }
}
