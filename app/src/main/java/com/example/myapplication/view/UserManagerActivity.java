package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUserManagerBinding;
import com.example.myapplication.viewmodel.UserManagerViewModel;

public class UserManagerActivity extends AppCompatActivity {
    ActivityUserManagerBinding activityUserManagerBinding;
    UserManagerViewModel userManagerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUserManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_manager);
        activityUserManagerBinding.setUserManagerViewModel(userManagerViewModel);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(activityUserManagerBinding.fragmentAdmin.getId(), new HomeUserFragment());
        fragmentTransaction.commit();

        activityUserManagerBinding.btnTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(activityUserManagerBinding.fragmentAdmin.getId(), new HomeUserFragment());
                fragmentTransaction.commit();
            }
        });

        activityUserManagerBinding.btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(activityUserManagerBinding.fragmentAdmin.getId(), new AccountFragment());
                fragmentTransaction.commit();
            }
        });

        activityUserManagerBinding.btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(activityUserManagerBinding.fragmentAdmin.getId(), new FilterFragment());
                fragmentTransaction.commit();
            }
        });
    }

}