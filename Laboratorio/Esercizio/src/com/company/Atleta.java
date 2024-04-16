package com.company;

public class Atleta extends Persona implements IAtleta {

    String disciplina;
    Rilevanza rilevanza;

    public Atleta(String nome, String cognome, String CF, int annoNascita, String disciplina, Rilevanza r) {
        super(nome, cognome, CF, annoNascita);
        this.disciplina = disciplina;
        this.rilevanza = r;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public double getTariffa() {
        double tariffa = 0;
        if(rilevanza == Rilevanza.INTERNAZIONALE){
            tariffa = TARIFFA_BASE * (1-SCONTO_INTERNAZIONALE);
        }else {
            tariffa = TARIFFA_BASE * (1 - SCONTO_NAZIONALE);
        }
        return Math.min(super.getTariffa(), tariffa);
    }

    @Override
    public String toString() {
        String r;
        if(rilevanza == Rilevanza.INTERNAZIONALE){
            r = "internazionale";
        }else{
            r = "nazionale";
        }
        return super.toString() + " " + disciplina + " " + r;
    }
}
