package com.example.ccplaces.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.MonumentosRepository;

import java.util.List;

public class CategoriaViewModel extends AndroidViewModel {


    private MonumentosRepository mRepository;
    private LiveData<List<Monumento>> mMonumentosCat;
    private String cat;

    public CategoriaViewModel(Application application,String cat) {
        super(application);
        mRepository = new MonumentosRepository(application);
        mMonumentosCat = mRepository.getMonumetosCat(cat);
    }

    public LiveData<List<Monumento>> getmMonumentosCat() {
        return mMonumentosCat;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
