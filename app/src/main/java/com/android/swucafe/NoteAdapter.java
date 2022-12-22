//swucafe_2020111324_김한선_2022-12-15
package com.android.swucafe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//NoteAdapter _ 뷰홀더 패턴
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>
        implements OnNoteItemClickListener{

    //Note클래스 객체로 Array 만듬
    ArrayList<Note> items = new ArrayList<Note>();

    OnNoteItemClickListener listener;

    int layoutType=0;

    @NonNull
    @Override
    //ViewHolder 클래스 객체를 생성하는 메서드
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.row_recyclerview, parent, false);

        return new ViewHolder(itemView, this, layoutType);
    }

    @Override
    //어댑터 생성자에 넘어온 데이터를 ViewHolder에 설정하는 메서드
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note item = items.get(position);
        holder.setItem(item);
        holder.setLayoutType(layoutType);
    }

    @Override
    //목록에 보여줄 아이템의 개수
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Note item) {
        items.add(item);
    }

    public void setItems(ArrayList<Note> items) {
        this.items = items;
    }

    public Note getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnNoteItemClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        LinearLayout layout1;
        ImageView ImageView;
        TextView contentsTextView;
        TextView KcalTextView;
        TextView descriptTextView;

        //아이템들 하나하나의 view 보여지게 할 수 있는 객체
        public ViewHolder(@NonNull View itemView, final OnNoteItemClickListener listener, int layoutType) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);

            ImageView = itemView.findViewById(R.id.ImageView);

            contentsTextView = itemView.findViewById(R.id.contentsTextView);

            KcalTextView = itemView.findViewById(R.id.kcalTextView);

            descriptTextView = itemView.findViewById(R.id.descriptTextView);

            //아이템뷰를 클릭하면 뷰홀더가 보여짐
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
            setLayoutType(layoutType);
        }

        //이미지, 내용, 칼로리, 설명을 각각의 item에 셋팅
        public void setItem(Note item){
            String img = item.getImg();
            int imgIndex = Integer.parseInt(img);
            setImage(imgIndex);

            contentsTextView.setText(item.getContents());
            KcalTextView.setText(item.getKcal());
            descriptTextView.setText(item.getDescript());
        }

        //image 셋팅
        public void setImage(int moodIndex) {
            switch (moodIndex) {
                //찬 음료
                case 0:
                    ImageView.setImageResource(R.drawable.ic_baseline_coffee_24);
                    break;
                    //따뜻한 음료
                case 1:
                    ImageView.setImageResource(R.drawable.ic_baseline_emoji_food_beverage_24);
                    break;
                default:
                    ImageView.setImageResource(R.drawable.ic_baseline_coffee_24);
                    break;
            }
        }

        //layout1을 VISIBLE 하게 함
        public void setLayoutType(int layoutType) {
            if (layoutType == 0) {
                layout1.setVisibility(View.VISIBLE);
            } else if (layoutType == 1) {
                layout1.setVisibility(View.GONE);
            }
        }

    }

}
