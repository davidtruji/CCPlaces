package com.example.ccplaces.RoomDB;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.Util.Network;
import com.example.ccplaces.Util.OpenDataAPI;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Monumento.class}, version = 1, exportSchema = false)
public abstract class MonumentosRoomDataBase extends RoomDatabase {

    private final static String TAG="ROOM-DB";



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
//            databaseWriteExecutor.execute(() -> {
//                // Populate the database in the background.
//                // If you want to start with more words, just add them.
//            });
        }


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new GetMonumentos().execute();
            Log.i(TAG,"Creada la base de datos...");
        }
    };


    private static class GetMonumentos extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        ArrayList<Monumento> listaMonumentos=new ArrayList<Monumento>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listaMonumentos.clear();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                JSONObject jsonObject = Network.getJSONObjectFromURL(Network.URL_OPENDATA);
                OpenDataAPI.getMonumentosFromJSON(jsonObject,listaMonumentos);

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            for(Monumento m: listaMonumentos){
                databaseWriteExecutor.execute(() -> {
                    MonumentoDao dao = INSTANCE.MonumentoDao();
                    dao.insert(m);
                });
            }

        }
    }


}
