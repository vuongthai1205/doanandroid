package com.example.myapplication.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityResetPasswordBinding;
import com.example.myapplication.model.ThanhVienRepository;
import com.example.myapplication.viewmodel.ResetPasswordViewModel;

public class ResetPasswordActivity extends AppCompatActivity {
    ActivityResetPasswordBinding activityResetPasswordBinding;
    ResetPasswordViewModel resetPasswordViewModel = new ResetPasswordViewModel();
    ThanhVienRepository thanhVienRepository = new ThanhVienRepository(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        activityResetPasswordBinding = DataBindingUtil.setContentView(ResetPasswordActivity.this,R.layout.activity_reset_password);
        activityResetPasswordBinding.setReserPasswordViewModel(resetPasswordViewModel);


        // Xử lí button đặt lại
        activityResetPasswordBinding.btnResetPassword.setOnClickListener(v -> {
            String email = resetPasswordViewModel.getEmail();
            String matKhau = resetPasswordViewModel.getMatKhau();
            String resetMatKhau = resetPasswordViewModel.getResetMatKhau();
            if (resetPasswordViewModel.kiemTraNhap(email,matKhau,resetMatKhau)==false) {
                Toast.makeText(ResetPasswordActivity.this,"Vui lòng nhập đầy đủ dữ liệu",Toast.LENGTH_SHORT).show();
                return;
            }
            resetPasswordViewModel.handleResetPassword(getApplicationContext());
            if(resetPasswordViewModel.isCheck()==true) {
                showDialogSignIn();
            }
        });



        // Set filter
        activityResetPasswordBinding.edtResetPassword.setFilters(new InputFilter[]{filter});
        activityResetPasswordBinding.edtResetAgainPassword.setFilters(new InputFilter[]{filter});

        //Xóa trống email
        activityResetPasswordBinding.imgClearEmail.setOnClickListener(v ->
                activityResetPasswordBinding.edtEmail.setText(""));

        //Ẩn hiên mật khẩu
        activityResetPasswordBinding.imgShowResetPassword.setOnClickListener(v ->
                resetPasswordViewModel.showPass(activityResetPasswordBinding.edtResetPassword));

        // Ẩn hiện nhập lại mật khẩu
        activityResetPasswordBinding.imgShowAgainPassword.setOnClickListener(v ->
                resetPasswordViewModel.showPass(activityResetPasswordBinding.edtResetAgainPassword));
    }


    //Phương thức updatePassword
//    private void UpdatePassword(String email, String resetPassword, String resetAgainPassword) {
//        DatabaseHelper dbHelper = new DatabaseHelper(this);
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        String[] information = {dbHelper.getCOLUMN_EMAIL(), dbHelper.getCOLUMN_MAT_KHAU()};
//        String select_ten_nguoi_dung = dbHelper.getCOLUMN_EMAIL() + " = ?";
//        String[] select_ten_args = {email};
//        Cursor cursor;
//        cursor = database.query(dbHelper.getTABLE_THANHVIEN(), information, select_ten_nguoi_dung, select_ten_args, null, null, null);
//        if (cursor.moveToFirst()) {
//            String select_email = cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.getCOLUMN_EMAIL()));
//            if (email.equals(select_email) && resetPassword.equals(resetAgainPassword)) {
//                ContentValues values = new ContentValues();
//                values.put(dbHelper.getCOLUMN_MAT_KHAU(), resetPassword);
//                String whereEmail = dbHelper.getCOLUMN_EMAIL() + "=?";
//                String[] wherEmailArgs = {email};
//                int rowSuccses = database.update(dbHelper.getTABLE_THANHVIEN(), values, whereEmail, wherEmailArgs);
//                if (rowSuccses == 1){
//                    Toast.makeText(getApplicationContext(), "Đặt lại mật khẩu thành công", Toast.LENGTH_SHORT).show();
//                    showDialogSignIn();
//                }
//                else
//                    Toast.makeText(getApplicationContext(), "Đặt lại mật khẩu không thành công", Toast.LENGTH_SHORT).show();
//            } else
//                Toast.makeText(getApplicationContext(), "Kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show();
//        } else
//            Toast.makeText(getApplicationContext(), "Kiểm tra lại email", Toast.LENGTH_SHORT).show();
//        cursor.close();
//        database.close();
//    }

    // Hộp thoại xác nhận đăng nhập
    private void showDialogSignIn(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ResetPasswordActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Bạn cần đăng nhập lại");
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Chuyển hướng đến trang đăng ký tài khoản
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }).setNegativeButton("Hủy", null);
        builder.show();
    }

        //Filter định dạng nội dung nhập
        InputFilter filter = (source, start, end, dest, dstart, dend) -> {
            for (int i = start; i < end; i++) {
                char c = source.charAt(i);
                if (Character.isWhitespace(c) || c == ',' || c == '.') {
                    return "";
                }
            }
            return null;
    };
}