package com.example.master.myapplication.modelo;


public class Pregunta {
    private int id;
    private String pregunta;
    private int nodoSi;
    private int nodoNo;
    private boolean nodoFinal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getNodoSi() {
        return nodoSi;
    }

    public void setNodoSi(int nodoSi) {
        this.nodoSi = nodoSi;
    }

    public int getNodoNo() {
        return nodoNo;
    }

    public void setNodoNo(int nodoNo) {
        this.nodoNo = nodoNo;
    }


    public boolean isNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(boolean nodoFinal) {
        this.nodoFinal = nodoFinal;
    }
}
