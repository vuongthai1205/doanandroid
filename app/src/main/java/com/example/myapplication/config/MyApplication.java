package com.example.myapplication.config;

import android.app.Application;

import androidx.room.Room;


import com.google.firebase.FirebaseApp;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.model.DAO.ChuyenXeDAO;
import com.example.myapplication.model.DAO.LoaiXeDAO;
import com.example.myapplication.model.DAO.QuyenDao;
import com.example.myapplication.model.DAO.ThanhVienDAO;
import com.example.myapplication.model.LoaiXe;
import com.example.myapplication.model.Quyen;
import com.example.myapplication.model.ThanhVien;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());


        FirebaseApp.initializeApp(getApplicationContext());




//        ThanhVienDAO thanhVienDAO = AppDatabase.getInstance(getApplicationContext()).getThanhVienDAO();
//        QuyenDao quyenDao = AppDatabase.getInstance(getApplicationContext()).getQuyenDAO();
//        Quyen q1 = new Quyen("ROLE_ADMIN");
//        Quyen q2 = new Quyen("ROLE_MEMBER");
//        Quyen q3 = new Quyen("ROLE_CUSTOMER");
//
//        quyenDao.insert(q1,q2,q3);
//        ThanhVien t1 = new ThanhVien("thaigiavuong", "giavuong.1205@gmail.com");
//        t1.setMatKhau("admin");
//        t1.setSoDienThoai("0912309812");
//        t1.setIdQuyenThanhVien(1);
//
//        ThanhVien t2 = new ThanhVien("dinhtanhuy", "dinhtanhuy@gmail.com");
//        t2.setMatKhau("admin");
//        t2.setSoDienThoai("12345678");
//        t2.setIdQuyenThanhVien(1);
//
//        ThanhVien t3 = new ThanhVien("dangtrungminh", "dangtrungminh@gmail.com");
//        t3.setMatKhau("admin");
//        t3.setSoDienThoai("876543212");
//        t3.setIdQuyenThanhVien(1);
//
//        ThanhVien t4 = new ThanhVien("khachhang", "khachhang.1205@gmail.com");
//        t4.setMatKhau("khachhang");
//        t4.setSoDienThoai("908734098");
//        t4.setIdQuyenThanhVien(3);
//
//        ThanhVien t5 = new ThanhVien("nhanvien", "nhanvien@gmail.com");
//        t5.setMatKhau("nhanvien");
//        t5.setSoDienThoai("1230948029");
//        t5.setIdQuyenThanhVien(2);
//
//
//
//        thanhVienDAO.insertAll(t1,t2,t3,t4,t5);
//        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(getApplicationContext()).getChuyenXeDAO();
//        LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(getApplicationContext()).getLoaiXeDAO();
//        LoaiXe loaiXe1 = new LoaiXe("Ford Transit",16);
//        LoaiXe loaiXe2 = new LoaiXe("Thaco Kinglong",35);
//        LoaiXe loaiXe3 = new LoaiXe("Mercedes Sprinter Limousine",16);
//        loaiXeDAO.insert(loaiXe1,loaiXe2,loaiXe3);
//
//
//        ChuyenXe chuyenXe1 = new ChuyenXe("TP.Hồ Chí Minh - TP.Nha Trang","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe1.setIdLoaiXe(1);
//        ChuyenXe chuyenXe2 = new ChuyenXe("TP.Hồ Chí Minh - TP.Cần Thơ","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe2.setIdLoaiXe(2);
//        ChuyenXe chuyenXe3 = new ChuyenXe("TP.Hồ Chí Minh - Tây Ninh","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe3.setIdLoaiXe(3);
//        ChuyenXe chuyenXe4 = new ChuyenXe("TP.Hồ Chí Minh - TP.Gia Nghĩa","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe4.setIdLoaiXe(3);
//
//        chuyenXeDAO.insert(chuyenXe1,chuyenXe2,chuyenXe3,chuyenXe4);

    }

}
