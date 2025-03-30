package solid.o.good;

public class BigTaxCalculator extends GoodTaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return 0.5 * amount;
    }
}
