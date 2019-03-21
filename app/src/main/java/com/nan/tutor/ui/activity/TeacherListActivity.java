package com.nan.tutor.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.log.TutorLog;
import com.nan.tutor.ui.adapter.TeacherListAdapter;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TeacherListActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teacher_list;
    }

    private List<Teacher> teacherList;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @OnClick(R.id.chinese)
    void clickChinese() {
        ToastUtil.show(this,"chinese");
    }

    @OnClick(R.id.math)
    void clickMath() {
        ToastUtil.show(this,"math");
    }

    @OnClick(R.id.english)
    void clickEnglish() {
        ToastUtil.show(this,"english");
    }

    @OnClick(R.id.physics)
    void clickPhysics() {
        ToastUtil.show(this,"physics");
    }


    @Override
    protected void initView() {
        super.initView();
        teacherList = new ArrayList<>();
        Teacher teacher = new Teacher("http://pic1.win4000.com/wallpaper/6/53a2444c0a635.jpg","123","123");
        for (int i = 0; i < 10; i++) {
            teacherList.add(teacher);
        }
        TeacherListAdapter teacherListAdapter=new TeacherListAdapter(this,teacherList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(teacherListAdapter);
    }
}