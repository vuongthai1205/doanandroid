package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "doanandroid.db";
    private static final int DATABASE_VERSION = 5;
    // Tạo các hằng số cho tên bảng
    final String TABLE_QUYEN = "table_quyen";
    final String TABLE_THANHVIEN = "table_thanhvien";
    final String TABLE_LOAIXE = "table_loaixe";
    final String TABLE_CHUYENXE = "table_chuyenxe";
    final String TABLE_VEXE = "table_vexe";
    final String TABLE_DANHGIA = "table_danhgia";

    // Tạo các hằng số cho tên cột
    final String COLUMN_ID_QUYEN = "id_quyen";
    final String COLUMN_TEN_QUYEN = "ten_quyen";

    final String COLUMN_ID_THANHVIEN = "id_thanh_vien";
    final String COLUMN_TEN_DANG_NHAP = "ten_dang_nhap";
    final String COLUMN_HO = "ho_thanh_vien";
    final String COLUMN_TEN = "ten_thanh_vien";
    final String COLUMN_MAT_KHAU = "mat_khau";
    final String COLUMN_AVATAR = "avatar";
    final String COLUMN_ID_QUYEN_THANHVIEN = "id_quyen";
    final String COLUMN_EMAIL = "email";
    final String COLUMN_SO_DIEN_THOAI = "so_dien_thoai";
    final String COLUMN_NGAY_TAO = "ngay_tao";
    final String COLUMN_NGAY_CAP_NHAT = "ngay_cap_nhat";

    final String COLUMN_ID_LOAIXE = "id_loai_xe";
    final String COLUMN_TEN_LOAIXE = "ten_loai_xe";
    final String COLUMN_SO_LUONG_GHE = "so_luong_ghe";

    final String COLUMN_ID_CHUYENXE = "id_chuyen_xe";
    final String COLUMN_TEN_CHUYEN = "ten_chuyen";
    final String COLUMN_HINH_ANH = "hinh_anh";
    final String COLUMN_THOI_GIAN_BAT_DAU = "thoi_gian_bat_dau";
    final String COLUMN_DIA_DIEM_DI = "dia_diem_di";
    final String COLUMN_DIA_DIEM_DEN = "dia_diem_den";

    final String COLUMN_ID_VEXE = "id_ve_xe";
    final String COLUMN_ID_THANHVIEN_VEXE = "id_thanh_vien";
    final String COLUMN_ID_LOAIXE_VEXE = "id_loai_xe";
    final String COLUMN_ID_CHUYENXE_VEXE = "id_chuyen_xe";
    final String COLUMN_NGAY_GIO_DAT = "ngay_gio_dat";
    final String COLUMN_THONG_TIN_KHAC = "thong_tin_khac";

    final String COLUMN_ID_DANHGIA = "id_danh_gia";
    final String COLUMN_ID_THANHVIEN_DANHGIA = "id_thanh_vien";
    final String COLUMN_ID_CHUYENXE_DANHGIA = "id_chuyen_xe";
    final String COLUMN_DIEM_DANH_GIA = "diem_danh_gia";
    final String COLUMN_NHAN_XET = "nhan_xet";


    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Query tao bang trong databse

        // Tạo các biến cho câu lệnh tạo bảng
        String createTable_quyen = "CREATE TABLE " + TABLE_QUYEN + " (" +
                COLUMN_ID_QUYEN + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_TEN_QUYEN + " VARCHAR(50) NOT NULL)";

        String createTable_thanhvien = "CREATE TABLE " + TABLE_THANHVIEN + " (" +
                COLUMN_ID_THANHVIEN + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEN_DANG_NHAP + " VARCHAR(100) NOT NULL, " +
                COLUMN_HO + " VARCHAR(30) ," +
                COLUMN_TEN+ " VARCHAR(30) ," +
                COLUMN_MAT_KHAU + " VARCHAR(50) NOT NULL, " +
                COLUMN_AVATAR + " VARCHAR(100), " +
                COLUMN_ID_QUYEN_THANHVIEN + " INTEGER NOT NULL, " +
                COLUMN_EMAIL + " VARCHAR(50), " +
                COLUMN_SO_DIEN_THOAI + " VARCHAR(12) NOT NULL, " +
                COLUMN_NGAY_TAO + " DATETIME, " +
                COLUMN_NGAY_CAP_NHAT + " DATETIME, " +
                "FOREIGN KEY (" + COLUMN_ID_QUYEN_THANHVIEN + ") REFERENCES " + TABLE_QUYEN + "(" + COLUMN_ID_QUYEN + "))";

        String createTable_loaixe = "CREATE TABLE " + TABLE_LOAIXE + "(" +
                COLUMN_ID_LOAIXE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_TEN_LOAIXE + " VARCHAR(50) NOT NULL, " +
                COLUMN_SO_LUONG_GHE + " INTEGER NOT NULL)";

        String createTable_chuyenxe = "CREATE TABLE " + TABLE_CHUYENXE + "(" +
                COLUMN_ID_CHUYENXE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_TEN_CHUYEN + " VARCHAR(50) NOT NULL, " +
                COLUMN_HINH_ANH + " VARCHAR(100)," +
                COLUMN_THOI_GIAN_BAT_DAU + " DATETIME, " +
                COLUMN_DIA_DIEM_DI + " VARCHAR(50), " +
                COLUMN_DIA_DIEM_DEN + " VARCHAR(50))";

        String createTable_vexe = "CREATE TABLE " + TABLE_VEXE + "(" +
                COLUMN_ID_VEXE + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_ID_THANHVIEN_VEXE + " INTEGER NOT NULL, " +
                COLUMN_ID_LOAIXE_VEXE + " INTEGER NOT NULL, " +
                COLUMN_ID_CHUYENXE_VEXE + " INTEGER NOT NULL, " +
                COLUMN_NGAY_GIO_DAT + " DATETIME, " +
                COLUMN_THONG_TIN_KHAC + " VARCHAR(100), " +
                "FOREIGN KEY (" + COLUMN_ID_THANHVIEN_VEXE + ") REFERENCES " + TABLE_THANHVIEN + "(" + COLUMN_ID_THANHVIEN + "), " +
                "FOREIGN KEY (" + COLUMN_ID_LOAIXE_VEXE + ") REFERENCES " + TABLE_LOAIXE + "(" + COLUMN_ID_LOAIXE + "), " +
                "FOREIGN KEY (" + COLUMN_ID_CHUYENXE_VEXE + ") REFERENCES " + TABLE_CHUYENXE + "(" + COLUMN_ID_CHUYENXE + "))";

        String createTable_danhgia = "CREATE TABLE " + TABLE_DANHGIA + "(" +
                COLUMN_ID_DANHGIA + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                COLUMN_ID_THANHVIEN_DANHGIA + " INTEGER NOT NULL, " +
                COLUMN_ID_CHUYENXE_DANHGIA + " INTEGER NOT NULL, " +
                COLUMN_DIEM_DANH_GIA + " INTEGER NOT NULL, " +
                COLUMN_NHAN_XET + " VARCHAR(100), " +
                "FOREIGN KEY (" + COLUMN_ID_THANHVIEN_DANHGIA + ") REFERENCES " + TABLE_THANHVIEN + "(" + COLUMN_ID_THANHVIEN + "), " +
                "FOREIGN KEY (" + COLUMN_ID_CHUYENXE_DANHGIA + ") REFERENCES " + TABLE_CHUYENXE + "(" + COLUMN_ID_CHUYENXE + "))";


        //Thuc thi query tao bang
        sqLiteDatabase.execSQL(createTable_quyen);
        sqLiteDatabase.execSQL(createTable_thanhvien);
        sqLiteDatabase.execSQL(createTable_loaixe);
        sqLiteDatabase.execSQL(createTable_chuyenxe);
        sqLiteDatabase.execSQL(createTable_vexe);
        sqLiteDatabase.execSQL(createTable_danhgia);

        // Thêm dữ liệu vào bảng table_quyen
        String insertQuyen1 = "INSERT INTO " + TABLE_QUYEN + " (" + COLUMN_TEN_QUYEN + ") VALUES ('Quản lý')";
        String insertQuyen2 = "INSERT INTO " + TABLE_QUYEN + " (" + COLUMN_TEN_QUYEN + ") VALUES ('Nhân Viên')";
        String insertQuyen3 = "INSERT INTO " + TABLE_QUYEN + " (" + COLUMN_TEN_QUYEN + ") VALUES ('Khách Hàng')";

        sqLiteDatabase.execSQL(insertQuyen1);
        sqLiteDatabase.execSQL(insertQuyen2);
        sqLiteDatabase.execSQL(insertQuyen3);

// Thêm dữ liệu vào bảng table_thanhvien
        String insertThanhVien1 = "INSERT INTO " + TABLE_THANHVIEN + " (" +
                COLUMN_TEN_DANG_NHAP + ", " + COLUMN_MAT_KHAU + ", " + COLUMN_ID_QUYEN_THANHVIEN + ", " +
                COLUMN_SO_DIEN_THOAI + ") VALUES ('thaigiavuong', 'admin', 1, '0123456789')";
        String insertThanhVien2 = "INSERT INTO " + TABLE_THANHVIEN + " (" +
                COLUMN_TEN_DANG_NHAP + ", " + COLUMN_MAT_KHAU + ", " + COLUMN_ID_QUYEN_THANHVIEN + ", " +
                COLUMN_SO_DIEN_THOAI + ") VALUES ('dinhtanhuy', 'admin', 1, '9876543210')";
        String insertThanhVien3 = "INSERT INTO " + TABLE_THANHVIEN + " (" +
                COLUMN_TEN_DANG_NHAP + ", " + COLUMN_MAT_KHAU + ", " + COLUMN_ID_QUYEN_THANHVIEN + ", " +
                COLUMN_SO_DIEN_THOAI + ") VALUES ('dangtrungminh', 'admin', 1, '111222333')";
        String insertThanhVien4 = "INSERT INTO " + TABLE_THANHVIEN + " (" +
                COLUMN_TEN_DANG_NHAP + ", " + COLUMN_MAT_KHAU + ", " + COLUMN_ID_QUYEN_THANHVIEN + ", " +
                COLUMN_SO_DIEN_THOAI + ") VALUES ('khachhang', 'khachhang', 3, '111222333')";
        String insertThanhVien5 = "INSERT INTO " + TABLE_THANHVIEN + " (" +
                COLUMN_TEN_DANG_NHAP + ", " + COLUMN_MAT_KHAU + ", " + COLUMN_ID_QUYEN_THANHVIEN + ", " +
                COLUMN_SO_DIEN_THOAI + ") VALUES ('nhanvien', 'nhanvien', 2, '111222333')";

        sqLiteDatabase.execSQL(insertThanhVien1);
        sqLiteDatabase.execSQL(insertThanhVien2);
        sqLiteDatabase.execSQL(insertThanhVien3);
        sqLiteDatabase.execSQL(insertThanhVien4);
        sqLiteDatabase.execSQL(insertThanhVien5);

// Thêm dữ liệu vào bảng table_loaixe
        String insertLoaiXe1 = "INSERT INTO " + TABLE_LOAIXE + " (" +
                COLUMN_TEN_LOAIXE + ", " + COLUMN_SO_LUONG_GHE + ") VALUES ('Xe 5 chỗ', 5)";
        String insertLoaiXe2 = "INSERT INTO " + TABLE_LOAIXE + " (" +
                COLUMN_TEN_LOAIXE + ", " + COLUMN_SO_LUONG_GHE + ") VALUES ('Xe 7 chỗ', 7)";
        String insertLoaiXe3 = "INSERT INTO " + TABLE_LOAIXE + " (" +
                COLUMN_TEN_LOAIXE + ", " + COLUMN_SO_LUONG_GHE + ") VALUES ('Xe 30 chỗ', 30)";

        sqLiteDatabase.execSQL(insertLoaiXe1);
        sqLiteDatabase.execSQL(insertLoaiXe2);
        sqLiteDatabase.execSQL(insertLoaiXe3);

// Thêm dữ liệu vào bảng table_chuyenxe
        String insertChuyenXe1 = "INSERT INTO " + TABLE_CHUYENXE + " (" +
                COLUMN_TEN_CHUYEN + ", " + COLUMN_THOI_GIAN_BAT_DAU + ", " + COLUMN_DIA_DIEM_DI + ", " +
                COLUMN_DIA_DIEM_DEN + ") VALUES ('Hà Nội - Sài Gòn', '2023-07-03 10:00:00', 'Hà Nội', 'Sài Gòn')";
        String insertChuyenXe2 = "INSERT INTO " + TABLE_CHUYENXE + " (" +
                COLUMN_TEN_CHUYEN + ", " + COLUMN_THOI_GIAN_BAT_DAU + ", " + COLUMN_DIA_DIEM_DI + ", " +
                COLUMN_DIA_DIEM_DEN + ") VALUES ('Bình Định - Gia Lai', '2023-07-04 09:30:00', 'Bình Định', 'Gia Lai')";
        String insertChuyenXe3 = "INSERT INTO " + TABLE_CHUYENXE + " (" +
                COLUMN_TEN_CHUYEN + ", " + COLUMN_THOI_GIAN_BAT_DAU + ", " + COLUMN_DIA_DIEM_DI + ", " +
                COLUMN_DIA_DIEM_DEN + ") VALUES ('Sài Gòn - Hà Nội', '2023-07-05 11:15:00', 'Sài Gòn', 'Hà Nội')";

        sqLiteDatabase.execSQL(insertChuyenXe1);
        sqLiteDatabase.execSQL(insertChuyenXe2);
        sqLiteDatabase.execSQL(insertChuyenXe3);

// Thêm dữ liệu vào bảng table_vexe
        String insertVeXe1 = "INSERT INTO " + TABLE_VEXE + " (" +
                COLUMN_ID_THANHVIEN_VEXE + ", " + COLUMN_ID_LOAIXE_VEXE + ", " + COLUMN_ID_CHUYENXE_VEXE + ", " +
                COLUMN_NGAY_GIO_DAT + ", " + COLUMN_THONG_TIN_KHAC + ") VALUES (1, 1, 1, '2023-07-03 08:00:00', 'Thông tin 1')";
        String insertVeXe2 = "INSERT INTO " + TABLE_VEXE + " (" +
                COLUMN_ID_THANHVIEN_VEXE + ", " + COLUMN_ID_LOAIXE_VEXE + ", " + COLUMN_ID_CHUYENXE_VEXE + ", " +
                COLUMN_NGAY_GIO_DAT + ", " + COLUMN_THONG_TIN_KHAC + ") VALUES (2, 2, 2, '2023-07-04 07:30:00', 'Thông tin 2')";
        String insertVeXe3 = "INSERT INTO " + TABLE_VEXE + " (" +
                COLUMN_ID_THANHVIEN_VEXE + ", " + COLUMN_ID_LOAIXE_VEXE + ", " + COLUMN_ID_CHUYENXE_VEXE + ", " +
                COLUMN_NGAY_GIO_DAT + ", " + COLUMN_THONG_TIN_KHAC + ") VALUES (3, 3, 3, '2023-07-05 09:45:00', 'Thông tin 3')";

        sqLiteDatabase.execSQL(insertVeXe1);
        sqLiteDatabase.execSQL(insertVeXe2);
        sqLiteDatabase.execSQL(insertVeXe3);

// Thêm dữ liệu vào bảng table_danhgia
        String insertDanhGia1 = "INSERT INTO " + TABLE_DANHGIA + " (" +
                COLUMN_ID_THANHVIEN_DANHGIA + ", " + COLUMN_ID_CHUYENXE_DANHGIA + ", " +
                COLUMN_DIEM_DANH_GIA + ", " + COLUMN_NHAN_XET + ") VALUES (1, 1, 4, 'Nhận xét 1')";
        String insertDanhGia2 = "INSERT INTO " + TABLE_DANHGIA + " (" +
                COLUMN_ID_THANHVIEN_DANHGIA + ", " + COLUMN_ID_CHUYENXE_DANHGIA + ", " +
                COLUMN_DIEM_DANH_GIA + ", " + COLUMN_NHAN_XET + ") VALUES (2, 2, 5, 'Nhận xét 2')";
        String insertDanhGia3 = "INSERT INTO " + TABLE_DANHGIA + " (" +
                COLUMN_ID_THANHVIEN_DANHGIA + ", " + COLUMN_ID_CHUYENXE_DANHGIA + ", " +
                COLUMN_DIEM_DANH_GIA + ", " + COLUMN_NHAN_XET + ") VALUES (3, 3, 3, 'Nhận xét 3')";

        sqLiteDatabase.execSQL(insertDanhGia1);
        sqLiteDatabase.execSQL(insertDanhGia2);
        sqLiteDatabase.execSQL(insertDanhGia3);

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
