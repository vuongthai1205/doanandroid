package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "table_chuyenxe"

)
public class ChuyenXe {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_chuyen_xe")
    private int idChuyenXe;
    @ColumnInfo(name = "ten_chuyen")
    private String tenChuyen;
    @ColumnInfo(name = "hinh_anh")
    private String hinhAnh;
    @ColumnInfo(name = "thoi_gian_bat_dau")
    private String thoiGianBatDau;
    @ColumnInfo(name = "thoi_gian_ket_thuc")
    private String thoiGianKetThuc;
    @ColumnInfo(name = "ngay_di")
    private String ngayDi;
    @ColumnInfo(name = "ngay_ve")
    private String ngayVe;
    @ColumnInfo(name = "dia_diem_di")
    private String diaDiemDi;
    @ColumnInfo(name = "dia_diem_den")
    private String diaDiemDen;

    public ChuyenXe(){

    }
    @Ignore
    public ChuyenXe( String tenChuyen, String hinhAnh, String thoiGianBatDau, String thoiGianKetThuc,String ngayDi, String ngayVe, String diaDiemDi, String diaDiemDen) {

        this.tenChuyen = tenChuyen;
        this.hinhAnh = hinhAnh;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.ngayDi = ngayDi;
        this.ngayVe = ngayVe;
        this.diaDiemDi = diaDiemDi;
        this.diaDiemDen = diaDiemDen;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường dữ liệu

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

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
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

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(String ngayVe) {
        this.ngayVe = ngayVe;
    }
}
