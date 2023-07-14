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

@Database(version = 2,
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
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Thêm dữ liệu vào bảng table_quyen
            String insertQuyen1 = "INSERT INTO " + VariableGlobal.TABLE_QUYEN + " (" + VariableGlobal.COLUMN_TEN_QUYEN + ") VALUES ('ROLE_ADMIN')";
            String insertQuyen2 = "INSERT INTO " + VariableGlobal.TABLE_QUYEN + " (" + VariableGlobal.COLUMN_TEN_QUYEN + ") VALUES ('ROLE_MEMBER')";
            String insertQuyen3 = "INSERT INTO " + VariableGlobal.TABLE_QUYEN + " (" + VariableGlobal.COLUMN_TEN_QUYEN + ") VALUES ('ROLE_CUSTOMER')";

            database.execSQL(insertQuyen1);
            database.execSQL(insertQuyen2);
            database.execSQL(insertQuyen3);

// Thêm dữ liệu vào bảng table_thanhvien
            String insertThanhVien1 = "INSERT INTO " + VariableGlobal.TABLE_THANHVIEN + " (" +
                    VariableGlobal.COLUMN_TEN_DANG_NHAP + ", " + VariableGlobal.COLUMN_MAT_KHAU + ", " + VariableGlobal.COLUMN_ID_QUYEN_THANHVIEN + ", " +
                    VariableGlobal.COLUMN_SO_DIEN_THOAI +", " + VariableGlobal.COLUMN_EMAIL + ") VALUES ('thaigiavuong', 'admin', 1, '0123456789', 'giavuong.1205@gmail.com')";
            String insertThanhVien2 = "INSERT INTO " + VariableGlobal.TABLE_THANHVIEN + " (" +
                    VariableGlobal.COLUMN_TEN_DANG_NHAP + ", " + VariableGlobal.COLUMN_MAT_KHAU + ", " + VariableGlobal.COLUMN_ID_QUYEN_THANHVIEN + ", " +
                    VariableGlobal.COLUMN_SO_DIEN_THOAI +", " + VariableGlobal.COLUMN_EMAIL + ") VALUES ('dinhtanhuy', 'admin', 1, '9876543210', 'dinhtanhuy@gmail.com')";
            String insertThanhVien3 = "INSERT INTO " + VariableGlobal.TABLE_THANHVIEN + " (" +
                    VariableGlobal.COLUMN_TEN_DANG_NHAP + ", " + VariableGlobal.COLUMN_MAT_KHAU + ", " + VariableGlobal.COLUMN_ID_QUYEN_THANHVIEN + ", " +
                    VariableGlobal.COLUMN_SO_DIEN_THOAI +", " + VariableGlobal.COLUMN_EMAIL + ") VALUES ('dangtrungminh', 'admin', 1, '111222333', 'dangtrungminh@gmail.com')";
            String insertThanhVien4 = "INSERT INTO " + VariableGlobal.TABLE_THANHVIEN + " (" +
                    VariableGlobal.COLUMN_TEN_DANG_NHAP + ", " + VariableGlobal.COLUMN_MAT_KHAU + ", " + VariableGlobal.COLUMN_ID_QUYEN_THANHVIEN + ", " +
                    VariableGlobal.COLUMN_SO_DIEN_THOAI + ") VALUES ('khachhang', 'khachhang', 3, '123')";
            String insertThanhVien5 = "INSERT INTO " + VariableGlobal.TABLE_THANHVIEN + " (" +
                    VariableGlobal.COLUMN_TEN_DANG_NHAP + ", " + VariableGlobal.COLUMN_MAT_KHAU + ", " + VariableGlobal.COLUMN_ID_QUYEN_THANHVIEN + ", " +
                    VariableGlobal.COLUMN_SO_DIEN_THOAI + ") VALUES ('nhanvien', 'nhanvien', 2, '1234')";

            database.execSQL(insertThanhVien1);
            database.execSQL(insertThanhVien2);
            database.execSQL(insertThanhVien3);
            database.execSQL(insertThanhVien4);
            database.execSQL(insertThanhVien5);
        }
    };
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "doanandroid.db")
                    .allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return instance;
    }
}
