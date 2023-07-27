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
import com.example.myapplication.view.DetailFilterChuyenXeActivity;

import java.util.ArrayList;
import java.util.List;

public class ChuyenXeFilterAdapter extends RecyclerView.Adapter<ChuyenXeFilterAdapter.ChuyenXeFilterAdapterViewHolder>{
    private List<ChuyenXe> chuyenXes;
    private Context context;

    public void setData(List<ChuyenXe> list){
        this.chuyenXes = list   ;
        notifyDataSetChanged();
    }

    public ChuyenXeFilterAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ChuyenXeFilterAdapter.ChuyenXeFilterAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filter_chuyen_xe, parent,false);

        return new ChuyenXeFilterAdapter.ChuyenXeFilterAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenXeFilterAdapter.ChuyenXeFilterAdapterViewHolder holder, int position) {
        ChuyenXe chuyenXe = chuyenXes.get(position);
        DanhGiaDAO danhGiaDAO = AppDatabase.getInstance(context).getDanhGiaDAO();
        Double danhGiaTrungBinh = danhGiaDAO.tinhDiemDanhGiaTrungBinhTheoChuyenXe(chuyenXe.getIdChuyenXe());
        holder.tenChuyenXe.setText(chuyenXe.getTenChuyen());
        holder.giaChuyenXe.setText(FunctionPublic.formatMoney(chuyenXe.getGiaTien()));
        holder.danhGia.setText(String.valueOf(danhGiaTrungBinh));
        FunctionPublic.loadAvatar(chuyenXe.getHinhAnh(), holder.hinhAnh,context);

        holder.itemChuyenXe.setOnClickListener(view -> {
            DetailFilterChuyenXeActivity detailFilterChuyenXeActivity = new DetailFilterChuyenXeActivity();
            showDetail(chuyenXe, detailFilterChuyenXeActivity);
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
    public void filterChuyenXe(String diaDiemDi, String diaDiemDen, int idLoaiXe, String ngayDi, String gioDi) {
        List<ChuyenXe> filteredList = new ArrayList<>();

        for (ChuyenXe chuyenXe : chuyenXes) {
            // Kiểm tra các điều kiện để tìm chuyến xe phù hợp
            if (chuyenXe.getDiaDiemDi().equals(diaDiemDi)
                    && chuyenXe.getDiaDiemDen().equals(diaDiemDen)
                    && chuyenXe.getIdLoaiXe()==(idLoaiXe)
                    && chuyenXe.getNgayDi().equals(ngayDi)
                    && chuyenXe.getThoiGianBatDau().equals(gioDi)) {
                filteredList.add(chuyenXe);
            }
        }

        // Cập nhật danh sách chuyến xe mới
        chuyenXes = filteredList;
        notifyDataSetChanged();
    }

    public static class ChuyenXeFilterAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView hinhAnh;
        TextView tenChuyenXe;
        TextView giaChuyenXe;
        TextView danhGia;
        CardView itemChuyenXe;
        public ChuyenXeFilterAdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            hinhAnh = itemView.findViewById(R.id.hinhAnhChuyenXe);
            tenChuyenXe = itemView.findViewById(R.id.tenChuyenXe);
            danhGia =itemView.findViewById(R.id.tvDanhgia);
            giaChuyenXe = itemView.findViewById(R.id.giaChuyenXe);
            itemChuyenXe = itemView.findViewById(R.id.itemFilterChuyenXe);
        }
    }
}
