package com.example.myapplication.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.view.DetailChuyenXeFragment;


import java.util.List;

public class ChuyenXeAdapter extends RecyclerView.Adapter<ChuyenXeAdapter.ChuyenXeHolder> {

    private List<ChuyenXe> chuyenXes;
    private Context context;

    public void setData(List<ChuyenXe> list){
        this.chuyenXes = list;
        notifyDataSetChanged();
    }

    public ChuyenXeAdapter(Context context) {
        this.context = context;
    }

    public void release(){
        this.context= null;
    }

    @NonNull
    @Override
    public ChuyenXeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_chuyen_xe, parent,false);
        return new ChuyenXeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ChuyenXeHolder holder, int position) {
        ChuyenXe chuyenXe = chuyenXes.get(position);

        holder.tenChuyenXe.setText(chuyenXe.getTenChuyen());
        holder.thoiGianBatDau.setText(chuyenXe.getThoiGianBatDau());
        holder.diaDiemDi.setText(String.valueOf(chuyenXe.getDiaDiemDi()));

        holder.itemChuyenXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetail(chuyenXe);
            }
        });

    }

    private void showDetail(ChuyenXe chuyenXe) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("chuyenXe", chuyenXe);

        DetailChuyenXeFragment detailChuyenXeFragment = new DetailChuyenXeFragment();
        detailChuyenXeFragment.setArguments(bundle);


        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerChuyenXeManager, detailChuyenXeFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public int getItemCount() {
        if (chuyenXes != null){
            return  chuyenXes.size();
        }
        return 0;
    }

    public static class ChuyenXeHolder extends RecyclerView.ViewHolder{
        TextView tenChuyenXe;
        TextView thoiGianBatDau;
        TextView diaDiemDi;
        CardView itemChuyenXe;
        public ChuyenXeHolder(@NonNull View itemView) {
            super(itemView);
            tenChuyenXe = itemView.findViewById(R.id.tenChuyenXe);
            thoiGianBatDau = itemView.findViewById(R.id.thoiGianBatDau);
            diaDiemDi = itemView.findViewById(R.id.diaDiemDi);
            itemChuyenXe = itemView.findViewById(R.id.itemChuyenXe);
        }
    }
}
