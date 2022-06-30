package com.example.novoapp.domain.model.GalleryModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("data")
    private List<DataItem> dataItem;

    @SerializedName("links")
    private List<Link> links;


    public List<DataItem> getDataItem() {
        return dataItem;
    }

    public List<Link> getLinks() {
        return links;
    }
}
