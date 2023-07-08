package com.example.myapplication.model;

public class LoaiXe {
    private int idLoaiXe;
    private String tenLoaiXe;
    private int soLuongGhe;

    public LoaiXe( String tenLoaiXe, int soLuongGhe) {

        this.tenLoaiXe = tenLoaiXe;
        this.soLuongGhe = soLuongGhe;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }
}

