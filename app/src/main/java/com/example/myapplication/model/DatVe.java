package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_dat_ve",
        foreignKeys = {@ForeignKey(entity = ThanhVien.class, parentColumns = "id_thanh_vien", childColumns = "id_thanh_vien"),
                @ForeignKey(entity = ChuyenXe.class, parentColumns = "id_chuyen_xe", childColumns = "id_chuyen_xe"),
                @ForeignKey(entity = TrangThai.class, parentColumns = "id_trang_thai", childColumns = "id_trang_thai")
        }
        ,indices = {@Index(name = "index_id_thanhvien_vexe", value = "id_thanh_vien"),
        @Index(name = "index_id_chuyen_xe_vexe", value = "id_chuyen_xe") ,
        @Index(name = "index_id_trang_thai", value = "id_trang_thai")}
)
public class DatVe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ve_xe")
    private int idVeXe;
    @ColumnInfo(name = "id_thanh_vien")
    private int idThanhVienVeXe;
    @ColumnInfo(name = "id_chuyen_xe")
    private int idChuyenXeVeXe;
    @ColumnInfo(name = "so_luong_ve")
    private int soLuongVe;
    @ColumnInfo(name = "ngay_gio_dat")
    private String ngayGioDat;
    @ColumnInfo(name = "id_trang_thai")
    private int idTrangThai;
    @ColumnInfo(name="thong_tin_khac")
    private String thongTinKhac;
    public DatVe(){

    }
    @Ignore
    public DatVe(int idThanhVienVeXe,int idChuyenXeVeXe, int soLuongVe, String ngayGioDat, String thongTinKhac) {

        this.idThanhVienVeXe = idThanhVienVeXe;
        this.idChuyenXeVeXe = idChuyenXeVeXe;
        this.soLuongVe = soLuongVe;
        this.ngayGioDat = ngayGioDat;
        this.thongTinKhac = thongTinKhac;
    }

    public int getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(int soLuongVe) {
        this.soLuongVe = soLuongVe;
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


    public int getIdChuyenXeVeXe() {
        return idChuyenXeVeXe;
    }

    public void setIdChuyenXeVeXe(int idChuyenXeVeXe) {
        this.idChuyenXeVeXe = idChuyenXeVeXe;
    }

    public String getNgayGioDat() {
        return ngayGioDat;
    }

    public void setNgayGioDat(String ngayGioDat) {
        this.ngayGioDat = ngayGioDat;
    }

    public String getThongTinKhac() {
        return thongTinKhac;
    }

    public void setThongTinKhac(String thongTinKhac) {
        this.thongTinKhac = thongTinKhac;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }
}

