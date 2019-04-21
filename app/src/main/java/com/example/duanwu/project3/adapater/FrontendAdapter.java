package com.example.duanwu.project3.adapater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.GankBean.FrontendBean;
import com.example.duanwu.project3.bean.GankBean.IOSBean;

import java.util.List;

public class FrontendAdapter extends RecyclerView.Adapter {
    Context  context;
    List<FrontendBean.ResultsBean> list;

    public FrontendAdapter(Context context, List<FrontendBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_frontend, null, false);
        MyHolder  myHolder=new MyHolder(inflate);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder  myHolders= (MyHolder) viewHolder;
        myHolders.text1.setText(list.get(i).getDesc());
        myHolders.text2.setText(list.get(i).getWho());
        myHolders.text3.setText(list.get(i).getPublishedAt());
       // Glide.with(context).load(list.get(i).getThumbnail()).into(myHolders.image);
        myHolders.image.setImageResource(R.mipmap.ic_android);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<FrontendBean.ResultsBean> data) {
        if(data.size()>0){
            this.list=data;
        }
    }
    class MyHolder  extends  RecyclerView.ViewHolder{


       private final ImageView image;
        private final TextView text1;
        private final TextView text2;
        private final TextView text3;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
           // image = itemView.findViewById(R.id.hot_image);
            image = itemView.findViewById(R.id.frontend_image);
            text1 = itemView.findViewById(R.id.frontend_title1);
            text2 = itemView.findViewById(R.id.frontend_title2);
            text3= itemView.findViewById(R.id.frontend_title3);


        }
    }
}
