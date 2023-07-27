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

    @Query("select * from table_chuyenxe")
    List<ChuyenXe> getAll();

    @Query("select dia_diem_di from table_chuyenxe")
    Set<String> getListDiaDiemDi();

    @Query("select dia_diem_den from table_chuyenxe")
    Set<String> getListDiaDiemDen();

}
