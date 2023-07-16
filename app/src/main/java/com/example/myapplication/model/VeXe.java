package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "table_dat_ve",
        foreignKeys = {@ForeignKey(entity = ThanhVien.class, parentColumns = "id_thanh_vien", childColumns = "id_thanh_vien"),
                @ForeignKey(entity = LoaiXe.class, parentColumns = "id_loai_xe",childColumns = "id_loai_xe"),
                @ForeignKey(entity = ChuyenXe.class, parentColumns = "id_chuyen_xe", childColumns = "id_chuyen_xe")
        }
        ,indices = {@Index(name = "index_id_thanhvien_vexe", value = "id_thanh_vien"),
        @Index(name = "index_id_loai_xe", value = "id_loai_xe"),
        @Index(name = "index_id_chuyen_xe_vexe", value = "id_chuyen_xe") }
)
public class VeXe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_ve_xe")
    private int idVeXe;
    @ColumnInfo(name = "id_thanh_vien")
    private int idThanhVienVeXe;
    @ColumnInfo(name = "id_loai_xe")
    private int idLoaiXeVeXe;
    @ColumnInfo(name = "id_chuyen_xe")
    private int idChuyenXeVeXe;
    @ColumnInfo(name = "ngay_gio_dat")
    private String ngayGioDat;
    @ColumnInfo(name="thong_tin_khac")
    private String thongTinKhac;

    public VeXe( int idThanhVienVeXe, int idLoaiXeVeXe, int idChuyenXeVeXe, String ngayGioDat, String thongTinKhac) {

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
}

