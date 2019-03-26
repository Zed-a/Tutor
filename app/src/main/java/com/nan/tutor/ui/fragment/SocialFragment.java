package com.nan.tutor.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.adapter.GridAdapter;
import com.nan.tutor.ui.adapter.SocialActivityAdapter;
import com.nan.tutor.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author nan
 * @date 2019/3/19
 */
public class SocialFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_social;
    }

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.grid_view)
    RecyclerView gridView;

    @Override
    protected void initView(View view) {
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher(R.drawable.social_top_left,"网球主题素拓活动",
                "等热爱网球的你加入");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.social_top_middle,"集体嗨哦",
                "一起加油，一起play");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.social_top_right,"国际志","奉献爱");
        teacherList.add(teacher);
        SocialActivityAdapter niceTeacherAdapter = new SocialActivityAdapter(getActivity(),teacherList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(niceTeacherAdapter);

        List<Teacher> gridList = new ArrayList<>();
        teacher = new Teacher(R.drawable.social_avatar_1,"二狗");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_2,"点点");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_3,"小福贵");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_4,"小蔓");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_5,"王子瑞");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_6,"小龙");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_7,"轩轩");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_8,"满满 ");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_9,"晶晶");
        gridList.add(teacher);
        teacher = new Teacher(R.drawable.social_avatar_10,"赫赫");
        gridList.add(teacher);
        GridAdapter gridAdapter = new GridAdapter(context, gridList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,5);
        gridView.setAdapter(gridAdapter);
        gridView.setLayoutManager(gridLayoutManager);
    }
}
