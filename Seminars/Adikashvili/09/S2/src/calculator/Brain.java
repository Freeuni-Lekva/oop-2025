package calculator;

public class Brain {

    private DisplayListener displayListener;

    private String prevDisplay, curDisplay;

    private char operator;

    public Brain() {
        this.prevDisplay = "0";
        this.curDisplay = "0";
        this.operator = '$';
    }

    public void registerDisplayListener(DisplayListener displayListener) {
        this.displayListener = displayListener;
    }

    public void addNumber(String digit) {
        this.curDisplay = digit;
        if (this.operator != '$') {
            calculate();
        } else fireDisplayChanged(this.curDisplay);
    }

    public void addOperator(char operator) {
        this.operator = operator;
        this.prevDisplay = curDisplay;
    }

    public void calculate() {
        double prev = Double.parseDouble(prevDisplay);
        double cur = Double.parseDouble(curDisplay);

        double result = switch (operator) {
            case '+' -> prev + cur;
            case '-' -> prev - cur;
            case '*' -> prev * cur;
            case '/' -> prev / cur;
            default -> 0;
        };

        this.curDisplay = result + "";
        this.operator = '$';
        fireDisplayChanged(this.curDisplay);
    }

    public void fireDisplayChanged(String display) {
        this.displayListener.displayChanged(display);
    }
}
