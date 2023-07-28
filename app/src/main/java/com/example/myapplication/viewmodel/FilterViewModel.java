package com.example.myapplication.viewmodel;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.library.baseAdapters.BR;

import com.example.myapplication.adapter.ChuyenXeFilterAdapter;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.model.DAO.ChuyenXeDAO;
import com.example.myapplication.model.DAO.LoaiXeDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterViewModel extends BaseObservable {
    private ChuyenXeFilterAdapter chuyenXeFilterAdapter;
    private String diaDiemDi;
    private String diaDiemDen;
    private String loaiXe;
    private String gioDi;
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
        Set<String> uniqueDiaDiemDiSet = new HashSet<>(diaDiemDi);
        return new ArrayList<>(uniqueDiaDiemDiSet);
    }
    public List<String> getListDiaDiemDen(Context context){

        List<String> diaDiemDen = AppDatabase.getInstance(context).getChuyenXeDAO().getListDiaDiemDen();
        Set<String> uniqueDiaDiemDenSet = new HashSet<>(diaDiemDen);
        return new ArrayList<>(uniqueDiaDiemDenSet);
    }

    public int getIdLoaiXeByName(Context context,String tenLoaiXe){
        LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(context).getLoaiXeDAO();
        int idLoaiXe =loaiXeDAO.getIDLoaiXe(tenLoaiXe);
        return  idLoaiXe;
    }

    public List<ChuyenXe> listFilterChuyenXe(Context context){
        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(context).getChuyenXeDAO();
        List<ChuyenXe> filterChuyenXe = chuyenXeDAO.filterChuyenXe(diaDiemDi,diaDiemDen,getIdLoaiXeByName(context,loaiXe),gioDi);
        return filterChuyenXe;
    }

    @Bindable
    public String getDiaDiemDi() {
        return diaDiemDi;

    }

    public void setDiaDiemDi(String diaDiemDi) {
        this.diaDiemDi = diaDiemDi;
        notifyPropertyChanged(BR.diaDiemDi);
    }

    @Bindable
    public String getDiaDiemDen() {
        return diaDiemDen;
    }

    public void setDiaDiemDen(String diaDiemDen) {
        this.diaDiemDen = diaDiemDen;
        notifyPropertyChanged(BR.diaDiemDen);
    }

    @Bindable
    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
        notifyPropertyChanged(BR.tenLoaiXe);
    }

    @Bindable
    public String getGioDi() {
        return gioDi;
    }

    public void setGioDi(String gioDi) {
        this.gioDi = gioDi;
        notifyPropertyChanged(BR.gioDi);
    }
}
