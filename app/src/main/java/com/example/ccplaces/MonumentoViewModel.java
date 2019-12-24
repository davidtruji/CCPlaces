package com.example.ccplaces;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MonumentoViewModel extends AndroidViewModel {


    private MonumentosRepository mRepository;

    private LiveData<List<Monumento>> mAllMonumentos;

    public MonumentoViewModel (Application application) {
        super(application);
        mRepository = new MonumentosRepository(application);
        mAllMonumentos = mRepository.getAllMonumentos();
    }

    LiveData<List<Monumento>> getmAllMonumentos() { return mAllMonumentos; }

    public void insert(Monumento m) { mRepository.insert(m); }

}
