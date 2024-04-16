package com.company;

import javax.print.DocFlavor;
import java.util.*;

//Palestra
public class Main{

    List<Persona> persone = new LinkedList<Persona>();

    int numPersone;

    public Main() {
        persone.add(new Persona("Mario", "Rossi", "1", 1950));
        //tutto come riga sopra
        persone.add(new Persona( "Carla", "Rossi", "2", 1990));
        persone.add(new Studente( "Giovanni", "Bianchi", "3", 1995, "UNITN", Studente.Laurea.TRIENNALE));
        persone.add(new Studente("Anna", "Bianchi", "4", 1990, "UNIPD", Studente.Laurea.MAGISTRALE));
        persone.add(new Atleta("Giacomo", "Verdi", "5", 1991, "nuoto", Atleta.Rilevanza.NAZIONALE));
        persone.add(new Atleta("Alice", "Verdi", "6", 1967, "Curling", Atleta.Rilevanza.INTERNAZIONALE));
        persone.add(new StudenteAtleta("Alberto", "Ferrari", "7", 1993, "UNITN", Studente.Laurea.MAGISTRALE, "atletica", IAtleta.Rilevanza.INTERNAZIONALE));
        persone.add(new StudenteAtleta("Vincenzo", "Ferrari", "8", 1997, "UNIVR", Studente.Laurea.TRIENNALE, "atletica", IAtleta.Rilevanza.NAZIONALE));

    }

    public static void main(String[] args) {
        Main palestra = new Main();
        palestra.printArray(palestra.persone);
        Collections.sort(palestra.persone);
        System.out.println("ORDINATI PER NOME");
        palestra.printArray(palestra.persone);
        Collections.sort(palestra.persone, new ComparatorByYear());
        System.out.println("ORDINATI PER ANNOO");
        palestra.printArray(palestra.persone);
    }



    public void printArray(List<Persona> persone){

        System.out.println(" ========== TUTTI GLI ABBONATI ==========");
        for(Persona p : persone){
            System.out.println(p);
        }


        System.out.println("\n ========== ABBONATI - SOLO STUDENTI ==========");
        for(Persona p : persone){
            if (p instanceof Studente){
                System.out.println(p);
            }
        }

        System.out.println("\n ========== ABBONATI - SOLO ATLETI ==========");
        for(Persona p : persone){
            if (p instanceof IAtleta){
                System.out.println(p);
            }
        }

    }

}
