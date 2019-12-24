package com.example.ccplaces;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class MonumentosRoomDataBase extends RoomDatabase {

    public abstract MonumentoDao MonumentoDao();
    private static volatile MonumentosRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MonumentosRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MonumentosRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MonumentosRoomDataBase.class, "monumentos_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
