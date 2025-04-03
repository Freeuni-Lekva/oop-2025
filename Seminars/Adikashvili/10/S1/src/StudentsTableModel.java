import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentsTableModel extends AbstractTableModel {

    private static final String[] header = {"first name", "last name", "year"};

    private List<Student> students; // filtered students (shown on table)

    public StudentsTableModel() {
        this.students = new ArrayList<>();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);

        switch (columnIndex) {
            case 0: return student.getFirstName();
            case 1: return student.getLastName();
            case 2: return student.getYear();
            default: throw new RuntimeException("Invalid column index");
        }
    }
}
