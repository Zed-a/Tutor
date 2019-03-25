package com.nan.tutor.ui.fragment;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.nan.tutor.R;
import com.nan.tutor.image.GlideApp;
import com.nan.tutor.ui.base.BaseFragment;
import com.nan.tutor.util.ImageUtils;

import butterknife.BindView;

public class PersonFragment extends BaseFragment {

    @BindView(R.id.comment_pic)
    ImageView comment;

    @BindView(R.id.order_pic)
    ImageView order;

    @BindView(R.id.mark_pic)
    ImageView mark;

    @BindView(R.id.account_pic)
    ImageView account;

    @BindView(R.id.setting_pic)
    ImageView setting;

    @BindView(R.id.service_pic)
    ImageView service;

    @BindView(R.id.collect_left)
    ImageView collectLeft;

    @BindView(R.id.collect_right)
    ImageView collectRight;

    @BindView(R.id.avatar)
    ImageView avatar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void initView(View view) {
        ImageUtils.load(context,R.drawable.person_comment,comment);
        ImageUtils.load(context,R.drawable.person_mark,mark);
        ImageUtils.load(context,R.drawable.person_order,order);
        ImageUtils.load(context,R.drawable.person_service,service);
        ImageUtils.load(context,R.drawable.person_accout,account);
        ImageUtils.load(context,R.drawable.person_setting,setting);
        ImageUtils.load(context,R.drawable.person_collect_left,collectLeft);
        ImageUtils.load(context,R.drawable.person_collect_right,collectRight);
        ImageUtils.load(context,R.drawable.avatar,avatar);
    }
}
