package com.nan.tutor.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.nan.tutor.R;

import java.util.ArrayList;
import java.util.List;

import com.nan.tutor.ui.adapter.TutorFragmentPagerAdapter;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.ui.fragment.HomeFragment;
import com.nan.tutor.ui.fragment.PersonFragment;
import com.nan.tutor.ui.fragment.ProtocolFragment;
import com.nan.tutor.ui.fragment.StudyFragment;
import com.nan.tutor.util.LogUtil;
import butterknife.BindView;
import github.chenupt.springindicator.SpringIndicator;

public class HomeActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragtitles = new ArrayList<>();

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    SpringIndicator springIndicator;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.Log(this,"start","");
    }

    @Override
    protected void initView() {
        super.initView();
        initFrag();
        initViewPager();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    private void initViewPager(){
        TutorFragmentPagerAdapter adapter = new TutorFragmentPagerAdapter(getSupportFragmentManager(),fragments,fragtitles);
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
