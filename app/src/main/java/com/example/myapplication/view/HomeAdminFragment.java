package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeAdminBinding;


public class HomeAdminFragment extends Fragment {
    FragmentHomeAdminBinding fragmentHomeAdminBinding;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        fragmentHomeAdminBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_admin,container,false);
//        fragmentHomeAdminBinding.imgQuanLiChuyenXe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ChuyenXeAdminFragment chuyenXeAdminFragment = new ChuyenXeAdminFragment();
//                FragmentManager fragmentManager = getChildFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragmentAdmin, chuyenXeAdminFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_admin, container, false);

    }
}