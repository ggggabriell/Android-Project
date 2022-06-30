package com.example.novoapp.roomDataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Pessoa.class}, exportSchema = false, version = 1)
public abstract class PessoaDataBase extends RoomDatabase {

    private static final String DB_name = "pessoa_db";
    private static PessoaDataBase instance;

    public static synchronized PessoaDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), PessoaDataBase.class, DB_name)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract PessoaDao pessoaDao();


}
