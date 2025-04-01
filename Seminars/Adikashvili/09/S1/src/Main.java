import calculator.*;

public class Main {

    public static void main(String[] args) {
        AbstractView view = new SwingView();
        CalculatorBrain brain = new CalculatorBrain();
        Controller controller = new Controller(view, brain);
        controller.runApp();
    }
}
