package com.example.myapplication.config;


import android.app.Application;

import com.example.myapplication.model.DAO.ChuyenXeDAO;
import com.example.myapplication.model.DAO.LoaiXeDAO;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
        ChuyenXeDAO chuyenXeDao = AppDatabase.getInstance(getApplicationContext()).getChuyenXeDAO();
        LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(getApplicationContext()).getLoaiXeDAO();

//        LoaiXe loaiXe1 = new LoaiXe("Ford Transit Limousine",16);
//        LoaiXe loaiXe2 = new LoaiXe("Thaco Town ",35);
//        LoaiXe loaiXe3 = new LoaiXe("Thaco Kinglong ",35);
//        loaiXeDAO.insert(loaiXe1,loaiXe2,loaiXe3);
//
//
//        ChuyenXe chuyenXe1 = new ChuyenXe("TP.Hồ Chí Minh - TP.Nha Trang","Bến xe miền Đông","Bến xe Nha Trang");
//        chuyenXe1.setIdLoaiXe(1);
//        ChuyenXe chuyenXe2 = new ChuyenXe("TP.Hồ Chí Minh - Đồng Nai","Bến xe miền Đông","Bến xe Đồng Nai");
//        chuyenXe2.setIdLoaiXe(2);
//        ChuyenXe chuyenXe3 = new ChuyenXe("TP.Cần Thơ - TP.Vũng Tàu","Bến xe Cần Thơ","Bến xe Vũng Tàu");
//        chuyenXe3.setIdLoaiXe(3);
//        chuyenXeDao.insert(chuyenXe1,chuyenXe2,chuyenXe3);

    }

}
