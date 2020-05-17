package com.company;

import java.util.ArrayList;

public class Pregunta {
    private Categoria categoria;
    private String anunciado;
    private ArrayList<String> respuestas;
    private String respuestaCorrecta;

    public Pregunta() {
    }

    public Pregunta(Categoria categoria, String anunciado, ArrayList<String> respuestas, String respuestaCorrecta) {
        this.categoria = categoria;
        this.anunciado = anunciado;
        this.respuestas = respuestas;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getAnunciado() {
        return anunciado;
    }

    public void setAnunciado(String anunciado) {
        this.anunciado = anunciado;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "categoria=" + categoria +
                ", anunciado='" + anunciado + '\'' +
                ", respuestas=" + respuestas +
                ", respuestaCorrecta='" + respuestaCorrecta + '\'' +
                '}';
    }
}
