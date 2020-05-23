package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FicheroPreguntas {


    public static ArrayList<Pregunta> leerArchivo(){
        File file= new File("Preguntas.txt");
        Scanner input;
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        try {
            input = new Scanner(file);
            String linea="";
            while (input.hasNextLine()) {
                if(linea.equals("")){
                    linea = input.nextLine();
                }

                Pregunta pregunta = new Pregunta();
                ArrayList<String>respuestas= new ArrayList<>();

                if (linea.contains("|")) {

                    String[] lieaCategoria = linea.split(Pattern.quote("| "));


                    pregunta.setAnunciado(lieaCategoria[0].split("-")[1]);    //Separacion del enunciado de la pregunta
                    pregunta.setCategoria(Categoria.valueOf(lieaCategoria[1].toUpperCase()));

                    linea=input.nextLine();
                }
                while (linea.contains("•")) {

                    String respuestString =linea.split("•")[1];
                    if(respuestString.contains("(c)")){
                        respuestString=respuestString.split(Pattern.quote("("))[0];
                        pregunta.setRespuestaCorrecta(respuestString);
                    }
                    linea=input.nextLine();
                    respuestas.add(respuestString);


                }
                pregunta.setRespuestas(respuestas);
                preguntas.add(pregunta);
            }
            return preguntas;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }



}