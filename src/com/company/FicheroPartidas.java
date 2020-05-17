package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;

public class FicheroPartidas {

    public static void gurdarPartida(Partida partida){
        File[]files;
        File fileRanking= new File("ranking");

        if (!fileRanking.exists()){
            fileRanking.mkdir();
        }
        if (fileRanking.isDirectory()){
            files=fileRanking.listFiles();
            File fileRankingTxt= new File("ranking/partida-"+(files.length+1)+".txt");

            try {
                PrintStream output = new PrintStream(fileRankingTxt);
                output.println("Partida: "+new Date());
                for (Jugador jugador:partida.getJugadores()) {
                    output.print(jugador.getNombre()+": ");
                    for (Corona corona: jugador.getCoronas()) {
                        output.print(corona.getCategoria()+" | ");

                    }
                    output.println(" ");
                }
                output.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }

        }
}
