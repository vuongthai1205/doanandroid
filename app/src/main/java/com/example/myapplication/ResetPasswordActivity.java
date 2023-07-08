package com.example.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Button btn_reset_password = findViewById(R.id.btnResetPassword);
        EditText edt_email = findViewById(R.id.edtEmail);
        EditText edt_reset_password = findViewById(R.id.edtResetPassword);
        EditText edt_reset_again_password = findViewById(R.id.edtResetAgainPassword);

        // Xử lí button đặt lại
        btn_reset_password.setOnClickListener(v -> {
            String email = edt_email.getText().toString();
            String reset_pass = edt_reset_password.getText().toString();
            String reset_again_pass = edt_reset_again_password.getText().toString();
            if (email.isEmpty()) {
                edt_email.setError("Vui lòng nhập dữ liệu");
            } else if (reset_pass.isEmpty()) {
                edt_reset_password.setError("Vui lòng nhập dữ liệu");
            } else if (reset_again_pass.isEmpty()) {
                edt_reset_again_password.setError("Vui lòng nhập dữ liệu");
            }
            if (UpdatePassword(email, reset_pass, reset_again_pass)) {
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                // Kết thúc Activity hiện tại
                finish();
            }
        });


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
        // Set filter
        edt_reset_password.setFilters(new InputFilter[]{filter});
        edt_reset_again_password.setFilters(new InputFilter[]{filter});

        //Xóa trống email
        LinearLayout layout_email = findViewById(R.id.layoutEmail);
        EditText edt_clear_email = layout_email.findViewById(R.id.edtEmail);
        ImageView img_clear_email = layout_email.findViewById(R.id.imgClearEmail);
        img_clear_email.setOnClickListener(v -> edt_clear_email.setText(""));

        //Ẩn hiên mật khẩu
        LinearLayout layout_reset_pass = findViewById(R.id.layoutResetPassword);
        EditText edt_show_reset_pass = layout_reset_pass.findViewById(R.id.edtResetPassword);
        ImageView img_show_reset_pass = layout_reset_pass.findViewById(R.id.imgShowResetPassword);
        img_show_reset_pass.setOnClickListener(new View.OnClickListener() {
            boolean isPasswordVisible = false;
            @Override
            public void onClick(View v) {
                ShowHidePassword(edt_show_reset_pass, isPasswordVisible);
                isPasswordVisible = !isPasswordVisible;
            }
        });

        // Ẩn hiện nhập lại mật khẩu
        LinearLayout layout_again_pass = findViewById(R.id.layoutResetAgainPassword);
        EditText edt_show_again_pass = layout_again_pass.findViewById(R.id.edtResetAgainPassword);
        ImageView img_show_again_pass = layout_again_pass.findViewById(R.id.imgShowAgainPassword);
        img_show_again_pass.setOnClickListener(new View.OnClickListener() {
            boolean isPasswordVisible = false;
            @Override
            public void onClick(View v) {
                ShowHidePassword(edt_show_again_pass, isPasswordVisible);
                isPasswordVisible = !isPasswordVisible;
            }
        });
    }

    // Phương thức ẩn hiện password
    private void ShowHidePassword(EditText editText, boolean isPasswordVisible) {
        if (isPasswordVisible) {
            editText.setTransformationMethod(null);// Hiện mật khẩu
        } else {
            editText.setTransformationMethod(new PasswordTransformationMethod());//Ẩn mật khẩu
        }
        editText.setSelection(editText.getText().length());//Di chuyển con trỏ về cuối dòng
    }

    //Phương thức updatePassword
    private boolean UpdatePassword(String email, String resetPassword, String resetAgainPassword) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String[] information = {dbHelper.COLUMN_EMAIL, dbHelper.COLUMN_MAT_KHAU};
        String select_ten_nguoi_dung = dbHelper.COLUMN_EMAIL + " = ?";
        String[] select_ten_args = {email};
        Cursor cursor;
        cursor = database.query(dbHelper.TABLE_THANHVIEN, information, select_ten_nguoi_dung, select_ten_args, null, null, null);
        if (cursor.moveToFirst()) {
            String select_email = cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_EMAIL));
            if (email.equals(select_email) && resetPassword.equals(resetAgainPassword)) {
                ContentValues values = new ContentValues();
                values.put(dbHelper.COLUMN_MAT_KHAU, resetPassword);
                String whereEmail = dbHelper.COLUMN_EMAIL + "=?";
                String[] wherEmailArgs = {email};
                int rowSuccses = database.update(dbHelper.TABLE_THANHVIEN, values, whereEmail, wherEmailArgs);
                if (rowSuccses == 1){
                    Toast.makeText(getApplicationContext(), "Đặt lại mật khẩu thành công", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else
                    Toast.makeText(getApplicationContext(), "Đặt lại mật khẩu không thành công", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(getApplicationContext(), "Kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "Kiểm tra lại email", Toast.LENGTH_SHORT).show();
        cursor.close();
        database.close();
        return false;
    }
}