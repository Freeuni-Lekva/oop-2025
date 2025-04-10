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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
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
