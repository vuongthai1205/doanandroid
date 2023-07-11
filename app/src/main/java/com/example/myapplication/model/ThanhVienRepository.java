package com.example.myapplication.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.config.DatabaseHelper;
import com.example.myapplication.config.VariableGlobal;
import com.example.myapplication.view.LoginActivity;
import com.example.myapplication.view.SignupActivity;

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
    public void openToWrite(){
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }
    public void openToRead(){
        sqLiteDatabase = databaseHelper.getReadableDatabase();
    }

    public void close(){
        databaseHelper.close();
    }

    public void addThanhVien(ThanhVien thanhVien){
        openToWrite();
        ContentValues values = new ContentValues();
        Date dataNow = new Date();
        thanhVien.setNgayTao(VariableGlobal.dateFormat.format(dataNow));
        thanhVien.setNgayCapNhat(VariableGlobal.dateFormat.format(dataNow));
        values.put(databaseHelper.getCOLUMN_TEN_DANG_NHAP(), thanhVien.getTenDangNhap());
        values.put(databaseHelper.getCOLUMN_HO(), thanhVien.getHo());
        values.put(databaseHelper.getCOLUMN_TEN(), thanhVien.getTen());
        values.put(databaseHelper.getCOLUMN_MAT_KHAU(), thanhVien.getMatKhau());
        values.put(databaseHelper.getCOLUMN_AVATAR(), thanhVien.getAvatar());
        values.put(databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN(), thanhVien.getIdQuyenThanhVien());
        values.put(databaseHelper.getCOLUMN_EMAIL(), thanhVien.getEmail());
        values.put(databaseHelper.getCOLUMN_SO_DIEN_THOAI(), thanhVien.getSoDienThoai());
        values.put(databaseHelper.getCOLUMN_NGAY_TAO(), thanhVien.getNgayTao());
        values.put(databaseHelper.getCOLUMN_NGAY_CAP_NHAT(), thanhVien.getNgayCapNhat());

        sqLiteDatabase.insert(databaseHelper.getTABLE_THANHVIEN(), null , values);

        close();
    }

    public void updateThanhVienByUserName(String username, ThanhVien thanhVien) {

            openToWrite();

            ContentValues values = new ContentValues();
            Date dataNow = new Date();
            thanhVien.setNgayCapNhat(VariableGlobal.dateFormat.format(dataNow));

            values.put(databaseHelper.getCOLUMN_HO(), thanhVien.getHo());
            values.put(databaseHelper.getCOLUMN_TEN(), thanhVien.getTen());
            values.put(databaseHelper.getCOLUMN_AVATAR(), thanhVien.getAvatar());
            values.put(databaseHelper.getCOLUMN_EMAIL(), thanhVien.getEmail());
            values.put(databaseHelper.getCOLUMN_SO_DIEN_THOAI(), thanhVien.getSoDienThoai());
            values.put(databaseHelper.getCOLUMN_NGAY_CAP_NHAT(), thanhVien.getNgayCapNhat());

            sqLiteDatabase.update(databaseHelper.getTABLE_THANHVIEN(), values, databaseHelper.getCOLUMN_TEN_DANG_NHAP() + "=?", new String[]{username});

            close();


    }


    public boolean isThanhVienExist(ThanhVien thanhVien){
        openToRead();

        String[] projection = {databaseHelper.getCOLUMN_TEN_DANG_NHAP()};
        String selection = databaseHelper.getCOLUMN_TEN_DANG_NHAP() + " = ? OR " +
                databaseHelper.getCOLUMN_EMAIL() + " = ? OR " +
                databaseHelper.getCOLUMN_SO_DIEN_THOAI() + " = ?";
        String[] selectionArgs = {thanhVien.getTenDangNhap(), thanhVien.getEmail(), thanhVien.getSoDienThoai()};

        Cursor cursor = sqLiteDatabase.query(
                databaseHelper.getTABLE_THANHVIEN(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean exists = cursor.moveToFirst();
        cursor.close();
        close();

        return exists;
    }

    public ThanhVien getThanhVienByUserName(String username) {
        openToWrite();
        ThanhVien thanhVien = null;
        Cursor cursor = sqLiteDatabase.query(databaseHelper.getTABLE_THANHVIEN(), null, databaseHelper.getCOLUMN_TEN_DANG_NHAP() + "= ? ",new String[]{username},null,null,null);
        if(cursor != null && cursor.moveToFirst()){
            String tendangnhap = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_TEN_DANG_NHAP()));
            String ho = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_HO()));
            String ten = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_TEN()));
            String avatar = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_AVATAR()));
            int quyen = cursor.getInt(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN()));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_EMAIL()));
            String sodienthoai = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_SO_DIEN_THOAI()));
            String ngaytao = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_NGAY_TAO())) ;
            String ngaycapnhat = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_NGAY_CAP_NHAT()));

            thanhVien = new ThanhVien(tendangnhap,ho,ten,null,avatar,quyen,email,sodienthoai,ngaytao,ngaycapnhat);
        }
        cursor.close();
        this.close();
        return thanhVien;
    }

    public List<ThanhVien> getAllThanhVien()  {
        openToRead();
        List<ThanhVien> list = new ArrayList<>();

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
                @SuppressLint("Range") String ngayTao =cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_NGAY_TAO()) );
                @SuppressLint("Range") String ngayCapNhat = cursor.getString(cursor.getColumnIndex(databaseHelper.getCOLUMN_NGAY_CAP_NHAT()));
                ThanhVien thanhVien = new ThanhVien(tenDangNhap,ho,ten,matKhau,avatar,idQuyenThanhVien,email,soDienThoai,ngayTao,ngayCapNhat);
                list.add(thanhVien);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        this.close();
        return list;
    }

    public String chuyenDoiQuyenThanhVien(int id){
        openToRead();
        String tenQuyen = null;

        String[] projection = { databaseHelper.getCOLUMN_TEN_QUYEN() };
        String selection = databaseHelper.getCOLUMN_ID_QUYEN()+ " = ?";
        String[] selectionArgs = { String.valueOf(id) };
        String tableName = databaseHelper.getTABLE_QUYEN();

        Cursor cursor = sqLiteDatabase.query(tableName, projection, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            tenQuyen = cursor.getString(cursor.getColumnIndexOrThrow(databaseHelper.getCOLUMN_TEN_QUYEN()));
        }

        cursor.close();
        this.close();

        return tenQuyen;
    }

}
