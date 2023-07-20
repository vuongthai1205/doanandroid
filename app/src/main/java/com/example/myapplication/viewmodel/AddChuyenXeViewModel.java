package com.example.myapplication.viewmodel;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.config.AppDatabase;
import com.example.myapplication.model.ChuyenXe;
import com.example.myapplication.model.DAO.ChuyenXeDAO;
import com.example.myapplication.model.DAO.LoaiXeDAO;
import com.example.myapplication.view.ListChuyenXeFragment;

import java.util.Calendar;
import java.util.List;

public class AddChuyenXeViewModel extends BaseObservable {
    private String tenChuyenXe;
    private String diaDiemDi;
    private String diaDiemDen;
    private String thoiGianDi;
    private String thoiGianDen;
    private String ngayDi;
    private String ngayVe;
    private int idLoaiXe;
    private String hinhAnh;
    private String giaTien;
    private String moTa;
    private Calendar calendarNgayDi;
    private Calendar selectedCalendarDi;

    public void showDatePickerDialogNgayDi(Context context) {
        // Lấy ngày hiện tại để hiển thị trong DatePicker
         calendarNgayDi = Calendar.getInstance();
        int year = calendarNgayDi.get(Calendar.YEAR);
        int month = calendarNgayDi.get(Calendar.MONTH);
        int dayOfMonth = calendarNgayDi.get(Calendar.DAY_OF_MONTH);

        // Giới hạn ngày tối đa là ngày hiện tại
        DatePickerDialog datePickerDialogNgayDi = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        selectedCalendarDi = Calendar.getInstance();
                        selectedCalendarDi.set(year, month, dayOfMonth);
                        // Xử lý ngày được chọn bởi người dùng ở đây
                        String selectedDateDi = dayOfMonth + "/" + (month + 1) + "/" + year;
                        // Hiển thị ngày đã chọn trong TextView
                        setNgayDi(selectedDateDi);
                    }
                },
                year,
                month,
                dayOfMonth
        );


        // Giới hạn DatePickerDialog không cho phép chọn các ngày trước ngày hôm nay
        datePickerDialogNgayDi.getDatePicker().setMinDate(System.currentTimeMillis());

        // Hiển thị DatePickerDialog
        datePickerDialogNgayDi.show();
    }

    public void showDatePickerDialogNgayVe(Context context) {
        // Lấy ngày hiện tại để hiển thị trong DatePicker
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialogNgayVe = new DatePickerDialog(
                context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            // Xử lý ngày được chọn bởi người dùng khi ngày về hợp lệ
                            String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                            // Hiển thị ngày đã chọn trong TextView
                            setNgayVe(selectedDate);
                    }
                },
                year,
                month,
                dayOfMonth
        );
         //Giới hạn DatePickerDialog không cho phép chọn các ngày trước ngày hôm nay
        datePickerDialogNgayVe.getDatePicker().setMinDate(selectedCalendarDi.getTimeInMillis());
        // Hiển thị DatePickerDialog
        datePickerDialogNgayVe.show();
    }

    public List<String> getListTenLoaiXe(Context context){

        List<String> tenLoaiXe = AppDatabase.getInstance(context).getLoaiXeDAO().getTenLoaiXe();
        return tenLoaiXe;
    }

    public int getIdLoaiXeByName(Context context,String tenLoaiXe){
        LoaiXeDAO loaiXeDAO = AppDatabase.getInstance(context).getLoaiXeDAO();
        idLoaiXe =loaiXeDAO.getIDLoaiXe(tenLoaiXe);
        return  idLoaiXe;
    }

    public void AddChuyenXe(Context context){
        if (kiemTraNhap(tenChuyenXe,diaDiemDi,diaDiemDen,thoiGianDi,thoiGianDen,ngayDi,ngayVe)==false) {
            Toast.makeText(context,"Vui lòng nhập đầy đủ dữ liệu",Toast.LENGTH_SHORT).show();
            return;
        }
        ChuyenXeDAO chuyenXeDAO = AppDatabase.getInstance(context).getChuyenXeDAO();
        ChuyenXe chuyenXe = new ChuyenXe();
        chuyenXe.setIdLoaiXe(getIdLoaiXe());
        chuyenXe.setTenChuyen(getTenChuyenXe());
        chuyenXe.setHinhAnh(getHinhAnh());
        chuyenXe.setThoiGianBatDau(getThoiGianDi());
        chuyenXe.setThoiGianKetThuc(getThoiGianDen());
        chuyenXe.setNgayDi(getNgayDi());
        chuyenXe.setNgayVe(getNgayVe());
        chuyenXe.setDiaDiemDi(getDiaDiemDi());
        chuyenXe.setDiaDiemDen(getDiaDiemDen());
        chuyenXe.setGiaTien(Double.parseDouble(getGiaTien()));
        chuyenXe.setMoTa(getMoTa());
        chuyenXeDAO.insert(chuyenXe);

        this.setTenChuyenXe("");
        this.setThoiGianDi("");
        this.setThoiGianDen("");
        this.setNgayDi("");
        this.setNgayVe("");
        this.setDiaDiemDi("");
        this.setDiaDiemDen("");
        this.setGiaTien("0");
        this.setMoTa("");


        Toast.makeText(context,"Thêm chuyến xe thành công",Toast.LENGTH_SHORT).show();
        goToListFragment(context);
    }

    public void goToListFragment(Context context){

        ListChuyenXeFragment listChuyenXeFragment = new ListChuyenXeFragment();
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerChuyenXeManager, listChuyenXeFragment);
        fragmentTransaction.commit();
    }


    public boolean kiemTraNhap(String tenChuyenXe, String diaDiemDi, String diaDiemDen,String thoiGianDi,String thoiGianDen,String ngayDi,String ngayVe) {
        //Tên đăng nhập và mật khẩu trống
        if (TextUtils.isEmpty(tenChuyenXe) || TextUtils.isEmpty(diaDiemDi) || TextUtils.isEmpty(diaDiemDen)|| TextUtils.isEmpty(thoiGianDi)|| TextUtils.isEmpty(thoiGianDen)|| TextUtils.isEmpty(ngayDi)|| TextUtils.isEmpty(ngayVe)) {
            return false;
        }
        return true;
    }
    @Bindable
    public String getTenChuyenXe() {
        return tenChuyenXe;
    }

    public void setTenChuyenXe(String tenChuyenXe) {
        this.tenChuyenXe = tenChuyenXe;
        notifyPropertyChanged(BR.tenChuyenXe);
    }

    @Bindable
    public String getDiaDiemDi() {
        return diaDiemDi;
    }

    public void setDiaDiemDi(String diaDiemDi) {
        this.diaDiemDi = diaDiemDi;
        notifyPropertyChanged(BR.diaDiemDi);
    }

    @Bindable
    public String getDiaDiemDen() {
        return diaDiemDen;
    }

    public void setDiaDiemDen(String diaDiemDen) {
        this.diaDiemDen = diaDiemDen;
        notifyPropertyChanged(BR.diaDiemDen);
    }

    @Bindable
    public String getThoiGianDi() {
        return thoiGianDi;
    }

    public void setThoiGianDi(String thoiGianDi) {
        this.thoiGianDi = thoiGianDi;
        notifyPropertyChanged(BR.thoiGianBatDau);
    }

    @Bindable
    public String getThoiGianDen() {
        return thoiGianDen;
    }

    public void setThoiGianDen(String thoiGianDen) {
        this.thoiGianDen = thoiGianDen;
        notifyPropertyChanged(BR.thoiGianKetThuc);
    }

    @Bindable
    public String getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
        notifyPropertyChanged(BR.ngayDi);
    }

    @Bindable
    public String getNgayVe() {
        return ngayVe;
    }

    public void setNgayVe(String ngayVe) {
        this.ngayVe = ngayVe;
        notifyPropertyChanged(BR.ngayVe);
    }

    @Bindable
    public int getIdLoaiXe() {
        return idLoaiXe;
    }

    public void setIdLoaiXe(int idLoaiXe) {
        this.idLoaiXe = idLoaiXe;
        notifyPropertyChanged(BR.idLoaiXe);
    }

    @Bindable
    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Bindable
    public Calendar getSelectedCalendarDi() {
        return selectedCalendarDi;
    }

    public void setSelectedCalendarDi(Calendar selectedCalendarDi) {
        this.selectedCalendarDi = selectedCalendarDi;
    }
    @Bindable
    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
        notifyPropertyChanged(BR.giaTien);
    }

    @Bindable
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
        notifyPropertyChanged(BR.moTa);
    }
}