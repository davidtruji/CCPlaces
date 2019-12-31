package com.example.ccplaces.ViewModel;


import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ccplaces.ViewModel.CategoriaViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mParam;


    public ViewModelFactory(Application application, String param) {
        mApplication = application;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new CategoriaViewModel(mApplication, mParam);
    }
}