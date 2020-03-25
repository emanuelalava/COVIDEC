package com.example.covid_ec;
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
