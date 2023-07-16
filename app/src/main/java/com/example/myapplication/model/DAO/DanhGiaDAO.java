package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.DanhGia;

import java.util.List;

@Dao
public interface DanhGiaDAO {
    @Insert
    void insert(DanhGia... danhGias);

    @Query("select * from table_danh_gia")
    List<DanhGia> getAll();
}
