import java.util.Objects;

public class RationalNumber {

    private final int numerator;

    private final int denominator;

    /*
        rep invariant: denominator > 0, rational number is reduced form = gcd is 1
        abstraction function: rational number with numerator and denominator
        safety from exposure: final keyword + checkRep()
     */

    // denominator = 1
    public RationalNumber(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public RationalNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("illegal denominator");
        }

        if (numerator == 0) {
            this.numerator = numerator;
            this.denominator = 1;
            return;
        }

        int g = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= g;
        denominator /= g;

        if (denominator < 0) {
            this.denominator = -denominator;
            this.numerator = -numerator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        checkRepresentation();
    }

    public RationalNumber add(RationalNumber rationalNumber) {
        return new RationalNumber(numerator * rationalNumber.denominator + denominator * rationalNumber.numerator,
                denominator * rationalNumber.denominator);
    }

    public double evaluate() {
        return (double) numerator / denominator;
    }

    private void checkRepresentation() {
        assert this.denominator > 0 && gcd(this.numerator, this.denominator) == 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RationalNumber)) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator && denominator == that.denominator;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
