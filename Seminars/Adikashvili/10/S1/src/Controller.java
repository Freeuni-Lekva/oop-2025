public class Controller implements InputListener {

    private AbstractView view;

    private Store store;

    public Controller(AbstractView view, Store store) {
        this.view = view;
        this.store = store;

        registerListeners();
    }

    public void registerListeners() {
        this.view.registerInputListener(this);
        this.store.registerDisplayListener(view);
    }

    @Override
    public void addStudent(Student student) {
        this.store.addStudent(student);
    }

    @Override
    public void addFilter(Filter filter) {
        this.store.addFilter(filter);
    }

    public void start() {
        this.view.show();
    }
}
