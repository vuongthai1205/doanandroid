package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.ChuyenXe;

import java.util.List;

@Dao
public interface ChuyenXeDAO {
    @Insert
    void insert(ChuyenXe... chuyenXe);

    @Query("select * from table_chuyenxe")
    List<ChuyenXe> getAll();
}
