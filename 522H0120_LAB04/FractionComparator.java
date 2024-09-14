import java.util.Comparator;

public class FractionComparator implements Comparator<Fraction> {
    @Override
    public int compare(Fraction f1, Fraction f2) {
        // for ascending order
        double ratio = f1.getRatio() - f2.getRatio();
        if (ratio > 0)
            return 1;
        if (ratio < 0)
            return -1;
        return 0;
    }
}