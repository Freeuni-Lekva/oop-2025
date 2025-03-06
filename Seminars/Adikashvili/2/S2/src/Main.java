public class Main {

    // 123 IV 5 V
    public static void main(String[] args) {
        for (String arg : args) {
            try {
                int arabicNumber = Integer.parseInt(arg);
                RomanNumeral romanNumeral = new RomanNumeral(arabicNumber);
                System.out.println(romanNumeral);
                System.out.println(romanNumeral.toInt());
            } catch (IllegalArgumentException exception) {
                RomanNumeral romanNumeral = new RomanNumeral(arg);
                System.out.println(romanNumeral);
                System.out.println(romanNumeral.toInt());
            }
        }
    }
}