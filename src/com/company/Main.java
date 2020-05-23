package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

       ArrayList<Pregunta>listaPreguntas=FicheroPreguntas.leerArchivo();

        Partida p1 = new Partida(loginJugadores(),listaPreguntas);
        p1.iniciarPartida();
        FicheroPartidas.gurdarPartida(p1);


    }
    public  static ArrayList<Jugador> loginJugadores (){
        ArrayList<Jugador> jugadores= new ArrayList<>();

        //Scanner nomsc = new Scanner(System.in);
        int resp=0;
        System.out.println("Quanto jugadores soys");
        resp=ControlErrores.controlInputInt();

        String nombre="";
        for (int i = 0; i <resp ; i++) {
            System.out.println("Introduce el nombre del Jugador: "+(i+1));
            nombre=ControlErrores.controlInputString();
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }
        return jugadores;
    }

}
