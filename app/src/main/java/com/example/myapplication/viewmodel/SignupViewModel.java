package com.example.myapplication.viewmodel;



import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;
import com.example.myapplication.view.LoginActivity;

public class SignupViewModel extends BaseObservable {
    private String tenDangNhap;
    private String ho;
    private String ten;
    private String soDienThoai;
    private String email;
    private String password;
    private String passwordAgain;
    private boolean dieuKhoan;
    private ThanhVienRepository thanhVienRepository;



    public void handleSignup(Context context){
        if(showRowEmpty().length() > 0 ){
            Toast.makeText(context, showRowEmpty(), Toast.LENGTH_LONG).show();
            return;
        }
        if (!isTenDangNhapValid(tenDangNhap)){
            Toast.makeText(context, "Tên đăng nhập sai định dạng, hãy viết liền không dấu", Toast.LENGTH_LONG).show();
            return;
        }

        if (!isEmailValid(email)){
            Toast.makeText(context, "Email sai định dạng, example@gmail.com", Toast.LENGTH_LONG).show();
            return;
        }

        if (!isPasswordValid(password)){
            Toast.makeText(context, "Độ dài mật khẩu phải lớn hơn hoặc bằng 5 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        if (!isPasswordAgainValid(passwordAgain)){
            Toast.makeText(context, "Nhập lại mật khẩu phải giống", Toast.LENGTH_LONG).show();
            return;
        }

        if(!dieuKhoan){
            Toast.makeText(context, "Vui lòng chấp nhận điều khoản", Toast.LENGTH_LONG).show();
            return;
        }

        thanhVienRepository = new ThanhVienRepository(context);
        ThanhVien thanhVien = new ThanhVien(tenDangNhap, ho, ten,password,null,3,email,soDienThoai, null,null);
        if (thanhVienRepository.isThanhVienExist(thanhVien)){
            Toast.makeText(context, "Người dùng đã tồn tại, vui lòng kiểm tra lại", Toast.LENGTH_LONG).show();
            return;
        }

        thanhVienRepository.addThanhVien(thanhVien);
        Toast.makeText(context, "Đăng ký thành công", Toast.LENGTH_LONG).show();
        Intent newActivityIntent = new Intent(context, LoginActivity.class);
        newActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(newActivityIntent);
    }

    private boolean isTenDangNhapValid(String tenDangNhap) {
        // Biểu thức chính quy kiểm tra viết liền không dấu
        String regex = "^[a-zA-Z0-9]+$";

        // Kiểm tra trường "tenDangNhap" với biểu thức chính quy
        return tenDangNhap.matches(regex);
    }

    private boolean isEmailValid(String email) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Kiểm tra trường "email" với biểu thức chính quy
        return email.matches(regex);
    }

    private boolean isPasswordValid(String password) {
        // Kiểm tra độ dài mật khẩu
        if (password.length() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPasswordAgainValid(String passwordAgain){
        if (password.equals(passwordAgain)){
            return true;
        }
        else {
            return false;
        }
    }

    public String showRowEmpty(){
        String result = "";
        if (TextUtils.isEmpty(tenDangNhap)){
            result = noiChuoi("tên đăng nhập");
            return result;
        } else if (TextUtils.isEmpty(ten)){
            result = noiChuoi("tên");
            return result;
        } else if (TextUtils.isEmpty(ho)){
            result = noiChuoi("họ");
            return result;
        } else if (TextUtils.isEmpty(soDienThoai)){
            result = noiChuoi("số điện thoại");
            return result;
        } else if (TextUtils.isEmpty(email)){
            result = noiChuoi("email");
            return result;
        } else if (TextUtils.isEmpty(password)){
            result = noiChuoi("mật khẩu");
            return result;
        } else if (TextUtils.isEmpty(passwordAgain)){
            result = noiChuoi("mật khẩu nhập lại");
            return result;
        }else {
            return "";
        }
    }



    public String noiChuoi(String chuoi){
        return "Không được bỏ trống ô " + chuoi;
    }

    @Bindable
    public boolean isDieuKhoan() {
        return dieuKhoan;
    }

    public void setDieuKhoan(boolean dieuKhoan) {
        this.dieuKhoan = dieuKhoan;
        notifyPropertyChanged(BR.dieuKhoan);
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
