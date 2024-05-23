package com.company;


import javafx.scene.paint.Color;

import java.util.Random;

abstract class Mattonella {
    String codice, materiale;
    double lato, prezzo;
    boolean sceltaColore;
    Random random = new Random();
    Color color;



    public Mattonella(String codice, double lato, double prezzo, String materiale, boolean sceltaColore) {
        this.codice = codice;
        this.materiale = materiale;
        this.prezzo = prezzo;
        this.lato = lato;
        this.sceltaColore = sceltaColore;
        setColor();
    }

    @Override
    public String toString() {
        return "Codice: " + codice + "\n" +
                "materiale: " + materiale + "\n" +
                "prezzo: " + prezzo + " EUR" + "\n" +
                "dimensione: " + lato + " cm" + "\n" +
                "scelta colore: " + getSceltaColore();
    }

    private String getSceltaColore() {
        if(sceltaColore){
            return "SI";
        }else{
            return "NO";
        }
    }

    private void setColor() {
        switch (random.nextInt(6)){
            case 0 -> color = Color.BROWN;
            case 1 -> color = Color.WHEAT;
            case 2 -> color = Color.TEAL;
            case 3 -> color = Color.DARKBLUE;
            case 4 -> color = Color.OLIVE;
            case 5 -> color = Color.GOLD;

        }
    }



}
