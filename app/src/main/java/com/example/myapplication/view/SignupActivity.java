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
    }

}



