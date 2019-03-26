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

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by nan on 2019/3/26.
 */
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context mContext;
    private List<Teacher> mDatas;
    private LayoutInflater inflater;

    public GridAdapter(Context context, List<Teacher> mDatas){
        this.mContext = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        private ImageView image;
        private TextView name;

        GridViewHolder(View view) {
            super(view);
            itemView = view;
            image = view.findViewById(R.id.image);
            name = view.findViewById(R.id.name);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        ImageUtils.load(mContext,mDatas.get(position).getImage(),holder.image);
        holder.name.setText(mDatas.get(position).getName());
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.item_grid,parent, false);
        final GridViewHolder holder = new GridViewHolder(view);
        return holder;
    }
}