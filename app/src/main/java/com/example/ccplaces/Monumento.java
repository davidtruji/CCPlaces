package com.example.ccplaces;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

//public enum tipoMonumento{
//Iglesia,Casa,Torre
//}


public class Monumento {


    private String nombre;
    private String tipo;
    private String desc;
    private Bitmap foto;
    private long lat;
    private long lon;


    public Monumento(String nombre) {
        this.nombre = nombre;
    }

    public Monumento(String nombre, String tipo, String desc, Bitmap foto, long lat, long lon) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.desc = desc;
        this.foto = foto;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @NonNull
    @Override
    public String toString() {
        return nombre;
    }
}
