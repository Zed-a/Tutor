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
import com.nan.tutor.util.ImageUtils;

import java.util.List;

/**
 * Created by nan on 2019/3/21.
 */
public class NiceTeacherAdapter extends RecyclerView.Adapter<NiceTeacherAdapter.NiceTeacherViewHolder> {
    private Context mContext;
    private List<Teacher> mDatas;
    private LayoutInflater inflater;

    public NiceTeacherAdapter(Context context, List<Teacher> mDatas){
        this.mContext = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class NiceTeacherViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private ImageView image;
        private TextView name;
        private TextView des;

        NiceTeacherViewHolder(View view) {
            super(view);
            itemView = view;
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
            des = view.findViewById(R.id.des);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NiceTeacherViewHolder holder, final int position) {
        holder.name.setText(mDatas.get(position).getName());
        holder.des.setText(mDatas.get(position).getDescription());
        ImageUtils.load(mContext,mDatas.get(position).getImage(),holder.image);
    }

    @NonNull
    @Override
    public NiceTeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.item_nice_teacher,parent, false);
        final NiceTeacherViewHolder holder= new NiceTeacherViewHolder(view);
        return holder;
    }
}