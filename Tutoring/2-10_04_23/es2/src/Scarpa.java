public class Scarpa implements Comparable<Scarpa>{
    String modello;
    int taglia;
    public Scarpa(String modello, int taglia){
        this.modello = modello;
        this.taglia = taglia;
    }

    @Override
    public int compareTo(Scarpa o) {
        return modello.compareTo(o.modello);
    }

    @Override
    public String toString() {
        return "Scarpa{" +
                "modello='" + modello + '\'' +
                ", taglia=" + taglia +
                '}';
    }

    public String getModello() {
        return modello;
    }

    public int getTaglia() {
        return taglia;
    }
}
