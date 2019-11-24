package com.example.ccplaces;

import java.util.ArrayList;

public class Datos {



    private  ArrayList<Monumento> puntosIneres;
    private  ArrayList<Monumento> favoritos;
    private static Datos datos;

    private Datos() {
        puntosIneres=new ArrayList<>();
        favoritos=new ArrayList<>();
        //System.out.println("Mi nombre es: " + this.nombre);
    }

    public static Datos getInstance() {
        if (datos == null){
            datos = new Datos();
        }

        return datos;
    }

    public ArrayList<Monumento> getPuntosIneres() {
        return puntosIneres;
    }

    public void setPuntosIneres(ArrayList<Monumento> puntosIneres) {
        this.puntosIneres = puntosIneres;
    }

    public ArrayList<Monumento> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(ArrayList<Monumento> favoritos) {
        this.favoritos = favoritos;
    }

}
