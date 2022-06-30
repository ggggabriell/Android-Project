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
import com.example.novoapp.domain.model.ApodDataModel;
import com.example.novoapp.domain.model.GalleryModels.Item;

import java.util.List;

public class RandomImagesAdapter extends RecyclerView.Adapter<RandomImagesAdapter.ViewHolder> {

    private List<ApodDataModel> lista;

    public RandomImagesAdapter(List<ApodDataModel> lista) {
        this.lista = lista;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvDate;
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
        return new RandomImagesAdapter.ViewHolder(galleryView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ApodDataModel item = lista.get(position);

        holder.tvTitle.setText(item.getTitle().toUpperCase());
        holder.tvDate.setText(item.getDate());
        Glide.with(holder.itemView.getContext())
                .asBitmap()
                .override(800, 600)
                .load(item.getHdurl()).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
