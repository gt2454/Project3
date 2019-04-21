package com.example.duanwu.project3.ui.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.V2exTabsBean;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class V2exFragment_detail extends Fragment {


    public V2exFragment_detail(V2exTabsBean str) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_v2ex_fragment_detail, container, false);
    }

}
