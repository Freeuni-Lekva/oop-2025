public class Main {
    public static void main(String[] args) {

        for (String arg : args) {
            try {
                RomanNumeral romanNumber = new RomanNumeral(Integer.parseInt(arg));
                System.out.println(romanNumber);
                System.out.println(romanNumber.toInt());
            } catch (RuntimeException exception) {
                RomanNumeral romanNumeral = new RomanNumeral(arg);
                System.out.println(romanNumeral);
                System.out.println(romanNumeral.toInt());
            }
        }
    }
}