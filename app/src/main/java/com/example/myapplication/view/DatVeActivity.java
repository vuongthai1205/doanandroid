package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.config.FunctionPublic;
import com.example.myapplication.config.VariableGlobal;
import com.example.myapplication.databinding.ActivityDatVeBinding;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.viewmodel.DatVeViewModel;

import java.text.ParseException;
import java.util.Calendar;

public class DatVeActivity extends AppCompatActivity {

    ActivityDatVeBinding activityDatVeBinding;
    DatVeViewModel datVeViewModel = new DatVeViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDatVeBinding = DataBindingUtil.setContentView(this, R.layout.activity_dat_ve);
        activityDatVeBinding.setDatVeViewModel(datVeViewModel);

        if (getIntent()!= null){
            ChuyenXe chuyenXe = (ChuyenXe) getIntent().getExtras().getSerializable("chuyen_xe");

            datVeViewModel.xulyThongTin(chuyenXe,getApplicationContext());

            activityDatVeBinding.soLuongVe.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.toString() != null && !charSequence.toString().isEmpty()){


                        datVeViewModel.setSoLuongVe(charSequence.toString());
                        int soLuong = Integer.parseInt(charSequence.toString()) ;

                        double tongTien = FunctionPublic.tinhTongTien(soLuong, chuyenXe.getGiaTien());

                        datVeViewModel.setTongTien(FunctionPublic.formatMoney(tongTien));
                    }

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });

            activityDatVeBinding.xacNhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    datVeViewModel.luuDatVe(getApplicationContext(),chuyenXe);
                }
            });
        }



        activityDatVeBinding.edtNgayDi.setOnClickListener(view -> {

            showDatePickerDialog();
        });

        activityDatVeBinding.khuHoi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    activityDatVeBinding.edtNgayVe.setVisibility(View.VISIBLE);
                }
                else {
                    activityDatVeBinding.edtNgayVe.setVisibility(View.GONE);
                }
            }
        });

        activityDatVeBinding.edtNgayVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    showNgayVePickerDialog();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void showDatePickerDialog() {
        // Lấy ngày hiện tại để hiển thị trong DatePicker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Giới hạn ngày tối đa là ngày hiện tại
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatVeActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datVeViewModel.setSelectedCalendarDi(Calendar.getInstance());
                        // Xử lý ngày được chọn bởi người dùng ở đây
                        datVeViewModel.getSelectedCalendarDi().set(year, month, dayOfMonth);
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        // Hiển thị ngày đã chọn trong TextView
                        datVeViewModel.setNgayDi(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );

        // Giới hạn DatePickerDialog không cho phép chọn các ngày trong tương lai
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());

        // Hiển thị DatePickerDialog
        datePickerDialog.show();
    }

    public void showNgayVePickerDialog() throws ParseException {
        // Lấy ngày hiện tại để hiển thị trong DatePicker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        // Giới hạn ngày tối đa là ngày hiện tại
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                DatVeActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Xử lý ngày được chọn bởi người dùng ở đây
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        // Hiển thị ngày đã chọn trong TextView
                        datVeViewModel.setNgayVe(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );

        if (datVeViewModel.getNgayDi() != null && !datVeViewModel.getNgayDi().isEmpty()){
            //Giới hạn DatePickerDialog không cho phép chọn các ngày trước ngày hôm nay
            datePickerDialog.getDatePicker().setMinDate(datVeViewModel.getSelectedCalendarDi().getTimeInMillis());
            // Hiển thị DatePickerDialog
            datePickerDialog.show();
        }
        else {
            Toast.makeText(this, "Vui lòng chọn ngày đi" , Toast.LENGTH_SHORT).show();
        }


    }
}