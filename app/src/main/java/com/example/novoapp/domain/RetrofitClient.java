package com.example.novoapp.domain;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static String BASE_URL = "https://api.nasa.gov/planetary/";

    private static Retrofit marsRetrofit;
    private static  String BASE_URL_MARS = "https://images-api.nasa.gov/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getMarsRetrofitInstance(){
        if(marsRetrofit == null){
            marsRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_MARS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return marsRetrofit;
    }
}
