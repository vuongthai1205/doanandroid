package com.example.myapplication.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityChuyenXeManagerBinding;
import com.example.myapplication.viewmodel.ChuyenXeManagerViewModel;
import com.google.android.material.navigation.NavigationBarView;

public class ChuyenXeManager extends AppCompatActivity {
    private boolean isRootFragmentAdded = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChuyenXeManagerViewModel chuyenXeManagerViewModel = new ChuyenXeManagerViewModel();
        ActivityChuyenXeManagerBinding activityChuyenXeManagerBinding = DataBindingUtil.setContentView(this, R.layout.activity_chuyen_xe_manager);
        activityChuyenXeManagerBinding.setChuyenXeManagerViewModel(chuyenXeManagerViewModel);

        if (!isRootFragmentAdded) {
            // Nếu fragment gốc chưa được thêm vào, thêm nó vào container
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(activityChuyenXeManagerBinding.containerChuyenXeManager.getId(), ListChuyenXeFragment.class, null);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

            // Đánh dấu rằng fragment gốc đã được thêm vào
            isRootFragmentAdded = true;
        }

        activityChuyenXeManagerBinding.menuChuyenXeManager.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_show){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityChuyenXeManagerBinding.containerChuyenXeManager.getId(), ListChuyenXeFragment.class, null).addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                else if(item.getItemId() == R.id.action_add){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(activityChuyenXeManagerBinding.containerChuyenXeManager.getId(), AddChuyenXeFragment.class, null).addToBackStack(null);
                    fragmentTransaction.commit();
                    return true;
                }
                return false;
            }
        });
    }
}
