package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.ChuyenXe;

import java.util.List;
import java.util.Set;

@Dao
public interface ChuyenXeDAO {
    @Insert
    void insert(ChuyenXe... chuyenXe);
    @Delete
    void delete(ChuyenXe chuyenXe);
    @Update
    void updateChuyenXe(ChuyenXe chuyenXe);

    @Query("select ten_chuyen from table_chuyenxe where id_chuyen_xe = :id")
    String getTenChuyenById(int id);

    @Query("select gia_tien from table_chuyenxe where id_chuyen_xe = :id")
    double getGiaVeById(int id);

    @Query("select * from table_chuyenxe")
    List<ChuyenXe> getAll();

    @Query("select dia_diem_di from table_chuyenxe")
    List<String> getListDiaDiemDi();

    @Query("select dia_diem_den from table_chuyenxe")
    List<String> getListDiaDiemDen();

//    @Query("SELECT * FROM ChuyenXe " +
//            "WHERE (:diemDi IS NULL OR dia_diem_di = :diemDi) " +
//            "AND (:diemDen IS NULL OR dia_diem_den = :diemDen) " +
//            "AND (:idLoaiXe = -1 OR id_loai_xe = :idLoaiXe) " +
//            "AND (:ngayDi IS NULL OR ngay_di = :ngayDi) " +
//            "AND (:gioDi IS NULL OR SUBSTR(thoi_gian_bat_dau, 1, 5) >= :gioDi) " +
//            "ORDER BY thoi_gian_bat_dau")
//    List<ChuyenXe> filterChuyenXe(String diemDi, String diemDen, int idLoaiXe, String ngayDi, String gioDi);

    @Query("select * from table_chuyenxe " +
            "where (:diaDiemDi is null or dia_diem_di = :diaDiemDi)" +
            "and (:diaDiemDen is null or dia_diem_den = :diaDiemDen)"+
            "and (:idLoaiXe = -1 or id_loai_xe = :idLoaiXe)"+
            "and (:gioDi is null or thoi_gian_bat_dau like '%' || :gioDi || '%')"+
            "order by thoi_gian_bat_dau")
    List<ChuyenXe> filterChuyenXe(String diaDiemDi, String diaDiemDen, int idLoaiXe,String gioDi);

    @Query("select * from table_chuyenxe where id_chuyen_xe = :id")
    ChuyenXe getChuyenXeById(int id);
}
