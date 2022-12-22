//swucafe_2020111324_김한선_2022-12-15
package com.android.swucafe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

//장바구니 화면
public class Fragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //fragment3 화면과 연결
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
}