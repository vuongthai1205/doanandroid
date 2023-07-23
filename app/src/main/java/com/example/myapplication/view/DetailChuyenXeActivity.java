package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.config.FunctionPublic;
import com.example.myapplication.databinding.ActivityDetailChuyenXeBinding;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.viewmodel.ADetailChuyenXeViewModel;

public class DetailChuyenXeActivity extends AppCompatActivity {
    ActivityDetailChuyenXeBinding detailThanhVienBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailThanhVienBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_chuyen_xe);
        ADetailChuyenXeViewModel aDetailChuyenXeViewModel = new ADetailChuyenXeViewModel();
        detailThanhVienBinding.setADetailChuyenXeViewModel(aDetailChuyenXeViewModel);

        if (getIntent().getExtras() != null){
            ChuyenXe chuyenXe = (ChuyenXe) getIntent().getExtras().getSerializable("chuyen_xe");

            aDetailChuyenXeViewModel.layThongTinChuyenXe(chuyenXe);
        }

        FunctionPublic.loadAvatar(aDetailChuyenXeViewModel.getHinhAnh(),detailThanhVienBinding.hinhAnhChuyenXe,getApplicationContext());
    }
}