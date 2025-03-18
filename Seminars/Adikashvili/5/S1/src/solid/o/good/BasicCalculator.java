package solid.o.good;

public class BasicCalculator extends GoodTaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return 0.1 * amount;
    }
}
