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
import com.bumptech.glide.request.RequestOptions;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.DailyNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RlvDailyNewsAdapater extends RecyclerView.Adapter {

    private OnItemCLickListener mListener;

    private Context mContext;
    private ArrayList<DailyNewsBean.StoriesBean> mStoriesBeans;
    private ArrayList<DailyNewsBean.TopStoriesBean> mTopStoriesBeans;
    private String mDate = "";
    private final int TYPE_BANNER = 0;
    private final int TYPE_TIME = 1;
    private final int TYPE_NEWS = 2;

    public RlvDailyNewsAdapater(Context context,
                               ArrayList<DailyNewsBean.StoriesBean> storiesBeans,
                               ArrayList<DailyNewsBean.TopStoriesBean> topStoriesBeans) {

        mContext = context;
        mStoriesBeans = storiesBeans;
        mTopStoriesBeans = topStoriesBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == TYPE_BANNER){
            View inflate = inflater.inflate(R.layout.item_banner, null);
            return new BannerVH(inflate);
        }else if (viewType == TYPE_TIME){
            View inflate = inflater.inflate(R.layout.item_time, null);
            return new TimeVH(inflate);
        }else {
            View inflate = inflater.inflate(R.layout.item_news, null);
            return new NewsVH(inflate);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mTopStoriesBeans.size()>0){
            if (position == 0){
                return TYPE_BANNER;
            }else if (position == 1){
                return TYPE_TIME;
            }else {
                return TYPE_NEWS;
            }
        }else {
            if (position == 0){
                return TYPE_TIME;
            }else {
                return TYPE_NEWS;
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_BANNER){
            BannerVH bannerVH = (BannerVH) holder;
            bannerVH.mBanner.setImages(mTopStoriesBeans)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            DailyNewsBean.TopStoriesBean bean = (DailyNewsBean.TopStoriesBean) path;
                            RequestOptions options = new RequestOptions()
                                    .placeholder(R.drawable.icon_banner_place);
                            Glide.with(context).load(bean.getImage()).apply(options).into(imageView);
                        }
                    }).start();
        }else if (viewType == TYPE_TIME){
            TimeVH timeVH = (TimeVH) holder;
            timeVH.mTvTime.setText(mDate);
        }else {
            NewsVH newsVH = (NewsVH) holder;
            int newPosition = position-1;
            if (mTopStoriesBeans.size()>0){
                newPosition-=1;
            }
            DailyNewsBean.StoriesBean storiesBean = mStoriesBeans.get(newPosition);
            newsVH.mTvTitle.setText(storiesBean.getTitle());

            List<String> images = storiesBean.getImages();
            if (images != null && images.size()>0){
                RequestOptions options = new RequestOptions()
                        .placeholder(R.mipmap.ic_launcher);
                Glide.with(mContext).load(images.get(0)).apply(options).into(newsVH.mIv);
            }

              newsVH.itemView.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             if(mListener!=null){
                                 mListener.onItemClick(v,position);

                             }
                         }
                     });


        }
    }
    public interface OnItemCLickListener{
        void onItemClick(View v,int position);
        // void onLongClick(View v,int  position);
    }

    public void setOnItemCLickListener(OnItemCLickListener listener){
        this.mListener = listener;
    }
    @Override
    public int getItemCount() {
        if (mTopStoriesBeans.size()>0){
            return mStoriesBeans.size()+2;
        }else {
            return mStoriesBeans.size()+1;
        }
    }

    public void setData(DailyNewsBean bean) {
        mDate = bean.getDate();
        List<DailyNewsBean.StoriesBean> stories = bean.getStories();
        if (stories != null && stories.size()>0){
            mStoriesBeans.clear();
            mStoriesBeans.addAll(stories);
        }

        List<DailyNewsBean.TopStoriesBean> top_stories = bean.getTop_stories();
        if (top_stories != null && top_stories.size()>0){
            mTopStoriesBeans.clear();
            mTopStoriesBeans.addAll(top_stories);
        }

        notifyDataSetChanged();
    }

    class BannerVH extends RecyclerView.ViewHolder{
        @BindView(R.id.banner)
        Banner mBanner;

        public BannerVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class TimeVH extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_time)
        TextView mTvTime;
        public TimeVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    class NewsVH extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.iv)
        ImageView mIv;
        public NewsVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
