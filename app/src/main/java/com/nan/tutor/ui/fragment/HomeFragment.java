package com.nan.tutor.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.activity.InstitutionListActivity;
import com.nan.tutor.ui.activity.TeacherListActivity;
import com.nan.tutor.ui.adapter.NiceTeacherAdapter;
import com.nan.tutor.ui.adapter.TeacherListAdapter;
import com.nan.tutor.ui.base.BaseFragment;
import com.nan.tutor.util.ImageUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;

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



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
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
        images.add("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg");
        images.add("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg");
        images.add("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg");
        images.add("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg");
        banner.setImages(images);
        banner.start();

        List<Teacher> teacherList = new ArrayList<>();

        Teacher teacher = new Teacher("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg","123","123");
        for (int i = 0; i < 10; i++) {
            teacherList.add(teacher);
        }
        NiceTeacherAdapter niceTeacherAdapter = new NiceTeacherAdapter(getActivity(),teacherList);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(getActivity());
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(niceTeacherAdapter);
    }
}
