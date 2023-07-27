package com.example.myapplication.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.config.FunctionPublic;
import com.example.myapplication.databinding.ActivityDetailFilterChuyenXeBinding;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.viewmodel.DetailFilterChuyenXeViewModel;

public class DetailFilterChuyenXeActivity extends AppCompatActivity {
    ActivityDetailFilterChuyenXeBinding activityDetailFilterChuyenXeBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailFilterChuyenXeBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail_filter_chuyen_xe);
        DetailFilterChuyenXeViewModel detailFilterChuyenXeViewModel = new DetailFilterChuyenXeViewModel();
        activityDetailFilterChuyenXeBinding.setDetailFilterChuyenXeViewModel(detailFilterChuyenXeViewModel);

    if(getIntent().getExtras() != null){
            ChuyenXe chuyenXe = (ChuyenXe) getIntent().getExtras().getSerializable("chuyen_xe");

           detailFilterChuyenXeViewModel.getThongTinChuyenXe(chuyenXe);
        }
        FunctionPublic.loadAvatar(detailFilterChuyenXeViewModel.getHinhAnh(),activityDetailFilterChuyenXeBinding.imgFilterChuyenXe,getApplicationContext());
    }
}