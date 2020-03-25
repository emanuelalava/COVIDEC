package com.example.covid_ec.model;

public class Posts {

    private String temperatura;
    private String intensidadTos;
    private String tosidosMinuto;
    private String DificultadRespirar;
    private String nivelDolor;
    private String hasDiarrea;
    private String hasVomito;

    public String getTemperatura() {
        return temperatura;
    }

    public String getIntensidadTos() {
        return intensidadTos;
    }

    public String getTosidosMinuto() {
        return tosidosMinuto;
    }

    public String getDificultadRespirar() {
        return DificultadRespirar;
    }

    public String getNivelDolor() {
        return nivelDolor;
    }

    public String getHasDiarrea() {
        return hasDiarrea;
    }

    public String getHasVomito() {
        return hasVomito;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "temperatura='" + temperatura + '\'' +
                ", intensidadTos='" + intensidadTos + '\'' +
                ", tosidosMinuto='" + tosidosMinuto + '\'' +
                ", DificultadRespirar='" + DificultadRespirar + '\'' +
                ", nivelDolor='" + nivelDolor + '\'' +
                ", hasDiarrea='" + hasDiarrea + '\'' +
                ", hasVomito='" + hasVomito + '\'' +
                '}';
    }
}
