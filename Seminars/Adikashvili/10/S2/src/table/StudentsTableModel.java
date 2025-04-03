package table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentsTableModel extends AbstractTableModel {

    private List<Student> students; // filtered students shown on table

    public StudentsTableModel() {
        this.students = new ArrayList<>();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.students.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);

        if (columnIndex == 0) {
            return student.getFirstName();
        } else if (columnIndex == 1) {
            return student.getLastName();
        } else if (columnIndex == 2) {
            return student.getYear();
        } else {
            throw new IndexOutOfBoundsException("column index is out of range");
        }
    }
}
