package com.company;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private ArrayList<Corona> coronas;
    private int preguntasAcertadas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.coronas = new ArrayList<>();
        this.preguntasAcertadas= 0;
    }

    public void acertarPregunta(){
        this.preguntasAcertadas++;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Corona> getCoronas() {
        return coronas;
    }

    public void setCoronas(ArrayList<Corona> coronas) {
        this.coronas = coronas;
    }

    public int getPreguntasAcertadas() {
        return preguntasAcertadas;
    }

    public void setPreguntasAcertadas(int preguntasAcertadas) {
        this.preguntasAcertadas = preguntasAcertadas;
    }
}
