package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing {

    private static int count = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton button = new JButton("click");
        JLabel label = new JLabel("count: 0");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;

                label.setText("count: " + count);
            }
        });

        panel.add(button);
        panel.add(label);

        frame.setContentPane(panel);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
