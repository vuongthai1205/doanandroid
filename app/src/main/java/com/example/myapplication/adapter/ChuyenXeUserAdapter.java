package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.config.FunctionPublic;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.model.DAO.DanhGiaDAO;
import com.example.myapplication.view.DetailChuyenXeActivity;

import java.util.List;

public class ChuyenXeUserAdapter  extends RecyclerView.Adapter<ChuyenXeUserAdapter.ChuyenXeUserAdapterViewHolder> {

    private List<ChuyenXe> chuyenXes;
    private Context context;

    public void setData(List<ChuyenXe> list){
        this.chuyenXes = list   ;
        notifyDataSetChanged();
    }

    public ChuyenXeUserAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ChuyenXeUserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_chuyen_xe, parent,false);

        return new ChuyenXeUserAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenXeUserAdapterViewHolder holder, int position) {
        ChuyenXe chuyenXe = chuyenXes.get(position);
        DanhGiaDAO danhGiaDAO = AppDatabase.getInstance(context).getDanhGiaDAO();
        Double danhGiaTrungBinh = danhGiaDAO.tinhDiemDanhGiaTrungBinhTheoChuyenXe(chuyenXe.getIdChuyenXe());
        holder.tenChuyenXe.setText(chuyenXe.getTenChuyen());
        holder.giaChuyenXe.setText(FunctionPublic.formatMoney(chuyenXe.getGiaTien()));
        holder.danhGia.setText(String.valueOf(danhGiaTrungBinh));
        FunctionPublic.loadAvatar(chuyenXe.getHinhAnh(), holder.hinhAnh,context);

        holder.itemChuyenXe.setOnClickListener(view -> {
            DetailChuyenXeActivity detailChuyenXeActivity = new DetailChuyenXeActivity();
            showDetail(chuyenXe, detailChuyenXeActivity);
        });

    }

    private void showDetail(ChuyenXe chuyenXe , Activity activity){
        Intent i = new Intent(context, activity.getClass());

        Bundle b = new Bundle();
        b.putSerializable("chuyen_xe", chuyenXe);
        i.putExtras( b);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        if (chuyenXes != null){
            return chuyenXes.size();
        }
        return 0;
    }

    public static class ChuyenXeUserAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView hinhAnh;
         TextView tenChuyenXe;
        TextView giaChuyenXe;

         TextView danhGia;
         CardView itemChuyenXe;
        public ChuyenXeUserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            hinhAnh = itemView.findViewById(R.id.hinhAnhChuyenXe);
            tenChuyenXe = itemView.findViewById(R.id.tenChuyenXe);
            danhGia =itemView.findViewById(R.id.tvDanhgia);
            giaChuyenXe = itemView.findViewById(R.id.giaChuyenXe);
            itemChuyenXe = itemView.findViewById(R.id.itemChuyenXe);
        }
    }
}
