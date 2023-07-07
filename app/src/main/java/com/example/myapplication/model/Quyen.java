package com.example.myapplication.model;

public class Quyen {
    private int idQuyen;
    private String tenQuyen;

    public Quyen(int idQuyen, String tenQuyen) {
        this.idQuyen = idQuyen;
        this.tenQuyen = tenQuyen;
    }

    // Các phương thức truy cập (getter) và cập nhật (setter) cho các trường

    public int getIdQuyen() {
        return idQuyen;
    }

    public void setIdQuyen(int idQuyen) {
        this.idQuyen = idQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }
}
