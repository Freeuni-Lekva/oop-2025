package calculator;

public class Controller implements InputListener {

    private AbstractView view;

    private Brain brain;

    public Controller(AbstractView view, Brain brain) {
        this.view = view;
        this.brain = brain;

        this.view.registerInputListener(this);
        this.brain.registerDisplayListener(view);
    }

    public void startApp() {
        view.show();
    }

    @Override
    public void inputChanged(String input) {
        char firstChar = input.charAt(0);
        if (Character.isDigit(firstChar)) {
            this.brain.addNumber(input);
        } else if (firstChar == '=') {
            this.brain.calculate();
        } else { // '='
            this.brain.addOperator(firstChar);
        }
    }
}
