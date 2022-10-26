package com.example.BBTG.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.BBTG.R;
import com.example.BBTG.model.Set;

import java.util.List;

public class SetAdapter extends RecyclerView.Adapter<SetAdapter.SetViewHolder> {

    private final Context context;
    private final List<Set> sets;

    public SetAdapter(Context context, List<Set> sets) {
        this.context = context;
        this.sets = sets;
    }

    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View setItems = LayoutInflater.from(context).inflate(R.layout.set_item, parent, false);
        return new SetViewHolder(setItems);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder, int position) {
        holder.setView.setText(sets.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return sets.size();
    }

    public static final class SetViewHolder extends RecyclerView.ViewHolder {

        TextView setView;

        public SetViewHolder(@NonNull View itemView) {
            super(itemView);
            setView = itemView.findViewById(R.id.setView);
        }
    }
}