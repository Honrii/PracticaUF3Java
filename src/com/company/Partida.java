package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
   private ArrayList<Jugador> jugadores;
   private ArrayList<Pregunta>preguntas;
   private ArrayList<Corona>coronas;
   private Jugador ganador;

    public Partida(ArrayList<Jugador> jugadores, ArrayList<Pregunta> preguntas) {
        this.jugadores = jugadores;
        this.preguntas = preguntas;
        this.ganador = null;
        this.initCoronas();

    }
    private void initCoronas(){
        this.coronas=new ArrayList<>();
       coronas.add(new Corona(Categoria.ARTE));
      coronas.add(new Corona(Categoria.CIENCIA));
       coronas.add(new Corona(Categoria.DEPORTES));
        coronas.add(new Corona(Categoria.ENTRETENIMIENTO));
       coronas.add(new Corona(Categoria.GEOGRAFÍA));
      coronas.add(new Corona(Categoria.HISTORIA));
    }




    public void iniciarPartida(){
        Random random = new Random();
        //int catElegida=this.coronas.size()+1; /*Forzar Corona*/
        Corona categoriaAsignada;
        int catElegida=random.nextInt(this.coronas.size()+1);       //this.coronas.size()+1 = 6 cat + corona
        if (catElegida==this.coronas.size()+1){
            System.out.println("Te toco corona");
            categoriaAsignada=selecionarCorona();
        }else{
            categoriaAsignada= this.coronas.get(catElegida);
        }
        Pregunta preguntaSelecionada = selecionarPregunta(categoriaAsignada.getCategoria());
        System.out.println(responderPregunta(preguntaSelecionada));



    }
    private Corona selecionarCorona(){
        Scanner sc = new Scanner(System.in);
        int respuestaUsuario;
        int i=1;
        System.out.println("Decide categoria de la corona");
        for (Corona corona:this.coronas) {
            System.out.println(i+"-"+corona.getCategoria());
            i++;
        }
        respuestaUsuario=sc.nextInt();

        return  this.coronas.get(respuestaUsuario-1);
    }
    private boolean responderPregunta(Pregunta preguntaSelecionda){
        Scanner sc = new Scanner(System.in);
        int respUsu;

        System.out.println("Te ha tocado un pregunta de: "+preguntaSelecionda.getCategoria());
        System.out.println(preguntaSelecionda.getAnunciado());
        int i=1;
        for (String respuesta:preguntaSelecionda.getRespuestas()) {

            System.out.println(i+"-"+respuesta);
            i++;
        }
        respUsu=sc.nextInt();
        String respuestaUsuario=preguntaSelecionda.getRespuestas().get(respUsu-1);
        if (respuestaUsuario.equals(preguntaSelecionda.getRespuestaCorrecta())){
            return true;

        }
        return  false;
    }
    private Pregunta selecionarPregunta(Categoria categoriaSeleccionada){

        ArrayList<Pregunta> preguntasDeLaCategoria=new ArrayList<>();
        for (Pregunta pregunta : this.preguntas) {
            if (categoriaSeleccionada==pregunta.getCategoria()){
                preguntasDeLaCategoria.add(pregunta);
            }
        }
        Random random = new Random();
        int preguntaElegida = random.nextInt((preguntasDeLaCategoria.size()) + 1);
        return preguntasDeLaCategoria.get(preguntaElegida);


    }


    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "jugadores=" + jugadores +
                ", preguntas=" + preguntas +
                ", ganador='" + ganador + '\'' +
                '}';
    }
}
