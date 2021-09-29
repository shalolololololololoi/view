package com.test.myviewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2Employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



        this.viewPager2Employee = findViewById(R.id.viewPager2_employee);

        // Employee FragmentStateAdapter.
        EmployeeFragmentStateAdapter adapter = new EmployeeFragmentStateAdapter(this);
        this.viewPager2Employee.setAdapter(adapter);

        // PageTransformer
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // Api 21+.
            this.viewPager2Employee.setPageTransformer(new ZoomOutPageTransformer());
        }
    }
}