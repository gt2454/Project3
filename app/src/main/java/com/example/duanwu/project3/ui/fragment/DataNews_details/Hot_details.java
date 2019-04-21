package com.example.duanwu.project3.ui.fragment.DataNews_details;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.duanwu.project3.R;
import com.example.duanwu.project3.bean.DailyNews_detailsBean;
import com.example.duanwu.project3.bean.Hot_detailsBean;
import com.example.duanwu.project3.net.ZhihuService;

import java.net.URL;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Hot_details extends AppCompatActivity {
    private ImageView imageView;
    private TextView tv;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_details);
        imageView = findViewById(R.id.image_hot);
        tv = findViewById(R.id.tv_hot);
        Intent  intent=getIntent();
        id = intent.getIntExtra("id", 0);
        init();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private void init() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ZhihuService.mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ZhihuService myServler = retrofit.create(ZhihuService.class);
        Observable<Hot_detailsBean> image = myServler.getHotInfo(id);
        image.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Hot_detailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Hot_detailsBean bean) {
                        String image1 = bean.getImage();
                        Glide.with(Hot_details.this).load(image1).into(imageView);
                        final String html =bean.getBody();//需要将转的数据转为String).getBody();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                final Spanned html_str =  Html.fromHtml(html,new Html.ImageGetter() {
                                    @Override
                                    public Drawable getDrawable(String source) {
                                        Drawable d = null;
                                        URL url = null;
                                        try {
                                            url = new URL(source);
                                            //获取html中的图片数据
                                            d = Drawable.createFromStream(url.openStream(),"");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
                                        return d;
                                    }
                                },null);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        tv.setText(html_str);
                                    }
                                });
                            }
                        }).start();


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("=====",e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
