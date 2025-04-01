package calculator;

public class CalculatorBrain {

    private DisplayListener displayListener;

    private char operator;

    private String previousDisplay;

    private String currentDisplay;

    public CalculatorBrain() {
        previousDisplay = "0";
        currentDisplay = "0";
        operator = '+';
    }

    public void addNumber(String input) {
        currentDisplay = input;
        fireDisplayChanged(currentDisplay);
    }

    public void addOperator(char operator) {
        previousDisplay = currentDisplay;
        this.operator = operator;
    }

    public void fireDisplayChanged(String display) {
        displayListener.displayChanged(display);
    }

    public void registerDisplayListener(DisplayListener displayListener) {
        this.displayListener = displayListener;
    }

    public void calculate() {
        double prev = Double.parseDouble(previousDisplay);
        double curr = Double.parseDouble(currentDisplay);

        double result = 0;

        switch (operator) {
            case '+':
                result = prev + curr;
                break;
            case '-':
                result = prev - curr;
                break;
            case '*':
                result = prev * curr;
                break;
            case '/':
                result = prev / curr;
                break;
        }

        this.currentDisplay = result + "";
        fireDisplayChanged(currentDisplay);
    }
}
