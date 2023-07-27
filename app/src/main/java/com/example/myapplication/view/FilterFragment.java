package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFilterBinding;
import com.example.myapplication.viewmodel.FilterViewModel;

public class FilterFragment extends Fragment {
    FragmentFilterBinding fragmentFilterBinding;
    FilterViewModel filterViewModel = new FilterViewModel();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFilterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_filter,container,false);
        fragmentFilterBinding.setFilterViewModel(filterViewModel);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        fragmentFilterBinding.rcvFilterChuyenXe.setLayoutManager(linearLayoutManager);
        filterViewModel.renderAdapter(getContext());
        fragmentFilterBinding.rcvFilterChuyenXe.setAdapter(filterViewModel.getChuyenXeFilterAdapter());

        ArrayAdapter<String> adapterLoaiXe = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListTenLoaiXe(getContext()));

        fragmentFilterBinding.spinnerLoaiXe.setAdapter(adapterLoaiXe);
        String loaiXe = fragmentFilterBinding.spinnerLoaiXe.getSelectedItem().toString();


        ArrayAdapter<String> adapterDiaDiemDi = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDi(getContext()));

        fragmentFilterBinding.spinnerDiaDiemDi.setAdapter(adapterDiaDiemDi);
        String diaDiemDi = fragmentFilterBinding.spinnerDiaDiemDi.getSelectedItem().toString();

        ArrayAdapter<String> adapterDiaDiemDen = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDen(getContext()));

        fragmentFilterBinding.spinnerDiaDiemDen.setAdapter(adapterDiaDiemDen);
        String diaDiemDen = fragmentFilterBinding.spinnerDiaDiemDen.getSelectedItem().toString();

        String ngayDi = fragmentFilterBinding.edtNgayDi.toString();
        String gioDi = fragmentFilterBinding.edtGioDi.toString();
        int idLoaiXe = filterViewModel.getIdLoaiXeByName(getContext(),loaiXe);

        fragmentFilterBinding.btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterViewModel.getChuyenXeFilterAdapter().filterChuyenXe(diaDiemDi,diaDiemDen,idLoaiXe,ngayDi,gioDi);
            }
        });
        return  fragmentFilterBinding.getRoot();

    }
}