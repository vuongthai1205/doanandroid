package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "doanandroid.db";
    private static final int DATABASE_VERSION = 2;
    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Query tao bang trong databse

        String createTable_quyen = "CREATE TABLE table_quyen (id_quyen INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ten_quyen VARCHAR(50) NOT NULL)";
        String createTable_thanhvien = "CREATE TABLE table_thanhvien (id_thanh_vien INTEGER PRIMARY KEY AUTOINCREMENT,ten_nguoi_dung VARCHAR(100) NOT NULL, mat_khau VARCHAR(50) NOT NULL,id_quyen INTEGER NOT NULL,  email VARCHAR(50), so_dien_thoai VARCHAR(12) NOT NULL, ngay_tao DATETIME , ngay_cap_nhat DATETIME , FOREIGN KEY  (id_quyen) REFERENCES table_quyen(id_quyen))";
        String createTable_loaixe = "CREATE TABLE table_loaixe(id_loai_xe INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ten_loai_xe VARCHAR(50) NOT NULL, so_luong_ghe INTEGER NOT NULL)";
        String createTable_chuyenxe = "CREATE TABLE table_chuyenxe(id_chuyen_xe INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ten_chuyen VARCHAR(50) NOT NULL, thoi_gian_bat_dau DATETIME, dia_diem_di VARCHAR(50), dia_diem_den VARCHAR(50))";
        String createTable_vexe = "CREATE TABLE table_vexe(id_ve_xe INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,id_thanh_vien INTEGER NOT NULL, id_loai_xe INTEGER NOT NULL, id_chuyen_xe INTEGER NOT NULL, ngay_gio_dat DATETIME, thong_tin_khac VARCHAR(100), FOREIGN KEY (id_thanh_vien) REFERENCES table_thanhvien(id_thanh_vien), FOREIGN KEY (id_loai_xe) REFERENCES table_loaixe(id_loai_xe), FOREIGN KEY (id_chuyen_xe) REFERENCES table_chuyenxe(id_chuyen_xe))";
        String createTable_danhgia = "CREATE TABLE table_danhgia( id_danh_gia INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, id_thanh_vien INTEGER NOT NULL, id_chuyen_xe INTEGER NOT NULL , diem_danh_gia INTEGER NOT NULL, nhan_xet VARCHAR(100),FOREIGN KEY (id_thanh_vien) REFERENCES table_thanhvien(id_thanh_vien), FOREIGN KEY (id_chuyen_xe) REFERENCES table_chuyenxe(id_chuyen_xe))";

        //Thuc thi query tao bang
        sqLiteDatabase.execSQL(createTable_quyen);
        sqLiteDatabase.execSQL(createTable_thanhvien);
        sqLiteDatabase.execSQL(createTable_loaixe);
        sqLiteDatabase.execSQL(createTable_chuyenxe);
        sqLiteDatabase.execSQL(createTable_vexe);
        sqLiteDatabase.execSQL(createTable_danhgia);
    }
    //Quan li viec nang cap CSDL
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i1 > i){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_quyen");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_thanhvien");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_loaixe");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_chuyenxe");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_vexe");
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_danhgia");
            onCreate(sqLiteDatabase);
        }
    }
}
