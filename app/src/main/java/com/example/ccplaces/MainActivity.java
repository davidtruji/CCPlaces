package com.example.ccplaces;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ccplaces.Model.Monumento;
import com.example.ccplaces.Util.Network;
import com.example.ccplaces.Util.OpenDataAPI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    // MonumentoViewModel  monumentoViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //  monumentoViewModel = new ViewModelProvider(this).get(MonumentoViewModel.class);


//        monumentoViewModel.getmAllMonumentos().observe(this, new Observer<List<Monumento>>() {
//            @Override
//            public void onChanged(@Nullable final List<Monumento> words) {
//                // Update the cached copy of the words in the adapter.
//                adapter.setMonumentos(words);
//            }
//        });



///if(monumentoViewModel.getmAllMonumentos().getValue()==null)
        // new GetMonumentos().execute();



        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_puntos_interes,R.id.nav_favoritos,
                R.id.nav_categorias,R.id.nav_rutas,R.id.nav_ajustes)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        // MonumentoViewModel monumentoViewModel = new ViewModelProvider(this).get(MonumentoViewModel.class);






    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }













}
