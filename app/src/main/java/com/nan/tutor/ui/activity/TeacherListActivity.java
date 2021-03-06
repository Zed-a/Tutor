package com.nan.tutor.ui.activity;

import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.adapter.TeacherListAdapter;
import com.nan.tutor.ui.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.nan.tutor.util.ImageUtils.resourceIdToUri;

public class TeacherListActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teacher_list;
    }

    private List<Teacher> teacherList;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initView() {
        setupToolbar(toolbar,true,"附近老师");
        super.initView();
        teacherList = new ArrayList<>();
        Teacher teacher;
        teacher = new Teacher(R.drawable.teacher_li,"李莉老师","初一语文，五年");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.teacher_shen,"沈倩老师","初二化学，三年");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.teacher_tina,"Tina老师","高三英语，三年");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.teacher_zhang,"张亮老师","高一物理，六年");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.teacher_wu,"吴明老师","初二地理，两年");
        teacherList.add(teacher);
        teacher = new Teacher(R.drawable.teacher_zhao,"赵宏老师","高二生物，七年");
        teacherList.add(teacher);
        TeacherListAdapter teacherListAdapter=new TeacherListAdapter(this,teacherList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(teacherListAdapter);
    }

}