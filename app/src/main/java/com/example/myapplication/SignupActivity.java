package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

public class SignupActivity extends AppCompatActivity {
    boolean chapNhanDieuKhoan = false;

    private EditText InputNameLogin;
    private EditText InputNumber;
    private EditText InputEmail;
    private EditText InputPassWord;
    private EditText InputAgianPW;
    private Button btnSignup;
    private Switch SwitchDienKhoan;

    // Tạo intent để chuyển trang

    public static final String TAG = SignupActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            Log.e(TAG, "Debug SignupActivity" );
        }
        else{
            Log.e(TAG, "Welcome SignupActivity");
        }
        setContentView(R.layout.activity_signup);
        HandlSignup();
        HandleSwitch();


    // Hàm xử lý chính
    }
    public void HandlSignup() {
        InputNameLogin = (EditText) findViewById(R.id.txtUserName);
        InputNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        InputEmail = (EditText) findViewById(R.id.txtEmail);
        InputPassWord = (EditText) findViewById(R.id.txtPassword);
        InputAgianPW = (EditText) findViewById(R.id.txtPasswordAgain);
        SwitchDienKhoan = (Switch) findViewById(R.id.switchDieuKhoan);
        btnSignup = (Button) findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnSignup();
                if (chapNhanDieuKhoan){
                    Toast.makeText(getApplicationContext(), "Bạn đã đăng kí thành công!", Toast.LENGTH_SHORT).show();
                    NextPage();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Bạn phải chấp nhận điều khoản!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // Hàm chuyển trang
    public void NextPage(){
        Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    // Hàm xử lý Điều khoản
    public void HandleSwitch() {

        SwitchDienKhoan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    chapNhanDieuKhoan = true;
                    Toast.makeText(getApplicationContext(), "Bạn đã chấp nhận điều khoản!", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Bạn chưa chấp nhận điều khoản!", Toast.LENGTH_SHORT).show();

                    chapNhanDieuKhoan = false;
                }
            }
        });
    }
    // hàm xử lý button đăng ký
    public void btnSignup(){
        String inputNameLogin = InputNameLogin.getText().toString().trim();
        String inputNumber = InputNumber.getText().toString().trim();
        String inputEmail = InputEmail.getText().toString().trim();
        String inputPassWord = InputPassWord.getText().toString().trim();
        String inputAgainPW = InputAgianPW.getText().toString().trim();
        String chooseDieuKhoan = SwitchDienKhoan.getText().toString().trim();



        // kiểm tra tên đăng nhập và số điên thoại không trống
        if(TextUtils.isEmpty(inputNameLogin) || (TextUtils.isEmpty(inputNumber))){
                Toast.makeText(this, "Không được để trống tên đăng nhập hoặc số điện thoại ",Toast.LENGTH_SHORT).show();
                return;
        }

        // kiểm tra số điện thoại phải là số
        if (!TextUtils.isDigitsOnly(inputNumber))
            Toast.makeText(this, "Số điện thoại phải là số! ",Toast.LENGTH_SHORT).show();

        // kiểm tra email phải hợp lệ và không trống
        if (TextUtils.isEmpty(inputEmail)){
            Toast.makeText(this, "Không được để trống email ",Toast.LENGTH_SHORT).show();
            return;
        }  else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()) {
            Toast.makeText(this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        // kiểm tra password không trống và độ dài của password
        if (TextUtils.isEmpty(inputPassWord)){
            Toast.makeText(this, "Không được để trống mật khẩu",Toast.LENGTH_SHORT).show();

        }
        else if (inputPassWord.length() < 5) {
            Toast.makeText(this, "Mật khẩu phải có ít nhất 5 ký tự", Toast.LENGTH_SHORT).show();

        }

        // Kiểm tra password phải trùng với ô nhập password
        if (TextUtils.isEmpty(inputAgainPW)){
            Toast.makeText(this, "Không được để trống nhập lại mật khẩu ",Toast.LENGTH_SHORT).show();

        }
        else if(!inputAgainPW.equals(inputPassWord)){
            Toast.makeText(this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
        }


    }
}