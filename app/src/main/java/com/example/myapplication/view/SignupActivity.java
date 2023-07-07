package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.R;

public class SignupActivity extends AppCompatActivity {
    boolean chapNhanDieuKhoan = false;

    private EditText InputNameLogin;
    private EditText InputNumber;
    private EditText InputEmail;
    private EditText InputPassWord;
    private EditText InputAgianPW;
    private Button btnSignup;
    private Switch SwitchDienKhoan;

    public static final String TAG = SignupActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        HandlSignup();
    }

    public void HandlSignup() {
        InputNameLogin = findViewById(R.id.txtUserName);
        InputNumber = findViewById(R.id.txtPhoneNumber);
        InputEmail = findViewById(R.id.txtEmail);
        InputPassWord = findViewById(R.id.txtPassword);
        InputAgianPW = findViewById(R.id.txtPasswordAgain);
        SwitchDienKhoan = findViewById(R.id.switchDieuKhoan);
        btnSignup = findViewById(R.id.btnSignUp);

        SwitchDienKhoan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chapNhanDieuKhoan = isChecked;

            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = InputNameLogin.getText().toString().trim();
                String phoneNumber = InputNumber.getText().toString().trim();
                String email = InputEmail.getText().toString().trim();
                String password = InputPassWord.getText().toString().trim();
                String confirmPassword = InputAgianPW.getText().toString().trim();

                if (!chapNhanDieuKhoan) {
                    Toast.makeText(SignupActivity.this, "Bạn phải chấp nhận điều khoản", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(SignupActivity.this, "Tên đăng nhập không được trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(SignupActivity.this, "Số điện thoại không được trống", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!TextUtils.isDigitsOnly(phoneNumber)) {
                    Toast.makeText(SignupActivity.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignupActivity.this, "Email không được trống", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(SignupActivity.this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password) || password.length() < 5) {
                    Toast.makeText(SignupActivity.this, "Mật khẩu phải có ít nhất 5 kí tự", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(confirmPassword) || !password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Mật khẩu nhập lại không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                builder.setMessage("Chính sách bảo mật \n " +
                        "1.Không chia sẻ mật khẩu với bất kì tổ chức cá nhân nào \n 2.Thông báo cho người dùng về việc thu thập dữ liệu riêng tư và cách thức mà nó sử dụng.\n" +
                        "3.Cung cấp cho người dùng lựa chọn từ chối thu thập dữ liệu.\n" +
                        "4.Cho phép người dùng truy cập dữ liệu được thu thập hoặc tranh luận về tính chính xác của nó.\n" +
                        "5.Đảm bảo với người dùng rằng dữ liệu của họ an toàn và bảo mật." );


                builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Chuyển hướng đến trang đăng ký tài khoản
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }

                });
                builder.setNegativeButton("Hủy", null);
                builder.show();
            }
        });
    }
}
