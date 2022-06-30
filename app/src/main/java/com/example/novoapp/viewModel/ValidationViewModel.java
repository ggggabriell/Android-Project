package com.example.novoapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.novoapp.roomDataBase.Pessoa;

import java.util.List;

public class ValidationViewModel extends ViewModel {

    private MutableLiveData<String> mLogin = new MutableLiveData<>();
    public LiveData<String> login = mLogin;
    private MutableLiveData<Boolean> mCadastro = new MutableLiveData<>();
    public LiveData<Boolean> cadastro = mCadastro;
    private Pessoa pessoa;


    public void fazLogin(List<Pessoa> listaPessoa, String email, String password) {
        String verify = "Deslogado";
        if (listaPessoa.size() > 0) {
            for (int i = 0; i < listaPessoa.size(); i++) {
                if (listaPessoa.get(i).getEmail().equals(email) && listaPessoa.get(i).getPassword().equals(password)) {
                    verify = "Logado";
                    this.pessoa = listaPessoa.get(i);
                    break;
                } else if (listaPessoa.get(i).getEmail().equals(email) && !listaPessoa.get(i).getPassword().equals(password)) {
                    verify = "Senha Incorreta";
                    break;
                } else {
                    verify = "Cadastre-se";
                }
            }
            this.mLogin.setValue(verify);
        } else {
            this.mLogin.setValue("Cadastre-se");
        }
    }

    public Pessoa getPessoa(){
        return this.pessoa;
    }

    public void fazCadastro(List<Pessoa> listaPessoa, String email) {
        Boolean verify = true;

        if (listaPessoa.size() > 0) {
            for (int i = 0; i < listaPessoa.size(); i++) {
                if (listaPessoa.get(i).getEmail().equals(email)) {
                    verify = false;
                    break;
                }
            }
            this.mCadastro.setValue(verify);
        } else {
            this.mCadastro.setValue(true);
        }
    }
}
