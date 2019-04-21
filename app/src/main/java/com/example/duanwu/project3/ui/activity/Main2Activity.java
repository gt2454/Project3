package com.example.duanwu.project3.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.example.duanwu.project3.R;
import com.example.duanwu.project3.base.BaseActivity;
import com.example.duanwu.project3.base.BaseFragment;
import com.example.duanwu.project3.presenter.MainP;
import com.example.duanwu.project3.ui.fragment.AboutFragment;
import com.example.duanwu.project3.ui.fragment.CollectFragment;
import com.example.duanwu.project3.ui.fragment.GankFragment;
import com.example.duanwu.project3.ui.fragment.GoldFragment;
import com.example.duanwu.project3.ui.fragment.SettingsFragment;
import com.example.duanwu.project3.ui.fragment.V2exFragment;
import com.example.duanwu.project3.ui.fragment.WechatFragment;
import com.example.duanwu.project3.ui.fragment.ZhihuDailyNewsFragment;
import com.example.duanwu.project3.view.MainV;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import butterknife.BindView;

public class Main2Activity extends BaseActivity<MainV, MainP> implements MainV {


    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.search_view)
    MaterialSearchView materialSearchView;
    private final int TYPE_ZHI = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX = 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTINGS = 6;
    private final int TYPE_ABOUT = 7;
    private int mLastFragmentType = 0;

    private ArrayList<BaseFragment> fragments;
    private FragmentManager mManager;
    private MenuItem item;

    @Override
    protected MainP initPresenter() {
        return new MainP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        mManager = getSupportFragmentManager();
        //toolBar
        mToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToolBar);

        //旋转开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToolBar, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDl.addDrawerListener(toggle);
        toggle.syncState();

        initFragment();
        addZhihuFragment();

    }

    private void addZhihuFragment() {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.fragment_container, fragments.get(0));
        transaction.commit();
    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new ZhihuDailyNewsFragment());
        fragments.add(new WechatFragment());
        fragments.add(new GankFragment());
        fragments.add(new GoldFragment());
        fragments.add(new V2exFragment());
        fragments.add(new CollectFragment());
        fragments.add(new SettingsFragment());
        fragments.add(new AboutFragment());

    }

    @Override
    protected void initListener() {
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                item.setChecked(true);
                mDl.closeDrawer(Gravity.LEFT);
                switch (itemId) {
                    case R.id.zhihu:

                        switchFragment(TYPE_ZHI);
                        break;
                    case R.id.wechat:
                        switchFragment(TYPE_WECHAT);
                        break;
                    case R.id.gank:

                        switchFragment(TYPE_GANK);
                        break;
                    case R.id.gold:
                        switchFragment(TYPE_GOLD);
                        break;
                    case R.id.v2ex:
                        switchFragment(TYPE_V2EX);
                        break;
                    case R.id.collect:
                        switchFragment(TYPE_COLLECT);
                        break;
                    case R.id.settings:
                        switchFragment(TYPE_SETTINGS);
                        break;
                    case R.id.about:
                        switchFragment(TYPE_ABOUT);
                        break;


                }

                return false;
            }
        });
        // MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                Toast.makeText(Main2Activity.this, "提交的内容" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                Toast.makeText(Main2Activity.this, "" + newText, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });
         //搜索栏提示内容
      //  materialSearchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
    }

    private void switchFragment(int type) {
    /*    BaseFragment fragment = fragments.get(type);
        FragmentTransaction transaction = mManager.beginTransaction();

        if (!fragment.isAdded()) {
            transaction.add(R.id.fragment_container, fragment);

        }
        transaction.show(fragment);
        BaseFragment baseFragment = fragments.get(mLastFragmentType);
        transaction.hide(baseFragment);
        transaction.commit();
        mLastFragmentType = type;*/
        BaseFragment fragment = fragments.get(type);
        FragmentTransaction transaction = mManager.beginTransaction();
        if (!fragment.isAdded()) {
            //没有添加过,添加
            transaction.add(R.id.fragment_container, fragment);
        }

        //隐藏上一个fragment
        BaseFragment baseFragment = fragments.get(mLastFragmentType);
        transaction.hide(baseFragment);
        transaction.show(fragment);
        transaction.commit();

        mLastFragmentType = type;

        //显示或者隐藏MaterialSearchView
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            item.setVisible(true);
        }else {
            item.setVisible(false);
        }

    }
    //管涛  1808

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        item = menu.findItem(R.id.action_search);
        materialSearchView.setMenuItem(item);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (materialSearchView.isSearchOpen()) {
            materialSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }


}
