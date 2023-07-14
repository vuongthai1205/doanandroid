package com.example.myapplication.model.DAO;

import androidx.room.Dao;
import androidx.room.Query;
@Dao
public interface QuyenDao {
    @Query("SELECT ten_quyen FROM table_quyen WHERE id_quyen = :id")
    String chuyenDoiQuyenThanhVien(int id);
}
