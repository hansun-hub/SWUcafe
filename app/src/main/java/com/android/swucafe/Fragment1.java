//swucafe_2020111324_김한선_2022-12-15
package com.android.swucafe;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_1, container, false);
        //작성할 내용이 길어서 메서스로 만들어서 뺌_ initUI()
        initUI(rootView);
        //fragment1.xml의 button위젯 order 클릭시 이벤트 발생
        Button button = rootView.findViewById(R.id.order);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //프래그먼트에서 화면전환을 하려면 activity 정보를 가져와야 함
                MainActivity activity = (MainActivity)getActivity();
                //fragment간의 이동은 onFragmentChanged라는 함수로 진행
                activity.onFragmentChanged(0);
            }
        });
        return rootView;
    }
    private void initUI(ViewGroup rootView){ }
}