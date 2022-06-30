package com.example.novoapp.domain;

import com.example.novoapp.domain.model.ApodDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApodApi {

    //  API KEY ===   mZcK2PYaapKV1WfOKNMoWQbieF3Lxpdhkv43GqB7

    @GET("apod?api_key=mZcK2PYaapKV1WfOKNMoWQbieF3Lxpdhkv43GqB7")
    Call<ApodDataModel> getData();

    @GET("apod?api_key=mZcK2PYaapKV1WfOKNMoWQbieF3Lxpdhkv43GqB7&count=12")
    Call<List<ApodDataModel>> getListaData();

}
