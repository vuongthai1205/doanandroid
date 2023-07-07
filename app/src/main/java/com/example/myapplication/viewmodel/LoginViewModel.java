package com.example.myapplication.viewmodel;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.config.DatabaseHelper;

public class LoginViewModel {
    public DatabaseHelper databaseHelper;
    public SQLiteDatabase sqLiteDatabase;

    public LoginViewModel() {
    }

    public String chuyenDoiQuyenThanhVien(int id){
        String query = "SELECT " + databaseHelper.getCOLUMN_TEN_QUYEN() + " FROM " + databaseHelper.getTABLE_THANHVIEN() + " , " + databaseHelper.getTABLE_QUYEN() + " WHERE " +databaseHelper.getTABLE_THANHVIEN()+ "."+ databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN() + " = " + databaseHelper.getTABLE_QUYEN() + "." + databaseHelper.getCOLUMN_ID_QUYEN()
                + " AND " + databaseHelper.getTABLE_THANHVIEN()+ "."+ databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN() + " = " + id;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        String tenQuyen = null;
        if (cursor.moveToFirst()){
            tenQuyen = cursor.getString(0);

        }
        cursor.close();
        return tenQuyen;
    }
}
