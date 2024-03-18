package com.company;
public class Main{
    public static final int ARRAY_SIZE = 100;

    Persona[] persone = new Persona[ARRAY_SIZE];

    int numPersone;

    public Main() {
        persone[numPersone++] = new Persona("Mario", "Rossi", "1", 1956);
        persone[numPersone++] = new Studente("Giovanni", "Bianchi", "3", 1995, "UNITN", "TRIENNALE");

    }

    public static void main(String[] args) {
        Main palestra = new Main();
        palestra.printArray(palestra.persone[]);



    }

    public void printArray(Persona[] persone){


        for (int i = 0; i <palestra.numPersone; i++) {
            if (palestra.persone[i] instanceof Studente){

            }
        }

        System.out.println(p);
    }

}
