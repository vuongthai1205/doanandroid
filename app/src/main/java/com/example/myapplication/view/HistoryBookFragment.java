package com.example.myapplication.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHistoryBookBinding;


public class HistoryBookFragment extends Fragment {

    FragmentHistoryBookBinding fragmentHistoryBookBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHistoryBookBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_history_book, container, false);
        // Inflate the layout for this fragment
        return fragmentHistoryBookBinding.getRoot();
    }
}