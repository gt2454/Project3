package com.example.duanwu.project3.adapater;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.HotBean;
import com.example.duanwu.project3.ui.fragment.DataNews_details.Hot_details;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter {
    Context context;
    List<HotBean.RecentBean> list;
    private OnItemCLickListener mListener;
    private int news_id;

    public HotAdapter(Context context, List<HotBean.RecentBean> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hot, null, false);
        MyHolder myHolder = new MyHolder(inflate);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final HotBean.RecentBean hot=list.get(i);
        MyHolder myHolders = (MyHolder) viewHolder;
        myHolders.text1.setText(list.get(i).getTitle());
        myHolders.text2.setText(list.get(i).getUrl());
        Glide.with(context).load(list.get(i).getThumbnail()).into(myHolders.image);

        myHolders.itemView.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Hot_details.class);
                intent.putExtra("id",hot.getNews_id());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setData(List<HotBean.RecentBean> data) {
        if (data.size() > 0) {
            this.list = data;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {


        private final ImageView image;
        private final TextView text1;
        private final TextView text2;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.hot_image);
            text1 = itemView.findViewById(R.id.hot_text1);
            text2 = itemView.findViewById(R.id.hot_text2);

        }
    }

    public interface OnItemCLickListener {
        void onItemClick(View v, int position);
        // void onLongClick(View v,int  position);
    }

    public void setOnItemCLickListener(OnItemCLickListener listener) {
        this.mListener = listener;
    }
}
