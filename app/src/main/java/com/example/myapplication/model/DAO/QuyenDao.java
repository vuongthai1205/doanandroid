package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.model.Quyen;

@Dao
public interface QuyenDao {
    @Query("SELECT ten_quyen FROM table_quyen WHERE id_quyen = :id")
    String chuyenDoiQuyenThanhVien(int id);

    @Insert
    void insert(Quyen... quyen);
}
