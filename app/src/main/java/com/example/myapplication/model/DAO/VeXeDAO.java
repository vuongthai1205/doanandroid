package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.VeXe;

import java.util.List;

@Dao
public interface VeXeDAO {
    @Insert
    void insert(VeXe... veXes);
    @Query("select * from table_dat_ve")
    List<VeXe> getAll();
}
