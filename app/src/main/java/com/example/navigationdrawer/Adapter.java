package com.example.navigationdrawer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.navigationdrawer.Item;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.HolderData> {

    List<Item> listData;
    LayoutInflater inflater;
    Context context;

    private ItemClickListener itemClickListener;

    public Adapter(Context context, List<Item> listData) {
        this.listData = listData;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public interface ItemClickListener {
        void onItemClick(View view, Item item);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_view, parent, false);
        return new HolderData(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        Item currentItem = listData.get(position);
        holder.txtName.setText(currentItem.getName());
        holder.description.setText(currentItem.getDescription());

        Glide.with(context)
                .load(currentItem.getImg())
                .error(R.drawable.bakso_malang)
                .placeholder(R.drawable.bakso_malang)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(view, currentItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class HolderData extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName;
        TextView description;
        ImageView img;
        ItemClickListener itemClickListener;

        public HolderData(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;

            img = itemView.findViewById(R.id.imgview);
            txtName = itemView.findViewById(R.id.text_title);
            description = itemView.findViewById(R.id.Text_Description);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(view, null);
            }
        }
    }
}

