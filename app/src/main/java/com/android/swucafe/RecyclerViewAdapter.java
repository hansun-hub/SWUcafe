package com.android.swucafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<String> items;

    public RecyclerViewAdapter(Context context, List<String> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.text.setText(items.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View diaolgView = View.inflate(context,R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                dlg.setIcon(R.drawable.movie_icon);
                dlg.setView(diaolgView);
                dlg.setNegativeButton("닫기", null);
                dlg.show();
           }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.tvCost);
        }
    }
}
