import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class SwingView extends AbstractView {

    private final JFrame frame;

    private final StudentsTableModel studentsTableModel;

    public SwingView() {
        frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel createPanel = new JPanel(new GridLayout(2, 4));
        JTextField firstNameTF = new JTextField();
        JTextField lastNameTF = new JTextField();
        JTextField yearTF = new JTextField();
        JButton add = new JButton("Add");

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String firstName = firstNameTF.getText();
                String lastName = lastNameTF.getText();
                String year = yearTF.getText();
                fireStudentAdded(new Student(firstName, lastName, Integer.parseInt(year)));
            }
        });
        JTextField firstNameFTF = new JTextField();
        firstNameFTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (!firstNameFTF.getText().isEmpty()) {
                    FirstNameFilter firstNameFilter = new FirstNameFilter(firstNameFTF.getText());
                    fireFilterAdded(firstNameFilter);
                }
            }
        });
        JTextField lastNameFTF = new JTextField();
        lastNameFTF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (!lastNameFTF.getText().isEmpty()) {
                    LastNameFilter lastNameFilter = new LastNameFilter(lastNameFTF.getText());
                    fireFilterAdded(lastNameFilter);
                }
            }
        });
        JTextField yearFTF = new JTextField();

        JButton filter = new JButton("Filter");
        filter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FirstNameFilter firstNameFilter = new FirstNameFilter(firstNameFTF.getText());
                LastNameFilter lastNameFilter = new LastNameFilter(lastNameFTF.getText());
                YearFilter yearFilter = new YearFilter(Integer.parseInt(yearFTF.getText()));

                AndFilter andFilter = new AndFilter();
                andFilter.addFilter(firstNameFilter);
                andFilter.addFilter(lastNameFilter);
                andFilter.addFilter(yearFilter);

                fireFilterAdded(andFilter);
            }
        });

        createPanel.add(firstNameTF);
        createPanel.add(lastNameTF);
        createPanel.add(yearTF);
        createPanel.add(add);
        createPanel.add(firstNameFTF);
        createPanel.add(lastNameFTF);
        createPanel.add(yearFTF);
        createPanel.add(filter);

        mainPanel.add(createPanel, BorderLayout.NORTH);

        // table---------------------------------------------
        JTable table = new JTable();
        studentsTableModel = new StudentsTableModel();
        table.setModel(studentsTableModel);

        JPanel tablePanel = new JPanel(new BorderLayout());

        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        mainPanel.add(tablePanel);

        frame.setContentPane(mainPanel);
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void studentsChanged(List<Student> students) {
        this.studentsTableModel.setStudents(students);
    }
}