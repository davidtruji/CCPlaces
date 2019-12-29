package com.example.ccplaces.RoomDB;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

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
    LiveData<List<Monumento>> getAlphabetizedMonumentos();

}
