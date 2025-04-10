package bean;

import java.util.Date;

public class Student {

    private int id;

    private int student_id;

    private String idnumber;

    private String firstname;

    private String lastname;

    private Date register_date;

    public Student(int id,
                   int student_id,
                   String idnumber,
                   String firstname,
                   String lastname,
                   Date register_date) {
        this.id = id;
        this.student_id = student_id;
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.register_date = register_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", idnumber='" + idnumber + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", register_date=" + register_date +
                '}' + "\n";
    }
}
