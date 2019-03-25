package com.nan.tutor.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nan.tutor.R;
import com.nan.tutor.bean.Institution;
import com.nan.tutor.util.ImageUtils;

import java.util.List;

/**
 * Created by nan on 2019/3/25.
 */
public class InstitutionAdapter extends RecyclerView.Adapter<InstitutionAdapter.InstitutionViewHolder> {
    private Context mContext;
    private List<Institution> mDatas;
    private LayoutInflater inflater;

    public InstitutionAdapter(Context context, List<Institution> mDatas){
        this.mContext = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class InstitutionViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private ImageView image;
        private TextView mark;
        private TextView name;
        private TextView dist;

        InstitutionViewHolder(View view) {
            super(view);
            itemView = view;
            image = view.findViewById(R.id.image);
            mark = view.findViewById(R.id.mark);
            name = view.findViewById(R.id.name);
            dist = view.findViewById(R.id.dist);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull InstitutionViewHolder holder, final int position) {
        ImageUtils.load(mContext, mDatas.get(position).getImage(),holder.image);
        holder.dist.setText(mDatas.get(position).getDist()+"KM");
        holder.name.setText(mDatas.get(position).getName());
        holder.mark.setText(mDatas.get(position).getMark()+"分");
    }

    @NonNull
    @Override
    public InstitutionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.item_institution,parent, false);
        final InstitutionViewHolder holder= new InstitutionViewHolder(view);
        return holder;
    }
}