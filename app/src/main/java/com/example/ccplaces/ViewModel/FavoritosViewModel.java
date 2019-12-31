package com.example.ccplaces.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.MonumentosRepository;

import java.util.List;

public class FavoritosViewModel extends AndroidViewModel {


    private MonumentosRepository mRepository;
    private LiveData<List<Monumento>> mMonumentosFavoritos;

    public FavoritosViewModel(Application application) {
        super(application);
        mRepository = new MonumentosRepository(application);
        mMonumentosFavoritos = mRepository.getmMonumentosFavoritos();
    }

    public LiveData<List<Monumento>> getmMonumentosFavoritos() {
        return mMonumentosFavoritos;
    }

//    public void updateFav(Boolean fav,String nom){
//        mRepository.updateFav(fav,nom);
//    }

    //public void insert(Monumento m) { mRepository.insert(m); }

}
