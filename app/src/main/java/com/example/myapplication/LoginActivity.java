package com.example.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button_login = findViewById(R.id.btnSignIn);


        //Xóa trống tên đăng nhập
        LinearLayout layout_username = findViewById(R.id.layoutUserName);
        ImageView img_clear_username = layout_username.findViewById(R.id.imgClearUserName);
        final EditText edt_clear_username = layout_username.findViewById(R.id.txtUserName);
        img_clear_username.setOnClickListener(v -> edt_clear_username.setText(""));


        //Ẩn/Hiện mật khẩu
        LinearLayout layout_password = findViewById(R.id.layoutPassword);
        ImageView img_show_password = layout_password.findViewById(R.id.imgShowPassword);
        final EditText edt_show_password = layout_password.findViewById(R.id.txtPassword);
        img_show_password.setOnClickListener(new View.OnClickListener() {
            boolean isPasswordVisible = false;
            @Override
            public void onClick(View v) {
                if(isPasswordVisible){
                    edt_show_password.setTransformationMethod(null);// Hiện mật khẩu
                }
                else{
                    edt_show_password.setTransformationMethod(new PasswordTransformationMethod());//Ẩn mật khẩu
                }
                edt_show_password.setSelection(edt_show_password.getText().length());//Di chuyển con trỏ về cuối dòng
                isPasswordVisible = !isPasswordVisible;// Đảo ngược trạng thái
            }
        });

        //Hạn chế người dùng nhập sai định dạng
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
               for (int i = start;i < end;i++){
                   char c = source.charAt(i);
                   if (Character.isWhitespace(c) || c == ','|| c == '.'){
                       return "";
                   }
               }
                return null;
            }
        };
        EditText edt_username = findViewById(R.id.txtUserName);
        EditText edt_password = findViewById(R.id.txtPassword);
        // Set filter cho EditText Username và EditText Password
        edt_username.setFilters(new InputFilter[] {filter});
        edt_password.setFilters(new InputFilter[] {filter});
        //Xác thực đăng nhập
        button_login.setOnClickListener(v -> {//Convert ra bieu thuc lambda
            String username = edt_username.getText().toString();
            String password = edt_password.getText().toString();
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            SQLiteDatabase database = dbHelper.getReadableDatabase();
            String [] information = {"ten_nguoi_dung","mat_khau","id_quyen"};
            String select_ten_nguoi_dung = "ten_nguoi_dung = ?";
            String [] select_ten_args = {username};
            Cursor cursor;
            cursor = database.query("table_thanhvien",
                    information,select_ten_nguoi_dung,select_ten_args,null,null,null);

            if(cursor.moveToFirst()){
                String select_password = cursor.getString(cursor.getColumnIndexOrThrow("mat_khau"));
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
            }else if(username.isEmpty()){
                edt_username.setError("Vui lòng nhập dữ liệu");
            }else if(password.isEmpty()) {
                edt_password.setError("Vui lòng nhập dữ liệu");
            }
            else{
                // Không tìm thấy thông tin người dùng và chuyển hướng qua trang SignupActivity
                Toast.makeText(getApplicationContext(), "Không tìm thấy thông tin người dùng", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn đăng kí tài khoản");
                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Hủy",null);
                builder.show();
            }
            cursor.close();
            database.close();
        });
    }
}
