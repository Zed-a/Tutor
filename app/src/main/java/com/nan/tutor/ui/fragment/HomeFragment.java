package com.nan.tutor.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.activity.InstitutionListActivity;
import com.nan.tutor.ui.activity.TeacherListActivity;
import com.nan.tutor.ui.adapter.NiceTeacherAdapter;
import com.nan.tutor.ui.base.BaseFragment;
import com.nan.tutor.util.ImageUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @BindView(R.id.banner)
    Banner banner;

    @BindView(R.id.city)
    TextView city;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @OnClick(R.id.teacher)
    void clickTeacher() {
        Intent intent = new Intent(getActivity(), TeacherListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.institution)
    void clickInstitution() {
        Intent intent = new Intent(getActivity(), InstitutionListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.city)
    void onClickCity() {
        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100"));
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.from(this) //activity或者fragment
//                .enableAnimation(true)	//启用动画效果，默认无
//                .setAnimationStyle(anim)	//自定义动画
                .setLocatedCity(new LocatedCity("上海", "上海", "101020100"))
                .setHotCities(hotCities)	//指定热门城市
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {
                        city.setText(data.getName());
                    }

                    @Override
                    public void onCancel(){}

                    @Override
                    public void onLocate() {}
                })
                .show();
    }

    @Override
    protected void initView(View view) {
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                ImageUtils.load(context, path.toString(), imageView);
            }
        });
        //设置图片集合
        List<String> images = new ArrayList<>();
        Uri uri;
        uri = ImageUtils.resourceIdToUri(context,R.drawable.home_top);
        images.add(uri.toString());
        uri = ImageUtils.resourceIdToUri(context,R.drawable.home_top2);
        images.add(uri.toString());
        uri = ImageUtils.resourceIdToUri(context,R.drawable.home_top3);
        images.add(uri.toString());
        banner.setImages(images);
        banner.start();

        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher;

        teacher = new Teacher(R.drawable.home_zhang,"123","123");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.home_zhao,"123","123");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.home_tina,"123","123");
        teacherList.add(teacher);

        NiceTeacherAdapter niceTeacherAdapter = new NiceTeacherAdapter(getActivity(),teacherList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(niceTeacherAdapter);
    }
}
