package com.company;

public class Persona implements Comparable<Persona>{
    public static final int TARIFFA_BASE = 1000;
    String nome, cognome, CF , cognomeNome;
    int annoNascita;

    public Persona(String nome, String cognome, String CF, int annoNascita){
        this.nome = nome;
        this.cognome= cognome;
        this.CF = CF;
        this.annoNascita = annoNascita;
        setCognomeNome(nome, cognome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCF() {
        return CF;
    }

    public void setCF(String CF) {
        this.CF = CF;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

    public void setAnnoNascita(int annoNascita) {
        this.annoNascita = annoNascita;
    }

    public String getCognomeNome() {
        return cognomeNome;
    }

    public void setCognomeNome(String nome, String cognome) {
        this.cognomeNome = cognome + " " + nome;
    }


    public double getTariffa(){
        if(annoNascita < 1968){
            return TARIFFA_BASE * (1-0.35);
        }else{
            return TARIFFA_BASE;
        }
    }

    @Override
    public String toString() {
        return getCognomeNome() + " " + CF + " " + annoNascita;
    }

    @Override
    public int compareTo(Persona o) {
        return cognome.compareTo(o.cognome);
    }
}
