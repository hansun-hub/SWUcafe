package com.android.swucafe;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    RecyclerView recyclerView;
    NoteAdapter adapter;
    Context context;
    OnTabItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        if(context instanceof OnTabItemSelectedListener){
            listener = (OnTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();

        if(context != null){
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_2, container, false);

        initUI(rootView);

        return rootView;
    }

    //initUI메서드
    private void initUI(ViewGroup rootView){

        //fragment2.xml의 recyclerView 위젯 등록
        recyclerView = rootView.findViewById(R.id.recyclerView);

        //리니어레이아웃 지정
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //어댑터 생성
        adapter = new NoteAdapter();

        adapter.addItem(new Note(0,"0","150kcal","","","아메리카노(Ice)",
                "0",null,"Best Menu"));
        adapter.addItem(new Note(1,"0","200kcal","","","아메리카노(HOT)",
                "1",null,"Best Menu"));
        adapter.addItem(new Note(2,"0","160kcal","","","까페라떼(Hot)",
                "1",null,"Best Menu"));
        adapter.addItem(new Note(3,"0","260kcal","","","고구마라떼(HOT)",
                "1",null,"한정 메뉴"));
        adapter.addItem(new Note(4,"0","180kcal","","","바나나주스",
                "0",null,"계절 메뉴"));
        adapter.addItem(new Note(5,"0","120kcal","","","딸기주스",
                "0",null, "계절 메뉴"));
        adapter.addItem(new Note(6,"0","126kcal","","","키위주스",
                "0",null,"계절 메뉴"));
        adapter.addItem(new Note(7,"0","130kcal","","","오렌지주스",
                "0",null,"계절 메뉴"));


        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnNoteItemClickListener() {
            @Override
            public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position) {
                Note item = adapter.getItem(position);

                View diaolgView = View.inflate(context,R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setIcon(R.drawable.movie_icon);
                final String[] option = new String[] {"포장", "매장"};
                dlg.setSingleChoiceItems(option,0, null);
                dlg.setView(diaolgView);
                dlg.setPositiveButton("주문하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),item.getContents()+"주문 완료",Toast.LENGTH_SHORT).show();
                        MainActivity activity = (MainActivity)getActivity();
                        activity.onFragmentChanged(1);
                    }
                });
                dlg.setNegativeButton("닫기", null);
                dlg.show();

//                Toast.makeText(getContext(),"아이템 선택됨 : "+ item.getContents(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}