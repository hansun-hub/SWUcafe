//swucafe_2020111324_김한선_2022-12-15
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

    //화면전환 할 fragment를 3개 만듬
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    //하단 메뉴 bottomNavigation
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        //처음 화면을 fragment1로 설정해줌
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        //xml의 하단 네비게이션 위젯과 연결
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //하단 네비게이션 위젯 클릭했을 때 리스너 작성
        bottomNavigation.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        //첫번쩨 탭 선택시
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                        return true;

                    case R.id.tab2:
                        //두번쩨 탭 선택시
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                        return true;

                    case R.id.tab3:
                        //세번쩨 탭 선택시
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
                        return true;
                }
                return false;
            }
        });
    }

    //프래그먼트 교체시 사용되는 메서드
    public void onFragmentChanged(int index){
        //index=0인 경우 메뉴인 fragment2 화면으로 이동
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }
        //index=1인 경우 장바구니인 fragment3 화면으로 이동
        if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
        }

    }
}