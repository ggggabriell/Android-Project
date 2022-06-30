package com.example.novoapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.novoapp.databinding.ActivitySubBinding;
import com.example.novoapp.roomDataBase.Pessoa;
import com.example.novoapp.roomDataBase.PessoaDataBase;
import com.example.novoapp.viewModel.ValidationViewModel;

import java.util.List;

public class SubActivity extends AppCompatActivity {

    private ActivitySubBinding binding;
    private PessoaDataBase pessoaDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        pessoaDataBase = PessoaDataBase.getInstance(this);
        List<Pessoa> listaPessoa = pessoaDataBase.pessoaDao().getPessoas();

        final ValidationViewModel viewModel = new ViewModelProvider(this).get(ValidationViewModel.class);

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.etEmail.getText().toString();
            String password = binding.etPassword.getText().toString();

            viewModel.fazLogin(listaPessoa, email, password);

        });

        binding.tvCadastrese.setOnClickListener(v -> {
            Intent intentBack = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentBack);
        });

//       Login
//        Email: gabriel@foursys.com.br Senha: gabrielteste
//        Email: imgabrielsf@gmail.com  Senha: Gabrielteste

        viewModel.login.observe(this, sucess -> {
            if (sucess.equals("Logado")) {
                Toast.makeText(getApplicationContext(), sucess, Toast.LENGTH_LONG).show();

                Intent intentHome = new Intent(getApplicationContext(), HomeActivity.class);
                intentHome.putExtra("chavePessoa", viewModel.getPessoa());
                startActivity(intentHome);

            } else if (sucess.equals("Cadastre-se")) {
                Toast.makeText(getApplicationContext(), sucess, Toast.LENGTH_LONG).show();

            } else if (sucess.equals("Senha Incorreta")) {
                Toast.makeText(getApplicationContext(), sucess, Toast.LENGTH_LONG).show();
            }
        });
    }
}
