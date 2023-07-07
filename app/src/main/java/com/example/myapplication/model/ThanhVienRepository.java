package com.example.myapplication.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.config.DatabaseHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<ThanhVien> getAllThanhVien() throws ParseException {
        List<ThanhVien> list = new ArrayList<>();
        String pattern = "dd-MM-yyyy";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Cursor cursor = sqLiteDatabase.query(databaseHelper.getTABLE_THANHVIEN(), null,null,null,null,null,null);
        if (cursor != null && cursor.moveToFirst()){
            do {
                @SuppressLint("Range") String tenDangNhap = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_TEN_DANG_NHAP()));
                @SuppressLint("Range") String ho = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_HO()));
                @SuppressLint("Range") String ten = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_TEN()));
                @SuppressLint("Range") String matKhau = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_MAT_KHAU()));
                @SuppressLint("Range") String avatar = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_AVATAR()));
                @SuppressLint("Range") int idQuyenThanhVien = cursor.getInt(cursor.getColumnIndex(databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN()));
                @SuppressLint("Range") String soDienThoai = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_SO_DIEN_THOAI()));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_EMAIL()));
                @SuppressLint("Range") Date ngayTao = dateFormat.parse(cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_NGAY_TAO())) );
                @SuppressLint("Range") Date ngayCapNhat = dateFormat.parse(cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_NGAY_CAP_NHAT())));
                ThanhVien thanhVien = new ThanhVien(tenDangNhap,ho,ten,matKhau,avatar,idQuyenThanhVien,email,soDienThoai,ngayTao,ngayCapNhat);
                list.add(thanhVien);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

}
