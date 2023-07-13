package com.example.myapplication.viewmodel;

import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.myapplication.BR;


public class LoginViewModel extends BaseObservable {
    private String tenDangNhap;
    private String password;

    // Ẩn hiện mật khẩu
    public boolean showPass(EditText editText) {
        if (editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
            // Nếu đang ẩn mật khẩu, hiển thị văn bản
            editText.setTransformationMethod(null);
            editText.setSelection(editText.getText().length());//Di chuyển con trỏ về cuối dòng
            return true;
        } else {
            // Nếu đang hiển thị văn bản, ẩn mật khẩu
            editText.setTransformationMethod(new PasswordTransformationMethod());
            editText.setSelection(editText.getText().length());//Di chuyển con trỏ về cuối dòng
            return false;
        }

    }

    //Kiểm tra nhập
    public boolean kiemTraNhap(String tenDangNhap, String password) {
        //Tên đăng nhập và mật khẩu trống
        if (TextUtils.isEmpty(tenDangNhap) || TextUtils.isEmpty(password)) {
            return false;
        }
        return true;
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

}
