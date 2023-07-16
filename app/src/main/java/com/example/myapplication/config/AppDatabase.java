package com.example.myapplication.config;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.model.DAO.QuyenDao;
import com.example.myapplication.model.DAO.ThanhVienDAO;
import com.example.myapplication.model.Quyen;
import com.example.myapplication.model.ThanhVien;

@Database(version = 1,
    entities = {
            ThanhVien.class,
            Quyen.class
    }
    , exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {


    public abstract ThanhVienDAO getThanhVienDAO();
    public abstract QuyenDao getQuyenDAO();
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "doanandroid.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
