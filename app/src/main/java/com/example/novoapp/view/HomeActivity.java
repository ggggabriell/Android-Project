package com.example.novoapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.novoapp.R;
import com.example.novoapp.databinding.ActivityHomeBinding;
import com.example.novoapp.view.fragments.HomeFragment;
import com.example.novoapp.view.fragments.ProfileFragment;
import com.example.novoapp.view.fragments.MoreFragment;
import com.example.novoapp.roomDataBase.Pessoa;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent it = getIntent();
        Pessoa pessoa = (Pessoa) it.getSerializableExtra("chavePessoa");
        Intent profileIntent = new Intent(this, ProfileFragment.class);
        profileIntent.putExtra("chavePessoa", pessoa);

        bottomNavigationView = findViewById(R.id.bnv);
        getSupportFragmentManager().beginTransaction().replace(R.id.fLayout, new HomeFragment()).commit();
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.ic_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.ic_more:
                    selectedFragment = new MoreFragment();
                    break;
                case R.id.ic_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fLayout, selectedFragment).commit();
            return false;
        });
    }
}