package table;

public class Main {

    public static void main(String[] args) {
        AbstractView view = new SwingTableView();
        Store store = new Store();
        Controller controller = new Controller(view, store);
        controller.startApp();
    }
}