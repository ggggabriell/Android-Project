package com.example.novoapp.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.novoapp.R;
import com.example.novoapp.adapter.RandomImagesAdapter;
import com.example.novoapp.databinding.FragmentHomeBinding;
import com.example.novoapp.databinding.FragmentMoreBinding;
import com.example.novoapp.domain.ApodApi;
import com.example.novoapp.domain.RetrofitClient;
import com.example.novoapp.domain.model.ApodDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MoreFragment extends Fragment {

    FragmentMoreBinding binding;

    MoreFragment.ViewHolder gViewHolder = new MoreFragment.ViewHolder();
    private RecyclerView.Adapter galleryAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMoreBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        gViewHolder.rv_gallery = view.findViewById(R.id.rv_gallery);
        gViewHolder.rv_gallery.setHasFixedSize(true);
        gViewHolder.rv_gallery.setLayoutManager(new GridLayoutManager(this.getContext(), 2));

        ApodApi rApodApi = RetrofitClient.getRetrofitInstance().create(ApodApi.class);
        Call<List<ApodDataModel>> callRI = rApodApi.getListaData();
        callRI.enqueue(new Callback<List<ApodDataModel>>() {
            @Override
            public void onResponse(Call<List<ApodDataModel>> call, Response<List<ApodDataModel>> response) {

                if(response.code() == 200) {
                    List<ApodDataModel> lista = response.body();

                    galleryAdapter = new RandomImagesAdapter(lista);
                    gViewHolder.rv_gallery.setAdapter(galleryAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<ApodDataModel>> call, Throwable t) {
            }
        });


        return view;
    }

    public static class ViewHolder {
        RecyclerView rv_gallery;
    }
}
