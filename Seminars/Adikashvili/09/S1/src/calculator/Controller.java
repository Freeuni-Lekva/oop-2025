package calculator;

public class Controller implements InputListener {

    private AbstractView view;

    private CalculatorBrain brain;

    public Controller(AbstractView view, CalculatorBrain brain) {
        this.view = view;
        this.brain = brain;

        // listeners registration
        this.view.registerInputListener(this);
        this.brain.registerDisplayListener(view);
    }

    public void runApp() {
        view.show();
    }

    @Override
    public void inputChanged(String input) { // comes from view
        if (input.equals("=")) {
            brain.calculate();
        } else if ("+-*/".contains(input)) {
            brain.addOperator(input.charAt(0));
        } else {
            brain.addNumber(input);
        }
    }
}
