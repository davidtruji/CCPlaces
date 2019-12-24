package com.example.ccplaces;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MonumentosRepository {


    private MonumentoDao mMonumentoDao;
    private LiveData<List<Monumento>> mAllMonumentos;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    MonumentosRepository(Application application) {
        MonumentosRoomDataBase db = MonumentosRoomDataBase.getDatabase(application);
        mMonumentoDao = db.MonumentoDao();
        mAllMonumentos = mMonumentoDao.getAlphabetizedMonumentos();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Monumento>> getAllMonumentos() {
        return mAllMonumentos;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Monumento m) {
        MonumentosRoomDataBase.databaseWriteExecutor.execute(() -> {
            mMonumentoDao.insert(m);
        });
    }

}
