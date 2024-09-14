// Cau 1
public class Fraction {
    private int numer, denom;

    public Fraction() {
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x, int y) {
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction f) {
        this.numer = f.numer;
        this.denom = f.denom;
    }

    public String toString() {
        return numer + "/" + denom;
    }

    public boolean equals(Fraction f) {
        if (this.numer * f.denom == this.denom * f.numer)
            return true;
        return false;
    }
}
