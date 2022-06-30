package com.example.novoapp.domain;

import com.example.novoapp.domain.model.GalleryModels.Collection;
import com.example.novoapp.domain.model.GalleryModels.MarsDataModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GalleryApi {

    // FAZER BUSCAS NA GALEIRA DA NASA
    // === https://images-api.nasa.gov/search?q=Webb

    @GET("search?media_type=image&title=Webb")
    Call<MarsDataModel> getData();
}
