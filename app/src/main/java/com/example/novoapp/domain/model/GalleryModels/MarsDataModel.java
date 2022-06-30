package com.example.novoapp.domain.model.GalleryModels;

import com.google.gson.annotations.SerializedName;

public class MarsDataModel {

    @SerializedName("collection")
    private Collection collection;

    public Collection getCollection() {
        return collection;
    }
}
