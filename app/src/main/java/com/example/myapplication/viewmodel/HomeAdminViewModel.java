package com.example.myapplication.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;

import com.example.myapplication.view.ChuyenXeManager;
import com.example.myapplication.view.ThanhVienManager;

public class HomeAdminViewModel extends BaseObservable {
    public void goToThanhVienManager(Context context){
        Intent i = new Intent(context, ThanhVienManager.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
    public void goToChuyenXeManager(Context context) {
        Intent i = new Intent(context, ChuyenXeManager.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
