package com.company;
public class Main{
    public static final int ARRAY_SIZE = 100;

    Persona[] persone = new Persona[ARRAY_SIZE];

    int numPersone;

    public Main() {
        persone[numPersone++] = new Persona("Mario", "Rossi", "1", 1950);
        persone[numPersone++] = new Persona( "Carla", "Rossi", "2", 1990);
        persone[numPersone++] = new Studente( "Giovanni", "Bianchi", "3", 1995, "UNITN", Studente.Laurea.TRIENNALE);
        persone[numPersone++] = new Studente("Anna", "Bianchi", "4", 1990, "UNIPD", Studente.Laurea.MAGISTRALE);
        persone[numPersone++] = new Atleta("Giacomo", "Verdi", "5", 1991, "nuoto", Atleta.Rilevanza.NAZIONALE);
        persone[numPersone++] = new Atleta("Alice", "Verdi", "6", 1967, "Curling", Atleta.Rilevanza.INTERNAZIONALE);


    }

    public static void main(String[] args) {
        Main palestra = new Main();
        palestra.printArray(palestra.persone);



    }

    public void printArray(Persona[] persone){


        System.out.println(" ========== TUTTI GLI ABBONATI ==========");
        for (int i = 0; i <numPersone; i++) {
            System.out.println(persone[i] + " | " + persone[i].getTariffa());
        }


        System.out.println("\n ========== ABBONATI - SOLO STUDENTI ==========");
        for (int i = 0; i <numPersone; i++) {
            if (persone[i] instanceof Studente){
                System.out.println(persone[i] + " | " + persone[i].getTariffa());
            }
        }

        System.out.println("\n ========== ABBONATI - SOLO ATLETI ==========");
        for (int i = 0; i <numPersone; i++) {
            if (persone[i] instanceof Atleta){
                System.out.println(persone[i] + " | " + persone[i].getTariffa());
            }
        }
    }

}
