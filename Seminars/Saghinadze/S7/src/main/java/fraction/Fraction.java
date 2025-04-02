package fraction;

import java.util.Objects;

import static java.lang.Math.abs;

public class Fraction {

    // RI: d > 0 gcd(n , d) = 1
    // AF - Fraction: numerator and denominator

    private int n, d;

    public Fraction(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator is zero");
        }

        this.n = n;
        this.d = d;

        int g = gcd(d, n);
        this.n /= g;
        this.d /= g;

        if (this.d < 0) {
            this.d = -this.d;
            this.n = -this.n;
        }

        checkRep();
    }

    public Fraction(int n) {
        this(n, 1);
    }


    public int getNumerator() {
        return n;
    }

    public int getDenominator() {
        return d;
    }

    public Fraction add(Fraction other) {
        return addOperation(other, 1);
    }

    public Fraction subtract(Fraction other) {
        return addOperation(other, -1);
    }

    private Fraction addOperation(Fraction other, int sign) {
        int g = gcd(this.d, other.d);
        int den = this.d / g * other.d;
        return new Fraction(this.n * (den / this.d) + sign * other.n * (den / other.d), den);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.n * other.n, this.d * other.d);
    }

    public Fraction divide(Fraction other) {
        return new Fraction(this.n * other.d, other.n * this.d);
    }

    public void checkRep() {
        assert d > 0;
        assert abs(gcd(d, n)) == 1;
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    @Override
    public String toString() {
        return n + "/" + d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n, d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fraction other)) return false;
        return this.n == other.n && this.d == other.d;
    }
}
