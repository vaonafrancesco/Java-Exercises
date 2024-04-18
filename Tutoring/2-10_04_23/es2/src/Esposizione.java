import java.util.ArrayList;

public class Esposizione<T extends Scarpa> {

    ArrayList<Scarpa> scarpe = new ArrayList<Scarpa>();

    public Esposizione() {
    }

    public Scarpa compra(){
        return scarpe.get(scarpe.size());
    }

    /**
     * Metodo per ordinare per modello le scarpe
     */
    public void ordina(){
        scarpe.sort(new CompartorByModel());
    }


    public void esponi(Scarpa scarpa){
        scarpe.add(scarpa);
    }

    public boolean isEmpty(){
        return scarpe.isEmpty();
    }

}
