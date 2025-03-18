package solid.o.good;

public class LuxuryTaxCalculator extends GoodTaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.2;
    }
}
