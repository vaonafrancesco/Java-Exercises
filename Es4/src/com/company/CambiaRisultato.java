package com.company;


public class CambiaRisultato {
    static final int NUM = 10;
    public CambiaRisultato(){

    }
    public Risultato cambiaRisultato(Risultato numero){
        numero.risultato += 10;
        return numero;
    }

}
