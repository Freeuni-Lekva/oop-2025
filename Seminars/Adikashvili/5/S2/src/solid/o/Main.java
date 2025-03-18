package solid.o;

import solid.o.good.BasicTaxCalculator;
import solid.o.good.GeorgianTaxCalculator;
import solid.o.good.GoodTaxCalculator;

public class Main {

    public static double getTax(double amount, GoodTaxCalculator calculator) {
        return calculator.calculateTax(amount);
    }

    public static void main(String[] args) {
        System.out.println(getTax(100, new GeorgianTaxCalculator()));
    }
}
