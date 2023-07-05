package com.example.myapplication;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button_login = findViewById(R.id.btnSignIn);

        button_login.setOnClickListener(v -> {//Convert ra bieu thuc lambda
            EditText edt_username = findViewById(R.id.txtUserName);
            EditText edt_password = findViewById(R.id.txtPassword);
            String username = edt_username.getText().toString();
            String password = edt_password.getText().toString();
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            SQLiteDatabase database = dbHelper.getReadableDatabase();

            String [] information = {dbHelper.COLUMN_TEN_DANG_NHAP,dbHelper.COLUMN_MAT_KHAU,dbHelper.COLUMN_ID_QUYEN_THANHVIEN};
            String select_ten_nguoi_dung = dbHelper.COLUMN_TEN_DANG_NHAP + " = ?";
            String [] select_ten_args = {username};
            Cursor cursor;
            cursor = database.query(dbHelper.TABLE_THANHVIEN,
                    information,select_ten_nguoi_dung,select_ten_args,null,null,null);

            if(cursor.moveToFirst()){
                String select_password = cursor.getString(cursor.getColumnIndexOrThrow(dbHelper.COLUMN_MAT_KHAU));
                if(password.equals(select_password)){
                    // Chuyển sang một trang khác
                    Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(intent);
                    // Kết thúc Activity hiện tại
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Kiểm tra lại mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }
            }else if(username.isEmpty() || password.isEmpty()) {
                edt_username.setError("Vui lòng nhập dữ liệu");
                edt_password.setError("Vui lòng nhập dữ liệu");
            }
            else{
                Toast.makeText(getApplicationContext(), "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
                return;
            }
            cursor.close();
            database.close();
        });
    }
}
