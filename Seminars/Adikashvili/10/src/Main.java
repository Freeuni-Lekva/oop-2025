public class Main {

    public static void main(String[] args) {
        SwingView view = new SwingView();
        Store store = new Store();
        Controller controller = new Controller(view, store);
        controller.start();
    }
}
