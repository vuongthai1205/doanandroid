package com.example.myapplication.model;

public class Quyen {
    private int idQuyen;
    private String tenQuyen;

    public Quyen( String tenQuyen) {

        this.tenQuyen = tenQuyen;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdQuyen() {
        return idQuyen;
    }


    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}
