package com.example.myapplication.model;

import java.util.Date;

public class ChuyenXe {
    private int idChuyenXe;
    private String tenChuyen;
    private String hinhAnh;
    private Date thoiGianBatDau;
    private String diaDiemDi;
    private String diaDiemDen;

    public ChuyenXe( String tenChuyen, String hinhAnh, Date thoiGianBatDau, String diaDiemDi, String diaDiemDen) {

        this.tenChuyen = tenChuyen;
        this.hinhAnh = hinhAnh;
        this.thoiGianBatDau = thoiGianBatDau;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public String getTenChuyen() {
        return tenChuyen;
    }

    public void setTenChuyen(String tenChuyen) {
        this.tenChuyen = tenChuyen;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getDiaDiemDi() {
        return diaDiemDi;
    }

    public void setDiaDiemDi(String diaDiemDi) {
        this.diaDiemDi = diaDiemDi;
    }

    public String getDiaDiemDen() {
        return diaDiemDen;
    }

    public void setDiaDiemDen(String diaDiemDen) {
        this.diaDiemDen = diaDiemDen;
    }
}
