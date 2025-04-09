package bean;


import java.util.Date;

public class Student {

    private int id;

    private int studentId;

    private String idNumber;

    private String firstName;

    private String lastName;

    private Date registerDate;

    public Student(int id,
                   int studentId,
                   String idNumber,
                   String firstName,
                   String lastName,
                   Date registerDate) {
        this.id = id;
        this.studentId = studentId;
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", idNumber='" + idNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registerDate=" + registerDate +
                '}' + "\n";
    }
}
