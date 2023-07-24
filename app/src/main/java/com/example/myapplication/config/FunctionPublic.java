package com.example.myapplication.config;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FunctionPublic {
    public static boolean isTenDangNhapValid(String tenDangNhap) {
        // Biểu thức chính quy kiểm tra viết liền không dấu
        String regex = "^[a-zA-Z0-9]+$";

        // Kiểm tra trường "tenDangNhap" với biểu thức chính quy
        return tenDangNhap.matches(regex);
    }

    public static boolean isEmailValid(String email) {
        // Biểu thức chính quy kiểm tra định dạng email
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

        // Kiểm tra trường "email" với biểu thức chính quy
        return email.matches(regex);
    }

    public static boolean isPasswordValid(String password) {
        // Kiểm tra độ dài mật khẩu
        if (password.length() >= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static void loadAvatar(String url, ImageView imageView, Context context){
        Glide.with(context)
                .load(url)
                .into(imageView);
    }

    public static String formatMoney(Double money){
        String moneyString = "";
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("#,###.##");
        moneyString = decimalFormat.format(money);
        moneyString += " VND";
        return moneyString;
    }

    public static String formatDouble(double so){
        String result = "";
        if (so >0){
            DecimalFormat decimalFormat = new DecimalFormat("#.0");
            result = decimalFormat.format(so);
        }
        else {
            result ="0";
        }

        return result;
    }
}
