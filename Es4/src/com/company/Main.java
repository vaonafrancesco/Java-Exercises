package com.company;

public class Main {
    public static void main(String[] args) {
        Risultato risultato = new Risultato(12.0f);
        System.out.println(risultato.toString());

        CambiaRisultato cambio = new CambiaRisultato();
        risultato = cambio.cambiaRisultato(risultato);
        System.out.println(risultato.toString());

    }

}
