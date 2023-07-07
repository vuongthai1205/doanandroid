package com.example.myapplication.model;

public class DanhGia {
    private int idDanhGia;
    private int idThanhVienDanhGia;
    private int idChuyenXeDanhGia;
    private int diemDanhGia;
    private String nhanXet;

    public DanhGia(int idThanhVienDanhGia, int idChuyenXeDanhGia, int diemDanhGia, String nhanXet) {

        this.idThanhVienDanhGia = idThanhVienDanhGia;
        this.idChuyenXeDanhGia = idChuyenXeDanhGia;
        this.diemDanhGia = diemDanhGia;
        this.nhanXet = nhanXet;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdDanhGia() {
        return idDanhGia;
    }


    public int getIdThanhVienDanhGia() {
        return idThanhVienDanhGia;
    }

    public void setIdThanhVienDanhGia(int idThanhVienDanhGia) {
        this.idThanhVienDanhGia = idThanhVienDanhGia;
    }

    public int getIdChuyenXeDanhGia() {
        return idChuyenXeDanhGia;
    }

    public void setIdChuyenXeDanhGia(int idChuyenXeDanhGia) {
        this.idChuyenXeDanhGia = idChuyenXeDanhGia;
    }

    public int getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
    }
}

