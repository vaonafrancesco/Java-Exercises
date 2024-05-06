package com.company;

public class Studente extends Persona{

    String uni;
    enum Laurea{ TRIENNALE, MAGISTRALE };
    Laurea laurea;

    public Studente(String nome, String cognome, String CF, int annoNascita, String uni, Laurea corsoLaurea){
        super(nome, cognome, CF, annoNascita);
        this.uni = uni;
        this.laurea = corsoLaurea;


    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }


    @Override
    public double getTariffa() {
        double tariffa = 0;
        if(laurea == Laurea.TRIENNALE){
            tariffa = TARIFFA_BASE * (1-0.4);
        }else {
            tariffa = TARIFFA_BASE * (1 - 0.2);
        }
        return Math.min(super.getTariffa(), tariffa);
    }

    @Override
    public String toString() {
        String l;
        if(laurea == Laurea.MAGISTRALE){
            l = "LM";
        }else{
            l = "LT";
        }
        return super.toString() + " " + uni + " " + l;
    }
}
