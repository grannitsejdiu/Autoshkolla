package com.example.admin.autoshkolla;

import android.support.design.widget.TabLayout;
import android.support.v4.view.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.autoshkolla.Ligjeratat.Ligjeratat_RecyclerAdapter;
import com.example.admin.autoshkolla.Models.Exam;
import com.example.admin.autoshkolla.Models.Group;
import com.example.admin.autoshkolla.Models.This;
import com.example.admin.autoshkolla.ServiceLayer.ExamsLayer;
import com.example.admin.autoshkolla.ServiceLayer.GroupsLayer;
import com.example.admin.autoshkolla.ServiceLayer.ResponseData;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExamsLayer.getAllExams(new ResponseData() {
            @Override
            public void onSuccess(Object data) {

                List<Exam> aa = (ArrayList<Exam>)data;
                This.exams = aa;
            }
        });

        GroupsLayer.getAllGroups(new ResponseData() {
            @Override
            public void onSuccess(Object data) {
                List<Group> gs = (ArrayList<Group>)data;
                This.groups = gs;
            }
        });


        //region ViewPager
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new com.example.admin.autoshkolla.PagerAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
        //endregion


//
    }
}
