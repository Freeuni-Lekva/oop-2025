package calculator;

import java.util.Scanner;

public class ConsoleView extends AbstractView {

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")) {
                break;
            }

            fireInputChanged(input);
        }

    }

    @Override
    public void displayChanged(String display) {
        System.out.println(display);
    }
}
