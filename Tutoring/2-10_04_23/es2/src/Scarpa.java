import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        Scarpa scarpa = (Scarpa) o;
        return (this.modello.equals(scarpa.modello)) && (this.taglia == scarpa.taglia);
        /**
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scarpa scarpa = (Scarpa) o;
        return taglia == scarpa.taglia && Objects.equals(modello, scarpa.modello);
         */
    }

    @Override
    public int hashCode() {
        return Objects.hash(modello, taglia);
    }
}
