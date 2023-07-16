package com.example.myapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "table_so_luong_ghe",
        foreignKeys = {@ForeignKey(entity = ChuyenXe.class, parentColumns = "id_chuyen_xe", childColumns = "id_chuyen_xe"),
                        @ForeignKey(entity = LoaiXe.class, parentColumns = "id_loai_xe", childColumns = "id_loai_xe")},
        indices = {@Index(name = "index_id_chuyen_xe_slg", value = "id_chuyen_xe"),@Index(name = "index_id_loai_xe_slg", value = "id_loai_xe")}
)
public class SoLuongGhe {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_so_luong_ghe")
    private int idSoLuongGhe;
    @ColumnInfo(name ="id_chuyen_xe" )
    private int idChuyenXe;
    @ColumnInfo(name = "id_loai_xe")
    private int idLoaiXe;
    @ColumnInfo(name = "so_luong_ghe")
    private int soLuongGhe;
    public SoLuongGhe(){

    }
    @Ignore
    public SoLuongGhe(int idChuyenXe, int idLoaiXe, int soLuongGhe) {
        this.idChuyenXe = idChuyenXe;
        this.idLoaiXe = idLoaiXe;
        this.soLuongGhe = soLuongGhe;
    }

    public int getIdSoLuongGhe() {
        return idSoLuongGhe;
    }

    public void setIdSoLuongGhe(int idSoLuongGhe) {
        this.idSoLuongGhe = idSoLuongGhe;
    }

    public int getIdChuyenXe() {
        return idChuyenXe;
    }

    public void setIdChuyenXe(int idChuyenXe) {
        this.idChuyenXe = idChuyenXe;
    }

    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
    }

    public int getSoLuongGhe() {
        return soLuongGhe;
    }

    public void setSoLuongGhe(int soLuongGhe) {
        this.soLuongGhe = soLuongGhe;
    }
}
