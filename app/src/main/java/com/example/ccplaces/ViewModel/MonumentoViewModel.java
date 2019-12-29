package com.example.ccplaces.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.MonumentosRepository;

import java.util.List;

public class MonumentoViewModel extends AndroidViewModel {


    private MonumentosRepository mRepository;
    private LiveData<List<Monumento>> mAllMonumentos;

    public MonumentoViewModel (Application application) {
        super(application);
        mRepository = new MonumentosRepository(application);
        mAllMonumentos = mRepository.getAllMonumentos();
    }

    public LiveData<List<Monumento>> getmAllMonumentos() { return mAllMonumentos; }

    public void insert(Monumento m) { mRepository.insert(m); }

}
