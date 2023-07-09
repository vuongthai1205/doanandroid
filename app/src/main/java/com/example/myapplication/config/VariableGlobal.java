package com.example.myapplication.config;

import java.text.SimpleDateFormat;

public class VariableGlobal {
    public static final String pattern = "dd-MM-yyyy";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
}
