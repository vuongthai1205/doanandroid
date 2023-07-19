package com.example.myapplication.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentUpdateThanhVienBinding;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.viewmodel.UpdateThanhVienViewModel;


public class UpdateThanhVienFragment extends Fragment {

    private FragmentUpdateThanhVienBinding fragmentUpdateThanhVienBinding;
    private UpdateThanhVienViewModel updateThanhVienViewModel = new UpdateThanhVienViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentUpdateThanhVienBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_update_thanh_vien, container, false);
        fragmentUpdateThanhVienBinding.setUpdateThanhVienViewModel(updateThanhVienViewModel);
        Bundle bundle = getArguments();


        fragmentUpdateThanhVienBinding.edtNgaySinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateThanhVienViewModel.showDatePickerDialog(getContext());
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, updateThanhVienViewModel.getListTenQuyen(getContext()));

        fragmentUpdateThanhVienBinding.spnerTenQuyen.setAdapter(adapter);
        if (bundle != null) {
            ThanhVien thanhVien = (ThanhVien) bundle.getSerializable("thanhVien");
            updateThanhVienViewModel.setDetailThanhVien(thanhVien, getContext());
            fragmentUpdateThanhVienBinding.spnerTenQuyen.setSelection(thanhVien.getIdQuyenThanhVien() - 1);
        }
        fragmentUpdateThanhVienBinding.spnerTenQuyen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                updateThanhVienViewModel.getIdQuyenThanhVien((String) adapterView.getItemAtPosition(i), getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fragmentUpdateThanhVienBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThanhVien thanhVien = (ThanhVien) bundle.getSerializable("thanhVien");
                updateThanhVienViewModel.updateThanhVien(thanhVien, getContext());
            }
        });


        // Inflate the layout for this fragment
        return fragmentUpdateThanhVienBinding.getRoot();
    }
}