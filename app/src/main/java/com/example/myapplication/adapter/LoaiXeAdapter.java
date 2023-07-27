package com.example.myapplication.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.config.DataLocalManager;
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
        holder.btnDelete.setOnClickListener(view -> showDiaLog(loaiXe, position));


    }
    private void showDiaLog(LoaiXe loaiXe, int posiotion){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xác nhận xóa");
        builder.setMessage("Bạn có muốn xóa loại xe này");
        builder.setPositiveButton("Đồng ý",((dialogInterface, i) -> {
           loaixes.remove(posiotion);
            AppDatabase.getInstance(context).getLoaiXeDAO().delete(loaiXe);
            notifyDataSetChanged(); // cập nhật giao diện sao khi xóa
        }));
        builder.setNegativeButton("Hủy", (dialogInterface, i) -> {
            // Đóng hộp thoại khi người dùng không đồng ý xóa
            dialogInterface.dismiss();
        });
        builder.create().show();
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
        ImageView btnDelete;


        public LoaiXeHolder(@NonNull View itemView) {
            super(itemView);
            tenLoaiXe = itemView.findViewById(R.id.tenLoaiXe);
            maSoLoaiXe = itemView.findViewById(R.id.idLoaiXe);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
