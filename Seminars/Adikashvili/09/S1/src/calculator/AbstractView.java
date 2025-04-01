package calculator;

public abstract class AbstractView implements DisplayListener {

    private InputListener inputListener;

    public void registerInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    public void fireInputChanged(String input) {
        inputListener.inputChanged(input);
    }

    public abstract void show();
}
