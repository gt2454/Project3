package com.example.duanwu.project3.adapater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.GankBean.FuLiBean;
import com.example.duanwu.project3.bean.HotBean;

import java.util.List;

public class BackendAdapter extends RecyclerView.Adapter {
    Context context;
    List<FuLiBean.ResultsBean> list;

    public BackendAdapter(Context context, List<FuLiBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_backend, null, false);
        MyHolder myHolder = new MyHolder(inflate);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder myHolders = (MyHolder) viewHolder;
        Glide.with(context).load(list.get(i).getUrl()).into(myHolders.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<FuLiBean.ResultsBean> data) {
        if (data.size() > 0) {
            this.list = data;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.fuli_image);
        }
    }
}
