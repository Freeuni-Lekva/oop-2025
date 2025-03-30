import java.util.Objects;

public class RationalNumber {

    private final int numerator;

    private final int denominator;

    /*
        Abstract function: represents numerator / denominator
        Rep invariant: denominator > 0, ration number is in reduced form = gcd is 1
        Safety from REP Exposure: gcd = 1, denominator > 0, checkRep(), final keyword
     */

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator can't be 0.");
        }

        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
            return;
        }

        // transform into reduced form----------------------------
        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= g;
        denominator /= g;
        //--------------------------------------------

        // denominator > 0 always
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        checkRep();
    }

    public RationalNumber subtract(RationalNumber r) {
        return new RationalNumber(numerator * r.denominator - denominator * r.numerator, denominator * r.denominator);
    }

    // checks rep invariant is correct or not (-ea vm options)
    private void checkRep() {
        assert denominator > 0;
        assert gcd(numerator, denominator) > 0;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RationalNumber)) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return "RationalNumber{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
