package com.example.novoapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.novoapp.R;
import com.example.novoapp.databinding.FragmentHomeBinding;
import com.example.novoapp.domain.ApodApi;
import com.example.novoapp.domain.RetrofitClient;
import com.example.novoapp.domain.model.ApodDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        ApodApi apodApi = RetrofitClient.getRetrofitInstance().create(ApodApi.class);
        Call<ApodDataModel> call = apodApi.getData();

        call.enqueue(new Callback<ApodDataModel>() {
            @Override
            public void onResponse(Call<ApodDataModel> call, Response<ApodDataModel> response) {

                if (response.code() == 200) {
                    binding.tvApodData.setText("Date: "+response.body().getDate());
                    binding.tvApodTitle.setText(response.body().getTitle().toUpperCase());
                    binding.tvApodDesc.setText(response.body().getExplanation());
                    binding.tvApodCop.setText(response.body().getCopyright());
                    Glide.with(view.getContext())
                            .asBitmap()
                            .load(response.body().getHdurl())
                            .centerCrop()
                            .into(binding.ivApod);
                }
            }

            @Override
            public void onFailure(Call<ApodDataModel> call, Throwable t) {

            }
        });


        return view;
    }
}
