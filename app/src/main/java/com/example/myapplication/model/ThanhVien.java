package com.example.myapplication.model;


public class ThanhVien {

    private int id;

    private String tenDangNhap;
    private String ho;
    private String ten;
    private String matKhau;
    private String avatar;
    private int idQuyenThanhVien;
    private String email;
    private String soDienThoai;
    private String ngayTao;
    private String ngayCapNhat;


    public ThanhVien( String tenDangNhap, String ho, String ten, String matKhau, String avatar, int idQuyenThanhVien, String email, String soDienThoai, String ngayTao, String ngayCapNhat) {

        this.tenDangNhap = tenDangNhap;
        this.ho = ho;
        this.ten = ten;
        this.matKhau = matKhau;
        this.avatar = avatar;
        this.idQuyenThanhVien = idQuyenThanhVien;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.ngayTao = ngayTao;
        this.ngayCapNhat = ngayCapNhat;
    }

    public ThanhVien( String tenDangNhap, String ho, String ten, String avatar,  String email, String soDienThoai) {

        this.tenDangNhap = tenDangNhap;
        this.ho = ho;
        this.ten = ten;
        this.avatar = avatar;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }
    public ThanhVien(String tenDangNhap){
        this.tenDangNhap = tenDangNhap;
    }
    public ThanhVien(String tenDangNhap,String email){
        this.tenDangNhap = tenDangNhap;
        this.email = email;
    }



    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIdQuyenThanhVien() {
        return idQuyenThanhVien;
    }

    public void setIdQuyenThanhVien(int idQuyenThanhVien) {
        this.idQuyenThanhVien = idQuyenThanhVien;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }
}
