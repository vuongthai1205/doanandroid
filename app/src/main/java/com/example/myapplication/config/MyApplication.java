package com.example.myapplication.config;

import android.app.Application;

import com.google.firebase.FirebaseApp;


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
//        t1.setAvatar("https://f9-zpcloud.zdn.vn/9192093310976170948/a4fd78baa13c7062292d.jpg");
//
//        ThanhVien t2 = new ThanhVien("dinhtanhuy", "dinhtanhuy@gmail.com");
//        t2.setMatKhau("admin");
//        t2.setSoDienThoai("12345678");
//        t2.setIdQuyenThanhVien(1);
//        t2.setAvatar("https://f9-zpcloud.zdn.vn/9192093310976170948/a4fd78baa13c7062292d.jpg");
//
//        ThanhVien t3 = new ThanhVien("dangtrungminh", "dangtrungminh@gmail.com");
//        t3.setMatKhau("admin");
//        t3.setSoDienThoai("876543212");
//        t3.setIdQuyenThanhVien(1);
//        t3.setAvatar("https://f9-zpcloud.zdn.vn/9192093310976170948/a4fd78baa13c7062292d.jpg");
//
//        ThanhVien t4 = new ThanhVien("khachhang", "khachhang.1205@gmail.com");
//        t4.setMatKhau("khachhang");
//        t4.setSoDienThoai("908734098");
//        t4.setIdQuyenThanhVien(3);
//        t4.setAvatar("https://f9-zpcloud.zdn.vn/9192093310976170948/a4fd78baa13c7062292d.jpg");
//
//        ThanhVien t5 = new ThanhVien("nhanvien", "nhanvien@gmail.com");
//        t5.setMatKhau("nhanvien");
//        t5.setSoDienThoai("1230948029");
//        t5.setIdQuyenThanhVien(2);
//        t5.setAvatar("https://f9-zpcloud.zdn.vn/3275679253552964365/8521a938356ce532bc7d.jpg");
//
//
//
//        thanhVienDAO.insertAll(t1,t2,t3,t4,t5);
//
//
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
//        chuyenXe1.setHinhAnh("https://firebasestorage.googleapis.com/v0/b/doanandroid-c9b13.appspot.com/o/xe_35_cho.jpg?alt=media&token=89119ebf-e6a8-4c0a-af7e-0b3fac672114");
//        ChuyenXe chuyenXe2 = new ChuyenXe("TP.Hồ Chí Minh - TP.Cần Thơ","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe2.setIdLoaiXe(2);
//        chuyenXe2.setHinhAnh("https://firebasestorage.googleapis.com/v0/b/doanandroid-c9b13.appspot.com/o/xe_35_cho.jpg?alt=media&token=89119ebf-e6a8-4c0a-af7e-0b3fac672114");
//        ChuyenXe chuyenXe3 = new ChuyenXe("TP.Hồ Chí Minh - Tây Ninh","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe3.setIdLoaiXe(3);
//        chuyenXe3.setHinhAnh("https://firebasestorage.googleapis.com/v0/b/doanandroid-c9b13.appspot.com/o/xe_35_cho.jpg?alt=media&token=89119ebf-e6a8-4c0a-af7e-0b3fac672114");
//        ChuyenXe chuyenXe4 = new ChuyenXe("TP.Hồ Chí Minh - TP.Gia Nghĩa","null","8h00","12h00","27/02/2023","28/02/2023","Bến xe Miền Đông","Bến xe Nha Trang",500000.00,"mô tả");
//        chuyenXe4.setIdLoaiXe(3);
//        chuyenXe4.setHinhAnh("https://firebasestorage.googleapis.com/v0/b/doanandroid-c9b13.appspot.com/o/xe_35_cho.jpg?alt=media&token=89119ebf-e6a8-4c0a-af7e-0b3fac672114");
//
//        chuyenXeDAO.insert(chuyenXe1,chuyenXe2,chuyenXe3,chuyenXe4);

    }

}
