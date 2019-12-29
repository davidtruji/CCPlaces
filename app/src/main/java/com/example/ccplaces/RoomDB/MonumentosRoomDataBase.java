package com.example.ccplaces.RoomDB;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ccplaces.Model.Monumento;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Monumento.class}, version = 1, exportSchema = false)
public abstract class MonumentosRoomDataBase extends RoomDatabase {

    public abstract MonumentoDao MonumentoDao();
    private static volatile MonumentosRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MonumentosRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MonumentosRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MonumentosRoomDataBase.class, "monumentos_datbase").addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }




    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                MonumentoDao dao = INSTANCE.MonumentoDao();
                dao.deleteAll();

                //TODO: Añadidos monumentos para ver si la lista se muestra correctamente
                // se pueden eliminar después
                dao.insert(new Monumento("Monumento de Incognito no:1"));
                dao.insert(new Monumento("Monumento de Incognito no:2"));
            });
        }
    };


}
