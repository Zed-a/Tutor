package com.nan.tutor.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.nan.tutor.R;
import com.nan.tutor.ui.base.BaseFragment;
import com.nan.tutor.util.ImageUtils;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

public class StudyFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_study;
    }

    @BindView(R.id.image1)
    ImageView image1;

    @BindView(R.id.image2)
    ImageView image2;

    @Override
    protected void initView(View view) {
        ImageUtils.load(context,R.drawable.icon_english,image1);
        ImageUtils.load(context,R.drawable.icon_math,image2);
        Logger.d("123");
    }
}
