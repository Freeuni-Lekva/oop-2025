public abstract class AbstractView implements DisplayListener {

    private InputListener inputListener;


    public void registerInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void fireStudentAdded(Student student) {
        this.inputListener.addStudent(student);
    }

    public void fireFilterAdded(Filter filter) {
        this.inputListener.addFilter(filter);
    }

    public abstract void show();
}
