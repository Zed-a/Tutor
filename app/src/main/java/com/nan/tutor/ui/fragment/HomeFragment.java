package com.nan.tutor.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.nan.tutor.R;
import com.nan.tutor.ui.activity.InstitutionListActivity;
import com.nan.tutor.ui.activity.TeacherListActivity;
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
    }
}
