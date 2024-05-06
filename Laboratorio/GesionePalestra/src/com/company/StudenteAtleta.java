package com.company;

public class StudenteAtleta extends Studente implements IAtleta{


    String disciplina;
    Rilevanza rilevanza;
    Studente studente;

    public StudenteAtleta(String nome, String cognome, String CF, int annoNascita, String uni, Laurea corsoLaurea, String disciplina, Rilevanza r) {
        super(nome, cognome, CF, annoNascita, uni, corsoLaurea);
        this.disciplina = disciplina;
        this.rilevanza = r;
        studente = new Studente(nome, cognome, CF, annoNascita, uni, corsoLaurea);
    }


    @Override
    public double getTariffa() {
        return Math.min(super.getTariffa(), studente.getTariffa());
    }

    @Override
    public String toString() {
        return super.toString() + " " + disciplina + " " + rilevanza;
    }
}
