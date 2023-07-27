package com.example.myapplication.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;

import com.example.myapplication.adapter.ChuyenXeFilterAdapter;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.model.DAO.ChuyenXeDAO;
import com.example.myapplication.model.DAO.LoaiXeDAO;

import java.util.List;

public class FilterViewModel extends BaseObservable {
    private ChuyenXeFilterAdapter chuyenXeFilterAdapter;
    public void renderAdapter(Context context){
        chuyenXeFilterAdapter = new ChuyenXeFilterAdapter(context);
        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(context).getChuyenXeDAO();
        chuyenXeFilterAdapter.setData(chuyenXeDAO.getAll());
        setChuyenXeFilterAdapter(chuyenXeFilterAdapter);
    }

    public ChuyenXeFilterAdapter getChuyenXeFilterAdapter() {
        return chuyenXeFilterAdapter;
    }

    public void setChuyenXeFilterAdapter(ChuyenXeFilterAdapter chuyenXeFilterAdapter) {
        this.chuyenXeFilterAdapter = chuyenXeFilterAdapter;
    }

    public List<String> getListTenLoaiXe(Context context){

        List<String> tenLoaiXe = AppDatabase.getInstance(context).getLoaiXeDAO().getTenLoaiXe();
        return tenLoaiXe;
    }
    public List<String> getListDiaDiemDi(Context context){

        List<String> diaDiemDi = AppDatabase.getInstance(context).getChuyenXeDAO().getListDiaDiemDi();
        return diaDiemDi;
    }
    public List<String> getListDiaDiemDen(Context context){

        List<String> diaDiemDen = AppDatabase.getInstance(context).getChuyenXeDAO().getListDiaDiemDen();
        return diaDiemDen;
    }

    public int getIdLoaiXeByName(Context context,String tenLoaiXe){
        LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(context).getLoaiXeDAO();
        int idLoaiXe =loaiXeDAO.getIDLoaiXe(tenLoaiXe);
        return  idLoaiXe;
    }
}
