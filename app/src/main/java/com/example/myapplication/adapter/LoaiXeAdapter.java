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
import com.example.myapplication.model.LoaiXe;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.view.DetailThanhVienFragment;

import java.util.List;

public class LoaiXeAdapter extends RecyclerView.Adapter<LoaiXeAdapter.LoaiXeHolder> {

    private List<LoaiXe> loaixes;
    private Context context;

    public void setData(List<LoaiXe> list){
        this.loaixes = list;
        notifyDataSetChanged();
    }

    public LoaiXeAdapter(Context context) {
        this.context = context;
    }

    public void release(){
        this.context= null;
    }

    @NonNull
    @Override
    public LoaiXeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_loaixe, parent,false);
        return new LoaiXeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiXeHolder holder, int position) {
        LoaiXe loaiXe = loaixes.get(position);

        holder.maSoLoaiXe.setText(String.valueOf(loaiXe.getIdLoaiXe()));
        holder.tenLoaiXe.setText(loaiXe.getTenLoaiXe());




    }

    private void showDetail(ThanhVien thanhVien) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("thanhVien", thanhVien);

        DetailThanhVienFragment detailThanhVienFragment = new DetailThanhVienFragment();
        detailThanhVienFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerThanhVienManager, detailThanhVienFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public int getItemCount() {
        if (loaixes != null){
            return  loaixes.size();
        }
        return 0;
    }

    public static class LoaiXeHolder extends RecyclerView.ViewHolder{
        TextView tenLoaiXe;
        TextView maSoLoaiXe;

        public LoaiXeHolder(@NonNull View itemView) {
            super(itemView);
            tenLoaiXe = itemView.findViewById(R.id.tenLoaiXe);
            maSoLoaiXe = itemView.findViewById(R.id.idLoaiXe);

        }
    }
}
