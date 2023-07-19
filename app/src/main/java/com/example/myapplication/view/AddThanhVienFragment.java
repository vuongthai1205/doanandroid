package com.example.myapplication.view;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.example.myapplication.R;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.databinding.FragmentAddThanhVienBinding;
import com.example.myapplication.viewmodel.AddThanhVienViewModel;

import java.util.Calendar;


public class AddThanhVienFragment extends Fragment {
    FragmentAddThanhVienBinding fragmentAddThanhVienBinding;
    AddThanhVienViewModel addThanhVienViewModel = new AddThanhVienViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddThanhVienBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_thanh_vien, container, false);
        fragmentAddThanhVienBinding.setAddThanhVienViewModel(addThanhVienViewModel);

        fragmentAddThanhVienBinding.edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThanhVienViewModel.showDatePickerDialog(getContext());
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, addThanhVienViewModel.getListTenQuyen(getContext()));

        fragmentAddThanhVienBinding.spnerTenQuyen.setAdapter(adapter);

        fragmentAddThanhVienBinding.spnerTenQuyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                addThanhVienViewModel.getIdQuyenThanhVien((String) adapterView.getItemAtPosition(i), getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fragmentAddThanhVienBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addThanhVienViewModel.handleAddThanhVien(getContext());
            }
        });

        return fragmentAddThanhVienBinding.getRoot();
    }
}