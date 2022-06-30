package com.example.novoapp.roomDataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PessoaDao {

    @Query("SELECT * FROM pessoa")
    List<Pessoa> getPessoas();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPessoa(Pessoa pessoa);

    @Delete
    void deletePessoa(Pessoa pessoa);

    @Query("UPDATE pessoa SET  name =:name WHERE id=:id")
    void updatePessoa(String name, int id);
}
