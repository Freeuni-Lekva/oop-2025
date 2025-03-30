public class Main {

    public static void main(String[] args) {

        RationalNumber r1 = new RationalNumber(2, 4);
        RationalNumber r2 = new RationalNumber(1, 2);

        RationalNumber r3 = new RationalNumber(5);
        System.out.println(r3.evaluate());

        System.out.println(r1.add(r2));
        System.out.println(r1.evaluate());

    }
}
