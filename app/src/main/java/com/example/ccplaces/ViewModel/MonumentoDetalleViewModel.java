package com.example.ccplaces.ViewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.MonumentosRepository;

import java.util.List;


public class MonumentoDetalleViewModel extends AndroidViewModel {


    private MonumentosRepository mRepository;
    private LiveData<Monumento> monumento;

    public MonumentoDetalleViewModel (Application application) {
        super(application);
        mRepository = new MonumentosRepository(application);
        //  monumento = mRepository.getMonumento(idNombre);
    }

    public LiveData<Monumento> getMonumento() {
        return monumento;
    }

    public void setMonumento(LiveData<Monumento> monumento) {
        this.monumento = monumento;
    }


    public void updateMonumento(Monumento m){
        mRepository.updateMonumento(m);
    }



    //    public void setFav(Boolean fav){
//        mRepository.updateFav(fav,monumento.getValue().get(0).getNombre());
//    }



}
