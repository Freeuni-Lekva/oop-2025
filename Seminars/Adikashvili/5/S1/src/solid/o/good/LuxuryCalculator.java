package solid.o.good;

public class LuxuryCalculator extends GoodTaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return 0.3 * amount;
    }
}
