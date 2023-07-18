package com.example.myapplication.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddThanhVienBinding;
import com.example.myapplication.viewmodel.AddThanhVienViewModel;


public class AddThanhVienFragment extends Fragment {
    FragmentAddThanhVienBinding fragmentAddThanhVienBinding;
    AddThanhVienViewModel addThanhVienViewModel = new AddThanhVienViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddThanhVienBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_thanh_vien, container, false);
        fragmentAddThanhVienBinding.setAddThanhVienViewModel(addThanhVienViewModel);

        return fragmentAddThanhVienBinding.getRoot();
    }
}