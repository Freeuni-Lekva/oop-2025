package swing;

import javax.swing.*;
import java.awt.*;

public class Swing {

    private static int count = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton button = new JButton("click");
        JLabel label = new JLabel("count: 0");

        button.addActionListener(_ -> {
            count++;
            label.setText("count: " + count);
        });

        panel.add(label, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
