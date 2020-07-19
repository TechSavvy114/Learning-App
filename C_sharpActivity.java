package com.example.codingstuff;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.codingstuff.ADAPTERS.All_View_Pager_Adapter;
import com.google.android.material.tabs.TabLayout;

public class C_sharpActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sharp);
        toolbar=findViewById(R.id.toolbar_C_Sharp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("C#");

        tabLayout=findViewById(R.id.tab_C_Sharp);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#D81B60"));
        tabLayout.setTabTextColors(Color.parseColor("#F8F9FA"), Color.parseColor("#D81B60"));



        viewPager=findViewById(R.id.C_Sharp_pager);
        All_View_Pager_Adapter adapter=new All_View_Pager_Adapter(getSupportFragmentManager(), FragmentStatePagerAdapter.
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount(),"C_SHARP");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.java));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(C_sharpActivity.this,
                                R.color.java));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.java));;
                } else if (tab.getPosition() == 2) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.and));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(C_sharpActivity.this,
                                R.color.and));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.and));
                } else if (tab.getPosition() == 3) {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            android.R.color.holo_blue_bright));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(C_sharpActivity.this,
                                android.R.color.holo_blue_bright));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            android.R.color.holo_blue_bright));
                }
                else {
                    tabLayout.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.colorPrimary));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(C_sharpActivity.this,
                                R.color.colorPrimary));
                    }
                    toolbar.setBackgroundColor(ContextCompat.getColor(C_sharpActivity.this,
                            R.color.colorPrimary));
                }}


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}