package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import com.example.myapplication.databinding.ActivitySignupBinding;
import com.example.myapplication.model.ThanhVien;
import com.example.myapplication.model.ThanhVienRepository;
import com.example.myapplication.viewmodel.SignupViewModel;

public class SignupActivity extends AppCompatActivity {
    ActivitySignupBinding activitySignupBinding;
    SignupViewModel signupViewModel = new SignupViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySignupBinding = DataBindingUtil.setContentView(this, R.layout.activity_signup);
        activitySignupBinding.setSignupViewModel(signupViewModel);
        activitySignupBinding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signupViewModel.handleSignup(getApplicationContext());

            }
        });
        handleDeleteText();
        handleShowPassword();
    }

    private void handleShowPassword() {
        activitySignupBinding.imgShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPass(activitySignupBinding.txtPassword);
            }
        });
        activitySignupBinding.imgShowPasswordAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPass(activitySignupBinding.txtPasswordAgain);
            }
        });
    }

    private boolean showPass(EditText editText) {
        if (editText.getTransformationMethod() instanceof PasswordTransformationMethod) {
            // Nếu đang ẩn mật khẩu, hiển thị văn bản
            editText.setTransformationMethod(null);
            return true;
        } else {
            // Nếu đang hiển thị văn bản, ẩn mật khẩu
            editText.setTransformationMethod(new PasswordTransformationMethod());
            return false;
        }
    }



    private void handleDeleteText(){
        activitySignupBinding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignupBinding.txtUserName);
            }
        });
        activitySignupBinding.deleteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignupBinding.txtName);
            }
        });
        activitySignupBinding.deleteLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignupBinding.txtLastName);
            }
        });
        activitySignupBinding.deleteNumberPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignupBinding.txtPhoneNumber);
            }
        });
        activitySignupBinding.deleteEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteText(activitySignupBinding.txtEmail);
            }
        });
    }
    private void deleteText(EditText view){
        view.setText("");
    }


}



