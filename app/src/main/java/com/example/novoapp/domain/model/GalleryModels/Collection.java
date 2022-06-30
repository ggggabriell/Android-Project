package com.example.novoapp.domain.model.GalleryModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Collection {

    @SerializedName("items")
   public List<Item> items;

    public List<Item> getItems() {
        return items;
    }
}
