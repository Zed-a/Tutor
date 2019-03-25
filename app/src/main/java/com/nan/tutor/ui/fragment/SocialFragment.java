package com.nan.tutor.ui.fragment;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.adapter.SocialActivityAdapter;
import com.nan.tutor.ui.base.BaseFragment;
import com.nan.tutor.util.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author nan
 * @date 2019/3/19
 */
public class SocialFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_social;
    }

    @Override
    protected void initView(View view) {
        List<Teacher> teacherList = new ArrayList<>();
        Uri uri;
        uri = ImageUtils.resourceIdToUri(context, R.drawable.social_top_left);
        Teacher teacher = new Teacher(uri.toString(),"456","123");
        teacherList.add(teacher);
        uri = ImageUtils.resourceIdToUri(context,R.drawable.social_top_middle);
        teacher = new Teacher(uri.toString(),"123","123");
        teacherList.add(teacher);
        uri = ImageUtils.resourceIdToUri(context,R.drawable.social_top_right);
        teacher = new Teacher(uri.toString(),"123","123");
        teacherList.add(teacher);
        SocialActivityAdapter niceTeacherAdapter = new SocialActivityAdapter(getActivity(),teacherList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(niceTeacherAdapter);
    }
}
