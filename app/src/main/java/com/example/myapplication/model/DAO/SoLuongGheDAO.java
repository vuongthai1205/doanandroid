package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.SoLuongGhe;

import java.util.List;

@Dao
public interface SoLuongGheDAO {
    @Insert
    void insert(SoLuongGhe... soLuongGhes);

    @Query("select * from table_so_luong_ghe")
    List<SoLuongGhe> getAll();
}
