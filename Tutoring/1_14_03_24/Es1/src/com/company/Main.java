package com.company;


public class Main{

    public static void main(String[] args) {
        Nave nave = new Nave();

        Auto a = new Auto("Fiat");
        Auto b = new Auto("Fiat");
        Auto c = new Auto("Fiat");

        nave.caricaAuto(a);
        nave.caricaAuto(b);
        nave.caricaAuto(c);

        System.out.println(nave.toString());

    }
}
