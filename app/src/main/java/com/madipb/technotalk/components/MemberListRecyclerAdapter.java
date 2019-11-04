package com.madipb.technotalk.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.madipb.technotalk.data.AnggotaEntity;
import com.madipb.technotalk.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MemberListRecyclerAdapter extends RecyclerView.Adapter<MemberListRecyclerAdapter.MemberListViewHolder>{

    private List<AnggotaEntity> anggotaEntityList;
    private Context context;

    public MemberListRecyclerAdapter(List<AnggotaEntity> anggotaEntities, Context context) {
        this.anggotaEntityList = anggotaEntities;
        this.context = context;
    }

    @NonNull
    @Override
    public MemberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_recyclerview_member, parent, false);
        MemberListRecyclerAdapter.MemberListViewHolder viewHolder = new MemberListRecyclerAdapter.MemberListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MemberListViewHolder holder, int position) {
        final AnggotaEntity model = anggotaEntityList.get(position);
        holder.namaTV.setText(model.getNama());
        holder.komunitasTV.setText(model.getKomunitas());
        holder.angkatanTV.setText(String.valueOf(model.getAngkatan()));
    }

    @Override
    public int getItemCount() {
        return anggotaEntityList.size();
    }

    public class MemberListViewHolder extends RecyclerView.ViewHolder{
        private TextView namaTV, komunitasTV, angkatanTV;
        private View layout;
        public MemberListViewHolder(@NonNull View itemView) {
            super(itemView);
            namaTV = itemView.findViewById(R.id.nameTV);
            komunitasTV = itemView.findViewById(R.id.komunitasTV);
            angkatanTV = itemView.findViewById(R.id.angkatanTV);
            layout = itemView;
        }
    }
}