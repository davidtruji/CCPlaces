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


    @PrimaryKey
    @NonNull
    private String nombre;

    private Boolean favorito;
    private String tipo;
    private String desc;
    private Integer imgId;


    public Monumento(String nombre,String tipo,String desc,Integer imgId){
        this.nombre=nombre;
        favorito=false;
        this.tipo=tipo;
        this.desc=desc;
        this.imgId=imgId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
