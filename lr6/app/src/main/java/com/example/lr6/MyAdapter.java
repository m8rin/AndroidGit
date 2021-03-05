package com.example.lr6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private static int viewHolderCount;
    private int numberItems;

    private String[] mCountries = {"Франция", "Испания", "Португалия", "Никарагуа", "Монголия",
            "Великобритания", "Малайзия", "Литва", "Словакия", "Польша", "Эстония", "Румыния",
            "Молдова", "Хорватия", "Япония", "Китай", "Намибия", "Мадагаскар", "Белоруссия", "Бангладеш", "Алжир",
            "Ангола", "Греция","Киргизия" ,"Мали", "Непал", "Южная Корея", "КНДР"};

    int[] mImageIds = {R.drawable.fr, R.drawable.spain, R.drawable.portugal,R.drawable.nicaragua,R.drawable.mongolia_640,
            R.drawable.united_kingdom_640,R.drawable.malaysia_640,R.drawable.lithuania_640,R.drawable.slovakia_640,
            R.drawable.poland_640,R.drawable.estonia_640,R.drawable.romania_640,R.drawable.moldova_640,
            R.drawable.croatia_640,R.drawable.japan_640,R.drawable.china_640,R.drawable.namibia_640,
            R.drawable.madagascar_640,R.drawable.belarus_640,R.drawable.bangladesh_640,R.drawable.algeria_640,
            R.drawable.angola_640,R.drawable.greece_640,R.drawable.kyrgyzstan_640,R.drawable.mali_640,
            R.drawable.nepal_640,R.drawable.korea_south_640,R.drawable.korea_north_640};

    public MyAdapter(int numberOfItems) {
        numberItems = numberOfItems;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.my_recycle;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        MyHolder viewHolder = new MyHolder(view);
        viewHolder.listItemView.setText("" + mCountries[viewHolderCount]);

        if (viewHolderCount == 100) {
            viewHolderCount = 0;
        }
        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView listItemView;
        ImageView imageView;

        public MyHolder(@NonNull View itemView) {
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
