package com.example.novoapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.novoapp.R;
import com.example.novoapp.domain.model.GalleryModels.Item;


import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    private List<Item> items;

    public ImagesAdapter(List<Item> items) {
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvLocation, tvDate;
        private ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivImage = itemView.findViewById(R.id.ivImage);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View galleryView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gallery_list, parent, false);
        return new ImagesAdapter.ViewHolder(galleryView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.tvTitle.setText("Title: "+ item.getDataItem().get(0).getTitle());
        holder.tvDate.setText(item.getDataItem().get(0).getDate_created());
        holder.tvLocation.setText(item.getDataItem().get(0).getLocation());

        Glide.with(holder.itemView.getContext()).load(item.getLinks().get(0).getHref()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
