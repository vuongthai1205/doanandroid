package com.example.myapplication.config;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "doanandroid.db";
    private static final int DATABASE_VERSION = 6;
    // Tạo các hằng số cho tên bảng
    private final String TABLE_QUYEN = "table_quyen";
    private final String TABLE_THANHVIEN = "table_thanhvien";
    private final String TABLE_LOAIXE = "table_loaixe";
    private final String TABLE_CHUYENXE = "table_chuyenxe";
    private final String TABLE_VEXE = "table_vexe";
    private final String TABLE_DANHGIA = "table_danhgia";

    // Tạo các hằng số cho tên cột
    private final String COLUMN_ID_QUYEN = "id_quyen";
    private final String COLUMN_TEN_QUYEN = "ten_quyen";

    private final String COLUMN_ID_THANHVIEN = "id_thanh_vien";
    private final String COLUMN_TEN_DANG_NHAP = "ten_dang_nhap";
    private final String COLUMN_HO = "ho_thanh_vien";
    private final String COLUMN_TEN = "ten_thanh_vien";
    private final String COLUMN_MAT_KHAU = "mat_khau";
    private final String COLUMN_AVATAR = "avatar";
    private final String COLUMN_ID_QUYEN_THANHVIEN = "id_quyen";
    private final String COLUMN_EMAIL = "email";
    private final String COLUMN_SO_DIEN_THOAI = "so_dien_thoai";
    private final String COLUMN_NGAY_TAO = "ngay_tao";
    private final String COLUMN_NGAY_CAP_NHAT = "ngay_cap_nhat";

    private final String COLUMN_ID_LOAIXE = "id_loai_xe";
    private final String COLUMN_TEN_LOAIXE = "ten_loai_xe";
    private final String COLUMN_SO_LUONG_GHE = "so_luong_ghe";

    private final String COLUMN_ID_CHUYENXE = "id_chuyen_xe";
    private final String COLUMN_TEN_CHUYEN = "ten_chuyen";
    private final String COLUMN_HINH_ANH = "hinh_anh";
    private final String COLUMN_THOI_GIAN_BAT_DAU = "thoi_gian_bat_dau";
    private final String COLUMN_DIA_DIEM_DI = "dia_diem_di";
    private final String COLUMN_DIA_DIEM_DEN = "dia_diem_den";

    private final String COLUMN_ID_VEXE = "id_ve_xe";
    private final String COLUMN_ID_THANHVIEN_VEXE = "id_thanh_vien";
    private final String COLUMN_ID_LOAIXE_VEXE = "id_loai_xe";
    private final String COLUMN_ID_CHUYENXE_VEXE = "id_chuyen_xe";
    private final String COLUMN_NGAY_GIO_DAT = "ngay_gio_dat";
    private final String COLUMN_THONG_TIN_KHAC = "thong_tin_khac";

    private final String COLUMN_ID_DANHGIA = "id_danh_gia";
    private final String COLUMN_ID_THANHVIEN_DANHGIA = "id_thanh_vien";
    private final String COLUMN_ID_CHUYENXE_DANHGIA = "id_chuyen_xe";
    private final String COLUMN_DIEM_DANH_GIA = "diem_danh_gia";
    private final String COLUMN_NHAN_XET = "nhan_xet";


    public DatabaseHelper(Context context){
        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Query tao bang trong databse

        // Tạo các biến cho câu lệnh tạo bảng
        String createTable_quyen = "CREATE TABLE " + getTABLE_QUYEN() + " (" +
                getCOLUMN_ID_QUYEN() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                getCOLUMN_TEN_QUYEN() + " VARCHAR(50) NOT NULL)";

        String createTable_thanhvien = "CREATE TABLE " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_ID_THANHVIEN() + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                getCOLUMN_TEN_DANG_NHAP() + " VARCHAR(100) NOT NULL, " +
                getCOLUMN_HO() + " VARCHAR(30) ," +
                getCOLUMN_TEN() + " VARCHAR(30) ," +
                getCOLUMN_MAT_KHAU() + " VARCHAR(50) NOT NULL, " +
                getCOLUMN_AVATAR() + " VARCHAR(100), " +
                getCOLUMN_ID_QUYEN_THANHVIEN() + " INTEGER NOT NULL, " +
                getCOLUMN_EMAIL() + " VARCHAR(50), " +
                getCOLUMN_SO_DIEN_THOAI() + " VARCHAR(12) NOT NULL, " +
                getCOLUMN_NGAY_TAO() + " DATETIME, " +
                getCOLUMN_NGAY_CAP_NHAT() + " DATETIME, " +
                "FOREIGN KEY (" + getCOLUMN_ID_QUYEN_THANHVIEN() + ") REFERENCES " + getTABLE_QUYEN() + "(" + getCOLUMN_ID_QUYEN() + "))";

        String createTable_loaixe = "CREATE TABLE " + getTABLE_LOAIXE() + "(" +
                getCOLUMN_ID_LOAIXE() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                getCOLUMN_TEN_LOAIXE() + " VARCHAR(50) NOT NULL, " +
                getCOLUMN_SO_LUONG_GHE() + " INTEGER NOT NULL)";

        String createTable_chuyenxe = "CREATE TABLE " + getTABLE_CHUYENXE() + "(" +
                getCOLUMN_ID_CHUYENXE() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                getCOLUMN_TEN_CHUYEN() + " VARCHAR(50) NOT NULL, " +
                getCOLUMN_HINH_ANH() + " VARCHAR(100)," +
                getCOLUMN_THOI_GIAN_BAT_DAU() + " DATETIME, " +
                getCOLUMN_DIA_DIEM_DI() + " VARCHAR(50), " +
                getCOLUMN_DIA_DIEM_DEN() + " VARCHAR(50))";

        String createTable_vexe = "CREATE TABLE " + getTABLE_VEXE() + "(" +
                getCOLUMN_ID_VEXE() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                getCOLUMN_ID_THANHVIEN_VEXE() + " INTEGER NOT NULL, " +
                getCOLUMN_ID_LOAIXE_VEXE() + " INTEGER NOT NULL, " +
                getCOLUMN_ID_CHUYENXE_VEXE() + " INTEGER NOT NULL, " +
                getCOLUMN_NGAY_GIO_DAT() + " DATETIME, " +
                getCOLUMN_THONG_TIN_KHAC() + " VARCHAR(100), " +
                "FOREIGN KEY (" + getCOLUMN_ID_THANHVIEN_VEXE() + ") REFERENCES " + getTABLE_THANHVIEN() + "(" + getCOLUMN_ID_THANHVIEN() + "), " +
                "FOREIGN KEY (" + getCOLUMN_ID_LOAIXE_VEXE() + ") REFERENCES " + getTABLE_LOAIXE() + "(" + getCOLUMN_ID_LOAIXE() + "), " +
                "FOREIGN KEY (" + getCOLUMN_ID_CHUYENXE_VEXE() + ") REFERENCES " + getTABLE_CHUYENXE() + "(" + getCOLUMN_ID_CHUYENXE() + "))";

        String createTable_danhgia = "CREATE TABLE " + getTABLE_DANHGIA() + "(" +
                getCOLUMN_ID_DANHGIA() + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                getCOLUMN_ID_THANHVIEN_DANHGIA() + " INTEGER NOT NULL, " +
                getCOLUMN_ID_CHUYENXE_DANHGIA() + " INTEGER NOT NULL, " +
                getCOLUMN_DIEM_DANH_GIA() + " INTEGER NOT NULL, " +
                getCOLUMN_NHAN_XET() + " VARCHAR(100), " +
                "FOREIGN KEY (" + getCOLUMN_ID_THANHVIEN_DANHGIA() + ") REFERENCES " + getTABLE_THANHVIEN() + "(" + getCOLUMN_ID_THANHVIEN() + "), " +
                "FOREIGN KEY (" + getCOLUMN_ID_CHUYENXE_DANHGIA() + ") REFERENCES " + getTABLE_CHUYENXE() + "(" + getCOLUMN_ID_CHUYENXE() + "))";


        //Thuc thi query tao bang
        sqLiteDatabase.execSQL(createTable_quyen);
        sqLiteDatabase.execSQL(createTable_thanhvien);
        sqLiteDatabase.execSQL(createTable_loaixe);
        sqLiteDatabase.execSQL(createTable_chuyenxe);
        sqLiteDatabase.execSQL(createTable_vexe);
        sqLiteDatabase.execSQL(createTable_danhgia);

        // Thêm dữ liệu vào bảng table_quyen
        String insertQuyen1 = "INSERT INTO " + getTABLE_QUYEN() + " (" + getCOLUMN_TEN_QUYEN() + ") VALUES ('Quản lý')";
        String insertQuyen2 = "INSERT INTO " + getTABLE_QUYEN() + " (" + getCOLUMN_TEN_QUYEN() + ") VALUES ('Nhân Viên')";
        String insertQuyen3 = "INSERT INTO " + getTABLE_QUYEN() + " (" + getCOLUMN_TEN_QUYEN() + ") VALUES ('Khách Hàng')";

        sqLiteDatabase.execSQL(insertQuyen1);
        sqLiteDatabase.execSQL(insertQuyen2);
        sqLiteDatabase.execSQL(insertQuyen3);

// Thêm dữ liệu vào bảng table_thanhvien
        String insertThanhVien1 = "INSERT INTO " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_TEN_DANG_NHAP() + ", " + getCOLUMN_MAT_KHAU() + ", " + getCOLUMN_ID_QUYEN_THANHVIEN() + ", " +
                getCOLUMN_SO_DIEN_THOAI() +", " + getCOLUMN_EMAIL() + ") VALUES ('thaigiavuong', 'admin', 1, '0123456789', 'giavuong.1205@gmail.com')";
        String insertThanhVien2 = "INSERT INTO " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_TEN_DANG_NHAP() + ", " + getCOLUMN_MAT_KHAU() + ", " + getCOLUMN_ID_QUYEN_THANHVIEN() + ", " +
                getCOLUMN_SO_DIEN_THOAI() +", " + getCOLUMN_EMAIL() + ") VALUES ('dinhtanhuy', 'admin', 1, '9876543210', 'dinhtanhuy@gmail.com')";
        String insertThanhVien3 = "INSERT INTO " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_TEN_DANG_NHAP() + ", " + getCOLUMN_MAT_KHAU() + ", " + getCOLUMN_ID_QUYEN_THANHVIEN() + ", " +
                getCOLUMN_SO_DIEN_THOAI() +", " + getCOLUMN_EMAIL() + ") VALUES ('dangtrungminh', 'admin', 1, '111222333', 'dangtrungminh@gmail.com')";
        String insertThanhVien4 = "INSERT INTO " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_TEN_DANG_NHAP() + ", " + getCOLUMN_MAT_KHAU() + ", " + getCOLUMN_ID_QUYEN_THANHVIEN() + ", " +
                getCOLUMN_SO_DIEN_THOAI() + ") VALUES ('khachhang', 'khachhang', 3, '111222333')";
        String insertThanhVien5 = "INSERT INTO " + getTABLE_THANHVIEN() + " (" +
                getCOLUMN_TEN_DANG_NHAP() + ", " + getCOLUMN_MAT_KHAU() + ", " + getCOLUMN_ID_QUYEN_THANHVIEN() + ", " +
                getCOLUMN_SO_DIEN_THOAI() + ") VALUES ('nhanvien', 'nhanvien', 2, '111222333')";

        sqLiteDatabase.execSQL(insertThanhVien1);
        sqLiteDatabase.execSQL(insertThanhVien2);
        sqLiteDatabase.execSQL(insertThanhVien3);
        sqLiteDatabase.execSQL(insertThanhVien4);
        sqLiteDatabase.execSQL(insertThanhVien5);


// Thêm dữ liệu vào bảng table_loaixe
        String insertLoaiXe1 = "INSERT INTO " + getTABLE_LOAIXE() + " (" +
                getCOLUMN_TEN_LOAIXE() + ", " + getCOLUMN_SO_LUONG_GHE() + ") VALUES ('Xe 5 chỗ', 5)";
        String insertLoaiXe2 = "INSERT INTO " + getTABLE_LOAIXE() + " (" +
                getCOLUMN_TEN_LOAIXE() + ", " + getCOLUMN_SO_LUONG_GHE() + ") VALUES ('Xe 7 chỗ', 7)";
        String insertLoaiXe3 = "INSERT INTO " + getTABLE_LOAIXE() + " (" +
                getCOLUMN_TEN_LOAIXE() + ", " + getCOLUMN_SO_LUONG_GHE() + ") VALUES ('Xe 30 chỗ', 30)";

        sqLiteDatabase.execSQL(insertLoaiXe1);
        sqLiteDatabase.execSQL(insertLoaiXe2);
        sqLiteDatabase.execSQL(insertLoaiXe3);

// Thêm dữ liệu vào bảng table_chuyenxe
        String insertChuyenXe1 = "INSERT INTO " + getTABLE_CHUYENXE() + " (" +
                getCOLUMN_TEN_CHUYEN() + ", " + getCOLUMN_THOI_GIAN_BAT_DAU() + ", " + getCOLUMN_DIA_DIEM_DI() + ", " +
                getCOLUMN_DIA_DIEM_DEN() + ") VALUES ('Hà Nội - Sài Gòn', '2023-07-03 10:00:00', 'Hà Nội', 'Sài Gòn')";
        String insertChuyenXe2 = "INSERT INTO " + getTABLE_CHUYENXE() + " (" +
                getCOLUMN_TEN_CHUYEN() + ", " + getCOLUMN_THOI_GIAN_BAT_DAU() + ", " + getCOLUMN_DIA_DIEM_DI() + ", " +
                getCOLUMN_DIA_DIEM_DEN() + ") VALUES ('Bình Định - Gia Lai', '2023-07-04 09:30:00', 'Bình Định', 'Gia Lai')";
        String insertChuyenXe3 = "INSERT INTO " + getTABLE_CHUYENXE() + " (" +
                getCOLUMN_TEN_CHUYEN() + ", " + getCOLUMN_THOI_GIAN_BAT_DAU() + ", " + getCOLUMN_DIA_DIEM_DI() + ", " +
                getCOLUMN_DIA_DIEM_DEN() + ") VALUES ('Sài Gòn - Hà Nội', '2023-07-05 11:15:00', 'Sài Gòn', 'Hà Nội')";

        sqLiteDatabase.execSQL(insertChuyenXe1);
        sqLiteDatabase.execSQL(insertChuyenXe2);
        sqLiteDatabase.execSQL(insertChuyenXe3);

// Thêm dữ liệu vào bảng table_vexe
        String insertVeXe1 = "INSERT INTO " + getTABLE_VEXE() + " (" +
                getCOLUMN_ID_THANHVIEN_VEXE() + ", " + getCOLUMN_ID_LOAIXE_VEXE() + ", " + getCOLUMN_ID_CHUYENXE_VEXE() + ", " +
                getCOLUMN_NGAY_GIO_DAT() + ", " + getCOLUMN_THONG_TIN_KHAC() + ") VALUES (1, 1, 1, '2023-07-03 08:00:00', 'Thông tin 1')";
        String insertVeXe2 = "INSERT INTO " + getTABLE_VEXE() + " (" +
                getCOLUMN_ID_THANHVIEN_VEXE() + ", " + getCOLUMN_ID_LOAIXE_VEXE() + ", " + getCOLUMN_ID_CHUYENXE_VEXE() + ", " +
                getCOLUMN_NGAY_GIO_DAT() + ", " + getCOLUMN_THONG_TIN_KHAC() + ") VALUES (2, 2, 2, '2023-07-04 07:30:00', 'Thông tin 2')";
        String insertVeXe3 = "INSERT INTO " + getTABLE_VEXE() + " (" +
                getCOLUMN_ID_THANHVIEN_VEXE() + ", " + getCOLUMN_ID_LOAIXE_VEXE() + ", " + getCOLUMN_ID_CHUYENXE_VEXE() + ", " +
                getCOLUMN_NGAY_GIO_DAT() + ", " + getCOLUMN_THONG_TIN_KHAC() + ") VALUES (3, 3, 3, '2023-07-05 09:45:00', 'Thông tin 3')";

        sqLiteDatabase.execSQL(insertVeXe1);
        sqLiteDatabase.execSQL(insertVeXe2);
        sqLiteDatabase.execSQL(insertVeXe3);

// Thêm dữ liệu vào bảng table_danhgia
        String insertDanhGia1 = "INSERT INTO " + getTABLE_DANHGIA() + " (" +
                getCOLUMN_ID_THANHVIEN_DANHGIA() + ", " + getCOLUMN_ID_CHUYENXE_DANHGIA() + ", " +
                getCOLUMN_DIEM_DANH_GIA() + ", " + getCOLUMN_NHAN_XET() + ") VALUES (1, 1, 4, 'Nhận xét 1')";
        String insertDanhGia2 = "INSERT INTO " + getTABLE_DANHGIA() + " (" +
                getCOLUMN_ID_THANHVIEN_DANHGIA() + ", " + getCOLUMN_ID_CHUYENXE_DANHGIA() + ", " +
                getCOLUMN_DIEM_DANH_GIA() + ", " + getCOLUMN_NHAN_XET() + ") VALUES (2, 2, 5, 'Nhận xét 2')";
        String insertDanhGia3 = "INSERT INTO " + getTABLE_DANHGIA() + " (" +
                getCOLUMN_ID_THANHVIEN_DANHGIA() + ", " + getCOLUMN_ID_CHUYENXE_DANHGIA() + ", " +
                getCOLUMN_DIEM_DANH_GIA() + ", " + getCOLUMN_NHAN_XET() + ") VALUES (3, 3, 3, 'Nhận xét 3')";

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

    @Override
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public String getTABLE_QUYEN() {
        return TABLE_QUYEN;
    }

    public String getTABLE_THANHVIEN() {
        return TABLE_THANHVIEN;
    }

    public String getTABLE_LOAIXE() {
        return TABLE_LOAIXE;
    }

    public String getTABLE_CHUYENXE() {
        return TABLE_CHUYENXE;
    }

    public String getTABLE_VEXE() {
        return TABLE_VEXE;
    }

    public String getTABLE_DANHGIA() {
        return TABLE_DANHGIA;
    }

    public String getCOLUMN_ID_QUYEN() {
        return COLUMN_ID_QUYEN;
    }

    public String getCOLUMN_TEN_QUYEN() {
        return COLUMN_TEN_QUYEN;
    }

    public String getCOLUMN_ID_THANHVIEN() {
        return COLUMN_ID_THANHVIEN;
    }

    public String getCOLUMN_TEN_DANG_NHAP() {
        return COLUMN_TEN_DANG_NHAP;
    }

    public String getCOLUMN_HO() {
        return COLUMN_HO;
    }

    public String getCOLUMN_TEN() {
        return COLUMN_TEN;
    }

    public String getCOLUMN_MAT_KHAU() {
        return COLUMN_MAT_KHAU;
    }

    public String getCOLUMN_AVATAR() {
        return COLUMN_AVATAR;
    }

    public String getCOLUMN_ID_QUYEN_THANHVIEN() {
        return COLUMN_ID_QUYEN_THANHVIEN;
    }

    public String getCOLUMN_EMAIL() {
        return COLUMN_EMAIL;
    }

    public String getCOLUMN_SO_DIEN_THOAI() {
        return COLUMN_SO_DIEN_THOAI;
    }

    public String getCOLUMN_NGAY_TAO() {
        return COLUMN_NGAY_TAO;
    }

    public String getCOLUMN_NGAY_CAP_NHAT() {
        return COLUMN_NGAY_CAP_NHAT;
    }

    public String getCOLUMN_ID_LOAIXE() {
        return COLUMN_ID_LOAIXE;
    }

    public String getCOLUMN_TEN_LOAIXE() {
        return COLUMN_TEN_LOAIXE;
    }

    public String getCOLUMN_SO_LUONG_GHE() {
        return COLUMN_SO_LUONG_GHE;
    }

    public String getCOLUMN_ID_CHUYENXE() {
        return COLUMN_ID_CHUYENXE;
    }

    public String getCOLUMN_TEN_CHUYEN() {
        return COLUMN_TEN_CHUYEN;
    }

    public String getCOLUMN_HINH_ANH() {
        return COLUMN_HINH_ANH;
    }

    public String getCOLUMN_THOI_GIAN_BAT_DAU() {
        return COLUMN_THOI_GIAN_BAT_DAU;
    }

    public String getCOLUMN_DIA_DIEM_DI() {
        return COLUMN_DIA_DIEM_DI;
    }

    public String getCOLUMN_DIA_DIEM_DEN() {
        return COLUMN_DIA_DIEM_DEN;
    }

    public String getCOLUMN_ID_VEXE() {
        return COLUMN_ID_VEXE;
    }

    public String getCOLUMN_ID_THANHVIEN_VEXE() {
        return COLUMN_ID_THANHVIEN_VEXE;
    }

    public String getCOLUMN_ID_LOAIXE_VEXE() {
        return COLUMN_ID_LOAIXE_VEXE;
    }

    public String getCOLUMN_ID_CHUYENXE_VEXE() {
        return COLUMN_ID_CHUYENXE_VEXE;
    }

    public String getCOLUMN_NGAY_GIO_DAT() {
        return COLUMN_NGAY_GIO_DAT;
    }

    public String getCOLUMN_THONG_TIN_KHAC() {
        return COLUMN_THONG_TIN_KHAC;
    }

    public String getCOLUMN_ID_DANHGIA() {
        return COLUMN_ID_DANHGIA;
    }

    public String getCOLUMN_ID_THANHVIEN_DANHGIA() {
        return COLUMN_ID_THANHVIEN_DANHGIA;
    }

    public String getCOLUMN_ID_CHUYENXE_DANHGIA() {
        return COLUMN_ID_CHUYENXE_DANHGIA;
    }

    public String getCOLUMN_DIEM_DANH_GIA() {
        return COLUMN_DIEM_DANH_GIA;
    }

    public String getCOLUMN_NHAN_XET() {
        return COLUMN_NHAN_XET;
    }
}
