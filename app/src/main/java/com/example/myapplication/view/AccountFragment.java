package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.config.DataLocalManager;
import com.example.myapplication.databinding.FragmentAccountBinding;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;
import com.example.myapplication.viewmodel.AccountViewModel;

import java.text.ParseException;

public class AccountFragment extends Fragment {
    private FragmentAccountBinding fragmentAccountBinding;
    private ThanhVienRepository thanhVienRepository;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater,container, false );

        AccountViewModel accountViewModel = new AccountViewModel();
        fragmentAccountBinding.setAccountViewModel(accountViewModel);
        thanhVienRepository = new ThanhVienRepository(getContext());
        ThanhVien thanhVien = thanhVienRepository.getThanhVienByUserName(DataLocalManager.getNameUser());
        accountViewModel.showAccount(thanhVien);

        return fragmentAccountBinding.getRoot();

    }
}