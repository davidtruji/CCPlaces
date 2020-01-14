package com.example.ccplaces.RoomDB;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ccplaces.Model.Monumento;

import java.util.List;

@Dao
public interface MonumentoDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Monumento m);

    @Query("DELETE FROM monumento_table")
    void deleteAll();

    @Query("SELECT * from monumento_table ORDER BY nombre ASC")
    LiveData<List<Monumento>> getMonumentos();

    @Query("SELECT * from monumento_table WHERE favorito=1 ORDER BY nombre ASC")
    LiveData<List<Monumento>> getFavoritos();

    @Query("SELECT * from monumento_table WHERE tipo=:categoria ORDER BY nombre ASC")
    LiveData<List<Monumento>> getMonumentosCategoria(String categoria);

    @Update
    public void updateMonumento(Monumento monumento);

    @Delete
    public void deleteMonumentos(Monumento... monumentos);



}
