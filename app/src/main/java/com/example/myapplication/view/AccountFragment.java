package com.example.myapplication.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.config.DataLocalManager;
import com.example.myapplication.config.FunctionPublic;
import com.example.myapplication.config.VariableGlobal;
import com.example.myapplication.databinding.FragmentAccountBinding;
import com.example.myapplication.model.DAO.ThanhVienDAO;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.viewmodel.AccountViewModel;

public class AccountFragment extends Fragment {
    private FragmentAccountBinding fragmentAccountBinding;
    AccountViewModel accountViewModel = new AccountViewModel();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAccountBinding = FragmentAccountBinding.inflate(inflater,container, false );

        fragmentAccountBinding.setAccountViewModel(accountViewModel);

        ThanhVienDAO thanhVienDAO = AppDatabase.getInstance(getContext()).getThanhVienDAO();



        ThanhVien thanhVien = thanhVienDAO.getThanhVienByUserName(DataLocalManager.getNameUser());

        accountViewModel.showAccount(thanhVien, getContext());
        FunctionPublic.loadAvatar(accountViewModel.getAvatar(),fragmentAccountBinding.avatarImg,getContext());

        fragmentAccountBinding.btnUpdateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountViewModel.updateAccount(getContext());
            }
        });

        fragmentAccountBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });


        return fragmentAccountBinding.getRoot();



    }




    private void Logout() {
        DataLocalManager.setIsLogin(false);
        Intent intent = new Intent(getContext(),LoginActivity.class);
        startActivity(intent);
    }
}