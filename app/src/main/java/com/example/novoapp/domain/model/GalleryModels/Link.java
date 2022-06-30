package com.example.novoapp.domain.model.GalleryModels;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }
}
