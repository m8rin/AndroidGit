package com.example.lab6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewHolder> {

    private static int viewHolderCount;
    private int numberItems;

    private String[] mCountries = {"Франция", "Испания", "Португалия", "Никарагуа", "Монголия",
            "Великобритания", "Малайзия", "Литва", "Словакия", "Польша", "Эстония", "Румыния",
            "Молдова", "Хорватия", "Япония", "Китай", "Намибия", "Мадагаскар", "Белоруссия"};

    int[] mImageIds = {R.drawable.france, R.drawable.es, R.drawable.pt, R.drawable.ni, R.drawable.mn,
            R.drawable.uk, R.drawable.my, R.drawable.lt, R.drawable.sk, R.drawable.pl, R.drawable.ee,
            R.drawable.ro, R.drawable.md, R.drawable.hr, R.drawable.jp, R.drawable.cn, R.drawable.na,
            R.drawable.mg, R.drawable.by};

    public MyRecyclerViewAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.recyclerview_row;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        MyRecyclerViewHolder viewHolder = new MyRecyclerViewHolder(view);
        viewHolder.listItemView.setText("" + mCountries[viewHolderCount]);

        if (viewHolderCount == 18) {
            viewHolderCount = 0;
        }
        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewHolder holder, int position) {
        //holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView listItemView;
        ImageView imageView;

        public MyRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            listItemView = itemView.findViewById(R.id.tv_text_item3);
            imageView = itemView.findViewById(R.id.iv_image_item3);

            imageView.setImageResource(mImageIds[viewHolderCount]);
        }

        void bind(int listIndex) {
            // listItemView.setText(String.valueOf(listIndex));
        }
    }
}