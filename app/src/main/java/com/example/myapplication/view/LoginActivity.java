package com.example.myapplication.view;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.config.DataLocalManager;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;
import com.example.myapplication.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    LoginViewModel loginViewModel = new LoginViewModel();
    ThanhVienRepository thanhVienRepository = new ThanhVienRepository(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(loginViewModel);

        // Xử lí button đăng nhập
        activityLoginBinding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tenDangNhap = loginViewModel.getTenDangNhap();
                String password = loginViewModel.getPassword();
                if(loginViewModel.kiemTraNhap(tenDangNhap,password)==false) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
                    return;
                }
                DataLocalManager.setNameUser(tenDangNhap);
                ThanhVien thanhVien = new ThanhVien(tenDangNhap);
                String select_password = thanhVienRepository.getMatKhauByUserName(thanhVien);
                int quyenHienTai = thanhVienRepository.getQuyenByUserName(thanhVien);

                // Khi không tìm thấy thông tin người dùng sẽ chuyển sang trang đăng kí
                 if(TextUtils.isEmpty(select_password)){
                    Toast.makeText(LoginActivity.this, "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
                    showDialogSignUp();
                }else if( password.equals(select_password)){
                    String tenQuyen = thanhVienRepository.chuyenDoiQuyenThanhVien(quyenHienTai);
                    DataLocalManager.setNameRole(tenQuyen);
                    DataLocalManager.setIdRole(quyenHienTai);
                    chuyenTrangTheoQuyen(quyenHienTai);
                }else{
                    Toast.makeText(LoginActivity.this, "Kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //Xử lí click lên view đặt lại mật khẩu
        activityLoginBinding.textViewResetPassword.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
            finish();
        });

        //Xóa trống tên đăng nhập
        activityLoginBinding.imgClearUserName.setOnClickListener(v -> activityLoginBinding.txtUserName.setText(""));

        //Ẩn/Hiện mật khẩu
        activityLoginBinding.imgShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.showPass(activityLoginBinding.txtPassword);
            }
        });
        //Set filter
        activityLoginBinding.txtUserName.setFilters(new InputFilter[] {filter});
        activityLoginBinding.txtPassword.setFilters(new InputFilter[] {filter});
    }

    // Hộp thoại xác nhận đăng kí
    public void showDialogSignUp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn có muốn đăng ký tài khoản mới?");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Chuyển hướng đến trang đăng ký tài khoản
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("Hủy", null);
        builder.show();
    }

    public void chuyenTrangTheoQuyen(int quyen){
        if(quyen == 1 || quyen == 2){
            Intent intent = new Intent(LoginActivity.this, AdminManagerActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(LoginActivity.this, UserManagerActivity.class);
            startActivity(intent);
            finish();
        }
    }
    InputFilter filter = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                char c = source.charAt(i);
                if (Character.isWhitespace(c) || c == ',' || c == '.') {
                    return "";
                }
            }
            return null;
        }
    };

}
