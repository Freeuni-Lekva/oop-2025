package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView extends AbstractView {
    public static final int CALC_WIDTH = 300;
    public static final int CALC_HEIGHT = 300;

    private final JFrame frame;
    private final JTextField inputField;

    public SwingView() {
        frame = new JFrame();
        // set general options
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();

        int x = (screenSize.width - CALC_WIDTH) / 2;
        int y = (screenSize.height - CALC_HEIGHT) / 2;

        frame.setSize(CALC_WIDTH, CALC_HEIGHT);
        frame.setLocation(x, y);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set main layout
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        borderLayout.setVgap(10);
        frame.setLayout(borderLayout);

        // create input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inputField.setEditable(false);
        inputPanel.add(inputField);

        // create value button panel
        JPanel valueButtonPanel = new JPanel(getGridLayout(4, 3));
        for (int i = 0; i <= 9; ++i) {
            valueButtonPanel.add(getCalcButton("" + i));
        }
        valueButtonPanel.add(getCalcButton("."));
        valueButtonPanel.add(getCalcButton("="));

        // create command button panel
        JPanel commandButtonPanel = new JPanel(getGridLayout(4, 1));
        String[] commands = {"+", "-", "*", "/"};
        for (String c : commands) {
            commandButtonPanel.add(getCalcButton(c));
        }

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(valueButtonPanel, BorderLayout.CENTER);
        frame.add(commandButtonPanel, BorderLayout.EAST);
    }

    private GridLayout getGridLayout(int rows, int cols) {
        GridLayout gridLayout = new GridLayout(rows, cols);
        gridLayout.setHgap(5);
        gridLayout.setVgap(5);
        return gridLayout;
    }

    private JButton getCalcButton(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fireInputChanged(actionEvent.getActionCommand());
            }
        });
        return button;
    }

    @Override
    public void displayChanged(String display) { // comes from brain
        this.inputField.setText(display);
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }
}