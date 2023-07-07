package com.example.myapplication.model;

import java.util.Date;

public class VeXe {
    private int idVeXe;
    private int idThanhVienVeXe;
    private int idLoaiXeVeXe;
    private int idChuyenXeVeXe;
    private Date ngayGioDat;
    private String thongTinKhac;

    public VeXe(int idVeXe, int idThanhVienVeXe, int idLoaiXeVeXe, int idChuyenXeVeXe, Date ngayGioDat, String thongTinKhac) {
        this.idVeXe = idVeXe;
        this.idThanhVienVeXe = idThanhVienVeXe;
        this.idLoaiXeVeXe = idLoaiXeVeXe;
        this.idChuyenXeVeXe = idChuyenXeVeXe;
        this.ngayGioDat = ngayGioDat;
        this.thongTinKhac = thongTinKhac;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdVeXe() {
        return idVeXe;
    }

    public void setIdVeXe(int idVeXe) {
        this.idVeXe = idVeXe;
    }

    public int getIdThanhVienVeXe() {
        return idThanhVienVeXe;
    }

    public void setIdThanhVienVeXe(int idThanhVienVeXe) {
        this.idThanhVienVeXe = idThanhVienVeXe;
    }

    public int getIdLoaiXeVeXe() {
        return idLoaiXeVeXe;
    }

    public void setIdLoaiXeVeXe(int idLoaiXeVeXe) {
        this.idLoaiXeVeXe = idLoaiXeVeXe;
    }

    public int getIdChuyenXeVeXe() {
        return idChuyenXeVeXe;
    }

    public void setIdChuyenXeVeXe(int idChuyenXeVeXe) {
        this.idChuyenXeVeXe = idChuyenXeVeXe;
    }

    public Date getNgayGioDat() {
        return ngayGioDat;
    }

    public void setNgayGioDat(Date ngayGioDat) {
        this.ngayGioDat = ngayGioDat;
    }

    public String getThongTinKhac() {
        return thongTinKhac;
    }

    public void setThongTinKhac(String thongTinKhac) {
        this.thongTinKhac = thongTinKhac;
    }
}

