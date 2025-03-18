package solid.o.good;

public class GeorgianTaxCalculator extends GoodTaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return 0.2 * amount;
    }
}
