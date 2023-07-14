package com.example.myapplication.config;

import android.app.Application;

import androidx.room.Room;

import com.example.myapplication.model.DAO.ThanhVienDAO;


public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }

}
