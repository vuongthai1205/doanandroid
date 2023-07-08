package com.example.myapplication.viewmodel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.config.DatabaseHelper;

public class LoginViewModel {
    public DatabaseHelper databaseHelper;
    public SQLiteDatabase sqLiteDatabase;

    public LoginViewModel() {
    }

    public String chuyenDoiQuyenThanhVien(Context context, int id){
        String tenQuyen = null;
        databaseHelper = new DatabaseHelper(context);
        sqLiteDatabase = databaseHelper.getReadableDatabase();

        String[] projection = { databaseHelper.getCOLUMN_TEN_QUYEN() };
        String selection = databaseHelper.getCOLUMN_ID_QUYEN()+ " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        String tableName = databaseHelper.getTABLE_QUYEN();

        Cursor cursor = sqLiteDatabase.query(tableName, projection, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            tenQuyen = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_TEN_QUYEN()));
        }

        cursor.close();
        databaseHelper.close();

        return tenQuyen;
    }
}
