package com.example.novoapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.novoapp.viewModel.Validacao;
import com.example.novoapp.databinding.ActivityMainBinding;
import com.example.novoapp.roomDataBase.Pessoa;
import com.example.novoapp.roomDataBase.PessoaDataBase;
import com.example.novoapp.viewModel.ValidationViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    PessoaDataBase pessoaDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        final ValidationViewModel viewModel = new ViewModelProvider(this).get(ValidationViewModel.class);

        // DataBase e lista de usuarios
        pessoaDataBase = PessoaDataBase.getInstance(this);
        List<Pessoa> listaPessoa = pessoaDataBase.pessoaDao().getPessoas();
        

        viewModel.cadastro.observe(this, sucess -> {
            if (sucess) {
                Toast.makeText(getApplicationContext(), "Sucesso", Toast.LENGTH_LONG).show();
                //          DB Insert
                pessoaDataBase.pessoaDao().insertPessoa(new Pessoa(binding.etName.getText().toString(),
                        binding.etEmail.getText().toString(), binding.etPassword.getText().toString()));

                    Intent intent = new Intent(this, SubActivity.class);
                    startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Email ja cadastrado", Toast.LENGTH_LONG).show();
            }
        });

        binding.btnCadastro.setOnClickListener(view1 -> {
            String userName = binding.etName.getText().toString();
            String password = binding.etPassword.getText().toString();
            String email = binding.etEmail.getText().toString();

            camposPreenchidos(userName, email, password);
            if(Validacao.userName(userName) && Validacao.email(email) && Validacao.password(password)){
                viewModel.fazCadastro(listaPessoa, email);
            }
        });

        binding.tvLogin.setOnClickListener(view1 -> {
            Intent intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

    }


    public void camposPreenchidos(String userName, String email, String password) {
        String verifyError = "Campos incorretos: ";

        if (!Validacao.userName(userName)) {
            binding.error.setVisibility(View.VISIBLE);
            binding.error.setText(verifyError += " Username.");
        } else {
            verifyError = verifyError.replace(" Username.", "");
        }

        if (!Validacao.email(email)) {
            binding.error.setVisibility(View.VISIBLE);
            binding.error.setText(verifyError += " Email.");
        } else {
            verifyError = verifyError.replace(" Email.", "");
        }

        if (!Validacao.password(password)) {
            binding.error.setVisibility(View.VISIBLE);
            binding.error.setText(verifyError += " Senha.");
        } else {
            verifyError = verifyError.replace(" Senha.", "");
        }

        if (Validacao.userName(userName) && Validacao.email(email) && Validacao.password(password)) {
            binding.error.setVisibility(View.INVISIBLE);
        }
    }
}