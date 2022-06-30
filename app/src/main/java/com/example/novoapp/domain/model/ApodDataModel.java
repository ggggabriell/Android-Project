package com.example.novoapp.domain.model;


import com.google.gson.annotations.SerializedName;

public class ApodDataModel {

    private String copyright;

    private String date;

    private String explanation;

    private String hdurl;

    private String title;

    private String url;

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getTitle() {
        return title;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getUrl(){ return url;}

}

