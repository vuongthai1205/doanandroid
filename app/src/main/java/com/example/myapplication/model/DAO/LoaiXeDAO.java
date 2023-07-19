package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.LoaiXe;

import java.util.List;

@Dao
public interface LoaiXeDAO {
    @Insert
    void insert(LoaiXe... loaiXes);

    @Query("select * from table_loaixe")
    List<LoaiXe> getAll();
}
