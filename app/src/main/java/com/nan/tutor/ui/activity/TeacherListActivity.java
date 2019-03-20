package com.nan.tutor.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.log.TutorLog;
import com.nan.tutor.ui.base.BaseActivity;
import com.nan.tutor.util.ImageUtils;
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

    private TeacherListAdapter teacherListAdapter;
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
        teacherListAdapter = new TeacherListAdapter(this,teacherList);
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(this);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(teacherListAdapter);
    }


}

class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherListViewHolder> {

    private TeacherListActivity teacherListActivity;
    private List<Teacher> mDatas;
    private LayoutInflater layoutInflater;

    TeacherListAdapter(TeacherListActivity teacherListActivity, List<Teacher> mDatas) {
        this.teacherListActivity = teacherListActivity;
        this.mDatas = mDatas;
        layoutInflater = LayoutInflater.from(teacherListActivity);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @Override
    public TeacherListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_teacher,viewGroup,false);
        return new TeacherListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListViewHolder holder, int position) {
        holder.name.setText(mDatas.get(position).getName());
        holder.description.setText(mDatas.get(position).getDescription());
        ImageUtils.load(teacherListActivity,mDatas.get(position).getImage(),holder.image);
    }

    class TeacherListViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        ImageView image;
        TextView name;
        TextView description;
        TeacherListViewHolder(View view) {
            super(view);
            itemView = view;
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
        }
    }
}