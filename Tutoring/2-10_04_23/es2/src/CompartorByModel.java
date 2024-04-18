import java.util.Comparator;

public class CompartorByModel implements Comparator<Scarpa> {

    @Override
    public int compare(Scarpa o1, Scarpa o2) {
        return o1.taglia-o2.taglia;
    }
}
