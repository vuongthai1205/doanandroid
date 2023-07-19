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
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.view.DetailThanhVienFragment;

import java.util.List;

public class ThanhVienAdapter extends RecyclerView.Adapter<ThanhVienAdapter.ThanhVienHolder> {

    private List<ThanhVien> thanhViens;
    private Context context;

    public void setData(List<ThanhVien> list){
        this.thanhViens = list;
        notifyDataSetChanged();
    }

    public ThanhVienAdapter(Context context) {
        this.context = context;
    }

    public void release(){
        this.context= null;
    }

    @NonNull
    @Override
    public ThanhVienHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_thanh_vien, parent,false);
        return new ThanhVienHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ThanhVienHolder holder, int position) {
        ThanhVien thanhVien = thanhViens.get(position);

        holder.id.setText(String.valueOf(thanhVien.getId()));
        holder.tenDangNhap.setText(thanhVien.getTenDangNhap());
        holder.email.setText(thanhVien.getEmail());

        holder.itemThanhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDetail(thanhVien);
            }
        });

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
        if (thanhViens != null){
            return  thanhViens.size();
        }
        return 0;
    }

    public static class ThanhVienHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView tenDangNhap;
        TextView email;
        CardView itemThanhVien;
        public ThanhVienHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idThanhVien);
            tenDangNhap = itemView.findViewById(R.id.tenDangNhap);
            email = itemView.findViewById(R.id.email);
            itemThanhVien = itemView.findViewById(R.id.itemThanhVien);
        }
    }
}
