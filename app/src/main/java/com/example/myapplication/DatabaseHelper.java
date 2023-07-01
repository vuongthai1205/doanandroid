package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "doanandroid.db";
    private static final int DATABASE_VERSION = 2;
    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable_quyen = "CREATE TABLE table_quyen (id_quyen INTEGER PRIMARY KEY AUTOINCREMENT, ten_quyen VARCHAR(50))";
        String createTable_thanhvien = "CREATE TABLE table_thanhvien (id_thanh_vien INTEGER PRIMARY KEY AUTOINCREMENT,ten_nguoi_dung VARCHAR(100), mat_khau VARCHAR(50),id_quyen INTEGER,  email VARCHAR(50), so_dien_thoai VARCHAR(12), ngay_tao DATETIME, ngay_cap_nhat DATETIME, FOREIGN KEY  (id_quyen) REFERENCES table_quyen(id_quyen)  )";

        sqLiteDatabase.execSQL(createTable_quyen);
        sqLiteDatabase.execSQL(createTable_thanhvien);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1 > i){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_quyen");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_thanhvien");
            onCreate(sqLiteDatabase);
        }
    }
}
