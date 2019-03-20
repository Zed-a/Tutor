package com.nan.tutor.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.nan.tutor.R;
import com.nan.tutor.ui.adapter.TutorFragmentPagerAdapter;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.ui.fragment.HomeFragment;
import com.nan.tutor.ui.fragment.PersonFragment;
import com.nan.tutor.ui.fragment.ClassFragment;
import com.nan.tutor.ui.fragment.SocialFragment;
import com.nan.tutor.ui.fragment.StudyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import github.chenupt.springindicator.SpringIndicator;

public class HomeActivity extends BaseActivity {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragtitles = new ArrayList<>();

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.indicator)
    SpringIndicator springIndicator;

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
        HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        fragtitles.add("主页");
        StudyFragment studyFragment = new StudyFragment();
        fragments.add(studyFragment);
        fragtitles.add("学习");
        ClassFragment protocalFragment = new ClassFragment();
        fragments.add(protocalFragment);
        fragtitles.add("课程");
        fragments.add(new SocialFragment());
        fragtitles.add("社区");
        PersonFragment personFragment = new PersonFragment();
        fragments.add(personFragment);
        fragtitles.add("我的");
    }

}
