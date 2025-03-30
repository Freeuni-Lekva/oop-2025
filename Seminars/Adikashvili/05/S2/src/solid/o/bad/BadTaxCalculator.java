package solid.o.bad;

public class BadTaxCalculator {

    public double calculateTax(String type, double amount) {
        switch (type) {
            case "basic":
                return amount * 0.1;
            case "luxury":
                return amount * 0.3;
            default: throw new RuntimeException("Invalid type");
        }
    }
}
