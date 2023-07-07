package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.config.DatabaseHelper;

public class ThanhVienRepository {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    public ThanhVienRepository(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    public void open(){
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    public void close(){
        databaseHelper.close();
    }

    public void addThanhVien(ThanhVien thanhVien){
        ContentValues values = new ContentValues();
        values.put(databaseHelper.getCOLUMN_TEN_DANG_NHAP(), thanhVien.getTenDangNhap());
        values.put(databaseHelper.getCOLUMN_HO(), thanhVien.getHo());
        values.put(databaseHelper.getCOLUMN_TEN(), thanhVien.getTen());
        values.put(databaseHelper.getCOLUMN_MAT_KHAU(), thanhVien.getMatKhau());
        values.put(databaseHelper.getCOLUMN_AVATAR(), thanhVien.getAvatar());
        values.put(databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN(), thanhVien.getIdQuyenThanhVien());
        values.put(databaseHelper.getCOLUMN_EMAIL(), thanhVien.getEmail());
        values.put(databaseHelper.getCOLUMN_SO_DIEN_THOAI(), thanhVien.getSoDienThoai());
        values.put(databaseHelper.getCOLUMN_NGAY_TAO(), thanhVien.getNgayTao().toString());
        values.put(databaseHelper.getCOLUMN_NGAY_CAP_NHAT(), thanhVien.getNgayCapNhat().toString());

        sqLiteDatabase.insert(databaseHelper.getTABLE_THANHVIEN(), null , values);
    }
}
