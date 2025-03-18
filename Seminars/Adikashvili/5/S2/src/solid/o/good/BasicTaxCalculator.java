package solid.o.good;

public class BasicTaxCalculator extends GoodTaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return 0.1 * amount;
    }
}
