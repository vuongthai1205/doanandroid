package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.config.DatabaseHelper;

public class SignupActivity extends AppCompatActivity {
    boolean chapNhanDieuKhoan = false;
    boolean allow = false;
    boolean show = false;
    private EditText InputNameLogin;
    private EditText InputName;
    private EditText InputLastName;
    private EditText InputNumber;
    private EditText InputEmail;
    private EditText InputPassWord;
    private EditText InputAgianPW;
    private Button btnSignup;
    private Switch SwitchDienKhoan;
    private ImageView txtDelete;
    private ImageView imgName;
    private ImageView imgLastName;
    private ImageView imgNumberPhone;
    private ImageView imgEmail;
    private ImageView imgShowPassWord;
    private ImageView imgShowPassWordAgain;
    public static final String TAG = SignupActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        HandlSignup();
    }

    private boolean isSwitchChecked() {
        return SwitchDienKhoan.isChecked();
    }


    public void HandlSignup() {
        InputNameLogin = findViewById(R.id.txtUserName);
        InputLastName = findViewById(R.id.txtLastName);
        InputName = findViewById(R.id.txtName);
        InputNumber = findViewById(R.id.txtPhoneNumber);
        InputEmail = findViewById(R.id.txtEmail);
        InputPassWord = findViewById(R.id.txtPassword);
        InputAgianPW = findViewById(R.id.txtPasswordAgain);
        SwitchDienKhoan = findViewById(R.id.switchDieuKhoan);
        btnSignup = findViewById(R.id.btnSignUp);

        // Xóa tên đăng nhập
        txtDelete = findViewById(R.id.imgDelete);
        txtDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            InputNameLogin = (EditText) findViewById(R.id.txtUserName);
                InputNameLogin.setText("");
            }
        });

        // Xóa tên người dùng
        imgName = findViewById(R.id.deleteName);
        imgName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputName = (EditText) findViewById(R.id.txtName);
                InputName.setText("");
            }
        });

        // Xóa họ người dùng
        imgLastName = findViewById(R.id.deleteLastName);
        imgLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputLastName = (EditText) findViewById(R.id.txtLastName);
                InputLastName.setText("");
            }
        });

        // Xóa số điện thoại
        imgNumberPhone = findViewById(R.id.deleteNumberPhone);
        imgNumberPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputNumber = (EditText) findViewById(R.id.txtPhoneNumber);
                InputNumber.setText("");
            }
        });

        // Xóa Email
        imgEmail = findViewById(R.id.deleteEmail);
        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputEmail = (EditText) findViewById(R.id.txtEmail);
                InputEmail.setText("");
            }
        });

        // Ẩn hiện mật khẩu
        imgShowPassWord = (ImageView) findViewById(R.id.imgShowPassword);
        imgShowPassWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show) {
                    // Ẩn mật khẩu
                    InputPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show = false;
                } else {
                    // Hiển thị mật khẩu
                    InputPassWord.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    show = true;
                }

                // Di chuyển con trỏ về cuối chuỗi trong EditText
                InputPassWord.setSelection(InputPassWord.getText().length());
            }
        });
        // Ẩn hiện ô nhập lại mật khẩu
        imgShowPassWordAgain= (ImageView) findViewById(R.id.imgShowPasswordAgain);
        imgShowPassWordAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (show) {
                    // Ẩn mật khẩu
                    InputAgianPW.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    show = false;
                } else {
                    // Hiển thị mật khẩu
                    InputAgianPW.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    show = true;
                }

                // Di chuyển con trỏ về cuối chuỗi trong EditText
                InputAgianPW.setSelection(InputAgianPW.getText().length());
            }
        });

        // Button đăng nhập
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = InputNameLogin.getText().toString().trim();
                String name = InputLastName.getText().toString().trim();
                String lastName = InputName.getText().toString().trim();
                String phoneNumber = InputNumber.getText().toString().trim();
                String email = InputEmail.getText().toString().trim();
                String password = InputPassWord.getText().toString().trim();
                String confirmPassword = InputAgianPW.getText().toString().trim();


                // Kiểm phải chấp nhận điều khoan thì mới cho đăng kí
                if (!chapNhanDieuKhoan) {
                    if (!isSwitchChecked()) {
                        Toast.makeText(SignupActivity.this, "Bạn phải chấp nhận điều khoản", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignupActivity.this);
                        builder.setMessage("Chính sách bảo mật \n " +
                                "1." + " " +"Không chia sẻ mật khẩu với bất kì tổ chức cá nhân nào \n 2.Thông báo cho người dùng về việc thu thập dữ liệu riêng tư và cách thức mà nó sử dụng.\n" +
                                "3."+" " + " Cung cấp cho người dùng lựa chọn từ chối thu thập dữ liệu.\n" +
                                "4."+" "+"Cho phép người dùng truy cập dữ liệu được thu thập hoặc tranh luận về tính chính xác của nó.\n" +
                                "5."+" " +"Đảm bảo với người dùng rằng dữ liệu của họ an toàn và bảo mật.");


                        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // điều khiển bật tất swtich điều khoản
                                // allow =true;

                                SwitchDienKhoan.setChecked(true);
                            }
                        });
                        builder.setNegativeButton("Hủy", null);
                        builder.show();
                        return;
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Bạn đã chấp nhận điều khoản", Toast.LENGTH_SHORT).show();

                    }

                }


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(SignupActivity.this, "Tên đăng nhập không được trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(lastName) ) {
                    Toast.makeText(SignupActivity.this, "Họ tên người dùng không được trống", Toast.LENGTH_SHORT).show();
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


                DatabaseHelper databaseHelper = new DatabaseHelper(SignupActivity.this);
                SQLiteDatabase db = databaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(databaseHelper.getCOLUMN_TEN_DANG_NHAP(), username);
                values.put(databaseHelper.getCOLUMN_HO(), name);
                values.put(databaseHelper.getCOLUMN_TEN(), lastName);
                values.put(databaseHelper.getCOLUMN_MAT_KHAU(), password);
                values.put(databaseHelper.getCOLUMN_SO_DIEN_THOAI(), phoneNumber);
                values.put(databaseHelper.getCOLUMN_EMAIL(), email);
                values.put(databaseHelper.getCOLUMN_ID_QUYEN_THANHVIEN(), 3);

                long result = db.insert(databaseHelper.getTABLE_THANHVIEN(), null, values);

                if (result != -1) {
                    Toast.makeText(SignupActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Đăng ký không thành công hãy kiểm tra lại thông tin", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });
            }

        }



