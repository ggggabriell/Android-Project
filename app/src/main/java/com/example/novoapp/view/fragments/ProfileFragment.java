package com.example.novoapp.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.novoapp.R;
import com.example.novoapp.databinding.FragmentProfileBinding;
import com.example.novoapp.roomDataBase.Pessoa;


public class ProfileFragment extends Fragment {

    TextView tvEmail, tvNome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, container, false);

        tvEmail = view.findViewById(R.id.tvPfEmail);
        tvNome = view.findViewById(R.id.tvPfUsuario);

        Intent profileIt = getActivity().getIntent();

        if(profileIt.hasExtra("chavePessoa")){
            Pessoa pessoa = (Pessoa) profileIt.getSerializableExtra("chavePessoa");
            tvEmail.setText(pessoa.getEmail());
            tvNome.setText(pessoa.getName().toUpperCase());
        }

        return view;
    }

}
