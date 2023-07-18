package com.example.myapplication.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;

import com.example.myapplication.view.ThanhVienManager;

public class HomeAdminViewModel extends BaseObservable {
    public void onClick(Context context){
        Intent i = new Intent(context, ThanhVienManager.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
