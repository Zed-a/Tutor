package com.nan.tutor;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyFragmentPagerAdapter;
import Base.BaseActivity;
import Fragments.HomeFragment;
import Fragments.PersonFragment;
import Fragments.ProtocolFragment;
import Fragments.StudyFragment;
import Util.LogUtil;
import github.chenupt.springindicator.SpringIndicator;

public class HomeActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragtitles = new ArrayList<>();
    private ViewPager viewPager;
    private SpringIndicator springIndicator;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        LogUtil.Log(this,"start","");
    }

    private void initView(){
        setContentView(R.layout.activity_home);

        springIndicator = findViewById(R.id.indicator);
        initFrag();
        initViewPager();
    }


    private void initViewPager(){
        viewPager = findViewById(R.id.viewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments,fragtitles);
        viewPager.setAdapter(adapter);
        springIndicator.setViewPager(viewPager);
        viewPager.setOffscreenPageLimit(2);
    }

    private void initFrag(){
        StudyFragment studyFragment = new StudyFragment();
        fragments.add(studyFragment);
        fragtitles.add("学习");
        ProtocolFragment protocalFragment = new ProtocolFragment();
        fragments.add(protocalFragment);
        fragtitles.add("协议");
        HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        fragtitles.add("主页");
        PersonFragment personFragment = new PersonFragment();
        fragments.add(personFragment);
        fragtitles.add("账户");
    }

}
