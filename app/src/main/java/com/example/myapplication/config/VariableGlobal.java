package com.example.myapplication.config;

import java.text.SimpleDateFormat;

public class VariableGlobal {
    public static final String PATTERN = "dd-MM-yyyy";

    public static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
}
