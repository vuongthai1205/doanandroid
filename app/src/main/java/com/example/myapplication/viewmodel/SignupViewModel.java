package com.example.myapplication.viewmodel;


import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;

public class SignupViewModel extends BaseObservable {
    private String tenDangNhap;
    private String ho;
    private String ten;
    private String soDienThoai;
    private String email;
    private String password;
    private String passwordAgain;



    public void handleSignup(String tenDangNhap, String ten , String ho , String soDienThoai, String email, String password){
        ThanhVien thanhVien = new ThanhVien(tenDangNhap, ho, ten,password,null,3,email,soDienThoai, null,null);

    }


    @Bindable
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
        notifyPropertyChanged(BR.tenDangNhap);

    }

    @Bindable
    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
        notifyPropertyChanged(BR.ho);

    }

    @Bindable
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
        notifyPropertyChanged(BR.ten);

    }

    @Bindable
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
        notifyPropertyChanged(BR.soDienThoai);

    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);

    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);

    }

    @Bindable
    public String getPasswordAgain() {
        return passwordAgain;
    }

    public void setPasswordAgain(String passwordAgain) {
        this.passwordAgain = passwordAgain;
        notifyPropertyChanged(BR.passwordAgain);

    }
}
