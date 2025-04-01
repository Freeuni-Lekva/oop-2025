import calculator.*;


public class Main {

    public static void main(String[] args) {
        AbstractView view = new ConsoleView();
        Brain brain = new Brain();
        Controller controller = new Controller(view, brain);
        controller.startApp();
    }
}