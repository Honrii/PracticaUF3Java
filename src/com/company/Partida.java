package com.company;

import java.util.ArrayList;
import java.util.Random;


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
        int index=0;
        Jugador jugador;
        while (true) {
            jugador=jugadores.get(index);
            if (jugador.getCoronas().size()==6){
                System.out.println("HA GANADO EL JUGADOR: "+jugador.getNombre());
                break;
            }
            turno(jugador);
            if (index==jugadores.size()-1){

                index=0;
            }else{
                index++;
            }
        }

    }

    private void turno(Jugador player){
        System.out.println("Es el turno del Jugador: "+player.getNombre());
        while (true) {
            System.out.println("Llevas acertadas: "+player.getPreguntasAcertadas());
            System.out.print("Llevas de coronas:");
            for (Corona corona:player.getCoronas()) {
                System.out.print(corona.getCategoria()+" | ");

            }
            System.out.println(" ");
            boolean respuestaCorecta;
            int catElegida;
            Random random = new Random();
            if (player.getPreguntasAcertadas()==3){
                catElegida=this.coronas.size(); /*Forzar Corona*/
                player.setPreguntasAcertadas(0);
            }else{
                catElegida = random.nextInt(this.coronas.size() );       //this.coronas.size()+1 = 6 cat + corona
            }
            Corona categoriaAsignada;
            if (catElegida == this.coronas.size() ) {
               responderPreguntaCorona(player);
               break;
            } else {
                categoriaAsignada = this.coronas.get(catElegida);
                Pregunta preguntaSelecionada = selecionarPregunta(categoriaAsignada.getCategoria());
                respuestaCorecta=responderPregunta(preguntaSelecionada);
            }

            if (!respuestaCorecta ) {
                System.out.println("Has Fallado!!");
                    break;
            }else {
                System.out.println("Correcto");
                player.acertarPregunta();//suma una respuesta
            }

        }
    }
    private Corona selecionarCorona(Jugador jugador){
        int respuestaUsuario;
        int i=1;
        System.out.println("Decide categoria de la corona");
        for (Corona corona:this.coronas) {
            System.out.println(i+"-"+corona.getCategoria());
            i++;
        }
        respuestaUsuario=ControlErrores.controlInputInt();

        return  this.coronas.get(respuestaUsuario-1);
    }
    private boolean responderPreguntaCorona(Jugador player){
        System.out.println("Te toco corona");
        Corona categoriaAsignada = selecionarCorona(player);
        Pregunta preguntaSelecionada= selecionarPregunta(categoriaAsignada.getCategoria());
        if (responderPregunta(preguntaSelecionada)){
            player.getCoronas().add(new Corona(preguntaSelecionada.getCategoria()));
            return  true;
        }else System.out.println("Has fallado la corona");
            return false;


    }
    private boolean responderPregunta(Pregunta preguntaSelecionda){
        int respUsu;

        System.out.println("Te ha tocado un pregunta de: "+preguntaSelecionda.getCategoria());
        System.out.println(preguntaSelecionda.getAnunciado());
        int i=1;
        for (String respuesta:preguntaSelecionda.getRespuestas()) {

            System.out.println(i+"-"+respuesta);
            i++;
        }
        respUsu=ControlErrores.controlInputInt();
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
        int preguntaElegida = random.nextInt((preguntasDeLaCategoria.size()) );
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
