package com.example.arunalu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class viewSubUser extends AppCompatActivity {

//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//
//    PagerAdapter pageAdapter = new PagerAdapter (getSupportFragmentManager (), tabLayout.getTabCount());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sub_user);

//        tabLayout = findViewById(R.id.tabId);
//
//        viewPager = findViewById(R.id.viewpager_id);
//
//        viewPager.setAdapter(pageAdapter);
//
//        viewPager.addOnPageChangeListener (new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
