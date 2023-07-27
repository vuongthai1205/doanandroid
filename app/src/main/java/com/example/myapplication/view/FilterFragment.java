package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentFilterBinding;
import com.example.myapplication.viewmodel.FilterViewModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterFragment extends Fragment {
    FragmentFilterBinding fragmentFilterBinding;
    FilterViewModel filterViewModel = new FilterViewModel();
    private String diaDiemDi;
    private String diaDiemDen;
    private String loaiXe;
    private String gioDi;
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

        // Lắng nghe sự kiện khi người dùng chọn một mục trong Spinner LoaiXe
        fragmentFilterBinding.spinnerLoaiXe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị loaiXe từ Spinner sau khi người dùng chọn
                loaiXe = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn (nếu cần)
            }
        });

        // Tạo adapter và thiết lập cho Spinner DiaDiemDi
        ArrayAdapter<String> adapterDiaDiemDi = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDi(getContext()));
        fragmentFilterBinding.spinnerDiaDiemDi.setAdapter(adapterDiaDiemDi);

        // Lắng nghe sự kiện khi người dùng chọn một mục trong Spinner DiaDiemDi
        fragmentFilterBinding.spinnerDiaDiemDi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị diaDiemDi từ Spinner sau khi người dùng chọn
                diaDiemDi = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn (nếu cần)
            }
        });
        // Tạo adapter và thiết lập cho Spinner DiaDiemDen
        ArrayAdapter<String> adapterDiaDiemDen = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDen(getContext()));
        fragmentFilterBinding.spinnerDiaDiemDen.setAdapter(adapterDiaDiemDen);

        // Lắng nghe sự kiện khi người dùng chọn một mục trong Spinner DiaDiemDen
        fragmentFilterBinding.spinnerDiaDiemDen.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Lấy giá trị diaDiemDen từ Spinner sau khi người dùng chọn
                diaDiemDen = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn (nếu cần)
            }
        });

        // Lấy giá trị gioDi từ EditText
        gioDi = fragmentFilterBinding.edtGioDi.getText().toString();

        // Lắng nghe sự kiện khi người dùng nhấn nút "Lọc"
        fragmentFilterBinding.btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idLoaiXe = filterViewModel.getIdLoaiXeByName(getContext(), loaiXe);
                filterViewModel.getChuyenXeFilterAdapter().filterChuyenXe(diaDiemDi, diaDiemDen, idLoaiXe, gioDi);
            }
        });



//        fragmentFilterBinding.btnLoc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ArrayAdapter<String> adapterLoaiXe = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListTenLoaiXe(getContext()));
//
//                fragmentFilterBinding.spinnerLoaiXe.setAdapter(adapterLoaiXe);
//                String loaiXe = fragmentFilterBinding.spinnerLoaiXe.getSelectedItem().toString();
//
//
//                ArrayAdapter<String> adapterDiaDiemDi = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDi(getContext()));
//
//                fragmentFilterBinding.spinnerDiaDiemDi.setAdapter(adapterDiaDiemDi);
//                String diaDiemDi = fragmentFilterBinding.spinnerDiaDiemDi.getSelectedItem().toString();
//
//                ArrayAdapter<String> adapterDiaDiemDen = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, filterViewModel.getListDiaDiemDen(getContext()));
//
//                fragmentFilterBinding.spinnerDiaDiemDen.setAdapter(adapterDiaDiemDen);
//                String diaDiemDen = fragmentFilterBinding.spinnerDiaDiemDen.getSelectedItem().toString();
//
//                String gioDi = fragmentFilterBinding.edtGioDi.toString();
//                int idLoaiXe = filterViewModel.getIdLoaiXeByName(getContext(),loaiXe);
//                filterViewModel.getChuyenXeFilterAdapter().filterChuyenXe(diaDiemDi,diaDiemDen,idLoaiXe,gioDi);
//            }
//        });
        return  fragmentFilterBinding.getRoot();

    }
}