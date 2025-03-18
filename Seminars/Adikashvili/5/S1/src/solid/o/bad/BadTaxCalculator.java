package solid.o.bad;

public class BadTaxCalculator {

    public double calculateTax(double amount, String type) {
        switch (type) {
            case "basic": return amount * 0.1;
            case "luxury": return amount * 0.3;
            default: return amount * 0.2;
        }
    }
}
