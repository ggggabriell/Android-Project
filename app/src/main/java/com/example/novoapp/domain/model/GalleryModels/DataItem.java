package com.example.novoapp.domain.model.GalleryModels;

import com.google.gson.annotations.SerializedName;

public class DataItem {

    @SerializedName("title")
    private String title;

    @SerializedName("location")
    private String location;

    @SerializedName("date_created")
    private String date_created;

    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDate_created() {
        return date_created;
    }

    public String getDescription() {
        return description;
    }
}
