import java.util.HashMap;
import java.util.Map;

public class Magazzino {

    HashMap<Scarpa, Integer> scarpe = new HashMap<>();

    int dim;


    public void aggiungi(Scarpa scarpa){


        if(scarpe.containsKey(scarpa)){
            scarpe.put(scarpa, scarpe.get(scarpa)+1);
        }else{
            scarpe.put(scarpa, 1);
        }
        dim++;

        //Scarpa s = new Scarpa("A", 12);
        //controlla se il modello della scarpa di ogni elemento della mappa è uguale al modello della mappa passata in input

        //print helloworld
        //
        /**
        scarpe.forEach((k, v) -> {
            if (k.modello.equals(scarpa.modello)) {
                v++;
            }
        }));
    */
        //scarpe.forEach((k, v) -> System.out.println("Modello: " + k.getModello() + " Taglia: " + k.getTaglia() + " Quantità: " + v));


        /**
        //controllo il nome di scarpa
        String nome = scarpa.getModello();

        //cerco in scarpe l'elemento che contiene il numero delle scarpe con quel nome
        int num = scarpe.get(scarpa);
        scarpe.forEach(Scarpa sc : );

        //sostituisco il valore con il valore++;
*/
    }

    public boolean estrai(Scarpa scarpa){
        if(scarpe.containsKey(scarpa)){
            scarpe.remove(scarpa, scarpe.get(scarpa));
            return true;
            //scarpe.put(scarpa, scarpe.get(scarpa)+1);
        }else{
            System.out.println("FALSE BRO");
            return false;
        }

        //scarpe.remove(scarpa.getModello(), scarpa.getTaglia());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        //stamoa tutto il Map
        return scarpe.toString();

    }
}
