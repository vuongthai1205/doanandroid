package com.example.myapplication.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;
import com.example.myapplication.model.ChuyenXe;

public class ADetailChuyenXeViewModel extends BaseObservable {
    private String tenChuyenXe;
    private String diaDiemDi;
    private String moTa;
    private String hinhAnh;

    public void layThongTinChuyenXe(ChuyenXe chuyenXe){


        setTenChuyenXe(chuyenXe.getTenChuyen());
        setDiaDiemDi("Địa điểm: " + chuyenXe.getDiaDiemDi());
        setMoTa("Mô tả: "+ chuyenXe.getMoTa());
        setHinhAnh(chuyenXe.getHinhAnh());
    }

    @Bindable
    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
        notifyPropertyChanged(BR.hinhAnh);
    }

    @Bindable
    public String getTenChuyenXe() {
        return tenChuyenXe;
    }

    public void setTenChuyenXe(String tenChuyenXe) {
        this.tenChuyenXe = tenChuyenXe;
        notifyPropertyChanged(BR.tenChuyenXe);
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
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
        notifyPropertyChanged(BR.moTa);
    }
}
