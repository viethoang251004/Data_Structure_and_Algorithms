import java.util.Arrays;

public class TestL4 {
    public static void print(Fraction[] arr) {
        for (Fraction f : arr) {
            System.out.print(f + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Fraction[] fractions = new Fraction[5];
        fractions[0] = new Fraction(5, 6);
        fractions[1] = new Fraction(1, 2);
        fractions[2] = new Fraction(7, 3);
        fractions[3] = new Fraction(3, 5);
        fractions[4] = new Fraction(2, 3);
        print(fractions);
        Arrays.sort(fractions, new FractionComparator());
        print(fractions);
    }
}