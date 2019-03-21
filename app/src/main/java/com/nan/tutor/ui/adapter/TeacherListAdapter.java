package com.nan.tutor.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Teacher;
import com.nan.tutor.ui.activity.TeacherListActivity;
import com.nan.tutor.util.ImageUtils;

import java.util.List;

/**
 * Created by nan on 2019/3/21.
 */
public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherListViewHolder> {
    private Context mContext;
    private List<Teacher> mDatas;
    private LayoutInflater inflater;

    public TeacherListAdapter(Context context, List<Teacher> mDatas){
        this.mContext = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class TeacherListViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private ImageView image;
        private TextView name;
        private TextView des;

        TeacherListViewHolder(View view) {
            super(view);
            itemView = view;
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
            des = view.findViewById(R.id.description);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListViewHolder holder, final int position) {
        holder.name.setText(mDatas.get(position).getName());
        holder.des.setText(mDatas.get(position).getDescription());
        ImageUtils.load(mContext,mDatas.get(position).getImage(),holder.image);
    }

    @NonNull
    @Override
    public TeacherListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.item_teacher,parent, false);
        final TeacherListViewHolder holder= new TeacherListViewHolder(view);
        return holder;
    }
}