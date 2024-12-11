package com.example.mytest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final List<String> originalItemList;
    private List<String> filteredItemList;

    public ItemAdapter(List<String> itemList) {
        this.originalItemList = new ArrayList<>(itemList);
        this.filteredItemList = new ArrayList<>(itemList);
    }

    public void filter(String query) {
        filteredItemList.clear();
        if (query == null || query.isEmpty()) {
            filteredItemList.addAll(originalItemList);
        } else {
            String lowerCaseQuery = query.toLowerCase();
            for (String item : originalItemList) {
                if (item.toLowerCase().contains(lowerCaseQuery)) {
                    filteredItemList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_detail, parent, false);
        return new ItemViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.textView.setText(filteredItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredItemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name); // ID из simple_list_item_1
        }
    }


}

