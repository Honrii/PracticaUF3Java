package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Pregunta>listaPreguntas= FicheroPreguntas.leerArchivo();

        Partida partida = new Partida(loginJugadores(),listaPreguntas);
        partida.iniciarPartida();


     /*   int streakAciertos=0;
        int catElegida=Pregunta
        if(streakAciertos != 3){
            catElegida = random.nextInt(7);
        }else{
            catElegida =  6;
            System.out.println("Racha de "+streakAciertos+" ,toca corona");
        }*/
    }
    public  static ArrayList<Jugador> loginJugadores (){
        ArrayList<Jugador> jugadores= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner nomsc = new Scanner(System.in);
        int resp=0;
        System.out.println("Quanto jugadores soys");
        resp=sc.nextInt();
        String nombre="";
        for (int i = 0; i <resp ; i++) {
            System.out.println("Introduce el nomnre del Jugador: "+(i+1));
            nombre=nomsc.nextLine();
            Jugador jugador = new Jugador(nombre);
            jugadores.add(jugador);
        }
        return jugadores;
    }

}
