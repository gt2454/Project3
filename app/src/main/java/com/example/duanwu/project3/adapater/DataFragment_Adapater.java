package com.example.duanwu.project3.adapater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.Fragment_lie;


import java.util.List;

public class DataFragment_Adapater extends RecyclerView.Adapter<DataFragment_Adapater.ViewHolder> {
    List<Fragment_lie.ShowapiResBodyBean.PagebeanBean.ContentlistBean> list;
    Context context;

    public DataFragment_Adapater(List<Fragment_lie.ShowapiResBodyBean.PagebeanBean.ContentlistBean>  list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechat_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        //加载一张圆形图片
                RequestOptions options = RequestOptions.circleCropTransform()
                         .placeholder(R.mipmap.ic_launcher)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .skipMemoryCache(true);
                Glide.with(context).load(list.get(i).getContentImg()).apply(options).into(viewHolder.iv);
        viewHolder.tv.setText(list.get(i).getTitle());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setDate(List<Fragment_lie.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentlist) {
        if(contentlist.size()>0){
            this.list=contentlist;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);

        }
    }
    private OnClickListener OnClickListener;

    public void setOnClickListener(DataFragment_Adapater.OnClickListener onClickListener) {
        OnClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int pos);
    }
}
