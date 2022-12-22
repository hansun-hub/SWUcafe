//swucafe_2020111324_김한선_2022-12-15
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
        //fragment_2 화면 연결
        ViewGroup rootView =(ViewGroup)inflater.inflate(R.layout.fragment_2, container, false);

        //initUI 메서드
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

        //리사이클러뷰 항목 생성
        adapter.addItem(new Note(0,"150kcal","","","아메리카노(Ice)",
                "0","Best Menu"));
        adapter.addItem(new Note(1,"200kcal","","","아메리카노(HOT)",
                "1","Best Menu"));
        adapter.addItem(new Note(2,"160kcal","","","까페라떼(Hot)",
                "1","Best Menu"));
        adapter.addItem(new Note(3,"260kcal","","","고구마라떼(HOT)",
                "1","한정 메뉴"));
        adapter.addItem(new Note(4,"180kcal","","","바나나주스",
                "0","계절 메뉴"));
        adapter.addItem(new Note(5,"120kcal","","","딸기주스",
                "0", "계절 메뉴"));
        adapter.addItem(new Note(6,"126kcal","","","키위주스",
                "0","계절 메뉴"));
        adapter.addItem(new Note(7,"130kcal","","","오렌지주스",
                "0","계절 메뉴"));


        recyclerView.setAdapter(adapter);

        //어댑터뷰 항목 클릭 시
        adapter.setOnItemClickListener(new OnNoteItemClickListener() {
            @Override
            public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position) {
                Note item = adapter.getItem(position);

                //dialog_ 대화상자 생성
                View diaolgView = View.inflate(context,R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setTitle("                          < 주문 >");

                //대화상자_ 라디오버튼 목록
                final String[] option = new String[] {"포장", "매장"};
                dlg.setSingleChoiceItems(option,0, null);
                dlg.setView(diaolgView);

                //주문하기 버튼
                dlg.setPositiveButton("주문하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //주문하기 버튼을 눌렀을 경우
                        Toast.makeText(getContext(),item.getContents()+"주문 완료",Toast.LENGTH_SHORT).show();
                        MainActivity activity = (MainActivity)getActivity();
                        activity.onFragmentChanged(1);
                    }
                });

                //닫기 버튼
                dlg.setNegativeButton("닫기", null);
                dlg.show();
            }
        });

    }
}