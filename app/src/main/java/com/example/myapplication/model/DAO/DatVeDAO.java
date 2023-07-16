package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.DatVe;

import java.util.List;

@Dao
public interface DatVeDAO {
    @Insert
    void insert(DatVe... veXes);
    @Query("select * from table_dat_ve")
    List<DatVe> getAll();
}
