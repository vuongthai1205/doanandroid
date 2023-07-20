package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.model.ChuyenXe;

import java.util.List;

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
}
