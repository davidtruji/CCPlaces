package com.example.ccplaces.Model;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

//public enum tipoMonumento{
//Iglesia,Casa,Torre
//}


@Entity(tableName = "monumento_table")
public class Monumento {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String nombre;

    private Boolean favorito;



    public Monumento(String nombre){
        this.nombre=nombre;
        favorito=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    @Override
    public String toString() {
        return nombre;
    }

//    private String tipo;
//    private String desc;
//    private Bitmap foto;
//    private Double lat;
//    private Double lon;
//    private Boolean fav;






//    public Monumento(String nombre) {
//        this.nombre = nombre;
//    }



//    public Monumento(String nombre, String tipo, String desc, Bitmap foto, Double lat, Double lon) {
//        this.nombre = nombre;
//        this.tipo = tipo;
//        this.desc = desc;
//        this.foto = foto;
//        this.lat = lat;
//        this.lon = lon;
//        this.fav = false;
//    }
//
//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public Bitmap getFoto() {
//        return foto;
//    }
//
//    public void setFoto(Bitmap foto) {
//        this.foto = foto;
//    }
//
//    public Double getLat() {
//        return lat;
//    }
//
//    public void setLat(Double lat) {
//        this.lat = lat;
//    }
//
//    public Double getLon() {
//        return lon;
//    }
//
//    public void setLon(Double lon) {
//        this.lon = lon;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Boolean getFav() {
//        return fav;
//    }
//
//    public void setFav(Boolean fav) {
//        this.fav = fav;
//    }
//
//
//    @NonNull
//    @Override
//    public String toString() {
//        return nombre;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Monumento monumento = (Monumento) o;
//        return Objects.equals(nombre, monumento.nombre);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nombre);
//    }
}
