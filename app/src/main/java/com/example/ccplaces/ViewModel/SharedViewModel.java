package com.example.ccplaces.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.ccplaces.Model.Monumento;


public class SharedViewModel extends AndroidViewModel {
    private final MutableLiveData<Monumento> selected = new MutableLiveData<>();

    public SharedViewModel(@NonNull Application application) {
        super(application);
    }

    public void select(Monumento item) {
        selected.setValue(item);
    }

    public LiveData<Monumento> getSelected() {
        return selected;
    }
}



