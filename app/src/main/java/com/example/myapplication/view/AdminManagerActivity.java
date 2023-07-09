package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityAdminManagerBinding;
import com.example.myapplication.viewmodel.AdminManagerViewModel;

public class AdminManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAdminManagerBinding activityAdminManagerBinding = DataBindingUtil.setContentView(this,R.layout.activity_admin_manager);
        AdminManagerViewModel adminManagerViewModel = new AdminManagerViewModel();
        activityAdminManagerBinding.setAdminManagerViewModel(adminManagerViewModel);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(activityAdminManagerBinding.fragmentAdmin.getId(),new HomeAdminFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        activityAdminManagerBinding.btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                fragmentTransaction.replace(activityAdminManagerBinding.fragmentAdmin.getId(),new AccountFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        activityAdminManagerBinding.btnTrangChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(activityAdminManagerBinding.fragmentAdmin.getId(),new HomeAdminFragment());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}