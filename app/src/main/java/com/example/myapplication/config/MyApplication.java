package com.example.myapplication.config;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.model.DAO.QuyenDao;
import com.example.myapplication.model.DAO.ThanhVienDAO;
import com.example.myapplication.model.Quyen;
import com.example.myapplication.model.ThanhVien;
import com.google.firebase.FirebaseApp;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());

        FirebaseApp.initializeApp(getApplicationContext());



    }

}
