package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentAddChuyenXeBinding;
import com.example.myapplication.viewmodel.AddChuyenXeViewModel;

public class AddChuyenXeFragment extends Fragment {
    FragmentAddChuyenXeBinding fragmentAddChuyenXeBinding;
    AddChuyenXeViewModel addChuyenXeViewModel = new AddChuyenXeViewModel();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fragmentAddChuyenXeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_chuyen_xe,container,false);
        fragmentAddChuyenXeBinding.setAddChuyenXeViewModel(addChuyenXeViewModel);

        fragmentAddChuyenXeBinding.edtNgayDi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChuyenXeViewModel.showDatePickerDialogNgayDi(getContext());
            }
        });

        fragmentAddChuyenXeBinding.edtNgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChuyenXeViewModel.showDatePickerDialogNgayVe(getContext());
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, addChuyenXeViewModel.getListTenLoaiXe(getContext()));

        fragmentAddChuyenXeBinding.spinnerTenLoaiXe.setAdapter(adapter);

        fragmentAddChuyenXeBinding.spinnerTenLoaiXe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                addChuyenXeViewModel.getIdLoaiXeByName(getContext(), (String) adapterView.getItemAtPosition(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fragmentAddChuyenXeBinding.btnThemChuyenXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addChuyenXeViewModel.AddChuyenXe(getContext());
                }
        });
        return fragmentAddChuyenXeBinding.getRoot();
    }


}