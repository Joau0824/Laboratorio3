package com.example.laboratorio3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class historialAdapter extends RecyclerView.Adapter<historialAdapter.HistorialViewHolder> {
    private Context context;

    public class HistorialViewHolder extends RecyclerView.ViewHolder{

        public HistorialViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    @NonNull
    @Override
    public HistorialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.historial_view, parent, false);
        return new HistorialViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistorialViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
