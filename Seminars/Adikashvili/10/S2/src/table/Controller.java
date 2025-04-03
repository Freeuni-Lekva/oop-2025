package table;

import filter.Filter;

public class Controller implements InputListener {

    private final AbstractView view;

    private final Store store;

    public Controller(AbstractView view, Store store) {
        this.view = view;
        this.store = store;

        registerListener();
    }

    public void registerListener() {
        this.view.registerInputListener(this);
        this.store.registerDisplayListener(view);
    }

    @Override
    public void addStudent(Student student) {
        this.store.addStudent(student);
    }

    public void addFilter(Filter filter) {
        this.store.addFilter(filter);
    }

    public void startApp() {
        this.view.show();
    }
}
