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

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragtitles = new ArrayList<>();
    private ViewPager viewPager;
    private LinearLayout llStudy, llProtocal,llHome, llPerson;
    private LinearLayout llPage;
    private LinearLayout llPage_;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        llPage = (LinearLayout) findViewById(R.id.Page);
        llPage_ = (LinearLayout) findViewById(R.id.Page_);
        LogUtil.Log(this,"start","");
    }

    public void hideBottom(){
        llPage_.setVisibility(View.INVISIBLE);
        llPage.setVisibility(View.INVISIBLE);
    }

    public void showBottom(){
        llPage_.setVisibility(View.VISIBLE);
        llPage.setVisibility(View.VISIBLE);
    }

    private void initView(){
        setContentView(R.layout.activity_home);

        llStudy = (LinearLayout) findViewById(R.id.study);
        llStudy.setOnClickListener(this);
        llProtocal = (LinearLayout) findViewById(R.id.protocal);
        llProtocal.setOnClickListener(this);
        llHome = (LinearLayout) findViewById(R.id.home);
        llHome.setOnClickListener(this);
        llPerson = (LinearLayout) findViewById(R.id.person);
        llPerson.setOnClickListener(this);

        //注意顺序，不能颠倒
        initFrag();
        initViewPager();
    }


    private void initViewPager(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments,fragtitles);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                changeTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
        viewPager.setOffscreenPageLimit(2);
    }

    private void initFrag(){
        StudyFragment studyFragment = new StudyFragment();
        fragments.add(studyFragment);
        fragtitles.add("study");
        ProtocolFragment protocalFragment = new ProtocolFragment();
        fragments.add(protocalFragment);
        fragtitles.add("protocal");
        HomeFragment homeFragment = new HomeFragment();
        fragments.add(homeFragment);
        fragtitles.add("home");
        PersonFragment personFragment = new PersonFragment();
        fragments.add(personFragment);
        fragtitles.add("person");
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.study:
                LogUtil.Log(HomeActivity.this,"click","study");
                changeTab(R.id.study);
            case 0:
                break;
            case R.id.protocal:
                LogUtil.Log(HomeActivity.this,"click","protocal");
                changeTab(R.id.protocal);
            case 1:
                break;
            case R.id.home:
                LogUtil.Log(HomeActivity.this,"click","home");
                changeTab(R.id.home);
            case 2:
                break;
            case R.id.person:
                LogUtil.Log(HomeActivity.this,"click","person");
                changeTab(R.id.person);
                break;
            default:
                break;
        }
    }

    private void changeTab(int id) {
        switch (id) {
            case R.id.study:
                viewPager.setCurrentItem(0);
            case 0:
                break;
            case R.id.protocal:
                viewPager.setCurrentItem(1);
            case 1:
                break;
            case R.id.home:
                viewPager.setCurrentItem(2);
            case 2:
                break;
            case R.id.person:
                viewPager.setCurrentItem(3);
            case 3:
                break;
            default:
                break;
        }
    }
}
