package com.example.covid_ec;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class Usuario implements Serializable {
    private String username,nombres,apellidos;

    public Usuario(String username, String nombres, String apellidos){
        this.username = username;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
    public Usuario(String username){
        this.username = username;
    }

    private Usuario(Parcel parcel){
        // In the same order than the original constructor
        this.username = parcel.readString();
        this.nombres = parcel.readString();
        this.apellidos = parcel.readString();
    }
    public String getUsername() {
        return username;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre(){
        String[] div = this.nombres.split(" ");
        return div[0];
    }


}
