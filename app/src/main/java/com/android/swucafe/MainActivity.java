package com.android.swucafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tab1:
//                        Toast.makeText(getApplicationContext(),"첫번쩨 탭 선택됨", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                        return true;

                    case R.id.tab2:
//                        Toast.makeText(getApplicationContext(),"두번쩨 탭 선택됨", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                        return true;

                    case R.id.tab3:
//                        Toast.makeText(getApplicationContext(),"세번쩨 탭 선택됨", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                        return true;

                }
                return false;
            }
        });
    }
    public void onTabSelected(int position){
        if(position == 0){
            bottomNavigation.setSelectedItemId(R.id.tab1);
        }else if(position == 1){
            fragment2 = new Fragment2();

            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        }else if(position==2){
            bottomNavigation.setSelectedItemId(R.id.tab3);
        }
    }

    public void onFragmentChanged(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }
        if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
        }

    }
}