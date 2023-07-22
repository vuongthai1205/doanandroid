package com.example.myapplication.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.telephony.TelephonyCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentListLoaiXeBinding;
import com.example.myapplication.viewmodel.ListLoaiXeViewModel;
import com.example.myapplication.viewmodel.ListThanhVienViewModel;

public class ListLoaiXeFragment extends Fragment {
    private ListLoaiXeViewModel listLoaiXeViewModel = new ListLoaiXeViewModel();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentListLoaiXeBinding fragmentListLoaiXeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_loai_xe,container,false);
        // Inflate the layout for this fragment
        fragmentListLoaiXeBinding.setListLoaiXeViewModel(listLoaiXeViewModel);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());


        fragmentListLoaiXeBinding.rcvLoaiXe.setLayoutManager(linearLayoutManager);
        listLoaiXeViewModel.renderAdapter(getContext());
        fragmentListLoaiXeBinding.rcvLoaiXe.setAdapter(listLoaiXeViewModel.getLoaiXeAdapter());

        return fragmentListLoaiXeBinding.getRoot();
    }
}