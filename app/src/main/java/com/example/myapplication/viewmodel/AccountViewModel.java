package com.example.myapplication.viewmodel;


import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;

public class AccountViewModel extends BaseObservable {
    private String ho;
    private String ten;
    private String tenDangNhap;
    private String soDienThoai;
    private String email;
    private String ngayTao;
    private String ngayCapNhat;
    private String avatar;

    public void showAccount(ThanhVien thanhVien){

        setHo(thanhVien.getHo());
        setTen(thanhVien.getTen());
        setTenDangNhap(thanhVien.getTenDangNhap());
        setSoDienThoai(thanhVien.getSoDienThoai());
        setEmail(thanhVien.getEmail());
        setNgayTao(thanhVien.getNgayTao());
        setNgayCapNhat(thanhVien.getNgayCapNhat());
        setAvatar(thanhVien.getAvatar());
    }

    public void updateAccount(Context context){
        ThanhVienRepository thanhVienRepository = new ThanhVienRepository(context);
        ThanhVien thanhVien = new ThanhVien(tenDangNhap, ho,ten, avatar,email,soDienThoai);
        thanhVienRepository.updateThanhVienByUserName(tenDangNhap, thanhVien);
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
    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
        notifyPropertyChanged(BR.ngayTao);
    }
    @Bindable
    public String getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(String ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
        notifyPropertyChanged(BR.ngayCapNhat);
    }
    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyPropertyChanged(BR.avatar);
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
}
