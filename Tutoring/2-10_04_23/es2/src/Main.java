import java.util.*;
public class Main {

    public static void main(String[] args) {

        final Magazzino magazzino = new Magazzino();
        final Esposizione esposizione = new Esposizione();
        final Random rand = new Random();

        for (char modello = 'A'; modello <= 'C'; ++modello) {
            for (int taglia = 35; taglia <= 47; ++taglia) {
                final int count = rand.nextInt(10);
                for (int i = 0; i < count; ++i) {
                    final Scarpa scarpa = new Scarpa(String.valueOf(modello), taglia);
                    magazzino.aggiungi(scarpa);
                }

                final Scarpa scarpa = new Scarpa(String.valueOf(modello), taglia);
                System.out.println(scarpa.toString());

                if(magazzino.scarpe.containsKey(scarpa)){
                    System.out.println("CONTIENE!!!");
                }else{
                    System.out.println("NON CONTIENE!!!");
                };
                //qua c'è un problema: non riconosce che scarpa è uguale a scarpa
                int contantore = magazzino.scarpe.get(scarpa);
                System.out.println("Contatore: " + contantore);
                int magazzinoCount = magazzino.scarpe.getOrDefault(scarpa,
                        0);

                if (magazzinoCount != count) {
                    System.err.println("Errore Magazzino.aggiungi(). (hash?)");
                }

                for (int i = 0; i < magazzinoCount; ++i) {
                    if (!(magazzino.estrai(scarpa))) {
                        System.err.println("Errore Magazzino.estrai()");
                    }

                    esposizione.esponi(scarpa);
                }

                magazzinoCount = magazzino.scarpe.getOrDefault(scarpa, 0);

                if (magazzinoCount != 0) {
                    System.err.println("Errore Magazzino.aggiungi().");
                }
            }
        }

        Collections.shuffle(esposizione.scarpe);

        esposizione.ordina();

        System.out.println(esposizione.scarpe);

    }




}
