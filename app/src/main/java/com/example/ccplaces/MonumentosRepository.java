package com.example.ccplaces;
import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.RoomDB.MonumentoDao;
import com.example.ccplaces.RoomDB.MonumentosRoomDataBase;

import java.util.List;


public class MonumentosRepository {


    private MonumentoDao mMonumentoDao;
    private LiveData<List<Monumento>> mAllMonumentos;
    private LiveData<List<Monumento>> mMonumentosFavoritos;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public MonumentosRepository(Application application) {
        MonumentosRoomDataBase db = MonumentosRoomDataBase.getDatabase(application);
        mMonumentoDao = db.MonumentoDao();
        mAllMonumentos = mMonumentoDao.getMonumentos();
        mMonumentosFavoritos = mMonumentoDao.getFavoritos();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Monumento>> getAllMonumentos() {
        return mAllMonumentos;
    }


    public LiveData<List<Monumento>> getmMonumentosFavoritos() {
        return mMonumentosFavoritos;
    }

    public LiveData<List<Monumento>> getMonumetosCat(String cat) {
        return mMonumentoDao.getMonumentosCategoria(cat);
    }

    public void updateMonumento(Monumento m){
        MonumentosRoomDataBase.databaseWriteExecutor.execute(() -> {
            mMonumentoDao.updateMonumento(m);
        });
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Monumento m) {
        MonumentosRoomDataBase.databaseWriteExecutor.execute(() -> {
            mMonumentoDao.insert(m);
        });
    }

}
