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
import com.example.duanwu.project3.bean.SectionsBean;

import java.util.ArrayList;
import java.util.List;

public class SectionsAdapater extends RecyclerView.Adapter {
    Context context;
    List<SectionsBean.DataBean> list = new ArrayList<>();
    private List<SectionsBean.DataBean> data;

    public SectionsAdapater(Context context, List<SectionsBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_sections, null, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder myHolders= (MyHolder) viewHolder;
        myHolders.text1.setText(list.get(i).getDescription());
        myHolders.text2.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getThumbnail()).into(myHolders.imageView1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<SectionsBean.DataBean> data) {
        if(data.size()>0){

            this.list=data;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {


        private final TextView text2;
        private final ImageView imageView1;
        private final TextView text1;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            text2 = itemView.findViewById(R.id.popu_name);
            imageView1 = itemView.findViewById(R.id.popu_img);
            text1 = itemView.findViewById(R.id.popu_txt);
        }
    }
}
